import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Remembers the most recent successful searches, newest first, each with a timestamp.
 */
public class SearchHistory {

    /** How many searches are kept. */
    public static final int CAPACITY = 10;

    /** Format of the timestamp shown in the history list. */
    private static final DateTimeFormatter STAMP = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    /**
     * One remembered search. The temperature is stored in Celsius so it can be shown in
     * whichever unit the user picks later.
     *
     * @param query        what the user typed, so the search can be repeated
     * @param place        the place that was found
     * @param temperatureC the temperature at the time of the search, in degrees Celsius
     * @param weatherCode  the WMO weather code at the time of the search
     * @param searched     when the search was made (the user's own clock)
     */
    public record Entry(String query, String place, double temperatureC, int weatherCode,
                        LocalDateTime searched) {

        /**
         * Returns a short result in the given unit.
         *
         * @param unit the temperature unit to use
         * @return e.g. "84°F, Clear sky"
         */
        public String summary(TemperatureUnit unit) {
            return unit.format(temperatureC) + ", " + WeatherCodes.describe(weatherCode);
        }

        /**
         * Returns a one-line description in Celsius.
         *
         * @return e.g. "2026-10-23 11:45  Nairobi, Kenya: 29°C, Clear sky"
         */
        @Override
        public String toString() {
            return searched.format(STAMP) + "  " + place + ": " + summary(TemperatureUnit.CELSIUS);
        }
    }

    /** The entries, newest first. */
    private final List<Entry> entries = new ArrayList<>();

    /** Creates an empty history. */
    public SearchHistory() {
        // starts empty; searches are added with add()
    }

    /**
     * Adds a search. A repeated search of the same place moves to the top instead of
     * appearing twice, and the oldest entry is dropped when the list is full.
     *
     * @param entry the search to remember
     */
    public void add(Entry entry) {
        entries.removeIf(old -> old.place().equals(entry.place()));
        entries.add(0, entry);
        if (entries.size() > CAPACITY) {
            entries.remove(entries.size() - 1);
        }
    }

    /**
     * Returns the remembered searches, newest first.
     *
     * @return an unmodifiable copy of the entries
     */
    public List<Entry> entries() {
        return List.copyOf(entries);
    }
}
