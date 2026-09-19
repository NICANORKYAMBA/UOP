/**
 * Background task that keeps a {@link Clock} up to date.
 *
 * <p>This class implements {@link Runnable} so that it can be run on its own
 * thread. Implementing {@code Runnable} (rather than extending {@code Thread})
 * keeps the task separate from the thread that runs it, which is the more
 * flexible of the two approaches for creating threads in Java. The task loops
 * continuously, refreshing the shared clock's stored time roughly once every
 * update interval, until it is asked to stop.</p>
 *
 * @author Nicanor Maswili
 */
public class ClockUpdater implements Runnable {

    /** The shared clock whose time this task refreshes. */
    private final Clock clock;

    /** Milliseconds to wait between successive time updates. */
    private final long updateIntervalMillis;

    /** Set to false to request that the update loop stop cleanly. */
    private volatile boolean running;

    /**
     * Creates an updater for the given clock.
     *
     * @param clock                the shared clock to keep updated;
     *                             must not be null
     * @param updateIntervalMillis delay between updates, in milliseconds;
     *                             must be positive
     * @throws IllegalArgumentException if clock is null or the interval is
     *                                  not positive
     */
    public ClockUpdater(Clock clock, long updateIntervalMillis) {
        if (clock == null) {
            throw new IllegalArgumentException("Clock must not be null.");
        }
        if (updateIntervalMillis <= 0) {
            throw new IllegalArgumentException(
                    "Update interval must be positive.");
        }
        this.clock = clock;
        this.updateIntervalMillis = updateIntervalMillis;
        this.running = true;
    }

    /**
     * Requests that the update loop stop before its next iteration.
     */
    public void stop() {
        this.running = false;
    }

    /**
     * Continuously refreshes the clock's time until stopped.
     *
     * <p>The loop sleeps for the update interval between refreshes. If the
     * thread is interrupted while sleeping, the loop treats that as a request
     * to stop, restores the thread's interrupted status, and exits cleanly.</p>
     */
    @Override
    public void run() {
        while (this.running) {
            this.clock.updateTime();
            try {
                Thread.sleep(this.updateIntervalMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                this.running = false;
            }
        }
    }
}
