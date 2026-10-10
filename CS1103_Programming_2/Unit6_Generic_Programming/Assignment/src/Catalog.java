import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * A generic catalog that stores and manages library items.
 *
 * <p>The bounded type parameter {@code T extends LibraryItem<?>} means the catalog accepts
 * any kind of library item, whatever its details type, while still giving compile-time type
 * safety. A {@code Catalog<LibraryItem<BookDetails>>} accepts only books, and a
 * {@code Catalog<LibraryItem<?>>} accepts a mix of books, DVDs, and magazines.
 *
 * @param <T> the type of library item stored in this catalog
 */
public class Catalog<T extends LibraryItem<?>> {

    /** Items keyed by upper-case ID; LinkedHashMap keeps the order items were added. */
    private final Map<String, T> items = new LinkedHashMap<>();

    /**
     * Adds a new item to the catalog.
     *
     * @param item the item to add
     * @throws DuplicateItemException   if an item with the same ID is already stored
     * @throws IllegalArgumentException if item is null
     */
    public void addItem(T item) throws DuplicateItemException {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add a null item.");
        }
        String key = keyFor(item.getItemID());
        if (items.containsKey(key)) {
            throw new DuplicateItemException(item.getItemID());
        }
        items.put(key, item);
    }

    /**
     * Removes an item from the catalog.
     *
     * @param itemID the ID of the item to remove
     * @return the item that was removed
     * @throws ItemNotFoundException if no item has this ID
     */
    public T removeItem(String itemID) throws ItemNotFoundException {
        T removed = items.remove(keyFor(itemID));
        if (removed == null) {
            throw new ItemNotFoundException(itemID);
        }
        return removed;
    }

    /**
     * Retrieves the details of one item.
     *
     * @param itemID the ID of the item
     * @return the matching item
     * @throws ItemNotFoundException if no item has this ID
     */
    public T getItem(String itemID) throws ItemNotFoundException {
        T item = items.get(keyFor(itemID));
        if (item == null) {
            throw new ItemNotFoundException(itemID);
        }
        return item;
    }

    /** Returns every item, in the order added, as a read-only list. */
    public List<T> getAllItems() {
        return Collections.unmodifiableList(new ArrayList<>(items.values()));
    }

    /**
     * Returns the items that match a condition. The wildcard {@code ? super T} lets a
     * condition written for a more general type, such as {@code LibraryItem<?>}, be reused.
     *
     * @param condition the test each returned item must pass
     * @return matching items, in the order added
     */
    public List<T> findItems(Predicate<? super T> condition) {
        List<T> matches = new ArrayList<>();
        for (T item : items.values()) {
            if (condition.test(item)) {
                matches.add(item);
            }
        }
        return matches;
    }

    /**
     * Generic method that converts every item into a value of another type, for example
     * each item's title (a String) or its ID. The method's own type parameter {@code R}
     * is chosen by the caller, so one method serves many purposes.
     *
     * @param <R>    the type of value produced for each item
     * @param mapper the conversion applied to each item
     * @return the converted values, in the order the items were added
     */
    public <R> List<R> mapItems(Function<? super T, ? extends R> mapper) {
        List<R> results = new ArrayList<>();
        for (T item : items.values()) {
            results.add(mapper.apply(item));
        }
        return results;
    }

    /** Returns the number of items in the catalog. */
    public int size() {
        return items.size();
    }

    /** Returns true when the catalog holds no items. */
    public boolean isEmpty() {
        return items.isEmpty();
    }

    /**
     * Generic static helper that prints any list of library items as a numbered list.
     *
     * @param <E>   the item type
     * @param label heading to print
     * @param list  the items to print
     */
    public static <E extends LibraryItem<?>> void printItems(String label, List<E> list) {
        System.out.println(label + " (" + list.size() + " item" + (list.size() == 1 ? "" : "s") + ")");
        if (list.isEmpty()) {
            System.out.println("  (none)");
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + list.get(i));
        }
    }

    private static String keyFor(String itemID) {
        if (itemID == null || itemID.isBlank()) {
            throw new IllegalArgumentException("Item ID cannot be empty.");
        }
        return itemID.trim().toUpperCase();
    }
}
