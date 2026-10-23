import java.util.List;

/**
 * Everything the app shows for one search: the place, the current weather, and the forecast.
 *
 * @param location the place the report is for
 * @param current  the weather right now
 * @param forecast one entry per day, starting today
 */
public record WeatherReport(Location location, CurrentWeather current, List<DailyForecast> forecast) {

    /**
     * Makes the forecast list unmodifiable, so a report cannot change after it is created.
     *
     * @param location the place the report is for
     * @param current  the weather right now
     * @param forecast one entry per day, starting today
     */
    public WeatherReport {
        forecast = List.copyOf(forecast);
    }
}
