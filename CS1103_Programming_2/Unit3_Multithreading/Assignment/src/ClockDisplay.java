/**
 * Task that repeatedly prints a {@link Clock}'s time to the console.
 *
 * <p>Like {@link ClockUpdater}, this class implements {@link Runnable} so it
 * can run on its own thread. It is meant to run on a higher-priority thread
 * than the updater so that displaying the time is favored by the scheduler,
 * giving smoother, more precise timekeeping on screen. The task loops until it
 * is asked to stop.</p>
 *
 * @author Nicanor Maswili
 */
public class ClockDisplay implements Runnable {

    /** The shared clock whose time this task prints. */
    private final Clock clock;

    /** Milliseconds to wait between successive prints. */
    private final long displayIntervalMillis;

    /** Set to false to request that the display loop stop cleanly. */
    private volatile boolean running;

    /**
     * Creates a display task for the given clock.
     *
     * @param clock                 the shared clock to display; must not be
     *                              null
     * @param displayIntervalMillis delay between prints, in milliseconds;
     *                              must be positive
     * @throws IllegalArgumentException if clock is null or the interval is
     *                                  not positive
     */
    public ClockDisplay(Clock clock, long displayIntervalMillis) {
        if (clock == null) {
            throw new IllegalArgumentException("Clock must not be null.");
        }
        if (displayIntervalMillis <= 0) {
            throw new IllegalArgumentException(
                    "Display interval must be positive.");
        }
        this.clock = clock;
        this.displayIntervalMillis = displayIntervalMillis;
        this.running = true;
    }

    /**
     * Requests that the display loop stop before its next iteration.
     */
    public void stop() {
        this.running = false;
    }

    /**
     * Continuously prints the clock's time until stopped.
     *
     * <p>The loop sleeps for the display interval between prints. If the thread
     * is interrupted while sleeping, the loop treats that as a request to stop,
     * restores the thread's interrupted status, and exits cleanly.</p>
     */
    @Override
    public void run() {
        while (this.running) {
            this.clock.displayTime();
            try {
                Thread.sleep(this.displayIntervalMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                this.running = false;
            }
        }
    }
}
