import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * Automated checks for the Weather Information App.
 *
 * <p>Most checks run offline against a real Open-Meteo response saved below, so they give the
 * same result every time. Run with {@code --live} to also call the real API over the internet.
 */
public final class WeatherAppTest {

    /** A real Forecast API response for Nairobi (October 23, 2026), shortened to one line. */
    private static final String NAIROBI_FORECAST = "{\"latitude\":-1.3005272,\"longitude\":36.824646,"
            + "\"utc_offset_seconds\":10800,\"timezone\":\"Africa/Nairobi\","
            + "\"current_units\":{\"temperature_2m\":\"\\u00b0C\",\"wind_speed_10m\":\"km/h\"},"
            + "\"current\":{\"time\":\"2026-10-23T11:45\",\"interval\":900,\"temperature_2m\":29.0,"
            + "\"relative_humidity_2m\":29,\"wind_speed_10m\":8.1,\"weather_code\":0,\"is_day\":1},"
            + "\"daily\":{\"time\":[\"2026-10-23\",\"2026-10-24\",\"2026-10-25\",\"2026-10-26\",\"2026-10-27\"],"
            + "\"weather_code\":[51,51,3,81,81],"
            + "\"temperature_2m_max\":[30.7,28.8,30.2,28.8,23.6],"
            + "\"temperature_2m_min\":[16.7,16.8,17.0,16.6,16.1]}}";

    /** A real Geocoding API response for "Nairobi". */
    private static final String NAIROBI_GEOCODING = "{\"results\":[{\"id\":184745,\"name\":\"Nairobi\","
            + "\"latitude\":-1.28333,\"longitude\":36.81667,\"timezone\":\"Africa/Nairobi\","
            + "\"country\":\"Kenya\",\"admin1\":\"Nairobi County\"}],\"generationtime_ms\":0.2}";

    /** Number of checks that passed. */
    private static int passed;

    /** Number of checks that failed. */
    private static int failed;

    /** Utility class: not meant to be instantiated. */
    private WeatherAppTest() {
    }

    /**
     * Runs every check and prints the results.
     *
     * @param args "--live" to include checks against the real API
     */
    public static void main(String[] args) {
        testJson();
        testParsing();
        testErrors();
        testUnits();
        testWeatherCodes();
        testTimeOfDay();
        testHistory();
        if (args.length > 0 && args[0].equals("--live")) {
            testLiveApi();
        }
        System.out.println();
        System.out.println("Tests passed: " + passed + ", failed: " + failed);
    }

    /** The JSON parser handles every type of value, escapes, and bad input. */
    private static void testJson() {
        Object parsed = Json.parse("{\"a\": [1, 2.5, -3e2], \"b\": \"x\\\"y \\u00b0C\", \"c\": true, \"d\": null}");
        check("JSON parser reads objects, arrays, numbers, escapes, true, and null",
                parsed instanceof Map<?, ?> m
                        && m.get("a").equals(List.of(1.0, 2.5, -300.0))
                        && m.get("b").equals("x\"y °C")
                        && m.get("c").equals(Boolean.TRUE)
                        && m.containsKey("d") && m.get("d") == null);
        check("JSON parser rejects invalid text", throwsIllegalArgument("{\"a\": }"));
    }

    /** Real API responses are turned into the right values. */
    private static void testParsing() {
        try {
            Location place = WeatherService.parseGeocoding(NAIROBI_GEOCODING, "Nairobi");
            check("geocoding response gives name, region, country, and coordinates",
                    place.label().equals("Nairobi, Nairobi County, Kenya")
                            && place.latitude() == -1.28333 && place.longitude() == 36.81667);

            WeatherReport report = WeatherService.parseForecast(NAIROBI_FORECAST, place);
            CurrentWeather now = report.current();
            check("current weather: temperature, humidity, wind, and conditions are read",
                    now.temperatureC() == 29.0 && now.humidity() == 29 && now.windKmh() == 8.1
                            && now.weatherCode() == 0 && now.isDay());
            check("local time at the place is read for the dynamic background",
                    now.localTime().equals(LocalDateTime.of(2026, 10, 23, 11, 45)));
            check("forecast has five days with dates, codes, highs, and lows",
                    report.forecast().size() == 5
                            && report.forecast().get(0).equals(
                                    new DailyForecast(LocalDate.of(2026, 10, 23), 51, 30.7, 16.7))
                            && report.forecast().get(4).minC() == 16.1);

            Location typed = WeatherService.parseCoordinates("-1.29, 36.82");
            check("typed coordinates are recognized without a geocoding request",
                    typed != null && typed.latitude() == -1.29 && typed.longitude() == 36.82);
            check("a normal city name is not mistaken for coordinates",
                    WeatherService.parseCoordinates("Nairobi") == null);
        } catch (WeatherException e) {
            check("parsing real responses (" + e.getMessage() + ")", false);
        }
    }

    /** Every error case gives a clear message instead of crashing. */
    private static void testErrors() {
        WeatherService service = new WeatherService();
        check("empty input is rejected with a helpful message",
                messageOf(() -> service.findLocation("   ")).startsWith("Please type a city name"));
        check("coordinates off the Earth are rejected",
                messageOf(() -> WeatherService.parseCoordinates("200, 10")).contains("latitude -90 to 90"));
        check("an unknown place gives a 'not found' message with a tip",
                messageOf(() -> WeatherService.parseGeocoding("{\"generationtime_ms\":0.1}", "Xyzzyqqq"))
                        .startsWith("No place called \"Xyzzyqqq\" was found"));
        check("an API error shows the API's own reason",
                WeatherService.apiErrorMessage(400, "{\"reason\":\"Latitude must be in range of -90 to 90\","
                        + "\"error\":true}").endsWith("Latitude must be in range of -90 to 90"));
        check("too many requests (HTTP 429) asks the user to wait",
                WeatherService.apiErrorMessage(429, "").startsWith("Too many requests"));
        check("a response with missing fields is reported, not crashed on",
                messageOf(() -> WeatherService.parseForecast("{\"current\":{}}", null))
                        .contains("did not send"));
        check("a response that is not JSON is reported clearly",
                messageOf(() -> WeatherService.parseForecast("<html>error</html>", null))
                        .contains("could not be read"));
    }

    /** Unit conversions are correct. */
    private static void testUnits() {
        check("Celsius to Fahrenheit: 0 -> 32, 100 -> 212, -40 -> -40",
                TemperatureUnit.FAHRENHEIT.fromCelsius(0) == 32
                        && TemperatureUnit.FAHRENHEIT.fromCelsius(100) == 212
                        && TemperatureUnit.FAHRENHEIT.fromCelsius(-40) == -40);
        check("temperatures are formatted with the unit symbol",
                TemperatureUnit.CELSIUS.format(29.0).equals("29°C")
                        && TemperatureUnit.FAHRENHEIT.format(29.0).equals("84°F"));
        check("wind: 36 km/h = 10.0 m/s = 22.4 mph",
                WindSpeedUnit.MS.format(36).equals("10.0 m/s")
                        && WindSpeedUnit.MPH.format(36).equals("22.4 mph")
                        && WindSpeedUnit.KMH.format(36).equals("36.0 km/h"));
    }

    /** Weather codes map to the right words and pictures. */
    private static void testWeatherCodes() {
        check("WMO codes give the documented descriptions",
                WeatherCodes.describe(0).equals("Clear sky") && WeatherCodes.describe(63).equals("Moderate rain")
                        && WeatherCodes.describe(95).equals("Thunderstorm")
                        && WeatherCodes.describe(1234).equals("Unknown conditions"));
        check("each kind of weather gets a matching icon",
                WeatherCodes.iconFor(0) == WeatherCodes.IconType.CLEAR
                        && WeatherCodes.iconFor(2) == WeatherCodes.IconType.PARTLY_CLOUDY
                        && WeatherCodes.iconFor(45) == WeatherCodes.IconType.FOG
                        && WeatherCodes.iconFor(81) == WeatherCodes.IconType.RAIN
                        && WeatherCodes.iconFor(73) == WeatherCodes.IconType.SNOW
                        && WeatherCodes.iconFor(99) == WeatherCodes.IconType.THUNDER);
    }

    /** The background changes with the local hour. */
    private static void testTimeOfDay() {
        check("hours map to morning, day, evening (sunset), and night",
                TimeOfDay.fromHour(6) == TimeOfDay.MORNING && TimeOfDay.fromHour(12) == TimeOfDay.DAY
                        && TimeOfDay.fromHour(18) == TimeOfDay.EVENING && TimeOfDay.fromHour(23) == TimeOfDay.NIGHT
                        && TimeOfDay.fromHour(3) == TimeOfDay.NIGHT);
        check("evening and night use light text for contrast",
                TimeOfDay.EVENING.isDark() && TimeOfDay.NIGHT.isDark() && !TimeOfDay.DAY.isDark());
    }

    /** The search history keeps recent searches in order. */
    private static void testHistory() {
        SearchHistory history = new SearchHistory();
        LocalDateTime t = LocalDateTime.of(2026, 10, 23, 9, 0);
        for (int i = 1; i <= 12; i++) {
            history.add(new SearchHistory.Entry("City" + i, "City" + i, 20.0, 0, t.plusMinutes(i)));
        }
        check("history keeps only the 10 most recent searches, newest first",
                history.entries().size() == SearchHistory.CAPACITY
                        && history.entries().get(0).place().equals("City12")
                        && history.entries().get(9).place().equals("City3"));
        history.add(new SearchHistory.Entry("City5", "City5", 21.0, 2, t.plusHours(1)));
        check("searching a place again moves it to the top instead of duplicating it",
                history.entries().get(0).place().equals("City5")
                        && history.entries().stream().filter(e -> e.place().equals("City5")).count() == 1);
        check("history entries show a timestamp",
                history.entries().get(0).toString().equals("2026-10-23 10:00  City5: 21°C, Partly cloudy"));
        check("history temperatures can be shown in the unit chosen later",
                history.entries().get(0).summary(TemperatureUnit.FAHRENHEIT).equals("70°F, Partly cloudy"));
    }

    /** Calls the real API (needs internet). */
    private static void testLiveApi() {
        WeatherService service = new WeatherService();
        try {
            Location place = service.findLocation("London");
            WeatherReport report = service.fetchReport(place);
            check("LIVE: London is found and real weather is returned",
                    place.label().contains("United Kingdom") && report.forecast().size() == 5
                            && report.current().humidity() >= 0 && report.current().humidity() <= 100);
            check("LIVE: a second request within 10 minutes is served from the cache",
                    service.fetchReport(place) == report);
            check("LIVE: an unknown place gives the 'not found' message",
                    messageOf(() -> service.findLocation("Xyzzyqqqplace")).startsWith("No place called"));
        } catch (WeatherException e) {
            check("LIVE: API reachable (" + e.getMessage() + ")", false);
        }
    }

    /** An action that may throw a WeatherException. */
    @FunctionalInterface
    private interface WeatherAction {
        /**
         * Runs the action.
         *
         * @throws WeatherException if the action fails
         */
        void run() throws WeatherException;
    }

    /**
     * Runs an action that should fail and returns its error message.
     *
     * @param action the action
     * @return the WeatherException message, or "" if no exception was thrown
     */
    private static String messageOf(WeatherAction action) {
        try {
            action.run();
            return "";
        } catch (WeatherException e) {
            return e.getMessage();
        }
    }

    /**
     * Tells whether parsing the text throws IllegalArgumentException.
     *
     * @param json the text to parse
     * @return true if it was rejected
     */
    private static boolean throwsIllegalArgument(String json) {
        try {
            Json.parse(json);
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    /**
     * Records one check and prints PASS or FAIL.
     *
     * @param description what the check verifies
     * @param condition   true if the check passed
     */
    private static void check(String description, boolean condition) {
        if (condition) {
            passed++;
            System.out.println("PASS  " + description);
        } else {
            failed++;
            System.out.println("FAIL  " + description);
        }
    }
}
