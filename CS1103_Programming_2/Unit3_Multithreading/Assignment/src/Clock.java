import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a simple clock that keeps track of the current date and time.
 *
 * <p>The clock stores a single time value that is refreshed by a background
 * updating thread and read by a separate display thread. Because the value is
 * shared between two threads, all access to it is synchronized so that a reader
 * never sees a partially written value. The time is formatted for display in
 * the pattern {@code HH:mm:ss dd-MM-yyyy}.</p>
 *
 * @author Nicanor Maswili
 */
public class Clock {

    /** Display pattern: hours:minutes:seconds day-month-year. */
    private static final String TIME_PATTERN = "HH:mm:ss dd-MM-yyyy";

    /** Formatter used to turn a {@link LocalDateTime} into readable text. */
    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern(TIME_PATTERN);

    /** The most recent time captured by the updating thread. */
    private LocalDateTime currentTime;

    /**
     * Creates a clock initialized to the current system date and time.
     */
    public Clock() {
        this.currentTime = LocalDateTime.now();
    }

    /**
     * Refreshes the stored time to the current system date and time.
     *
     * <p>This method is intended to be called repeatedly by the background
     * updating thread. It is synchronized so that the update is not interleaved
     * with a read performed by the display thread.</p>
     */
    public synchronized void updateTime() {
        this.currentTime = LocalDateTime.now();
    }

    /**
     * Returns the stored time formatted as {@code HH:mm:ss dd-MM-yyyy}.
     *
     * <p>This method is synchronized so that it reads a complete, consistent
     * value even while the updating thread is running.</p>
     *
     * @return the current stored time as a formatted string
     */
    public synchronized String getFormattedTime() {
        return this.currentTime.format(this.formatter);
    }

    /**
     * Prints the current formatted time to the console on its own line.
     *
     * <p>This method is intended to be called repeatedly by the display thread.
     * Each call prints the latest time on a new line so that a screenshot of
     * the console clearly shows the clock advancing from one second to the
     * next, demonstrating that it updates continuously.</p>
     */
    public void displayTime() {
        System.out.println("Current time: " + getFormattedTime());
    }
}
