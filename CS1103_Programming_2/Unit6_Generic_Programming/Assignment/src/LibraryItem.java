import java.util.Objects;

/**
 * A single item in the library, such as a book, DVD, or magazine.
 *
 * <p>The class is generic in {@code T}, the type of the item's type-specific details.
 * A book can carry {@link BookDetails}, a DVD {@link DvdDetails}, and a magazine
 * {@link MagazineDetails}, while every item shares the same title, author, and itemID.
 *
 * @param <T> the type of the extra details stored for this kind of item
 */
public class LibraryItem<T> {

    private final String itemID;
    private final String title;
    private final String author;
    private final T details;

    /**
     * Creates a library item.
     *
     * @param itemID  unique identifier, for example "B001"
     * @param title   title of the item
     * @param author  author, director, or publisher
     * @param details type-specific details (may not be null)
     * @throws IllegalArgumentException if any text field is blank or details is null
     */
    public LibraryItem(String itemID, String title, String author, T details) {
        this.itemID = requireText(itemID, "Item ID");
        this.title = requireText(title, "Title");
        this.author = requireText(author, "Author");
        if (details == null) {
            throw new IllegalArgumentException("Details cannot be null.");
        }
        this.details = details;
    }

    private static String requireText(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " cannot be empty.");
        }
        return value.trim();
    }

    public String getItemID() {
        return itemID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public T getDetails() {
        return details;
    }

    /** Two items are equal when they have the same item ID. */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LibraryItem<?> item)) {
            return false;
        }
        return itemID.equalsIgnoreCase(item.itemID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemID.toUpperCase());
    }

    @Override
    public String toString() {
        return String.format("[%s] \"%s\" by %s | %s", itemID, title, author, details);
    }
}
