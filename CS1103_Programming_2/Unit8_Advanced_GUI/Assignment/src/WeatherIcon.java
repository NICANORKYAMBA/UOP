import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.Icon;

/**
 * A weather picture drawn with Java 2D, so the app needs no image files.
 *
 * <p>The picture is chosen from the WMO weather code: a sun (or a moon at night) for a clear
 * sky, clouds, rain streaks, snowflakes, fog bands, or a lightning bolt.
 */
public class WeatherIcon implements Icon {

    /** Sun yellow. */
    private static final Color SUN = new Color(255, 196, 0);

    /** Moon pale yellow. */
    private static final Color MOON = new Color(245, 235, 180);

    /** Light cloud grey. */
    private static final Color CLOUD = new Color(235, 238, 242);

    /** Dark storm-cloud grey. */
    private static final Color DARK_CLOUD = new Color(150, 156, 168);

    /** Rain blue. */
    private static final Color RAIN = new Color(40, 120, 220);

    /** Lightning yellow. */
    private static final Color BOLT = new Color(255, 220, 40);

    /** What to draw. */
    private final WeatherCodes.IconType type;

    /** True to draw a sun, false to draw a moon. */
    private final boolean isDay;

    /** Width and height of the icon in pixels. */
    private final int size;

    /**
     * Creates an icon for a weather code.
     *
     * @param weatherCode the WMO weather code
     * @param isDay       true for daytime (sun), false for night (moon)
     * @param size        width and height in pixels
     */
    public WeatherIcon(int weatherCode, boolean isDay, int size) {
        this.type = WeatherCodes.iconFor(weatherCode);
        this.isDay = isDay;
        this.size = size;
    }

    @Override
    public int getIconWidth() {
        return size;
    }

    @Override
    public int getIconHeight() {
        return size;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.translate(x, y);
        g2.scale(size / 100.0, size / 100.0); // draw on a 100 x 100 grid
        switch (type) {
            case CLEAR -> drawSunOrMoon(g2, 50, 50, 26);
            case PARTLY_CLOUDY -> {
                drawSunOrMoon(g2, 36, 36, 20);
                drawCloud(g2, 58, 62, CLOUD);
            }
            case CLOUDY -> {
                drawCloud(g2, 40, 46, DARK_CLOUD);
                drawCloud(g2, 56, 60, CLOUD);
            }
            case FOG -> {
                drawCloud(g2, 50, 42, CLOUD);
                g2.setColor(new Color(220, 224, 230));
                g2.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                for (int row = 0; row < 3; row++) {
                    g2.draw(new Line2D.Double(18 + row * 6, 70 + row * 10, 82 - row * 6, 70 + row * 10));
                }
            }
            case DRIZZLE -> drawPrecipitation(g2, false, 3);
            case RAIN -> drawPrecipitation(g2, false, 5);
            case SNOW -> drawPrecipitation(g2, true, 4);
            case THUNDER -> {
                drawCloud(g2, 50, 42, DARK_CLOUD);
                g2.setColor(BOLT);
                g2.fillPolygon(new Polygon(new int[] {52, 38, 50, 44, 64, 52},
                        new int[] {58, 80, 80, 98, 72, 72}, 6));
            }
        }
        g2.dispose();
    }

    /**
     * Draws a sun with rays during the day, or a crescent moon at night.
     *
     * @param g2 the graphics context
     * @param cx centre x
     * @param cy centre y
     * @param r  radius
     */
    private void drawSunOrMoon(Graphics2D g2, double cx, double cy, double r) {
        if (isDay) {
            g2.setColor(SUN);
            g2.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            for (int i = 0; i < 8; i++) {
                double angle = Math.PI / 4 * i;
                g2.draw(new Line2D.Double(cx + Math.cos(angle) * (r + 6), cy + Math.sin(angle) * (r + 6),
                        cx + Math.cos(angle) * (r + 16), cy + Math.sin(angle) * (r + 16)));
            }
            g2.fill(new Ellipse2D.Double(cx - r, cy - r, 2 * r, 2 * r));
        } else {
            // a crescent: a full disc minus an offset disc
            Area moon = new Area(new Ellipse2D.Double(cx - r, cy - r, 2 * r, 2 * r));
            moon.subtract(new Area(
                    new Ellipse2D.Double(cx - r * 0.45, cy - r * 1.15, 2 * r, 2 * r)));
            g2.setColor(MOON);
            g2.fill(moon);
        }
    }

    /**
     * Draws a cloud made of overlapping circles.
     *
     * @param g2    the graphics context
     * @param cx    centre x
     * @param cy    centre y
     * @param color the cloud colour
     */
    private static void drawCloud(Graphics2D g2, double cx, double cy, Color color) {
        g2.setColor(color);
        g2.fill(new Ellipse2D.Double(cx - 34, cy - 4, 68, 24));
        g2.fill(new Ellipse2D.Double(cx - 26, cy - 18, 30, 30));
        g2.fill(new Ellipse2D.Double(cx - 8, cy - 26, 36, 36));
        g2.setColor(color.darker());
        g2.setStroke(new BasicStroke(1.5f));
        g2.draw(new Ellipse2D.Double(cx - 34, cy - 4, 68, 24));
    }

    /**
     * Draws a cloud with rain streaks or snowflakes underneath.
     *
     * @param g2    the graphics context
     * @param snow  true for snowflakes, false for rain
     * @param count how many drops or flakes
     */
    private static void drawPrecipitation(Graphics2D g2, boolean snow, int count) {
        drawCloud(g2, 50, 40, snow ? CLOUD : DARK_CLOUD);
        g2.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        for (int i = 0; i < count; i++) {
            double x = 26 + i * (48.0 / Math.max(1, count - 1));
            double y = 72 + (i % 2) * 10;
            if (snow) {
                g2.setColor(Color.WHITE);
                g2.fill(new Ellipse2D.Double(x - 5, y - 5, 10, 10));
                g2.setColor(new Color(170, 200, 235));
                g2.draw(new Ellipse2D.Double(x - 5, y - 5, 10, 10));
            } else {
                g2.setColor(RAIN);
                g2.draw(new Line2D.Double(x, y - 6, x - 4, y + 6));
            }
        }
    }
}
