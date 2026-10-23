/** Temperature units the user can choose. The API always returns Celsius. */
public enum TemperatureUnit {

    /** Degrees Celsius (the API's unit). */
    CELSIUS("°C"),

    /** Degrees Fahrenheit: F = C × 9/5 + 32. */
    FAHRENHEIT("°F");

    /** The symbol shown after a value. */
    private final String symbol;

    /**
     * Creates a unit.
     *
     * @param symbol the symbol shown after a value
     */
    TemperatureUnit(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Converts a Celsius value to this unit.
     *
     * @param celsius the temperature in degrees Celsius
     * @return the temperature in this unit
     */
    public double fromCelsius(double celsius) {
        return this == CELSIUS ? celsius : celsius * 9.0 / 5.0 + 32.0;
    }

    /**
     * Formats a Celsius value in this unit, rounded to a whole degree, e.g. "84°F".
     *
     * @param celsius the temperature in degrees Celsius
     * @return the formatted temperature
     */
    public String format(double celsius) {
        return Math.round(fromCelsius(celsius)) + symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
