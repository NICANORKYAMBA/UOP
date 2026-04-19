import java.util.Scanner;

/**
 * LibrarySystem.java
 *
 * A basic library management system that allows users to:
 *   1. Add books (new or update existing quantity)
 *   2. Borrow books (if available)
 *   3. Return books (if they belong to the library)
 *   4. Exit the program
 *
 * Control structures used:
 *   - while loop: keeps the menu running until the user exits
 *   - switch statement: dispatches menu choices
 *   - if-else: validates availability and membership
 *   - try-catch: handles invalid numeric input
 *
 * Author : Nicanor Kyamba
 * Course : CS 1102 — Programming 1, Unit 2
 */
public class LibrarySystem {

    // ── Constants ────────────────────────────────────────────────
    static final int MAX_BOOKS = 100; // maximum distinct titles

    // ── Parallel arrays to store library data ───────────────────
    static String[] titles   = new String[MAX_BOOKS];
    static String[] authors  = new String[MAX_BOOKS];
    static int[]    quantity = new int[MAX_BOOKS];
    static int      bookCount = 0; // number of distinct titles currently stored

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean running = true; // controls the main menu loop

        System.out.println("============================================");
        System.out.println("       Welcome to the Library System        ");
        System.out.println("============================================");

        // ── Main menu loop (while) ───────────────────────────────
        // Keeps running until the user selects Exit
        while (running) {
            printMenu();
            System.out.print("Enter your choice (1-4): ");

            int choice = 0;
            // try-catch: handle non-integer menu input
            try {
                choice = Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.\n");
                continue; // skip to next iteration of the while loop
            }

            // switch: dispatch to the correct operation
            switch (choice) {
                case 1 -> addBook(input);
                case 2 -> borrowBook(input);
                case 3 -> returnBook(input);
                case 4 -> {
                    System.out.println("Thank you for using the Library System. Goodbye!");
                    running = false; // exit the while loop
                }
                default -> System.out.println("Invalid choice. Please enter 1, 2, 3, or 4.\n");
            }
        }

        input.close();
    }

    // ── Print the main menu ──────────────────────────────────────
    static void printMenu() {
        System.out.println("--------------------------------------------");
        System.out.println("1. Add Books");
        System.out.println("2. Borrow Books");
        System.out.println("3. Return Books");
        System.out.println("4. Exit");
        System.out.println("--------------------------------------------");
    }

    // ── Find the index of a book by title (-1 if not found) ─────
    static int findBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (titles[i].equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }

    // ── Add Books ────────────────────────────────────────────────
    static void addBook(Scanner input) {
        System.out.println("\n--- Add Books ---");
        System.out.print("Enter book title: ");
        String title = input.nextLine().trim();

        System.out.print("Enter author name: ");
        String author = input.nextLine().trim();

        // Validate that title and author are not empty
        if (title.isEmpty() || author.isEmpty()) {
            System.out.println("Error: Title and author cannot be empty.\n");
            return;
        }

        // Validate quantity input
        int qty = 0;
        try {
            System.out.print("Enter quantity to add: ");
            qty = Integer.parseInt(input.nextLine().trim());
            if (qty <= 0) {
                System.out.println("Error: Quantity must be a positive number.\n");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid quantity. Please enter a whole number.\n");
            return;
        }

        // Check if book already exists — if so, update quantity
        int index = findBook(title);
        if (index != -1) {
            quantity[index] += qty;
            System.out.println("Updated: \"" + titles[index] + "\" — new quantity: " + quantity[index] + "\n");
        } else {
            // New book — add to library if space available
            if (bookCount >= MAX_BOOKS) {
                System.out.println("Error: Library is full. Cannot add more titles.\n");
                return;
            }
            titles[bookCount]   = title;
            authors[bookCount]  = author;
            quantity[bookCount] = qty;
            bookCount++;
            System.out.println("Added: \"" + title + "\" by " + author + " — quantity: " + qty + "\n");
        }
    }

    // ── Borrow Books ─────────────────────────────────────────────
    static void borrowBook(Scanner input) {
        System.out.println("\n--- Borrow Books ---");
        System.out.print("Enter book title: ");
        String title = input.nextLine().trim();

        // Validate quantity input
        int qty = 0;
        try {
            System.out.print("Enter number of books to borrow: ");
            qty = Integer.parseInt(input.nextLine().trim());
            if (qty <= 0) {
                System.out.println("Error: Quantity must be a positive number.\n");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid quantity. Please enter a whole number.\n");
            return;
        }

        int index = findBook(title);

        // if-else: check if book exists and has sufficient quantity
        if (index == -1) {
            System.out.println("Error: \"" + title + "\" is not in the library.\n");
        } else if (quantity[index] < qty) {
            System.out.println("Error: Only " + quantity[index] + " copy/copies of \""
                    + titles[index] + "\" available. Cannot borrow " + qty + ".\n");
        } else {
            quantity[index] -= qty;
            System.out.println("Success: You borrowed " + qty + " copy/copies of \""
                    + titles[index] + "\". Remaining: " + quantity[index] + "\n");
        }
    }

    // ── Return Books ─────────────────────────────────────────────
    static void returnBook(Scanner input) {
        System.out.println("\n--- Return Books ---");
        System.out.print("Enter book title: ");
        String title = input.nextLine().trim();

        // Validate quantity input
        int qty = 0;
        try {
            System.out.print("Enter number of books to return: ");
            qty = Integer.parseInt(input.nextLine().trim());
            if (qty <= 0) {
                System.out.println("Error: Quantity must be a positive number.\n");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid quantity. Please enter a whole number.\n");
            return;
        }

        int index = findBook(title);

        // if-else: check if book belongs to this library
        if (index == -1) {
            System.out.println("Error: \"" + title + "\" does not belong to this library system.\n");
        } else {
            quantity[index] += qty;
            System.out.println("Success: Returned " + qty + " copy/copies of \""
                    + titles[index] + "\". New quantity: " + quantity[index] + "\n");
        }
    }
}
