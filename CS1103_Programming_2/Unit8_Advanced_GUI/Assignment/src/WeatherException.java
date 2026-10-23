/**
 * A problem that stops a weather search, with a message written for the user.
 *
 * <p>It is a checked exception, so every caller of {@link WeatherService} must handle invalid
 * input, unknown places, and network or API failures.
 */
public class WeatherException extends Exception {

    /** Version number for serialization. */
    private static final long serialVersionUID = 1L;

    /**
     * Creates an exception with a message that can be shown to the user.
     *
     * @param message what went wrong, in plain language
     */
    public WeatherException(String message) {
        super(message);
    }

    /**
     * Creates an exception that also keeps the technical cause.
     *
     * @param message what went wrong, in plain language
     * @param cause   the underlying exception
     */
    public WeatherException(String message, Throwable cause) {
        super(message, cause);
    }
}
