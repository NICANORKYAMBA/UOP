import java.util.List;
import java.util.Scanner;

/**
 * Command-line interface for the generic library catalog.
 *
 * <p>Users can add books, DVDs, and magazines, remove an item, view one item's details,
 * view the whole catalog, and search by author. Every error is caught and shown as a clear
 * message, so the program never crashes on bad input.
 */
public class LibraryApp {

    private final Catalog<LibraryItem<?>> catalog = new Catalog<>();
    private final Scanner input;

    public LibraryApp(Scanner input) {
        this.input = input;
    }

    public static void main(String[] args) {
        LibraryApp app = new LibraryApp(new Scanner(System.in));
        app.loadSampleItems();
        app.run();
    }

    /** Adds a few starting items so the catalog is not empty on launch. */
    private void loadSampleItems() {
        try {
            catalog.addItem(new LibraryItem<>("B001", "Introduction to Programming Using Java",
                    "David J. Eck", new BookDetails(640, "978-1-0000-0001-1")));
            catalog.addItem(new LibraryItem<>("D001", "The Imitation Game",
                    "Morten Tyldum", new DvdDetails(114, "PG-13")));
            catalog.addItem(new LibraryItem<>("M001", "National Geographic",
                    "National Geographic Society", new MagazineDetails(245, "October 2026")));
        } catch (DuplicateItemException e) {
            System.out.println("Could not load sample items: " + e.getMessage());
        }
    }

    /** Shows the menu until the user chooses to exit. */
    public void run() {
        System.out.println("=== Generic Library Catalog ===");
        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Choose an option: ");
            switch (choice) {
                case 1 -> addItem();
                case 2 -> removeItem();
                case 3 -> viewItem();
                case 4 -> Catalog.printItems("Current catalog", catalog.getAllItems());
                case 5 -> searchByAuthor();
                case 0 -> running = false;
                default -> System.out.println("Please choose a number from the menu.");
            }
        }
        System.out.println("Goodbye!");
    }

    private void printMenu() {
        System.out.println();
        System.out.println("1. Add a new item");
        System.out.println("2. Remove an item");
        System.out.println("3. View item details");
        System.out.println("4. View the current catalog");
        System.out.println("5. Search by author");
        System.out.println("0. Exit");
    }

    private void addItem() {
        System.out.println("Item type: 1 = Book, 2 = DVD, 3 = Magazine");
        int type = readInt("Type: ");
        if (type < 1 || type > 3) {
            System.out.println("Unknown item type, nothing was added.");
            return;
        }
        String id = readLine("Item ID: ");
        String title = readLine("Title: ");
        String author = readLine("Author: ");
        try {
            LibraryItem<?> item = switch (type) {
                case 1 -> new LibraryItem<>(id, title, author,
                        new BookDetails(readInt("Pages: "), readLine("ISBN: ")));
                case 2 -> new LibraryItem<>(id, title, author,
                        new DvdDetails(readInt("Runtime (minutes): "), readLine("Rating: ")));
                default -> new LibraryItem<>(id, title, author,
                        new MagazineDetails(readInt("Issue number: "), readLine("Month: ")));
            };
            catalog.addItem(item);
            System.out.println("Added: " + item);
        } catch (DuplicateItemException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void removeItem() {
        String id = readLine("ID of the item to remove: ");
        try {
            LibraryItem<?> removed = catalog.removeItem(id);
            System.out.println("Removed: " + removed);
        } catch (ItemNotFoundException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void viewItem() {
        String id = readLine("ID of the item to view: ");
        try {
            LibraryItem<?> item = catalog.getItem(id);
            System.out.println("Item ID : " + item.getItemID());
            System.out.println("Title   : " + item.getTitle());
            System.out.println("Author  : " + item.getAuthor());
            System.out.println("Details : " + item.getDetails());
        } catch (ItemNotFoundException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void searchByAuthor() {
        String author = readLine("Author name (or part of it): ").toLowerCase();
        List<LibraryItem<?>> found =
                catalog.findItems(item -> item.getAuthor().toLowerCase().contains(author));
        Catalog.printItems("Search results", found);
    }

    /** Reads a whole number, asking again until the user enters one. */
    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!input.hasNextLine()) {
                return 0;           // end of input: treat as Exit
            }
            String line = input.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    private String readLine(String prompt) {
        System.out.print(prompt);
        return input.hasNextLine() ? input.nextLine().trim() : "";
    }
}
