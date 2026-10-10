import java.util.List;

/**
 * Tests for the generic catalog and LibraryItem classes. Runs without any external
 * framework: each check prints PASS or FAIL, and a summary is printed at the end.
 */
public class CatalogTest {

    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) throws Exception {
        testAddAndRetrieve();
        testTypedCatalogs();
        testMixedCatalog();
        testRemoveExisting();
        testRemoveMissing();
        testGetMissing();
        testDuplicateId();
        testInvalidItems();
        testSearch();
        System.out.printf("%nTests passed: %d, failed: %d%n", passed, failed);
        if (failed > 0) {
            System.exit(1);
        }
    }

    private static void check(String name, boolean condition) {
        if (condition) {
            passed++;
            System.out.println("PASS  " + name);
        } else {
            failed++;
            System.out.println("FAIL  " + name);
        }
    }

    private static LibraryItem<BookDetails> book(String id) {
        return new LibraryItem<>(id, "Java Basics", "Ada Writer", new BookDetails(300, "111"));
    }

    private static void testAddAndRetrieve() throws Exception {
        Catalog<LibraryItem<BookDetails>> books = new Catalog<>();
        books.addItem(book("B1"));
        LibraryItem<BookDetails> found = books.getItem("b1");      // IDs are case-insensitive
        check("add then retrieve returns the same item", found.getTitle().equals("Java Basics"));
        check("retrieved details keep their type", found.getDetails().pages() == 300);
        check("size is 1 after one add", books.size() == 1);
    }

    private static void testTypedCatalogs() throws Exception {
        Catalog<LibraryItem<DvdDetails>> dvds = new Catalog<>();
        dvds.addItem(new LibraryItem<>("D1", "Inception", "Christopher Nolan", new DvdDetails(148, "PG-13")));
        int minutes = dvds.getItem("D1").getDetails().runtimeMinutes();   // no cast needed
        check("DVD catalog returns DvdDetails without casting", minutes == 148);

        Catalog<LibraryItem<MagazineDetails>> magazines = new Catalog<>();
        magazines.addItem(new LibraryItem<>("M1", "Wired", "Conde Nast", new MagazineDetails(10, "May")));
        check("magazine catalog works with MagazineDetails", magazines.getItem("M1").getDetails().issueNumber() == 10);
    }

    private static void testMixedCatalog() throws Exception {
        Catalog<LibraryItem<?>> mixed = new Catalog<>();
        mixed.addItem(book("B1"));
        mixed.addItem(new LibraryItem<>("D1", "Up", "Pete Docter", new DvdDetails(96, "PG")));
        mixed.addItem(new LibraryItem<>("M1", "Time", "Time USA", new MagazineDetails(3, "June")));
        check("mixed catalog holds books, DVDs, and magazines", mixed.size() == 3);
        check("items are listed in the order added",
                mixed.getAllItems().get(2).getItemID().equals("M1"));
    }

    private static void testRemoveExisting() throws Exception {
        Catalog<LibraryItem<BookDetails>> books = new Catalog<>();
        books.addItem(book("B1"));
        books.addItem(book("B2"));
        LibraryItem<BookDetails> removed = books.removeItem("B1");
        check("remove returns the removed item", removed.getItemID().equals("B1"));
        check("catalog shrinks after remove", books.size() == 1);
    }

    private static void testRemoveMissing() {
        Catalog<LibraryItem<BookDetails>> books = new Catalog<>();
        try {
            books.removeItem("X99");
            check("removing a missing item throws ItemNotFoundException", false);
        } catch (ItemNotFoundException e) {
            check("removing a missing item throws ItemNotFoundException",
                    e.getMessage().contains("X99"));
        }
    }

    private static void testGetMissing() {
        Catalog<LibraryItem<?>> mixed = new Catalog<>();
        try {
            mixed.getItem("NOPE");
            check("viewing a missing item throws ItemNotFoundException", false);
        } catch (ItemNotFoundException e) {
            check("viewing a missing item throws ItemNotFoundException", true);
        }
    }

    private static void testDuplicateId() throws Exception {
        Catalog<LibraryItem<BookDetails>> books = new Catalog<>();
        books.addItem(book("B1"));
        try {
            books.addItem(book("b1"));
            check("adding a duplicate ID throws DuplicateItemException", false);
        } catch (DuplicateItemException e) {
            check("adding a duplicate ID throws DuplicateItemException", books.size() == 1);
        }
    }

    private static void testInvalidItems() {
        boolean blankTitleRejected;
        try {
            new LibraryItem<>("B5", "  ", "Someone", new BookDetails(10, "1"));
            blankTitleRejected = false;
        } catch (IllegalArgumentException e) {
            blankTitleRejected = true;
        }
        check("a blank title is rejected", blankTitleRejected);

        boolean badPagesRejected;
        try {
            new BookDetails(0, "1");
            badPagesRejected = false;
        } catch (IllegalArgumentException e) {
            badPagesRejected = true;
        }
        check("zero pages is rejected", badPagesRejected);
    }

    private static void testSearch() throws Exception {
        Catalog<LibraryItem<?>> mixed = new Catalog<>();
        mixed.addItem(book("B1"));
        mixed.addItem(new LibraryItem<>("D1", "Up", "Pete Docter", new DvdDetails(96, "PG")));
        List<LibraryItem<?>> found = mixed.findItems(item -> item.getAuthor().contains("Ada"));
        check("search by author finds the matching item", found.size() == 1
                && found.get(0).getItemID().equals("B1"));
    }
}
