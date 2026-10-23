import java.time.LocalDate;

/**
 * The forecast for one day, in metric units.
 *
 * @param date        the day
 * @param weatherCode WMO weather code for the day's main condition
 * @param maxC        highest temperature in degrees Celsius
 * @param minC        lowest temperature in degrees Celsius
 */
public record DailyForecast(LocalDate date, int weatherCode, double maxC, double minC) {
}
