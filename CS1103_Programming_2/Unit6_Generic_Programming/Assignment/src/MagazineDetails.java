/** Extra details stored for a magazine. */
public record MagazineDetails(int issueNumber, String month) {

    public MagazineDetails {
        if (issueNumber <= 0) {
            throw new IllegalArgumentException("Issue number must be greater than zero.");
        }
    }

    @Override
    public String toString() {
        return "Magazine, issue " + issueNumber + " (" + month + ")";
    }
}
