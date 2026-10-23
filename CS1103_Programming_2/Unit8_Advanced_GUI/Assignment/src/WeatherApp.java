import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * The Weather Information App: a Swing window that shows real-time weather for any place.
 *
 * <p>The user types a city name or coordinates and presses Search. The app shows the current
 * temperature, humidity, wind speed, and conditions with an icon, a five-day forecast, and a
 * history of recent searches. Units can be switched at any time, and the background changes with
 * the local time of day at the searched place. Network work runs on a background thread
 * (SwingWorker) so the window never freezes.
 */
public final class WeatherApp extends JFrame {

    /** Version number for serialization. */
    private static final long serialVersionUID = 1L;

    /** Format of the local time shown under the current weather. */
    private static final DateTimeFormatter LOCAL_TIME = DateTimeFormatter.ofPattern("EEE d MMM, HH:mm");

    /** Format of the day names in the forecast row. */
    private static final DateTimeFormatter FORECAST_DAY = DateTimeFormatter.ofPattern("EEE d MMM");

    /** Colour for error messages in the status bar. */
    private static final Color ERROR_RED = new Color(200, 30, 30);

    /** Fetches weather data from the API. */
    private final transient WeatherService service = new WeatherService();

    /** Recent successful searches. */
    private final transient SearchHistory history = new SearchHistory();

    /** The report currently shown, kept so units can be changed without a new request. */
    private transient WeatherReport currentReport;

    /** The window background, which changes with the time of day. */
    private final GradientPanel background = new GradientPanel();

    /** Where the user types a city name or coordinates. */
    private final JTextField locationField = new JTextField(22);

    /** Starts a search. */
    private final JButton searchButton = new JButton("Search");

    /** Temperature unit choice. */
    private final JComboBox<TemperatureUnit> temperatureUnit = new JComboBox<>(TemperatureUnit.values());

    /** Wind speed unit choice. */
    private final JComboBox<WindSpeedUnit> windUnit = new JComboBox<>(WindSpeedUnit.values());

    /** Large picture of the current conditions. */
    private final JLabel iconLabel = new JLabel();

    /** Name of the place. */
    private final JLabel placeLabel = new JLabel("Search for a city to see its weather");

    /** Current temperature. */
    private final JLabel temperatureLabel = new JLabel(" ");

    /** Current conditions in words. */
    private final JLabel conditionLabel = new JLabel(" ");

    /** Humidity and wind speed. */
    private final JLabel detailsLabel = new JLabel(" ");

    /** Local time and part of the day at the place. */
    private final JLabel timeLabel = new JLabel(" ");

    /** Holds one small panel per forecast day. */
    private final JPanel forecastRow = new JPanel(new GridLayout(1, WeatherService.FORECAST_DAYS, 10, 0));

    /** The history entries shown in the list. */
    private final DefaultListModel<SearchHistory.Entry> historyModel = new DefaultListModel<>();

    /** The list that shows the history. */
    private final JList<SearchHistory.Entry> historyList = new JList<>(historyModel);

    /** Messages and errors for the user. */
    private final JLabel statusLabel = new JLabel("Type a city such as \"Nairobi\" or coordinates such as \"-1.29, 36.82\".");

    /** Title above the forecast row. */
    private final JLabel forecastTitle = new JLabel("5-day forecast");

    /** Labels whose colour follows the background (light text on dark backgrounds). */
    private final transient List<JLabel> adaptiveLabels = List.of(
            placeLabel, temperatureLabel, conditionLabel, detailsLabel, timeLabel, forecastTitle);

    /** Builds the window and all its components. */
    public WeatherApp() {
        super("Weather Information App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(960, 600));

        background.setLayout(new BorderLayout(12, 12));
        background.setBorder(BorderFactory.createEmptyBorder(12, 12, 8, 12));
        background.add(buildSearchBar(), BorderLayout.NORTH);
        background.add(buildWeatherArea(), BorderLayout.CENTER);
        background.add(buildHistoryPanel(), BorderLayout.EAST);
        background.add(buildStatusBar(), BorderLayout.SOUTH);
        setContentPane(background);

        searchButton.addActionListener(e -> startSearch(locationField.getText()));
        getRootPane().setDefaultButton(searchButton); // Enter in the text field searches
        temperatureUnit.addActionListener(e -> {
            showReport();
            historyList.repaint(); // history temperatures follow the chosen unit too
        });
        windUnit.addActionListener(e -> showReport());

        applyTimeOfDay(TimeOfDay.fromHour(LocalDateTime.now().getHour()));
        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Builds the row with the location field, Search button, and unit choices.
     *
     * @return the search bar
     */
    private JPanel buildSearchBar() {
        JPanel bar = card(new FlowLayout(FlowLayout.LEFT, 8, 6));
        locationField.setToolTipText("A city name (e.g. Paris, France) or latitude, longitude (e.g. 48.85, 2.35)");
        searchButton.setMnemonic(KeyEvent.VK_S);
        bar.add(new JLabel("City or coordinates:"));
        bar.add(locationField);
        bar.add(searchButton);
        bar.add(Box.createHorizontalStrut(16));
        bar.add(new JLabel("Temperature:"));
        bar.add(temperatureUnit);
        bar.add(new JLabel("Wind:"));
        bar.add(windUnit);
        return bar;
    }

    /**
     * Builds the centre area: the current weather above the forecast row.
     *
     * @return the weather area
     */
    private JPanel buildWeatherArea() {
        JPanel current = transparent(new BorderLayout(16, 0));
        JPanel text = transparent(null);
        text.setLayout(new BoxLayout(text, BoxLayout.Y_AXIS));
        placeLabel.setFont(placeLabel.getFont().deriveFont(Font.BOLD, 24f));
        temperatureLabel.setFont(temperatureLabel.getFont().deriveFont(Font.BOLD, 56f));
        conditionLabel.setFont(conditionLabel.getFont().deriveFont(Font.PLAIN, 22f));
        detailsLabel.setFont(detailsLabel.getFont().deriveFont(Font.PLAIN, 17f));
        timeLabel.setFont(timeLabel.getFont().deriveFont(Font.ITALIC, 15f));
        for (JLabel label : List.of(placeLabel, temperatureLabel, conditionLabel, detailsLabel, timeLabel)) {
            text.add(label);
            text.add(Box.createVerticalStrut(4));
        }
        current.add(iconLabel, BorderLayout.WEST);
        current.add(text, BorderLayout.CENTER);

        forecastRow.setOpaque(false);
        JPanel forecastBox = transparent(new BorderLayout(0, 6));
        forecastTitle.setFont(forecastTitle.getFont().deriveFont(Font.BOLD, 16f));
        forecastBox.add(forecastTitle, BorderLayout.NORTH);
        forecastBox.add(forecastRow, BorderLayout.CENTER);

        JPanel area = transparent(new BorderLayout(0, 18));
        area.add(current, BorderLayout.CENTER);
        area.add(forecastBox, BorderLayout.SOUTH);
        return area;
    }

    /**
     * Builds the history list on the right.
     *
     * @return the history panel
     */
    private JPanel buildHistoryPanel() {
        JPanel panel = card(new BorderLayout(0, 6));
        panel.setPreferredSize(new Dimension(300, 0));
        JLabel title = new JLabel("Recent searches (double-click to repeat)");
        title.setFont(title.getFont().deriveFont(Font.BOLD));
        historyList.setCellRenderer(new HistoryRenderer());
        historyList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && historyList.getSelectedValue() != null) {
                    repeatSearch(historyList.getSelectedValue());
                }
            }
        });
        historyList.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "repeat");
        historyList.getActionMap().put("repeat", new AbstractAction() {
            /** Version number for serialization. */
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (historyList.getSelectedValue() != null) {
                    repeatSearch(historyList.getSelectedValue());
                }
            }
        });
        panel.add(title, BorderLayout.NORTH);
        panel.add(new JScrollPane(historyList), BorderLayout.CENTER);
        return panel;
    }

    /**
     * Builds the status bar with messages on the left and the data credit on the right.
     *
     * @return the status bar
     */
    private JPanel buildStatusBar() {
        JPanel bar = card(new BorderLayout());
        String source = "Weather data by Open-Meteo.com (CC BY 4.0)"
                + (service.usesApiKey() ? ", customer API" : ", free API");
        bar.add(statusLabel, BorderLayout.CENTER);
        bar.add(new JLabel(source), BorderLayout.EAST);
        return bar;
    }

    /**
     * Starts a search in the background so the window stays responsive.
     *
     * @param query what the user typed
     */
    private void startSearch(String query) {
        searchButton.setEnabled(false);
        setStatus("Searching for \"" + query.strip() + "\"...", false);
        new SwingWorker<WeatherReport, Void>() {
            @Override
            protected WeatherReport doInBackground() throws WeatherException {
                Location location = service.findLocation(query);
                return service.fetchReport(location);
            }

            @Override
            protected void done() {
                searchButton.setEnabled(true);
                try {
                    WeatherReport report = get();
                    currentReport = report;
                    showReport();
                    addToHistory(query.strip(), report);
                    setStatus("Updated " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))
                            + " for " + report.location().label() + ".", false);
                } catch (ExecutionException e) {
                    String message = e.getCause() instanceof WeatherException we
                            ? we.getMessage()
                            : "Something went wrong: " + e.getCause();
                    setStatus(message, true);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    setStatus("The search was interrupted.", true);
                }
            }
        }.execute();
    }

    /**
     * Repeats a search from the history list.
     *
     * @param entry the remembered search
     */
    private void repeatSearch(SearchHistory.Entry entry) {
        locationField.setText(entry.query());
        startSearch(entry.query());
    }

    /**
     * Records a successful search in the history list.
     *
     * @param query  what the user typed
     * @param report the result
     */
    private void addToHistory(String query, WeatherReport report) {
        CurrentWeather now = report.current();
        history.add(new SearchHistory.Entry(query, report.location().label(), now.temperatureC(),
                now.weatherCode(), LocalDateTime.now()));
        historyModel.clear();
        history.entries().forEach(historyModel::addElement);
    }

    /** Shows the current report in the selected units. Does nothing before the first search. */
    private void showReport() {
        if (currentReport == null) {
            return;
        }
        TemperatureUnit tUnit = (TemperatureUnit) temperatureUnit.getSelectedItem();
        WindSpeedUnit wUnit = (WindSpeedUnit) windUnit.getSelectedItem();
        CurrentWeather now = currentReport.current();

        iconLabel.setIcon(new WeatherIcon(now.weatherCode(), now.isDay(), 150));
        placeLabel.setText(currentReport.location().label());
        temperatureLabel.setText(tUnit.format(now.temperatureC()));
        conditionLabel.setText(WeatherCodes.describe(now.weatherCode()));
        detailsLabel.setText("Humidity: " + now.humidity() + "%     Wind: " + wUnit.format(now.windKmh()));
        TimeOfDay part = TimeOfDay.fromHour(now.localTime().getHour());
        timeLabel.setText("Local time: " + now.localTime().format(LOCAL_TIME) + "  (" + part + ")");

        forecastRow.removeAll();
        for (int i = 0; i < currentReport.forecast().size(); i++) {
            forecastRow.add(forecastCard(currentReport.forecast().get(i), i == 0, tUnit));
        }
        applyTimeOfDay(part);
        forecastRow.revalidate();
        repaint();
    }

    /**
     * Builds the small panel for one forecast day.
     *
     * @param day     the forecast
     * @param isToday true for the first day
     * @param unit    the temperature unit to show
     * @return the panel
     */
    private JPanel forecastCard(DailyForecast day, boolean isToday, TemperatureUnit unit) {
        JPanel cardPanel = card(new BorderLayout(0, 2));
        JLabel name = centered(isToday ? "Today" : day.date().format(FORECAST_DAY), Font.BOLD);
        JLabel icon = new JLabel(new WeatherIcon(day.weatherCode(), true, 56));
        icon.setHorizontalAlignment(SwingConstants.CENTER);
        icon.setToolTipText(WeatherCodes.describe(day.weatherCode()));
        JLabel temps = centered(unit.format(day.maxC()) + " / " + unit.format(day.minC()), Font.PLAIN);
        JLabel words = centered("<html><div style='text-align:center'>"
                + WeatherCodes.describe(day.weatherCode()) + "</div></html>", Font.PLAIN);
        words.setFont(words.getFont().deriveFont(11f));
        JPanel bottom = transparent(new BorderLayout());
        bottom.add(temps, BorderLayout.NORTH);
        bottom.add(words, BorderLayout.CENTER);
        cardPanel.add(name, BorderLayout.NORTH);
        cardPanel.add(icon, BorderLayout.CENTER);
        cardPanel.add(bottom, BorderLayout.SOUTH);
        return cardPanel;
    }

    /**
     * Changes the background and text colours for a part of the day.
     *
     * @param part the part of the day at the searched place
     */
    private void applyTimeOfDay(TimeOfDay part) {
        background.setTimeOfDay(part);
        Color text = part.isDark() ? Color.WHITE : new Color(20, 30, 50);
        adaptiveLabels.forEach(label -> label.setForeground(text));
    }

    /**
     * Shows a message in the status bar.
     *
     * @param message the text
     * @param isError true to show it in red as an error
     */
    private void setStatus(String message, boolean isError) {
        statusLabel.setText(message);
        statusLabel.setForeground(isError ? ERROR_RED : Color.DARK_GRAY);
    }

    /**
     * Creates a white, slightly rounded "card" panel that stays readable on any background.
     *
     * @param layout the layout manager
     * @return the panel
     */
    private static JPanel card(LayoutManager layout) {
        JPanel panel = new CardPanel(layout);
        panel.setBorder(BorderFactory.createEmptyBorder(6, 8, 6, 8));
        return panel;
    }

    /**
     * Creates a see-through panel, so the gradient background shows behind it.
     *
     * @param layout the layout manager, or null to set it later
     * @return the panel
     */
    private static JPanel transparent(LayoutManager layout) {
        JPanel panel = new JPanel(layout);
        panel.setOpaque(false);
        return panel;
    }

    /**
     * Creates a centred label.
     *
     * @param text  the text
     * @param style Font.BOLD or Font.PLAIN
     * @return the label
     */
    private static JLabel centered(String text, int style) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(style));
        return label;
    }

    /** Shows each history entry on three lines: the place in bold, the result, and the time. */
    private final class HistoryRenderer extends DefaultListCellRenderer {

        /** Version number for serialization. */
        private static final long serialVersionUID = 1L;

        /** Format of the timestamp under each entry. */
        private static final DateTimeFormatter STAMP = DateTimeFormatter.ofPattern("d MMM yyyy, HH:mm");

        /** Creates the renderer. */
        HistoryRenderer() {
            setVerticalAlignment(SwingConstants.TOP);
        }

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof SearchHistory.Entry entry) {
                TemperatureUnit unit = (TemperatureUnit) temperatureUnit.getSelectedItem();
                setText("<html><b>" + escape(entry.place()) + "</b><br>" + escape(entry.summary(unit))
                        + "<br><span style='color:gray'>Searched " + entry.searched().format(STAMP)
                        + "</span></html>");
            }
            setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
            return this;
        }

        /**
         * Makes text safe to show inside HTML.
         *
         * @param text the text
         * @return the text with &amp;, &lt;, and &gt; escaped
         */
        private static String escape(String text) {
            return text.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
        }
    }

    /** A see-through panel that paints a rounded, mostly white background behind its contents. */
    private static final class CardPanel extends JPanel {

        /** Version number for serialization. */
        private static final long serialVersionUID = 1L;

        /** Fill colour: white with a little transparency. */
        private static final Color FILL = new Color(255, 255, 255, 225);

        /**
         * Creates a card.
         *
         * @param layout the layout manager
         */
        CardPanel(LayoutManager layout) {
            super(layout);
            setOpaque(false); // the rounded background is painted below instead
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(FILL);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 14, 14);
            g2.dispose();
            super.paintComponent(g);
        }
    }

    /** A panel that paints a vertical colour gradient for the current part of the day. */
    private static final class GradientPanel extends JPanel {

        /** Version number for serialization. */
        private static final long serialVersionUID = 1L;

        /** The part of the day whose colours are painted. */
        private TimeOfDay timeOfDay = TimeOfDay.DAY;

        /** Creates the background panel with the daytime colours. */
        GradientPanel() {
            setOpaque(true);
        }

        /**
         * Changes the colours and repaints.
         *
         * @param timeOfDay the new part of the day
         */
        void setTimeOfDay(TimeOfDay timeOfDay) {
            this.timeOfDay = timeOfDay;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setPaint(new GradientPaint(0, 0, timeOfDay.top(), 0, getHeight(), timeOfDay.bottom()));
            g2.fillRect(0, 0, getWidth(), getHeight());
            g2.dispose();
        }
    }

    /**
     * Starts the app on the Swing event thread.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ReflectiveOperationException | UnsupportedLookAndFeelException e) {
                // the default look and feel is fine
            }
            new WeatherApp().setVisible(true);
        });
    }
}
