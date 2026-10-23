import java.util.Map;

/**
 * Translates WMO weather codes, which the API returns, into words and icon types.
 *
 * <p>The descriptions follow the WMO code table in the Open-Meteo documentation.
 */
public final class WeatherCodes {

    /** The kind of picture used for a condition. */
    public enum IconType {
        /** Sun, or moon at night. */
        CLEAR,
        /** Sun or moon partly behind a cloud. */
        PARTLY_CLOUDY,
        /** Two clouds. */
        CLOUDY,
        /** Cloud with fog bands. */
        FOG,
        /** Cloud with a few raindrops. */
        DRIZZLE,
        /** Dark cloud with heavy rain. */
        RAIN,
        /** Cloud with snowflakes. */
        SNOW,
        /** Dark cloud with lightning. */
        THUNDER
    }

    /** Code to description, as listed in the Open-Meteo documentation. */
    private static final Map<Integer, String> DESCRIPTIONS = Map.ofEntries(
            Map.entry(0, "Clear sky"), Map.entry(1, "Mainly clear"),
            Map.entry(2, "Partly cloudy"), Map.entry(3, "Overcast"),
            Map.entry(45, "Fog"), Map.entry(48, "Depositing rime fog"),
            Map.entry(51, "Light drizzle"), Map.entry(53, "Moderate drizzle"),
            Map.entry(55, "Dense drizzle"), Map.entry(56, "Light freezing drizzle"),
            Map.entry(57, "Dense freezing drizzle"), Map.entry(61, "Slight rain"),
            Map.entry(63, "Moderate rain"), Map.entry(65, "Heavy rain"),
            Map.entry(66, "Light freezing rain"), Map.entry(67, "Heavy freezing rain"),
            Map.entry(71, "Slight snowfall"), Map.entry(73, "Moderate snowfall"),
            Map.entry(75, "Heavy snowfall"), Map.entry(77, "Snow grains"),
            Map.entry(80, "Slight rain showers"), Map.entry(81, "Moderate rain showers"),
            Map.entry(82, "Violent rain showers"), Map.entry(85, "Slight snow showers"),
            Map.entry(86, "Heavy snow showers"), Map.entry(95, "Thunderstorm"),
            Map.entry(96, "Thunderstorm with slight hail"), Map.entry(97, "Heavy thunderstorm"),
            Map.entry(99, "Thunderstorm with heavy hail"));

    /** Utility class: not meant to be instantiated. */
    private WeatherCodes() {
    }

    /**
     * Returns the description of a weather code.
     *
     * @param code the WMO weather code
     * @return the description, or "Unknown conditions" for a code not in the table
     */
    public static String describe(int code) {
        return DESCRIPTIONS.getOrDefault(code, "Unknown conditions");
    }

    /**
     * Chooses the icon type for a weather code.
     *
     * @param code the WMO weather code
     * @return the icon type that best pictures the condition
     */
    public static IconType iconFor(int code) {
        if (code <= 1) {
            return IconType.CLEAR;
        } else if (code == 2) {
            return IconType.PARTLY_CLOUDY;
        } else if (code == 3) {
            return IconType.CLOUDY;
        } else if (code == 45 || code == 48) {
            return IconType.FOG;
        } else if (code >= 51 && code <= 57) {
            return IconType.DRIZZLE;
        } else if ((code >= 61 && code <= 67) || (code >= 80 && code <= 82)) {
            return IconType.RAIN;
        } else if ((code >= 71 && code <= 77) || code == 85 || code == 86) {
            return IconType.SNOW;
        } else if (code >= 95) {
            return IconType.THUNDER;
        }
        return IconType.CLOUDY; // unknown code: a neutral picture
    }
}
