/** Extra details stored for a DVD. */
public record DvdDetails(int runtimeMinutes, String rating) {

    public DvdDetails {
        if (runtimeMinutes <= 0) {
            throw new IllegalArgumentException("Runtime must be greater than zero.");
        }
    }

    @Override
    public String toString() {
        return "DVD, " + runtimeMinutes + " min, rated " + rating;
    }
}
