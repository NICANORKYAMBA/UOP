import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Fetches real-time weather from the Open-Meteo API.
 *
 * <p>A search happens in two steps. The Geocoding API turns a place name into coordinates, and
 * the Forecast API returns the current weather and a daily forecast for those coordinates. Typed
 * coordinates such as "-1.29, 36.82" skip the first step.
 *
 * <p><b>API key and usage guidelines.</b> Open-Meteo's free API needs no key for non-commercial
 * use, within 10,000 calls per day and 600 per minute. If the environment variable
 * {@value #API_KEY_VARIABLE} is set, the app uses the paid customer endpoint and sends the key,
 * which is read from the environment and never written into the code. To stay well inside the
 * limits, results are cached for {@link #CACHE_TIME}, every request has a timeout, and the app
 * identifies itself with a User-Agent header. The data is credited to Open-Meteo (CC BY 4.0) in
 * the window, as the terms require.
 */
public class WeatherService {

    /** Name of the environment variable that may hold a paid Open-Meteo API key. */
    public static final String API_KEY_VARIABLE = "OPEN_METEO_API_KEY";

    /** How long a fetched report is reused before the API is asked again. */
    public static final Duration CACHE_TIME = Duration.ofMinutes(10);

    /** Number of forecast days requested (today plus four). */
    public static final int FORECAST_DAYS = 5;

    /** Free forecast endpoint. */
    private static final String FREE_FORECAST_URL = "https://api.open-meteo.com/v1/forecast";

    /** Paid forecast endpoint, used only when an API key is configured. */
    private static final String CUSTOMER_FORECAST_URL = "https://customer-api.open-meteo.com/v1/forecast";

    /** Geocoding (place name search) endpoint. */
    private static final String GEOCODING_URL = "https://geocoding-api.open-meteo.com/v1/search";

    /** Matches typed coordinates such as "-1.29, 36.82" or "51.5 -0.12". */
    private static final Pattern COORDINATES =
            Pattern.compile("\\s*(-?\\d+(?:\\.\\d+)?)\\s*[, ]\\s*(-?\\d+(?:\\.\\d+)?)\\s*");

    /** Longest place name accepted, to keep requests sensible. */
    private static final int MAX_QUERY_LENGTH = 100;

    /**
     * A cached report and the moment it was fetched.
     *
     * @param report  the report
     * @param fetched when it was fetched
     */
    private record CachedReport(WeatherReport report, Instant fetched) {
    }

    /** HTTP client shared by all requests; it is thread-safe. */
    private final HttpClient http = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    /** Paid API key, or null to use the free API. */
    private final String apiKey;

    /** Recent reports keyed by rounded coordinates; safe to use from several threads. */
    private final Map<String, CachedReport> cache = new ConcurrentHashMap<>();

    /** Creates a service that reads the optional API key from the environment. */
    public WeatherService() {
        String key = System.getenv(API_KEY_VARIABLE);
        this.apiKey = (key == null || key.isBlank()) ? null : key.strip();
    }

    /**
     * Tells whether the paid endpoint with an API key is in use.
     *
     * @return true if an API key was found in the environment
     */
    public boolean usesApiKey() {
        return apiKey != null;
    }

    /**
     * Turns what the user typed into a location: either typed coordinates or a place name.
     *
     * @param query a place name such as "Nairobi" or coordinates such as "-1.29, 36.82"
     * @return the location found
     * @throws WeatherException if the input is empty, invalid, or matches no place
     */
    public Location findLocation(String query) throws WeatherException {
        String text = query == null ? "" : query.strip();
        if (text.isEmpty()) {
            throw new WeatherException("Please type a city name or coordinates (latitude, longitude).");
        }
        if (text.length() > MAX_QUERY_LENGTH) {
            throw new WeatherException("That place name is too long. Please shorten it.");
        }
        Location typed = parseCoordinates(text);
        if (typed != null) {
            return typed;
        }
        String url = GEOCODING_URL + "?count=1&language=en&format=json&name="
                + URLEncoder.encode(text, StandardCharsets.UTF_8);
        return parseGeocoding(get(url), text);
    }

    /**
     * Fetches the current weather and forecast for a location, reusing a recent result if there
     * is one.
     *
     * @param location where to get the weather for
     * @return the weather report
     * @throws WeatherException if the request fails or the reply cannot be read
     */
    public WeatherReport fetchReport(Location location) throws WeatherException {
        String key = String.format(Locale.ROOT, "%.2f,%.2f", location.latitude(), location.longitude());
        CachedReport cached = cache.get(key);
        if (cached != null && cached.fetched().plus(CACHE_TIME).isAfter(Instant.now())) {
            return cached.report();
        }
        String url = String.format(Locale.ROOT,
                "%s?latitude=%.4f&longitude=%.4f"
                        + "&current=temperature_2m,relative_humidity_2m,wind_speed_10m,weather_code,is_day"
                        + "&daily=weather_code,temperature_2m_max,temperature_2m_min"
                        + "&timezone=auto&forecast_days=%d",
                apiKey == null ? FREE_FORECAST_URL : CUSTOMER_FORECAST_URL,
                location.latitude(), location.longitude(), FORECAST_DAYS);
        if (apiKey != null) {
            url += "&apikey=" + URLEncoder.encode(apiKey, StandardCharsets.UTF_8);
        }
        WeatherReport report = parseForecast(get(url), location);
        cache.put(key, new CachedReport(report, Instant.now()));
        return report;
    }

    /**
     * Sends a GET request and returns the body, turning every failure into a clear message.
     *
     * @param url the full request URL
     * @return the response body
     * @throws WeatherException if the network fails, times out, or the API reports an error
     */
    private String get(String url) throws WeatherException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(url))
                .timeout(Duration.ofSeconds(15))
                .header("User-Agent", "CS1103-WeatherInformationApp/1.0 (student project)")
                .GET()
                .build();
        try {
            HttpResponse<String> response = http.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new WeatherException(apiErrorMessage(response.statusCode(), response.body()));
            }
            return response.body();
        } catch (HttpTimeoutException e) {
            throw new WeatherException("The weather service took too long to answer. Please try again.", e);
        } catch (IOException e) {
            throw new WeatherException(
                    "Could not reach the weather service. Please check your internet connection.", e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new WeatherException("The search was interrupted.", e);
        }
    }

    /**
     * Builds a user-facing message for an HTTP error, using the API's own reason when present.
     *
     * @param status the HTTP status code
     * @param body   the response body, which may contain {"error":true,"reason":"..."}
     * @return the message to show
     */
    static String apiErrorMessage(int status, String body) {
        String reason = null;
        try {
            if (Json.parse(body) instanceof Map<?, ?> map && map.get("reason") instanceof String r) {
                reason = r;
            }
        } catch (IllegalArgumentException e) {
            // the body is not JSON; fall back to a general message below
        }
        if (status == 429) {
            return "Too many requests to the weather service. Please wait a minute and try again.";
        }
        return reason != null
                ? "The weather service rejected the request: " + reason
                : "The weather service returned an error (HTTP " + status + "). Please try again later.";
    }

    /**
     * Recognizes typed coordinates and checks that they are on Earth.
     *
     * @param text the user's input
     * @return a location for the coordinates, or null if the text is not coordinates
     * @throws WeatherException if the numbers are outside the valid ranges
     */
    static Location parseCoordinates(String text) throws WeatherException {
        Matcher m = COORDINATES.matcher(text);
        if (!m.matches()) {
            return null;
        }
        double lat = Double.parseDouble(m.group(1));
        double lon = Double.parseDouble(m.group(2));
        if (lat < -90 || lat > 90 || lon < -180 || lon > 180) {
            throw new WeatherException(
                    "Coordinates must be latitude -90 to 90 and longitude -180 to 180.");
        }
        String name = String.format(Locale.ROOT, "Coordinates %.2f, %.2f", lat, lon);
        return new Location(name, "", "", lat, lon);
    }

    /**
     * Reads the first match from a Geocoding API response.
     *
     * @param json  the response body
     * @param query what the user searched for, used in the "not found" message
     * @return the location found
     * @throws WeatherException if no place matched or the response is malformed
     */
    static Location parseGeocoding(String json, String query) throws WeatherException {
        Map<?, ?> root = asMap(parseJson(json), "geocoding response");
        if (!(root.get("results") instanceof List<?> results) || results.isEmpty()) {
            throw new WeatherException("No place called \"" + query
                    + "\" was found. Check the spelling, or add the country, e.g. \"Paris, France\".");
        }
        Map<?, ?> first = asMap(results.get(0), "geocoding result");
        return new Location(
                text(first, "name"), text(first, "admin1"), text(first, "country"),
                number(first, "latitude"), number(first, "longitude"));
    }

    /**
     * Reads a Forecast API response into a report.
     *
     * @param json     the response body
     * @param location the place the forecast is for
     * @return the weather report
     * @throws WeatherException if a required field is missing or malformed
     */
    static WeatherReport parseForecast(String json, Location location) throws WeatherException {
        try {
            return readForecast(asMap(parseJson(json), "forecast response"), location);
        } catch (DateTimeParseException | ClassCastException | IndexOutOfBoundsException e) {
            throw new WeatherException("The weather service sent a forecast in an unexpected format.", e);
        }
    }

    /**
     * Builds the report from the parsed forecast object.
     *
     * @param root     the parsed response
     * @param location the place the forecast is for
     * @return the weather report
     * @throws WeatherException if a required field is missing
     */
    private static WeatherReport readForecast(Map<?, ?> root, Location location) throws WeatherException {
        Map<?, ?> now = asMap(root.get("current"), "current weather");
        CurrentWeather current = new CurrentWeather(
                number(now, "temperature_2m"),
                (int) Math.round(number(now, "relative_humidity_2m")),
                number(now, "wind_speed_10m"),
                (int) number(now, "weather_code"),
                number(now, "is_day") == 1,
                LocalDateTime.parse(text(now, "time")));

        Map<?, ?> daily = asMap(root.get("daily"), "daily forecast");
        List<?> dates = list(daily, "time");
        List<?> codes = list(daily, "weather_code");
        List<?> highs = list(daily, "temperature_2m_max");
        List<?> lows = list(daily, "temperature_2m_min");
        List<DailyForecast> days = new ArrayList<>();
        for (int i = 0; i < dates.size(); i++) {
            if (codes.get(i) instanceof Double code && highs.get(i) instanceof Double high
                    && lows.get(i) instanceof Double low) {
                days.add(new DailyForecast(LocalDate.parse((String) dates.get(i)),
                        code.intValue(), high, low));
            }
        }
        return new WeatherReport(location, current, days);
    }

    /**
     * Parses JSON, reporting bad data as a weather error.
     *
     * @param json the text to parse
     * @return the parsed value
     * @throws WeatherException if the text is not valid JSON
     */
    private static Object parseJson(String json) throws WeatherException {
        try {
            return Json.parse(json);
        } catch (IllegalArgumentException e) {
            throw new WeatherException("The weather service sent data that could not be read.", e);
        }
    }

    /**
     * Checks that a value is a JSON object.
     *
     * @param value the value to check
     * @param what  what the value should be, for the error message
     * @return the value as a map
     * @throws WeatherException if it is not an object
     */
    private static Map<?, ?> asMap(Object value, String what) throws WeatherException {
        if (value instanceof Map<?, ?> map) {
            return map;
        }
        throw new WeatherException("The weather service sent an incomplete " + what + ".");
    }

    /**
     * Reads a required number field.
     *
     * @param map   the JSON object
     * @param field the field name
     * @return the number
     * @throws WeatherException if the field is missing or not a number
     */
    private static double number(Map<?, ?> map, String field) throws WeatherException {
        if (map.get(field) instanceof Double d) {
            return d;
        }
        throw new WeatherException("The weather service did not send \"" + field + "\".");
    }

    /**
     * Reads a required array field.
     *
     * @param map   the JSON object
     * @param field the field name
     * @return the array
     * @throws WeatherException if the field is missing or not an array
     */
    private static List<?> list(Map<?, ?> map, String field) throws WeatherException {
        if (map.get(field) instanceof List<?> l) {
            return l;
        }
        throw new WeatherException("The weather service did not send \"" + field + "\".");
    }

    /**
     * Reads an optional text field.
     *
     * @param map   the JSON object
     * @param field the field name
     * @return the text, or an empty string if it is missing
     */
    private static String text(Map<?, ?> map, String field) {
        return map.get(field) instanceof String s ? s : "";
    }
}
