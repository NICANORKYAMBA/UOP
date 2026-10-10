/** Thrown when an operation refers to an item ID that is not in the catalog. */
public class ItemNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public ItemNotFoundException(String itemID) {
        super("No item with ID \"" + itemID + "\" exists in the catalog.");
    }
}
