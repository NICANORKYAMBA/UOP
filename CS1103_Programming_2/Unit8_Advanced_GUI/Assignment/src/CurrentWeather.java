import java.time.LocalDateTime;

/**
 * The weather right now at one location, always stored in metric units.
 *
 * @param temperatureC temperature in degrees Celsius
 * @param humidity     relative humidity in percent
 * @param windKmh      wind speed in kilometres per hour
 * @param weatherCode  WMO weather code (see {@link WeatherCodes})
 * @param isDay        true between sunrise and sunset
 * @param localTime    the current local time at the location
 */
public record CurrentWeather(double temperatureC, int humidity, double windKmh,
                             int weatherCode, boolean isDay, LocalDateTime localTime) {
}
