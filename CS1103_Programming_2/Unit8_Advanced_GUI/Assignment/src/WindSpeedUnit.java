import java.util.Locale;

/** Wind speed units the user can choose. The API always returns kilometres per hour. */
public enum WindSpeedUnit {

    /** Kilometres per hour (the API's unit). */
    KMH("km/h", 1.0),

    /** Metres per second: 1 km/h = 1000 m / 3600 s. */
    MS("m/s", 1000.0 / 3600.0),

    /** Miles per hour: 1 mile = 1.609344 km. */
    MPH("mph", 1.0 / 1.609344);

    /** The symbol shown after a value. */
    private final String symbol;

    /** How many of this unit equal 1 km/h. */
    private final double perKmh;

    /**
     * Creates a unit.
     *
     * @param symbol the symbol shown after a value
     * @param perKmh how many of this unit equal 1 km/h
     */
    WindSpeedUnit(String symbol, double perKmh) {
        this.symbol = symbol;
        this.perKmh = perKmh;
    }

    /**
     * Converts a km/h value to this unit.
     *
     * @param kmh the speed in kilometres per hour
     * @return the speed in this unit
     */
    public double fromKmh(double kmh) {
        return kmh * perKmh;
    }

    /**
     * Formats a km/h value in this unit with one decimal place, e.g. "2.3 m/s".
     *
     * @param kmh the speed in kilometres per hour
     * @return the formatted speed
     */
    public String format(double kmh) {
        return String.format(Locale.ROOT, "%.1f %s", fromKmh(kmh), symbol);
    }

    @Override
    public String toString() {
        return symbol;
    }
}
