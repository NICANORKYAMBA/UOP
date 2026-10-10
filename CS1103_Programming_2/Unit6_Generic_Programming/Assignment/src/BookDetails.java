/** Extra details stored for a book. */
public record BookDetails(int pages, String isbn) {

    public BookDetails {
        if (pages <= 0) {
            throw new IllegalArgumentException("Pages must be greater than zero.");
        }
    }

    @Override
    public String toString() {
        return "Book, " + pages + " pages, ISBN " + isbn;
    }
}
