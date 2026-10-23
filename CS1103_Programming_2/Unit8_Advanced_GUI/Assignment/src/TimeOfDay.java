import java.awt.Color;

/**
 * Parts of the day, each with its own background colours, used for the dynamic background.
 */
public enum TimeOfDay {

    /** 05:00 to 10:59, a soft sunrise sky. */
    MORNING("Morning", new Color(255, 200, 150), new Color(135, 190, 235)),

    /** 11:00 to 16:59, a bright blue sky. */
    DAY("Daytime", new Color(70, 150, 230), new Color(170, 215, 250)),

    /** 17:00 to 19:59, an orange and purple sunset. */
    EVENING("Evening", new Color(250, 130, 70), new Color(110, 70, 140)),

    /** 20:00 to 04:59, a dark night sky. */
    NIGHT("Night", new Color(15, 25, 60), new Color(45, 55, 100));

    /** The name shown to the user. */
    private final String label;

    /** Colour at the top of the window. */
    private final Color top;

    /** Colour at the bottom of the window. */
    private final Color bottom;

    /**
     * Creates a part of the day.
     *
     * @param label  the name shown to the user
     * @param top    colour at the top of the window
     * @param bottom colour at the bottom of the window
     */
    TimeOfDay(String label, Color top, Color bottom) {
        this.label = label;
        this.top = top;
        this.bottom = bottom;
    }

    /**
     * Finds the part of the day for an hour on the 24-hour clock.
     *
     * @param hour the hour, 0 to 23
     * @return the matching part of the day
     */
    public static TimeOfDay fromHour(int hour) {
        if (hour >= 5 && hour < 11) {
            return MORNING;
        } else if (hour >= 11 && hour < 17) {
            return DAY;
        } else if (hour >= 17 && hour < 20) {
            return EVENING;
        }
        return NIGHT;
    }

    /**
     * Returns the colour at the top of the background.
     *
     * @return the top colour
     */
    public Color top() {
        return top;
    }

    /**
     * Returns the colour at the bottom of the background.
     *
     * @return the bottom colour
     */
    public Color bottom() {
        return bottom;
    }

    /**
     * Tells whether light text is needed for good contrast on this background.
     *
     * @return true for the darker evening and night backgrounds
     */
    public boolean isDark() {
        return this == EVENING || this == NIGHT;
    }

    @Override
    public String toString() {
        return label;
    }
}
