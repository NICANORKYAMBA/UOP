/**
 * Entry point for the simple multithreaded clock application.
 *
 * <p>The program creates one shared {@link Clock} and runs two cooperating
 * threads on it:</p>
 *
 * <ul>
 *   <li>a background <em>updater</em> thread ({@link ClockUpdater}) that
 *       refreshes the clock's stored time, given a lower priority; and</li>
 *   <li>a <em>display</em> thread ({@link ClockDisplay}) that prints the time
 *       to the console, given a higher priority for better timekeeping
 *       precision on screen.</li>
 * </ul>
 *
 * <p>Both threads update the clock continuously. To keep the demonstration
 * self-contained and easy to capture in a screenshot, the program runs the
 * clock for a fixed number of seconds and then stops the two threads cleanly.</p>
 *
 * @author Nicanor Maswili
 */
public class Main {

    /** How long the demonstration runs, in milliseconds. */
    private static final long RUN_DURATION_MILLIS = 15_000L;

    /** How often the background thread refreshes the time, in milliseconds. */
    private static final long UPDATE_INTERVAL_MILLIS = 1_000L;

    /** How often the display thread prints the time, in milliseconds. */
    private static final long DISPLAY_INTERVAL_MILLIS = 1_000L;

    /** Utility class: prevent instantiation. */
    private Main() {
    }

    /**
     * Launches the clock threads, runs them for a fixed period, then stops them.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Clock clock = new Clock();

        ClockUpdater updaterTask =
                new ClockUpdater(clock, UPDATE_INTERVAL_MILLIS);
        ClockDisplay displayTask =
                new ClockDisplay(clock, DISPLAY_INTERVAL_MILLIS);

        Thread updaterThread = new Thread(updaterTask, "Clock-Updater");
        Thread displayThread = new Thread(displayTask, "Clock-Display");

        // The display thread is favored by the scheduler over the updater so
        // that printing the time is prioritized for smoother timekeeping.
        updaterThread.setPriority(Thread.MIN_PRIORITY);
        displayThread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("Starting clock application...");
        System.out.println("Updater thread priority: "
                + updaterThread.getPriority()
                + " | Display thread priority: "
                + displayThread.getPriority());
        System.out.println("(The clock will run for "
                + (RUN_DURATION_MILLIS / 1000) + " seconds.)");
        System.out.println();

        updaterThread.start();
        displayThread.start();

        try {
            Thread.sleep(RUN_DURATION_MILLIS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Ask both tasks to stop, then interrupt to break any active sleep.
        updaterTask.stop();
        displayTask.stop();
        updaterThread.interrupt();
        displayThread.interrupt();

        try {
            updaterThread.join();
            displayThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println();
        System.out.println("Clock application stopped.");
    }
}
