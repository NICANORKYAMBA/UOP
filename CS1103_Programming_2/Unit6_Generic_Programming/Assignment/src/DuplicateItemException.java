/** Thrown when adding an item whose ID is already used in the catalog. */
public class DuplicateItemException extends Exception {

    private static final long serialVersionUID = 1L;

    public DuplicateItemException(String itemID) {
        super("An item with ID \"" + itemID + "\" already exists in the catalog.");
    }
}
