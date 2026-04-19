# CS 1102 — Unit 2 Programming Assignment
## Basic Library Management System

**Student**: Nicanor Kyamba
**Course**: CS 1102 — Programming 1
**Unit**: 2 — Control Structures

---

## 1. Program Overview

This program implements a basic library management system with four menu options: Add Books, Borrow Books, Return Books, and Exit. The system stores each book's title, author, and available quantity using three parallel arrays. The program runs continuously in a menu loop until the user chooses to exit, and handles all invalid input without crashing. It demonstrates the full range of Unit 2 control structures: a `while` loop for the main menu, a `switch` statement for menu dispatch, nested `if-else` statements for availability and membership checks, a `for` loop for searching the collection, and `try-catch` blocks for exception handling.

---

## 2. Functionality

The program correctly implements three core operations — `addBook`, `borrowBook`, and `returnBook` — as static methods, each with its own input validation and nested control structures.

**addBook**: Prompts the user for title, author, and quantity. It first validates that neither the title nor author is an empty string. It then uses a `try-catch` block nested inside the method to catch `NumberFormatException` if the quantity is not a valid integer, and an `if` statement to reject non-positive quantities. After validation, a `findBook` call determines whether the book already exists. An `if-else` statement then either updates the existing quantity or adds the book as a new entry:

```java
int index = findBook(title);
if (index != -1) {
    quantity[index] += qty;  // existing book — update quantity
} else {
    titles[bookCount]   = title;
    authors[bookCount]  = author;
    quantity[bookCount] = qty;
    bookCount++;             // new book — add to collection
}
```

**borrowBook**: Prompts for title and quantity. After input validation, it uses a chained `if-else if-else` — a nested control structure — to check two conditions in sequence: whether the book exists in the library, and whether sufficient copies are available:

```java
if (index == -1) {
    System.out.println("Error: book not in library.");
} else if (quantity[index] < qty) {
    System.out.println("Error: only " + quantity[index] + " available.");
} else {
    quantity[index] -= qty;
    System.out.println("Success: borrowed " + qty + " copies.");
}
```

This is the multiway branching pattern described by Eck (2022, Section 3.5.2) — each condition is tested in order and only one branch executes.

**returnBook**: Prompts for title and quantity. After validation, it checks whether the book belongs to the library using `findBook`. If the book is not in the system, an error message is displayed. If it is, the quantity is incremented and a success message is shown. This correctly implements the requirement to verify library membership before accepting a return.

All three methods display appropriate success and error messages for every scenario, including: book not found, insufficient copies, invalid quantity input, empty title/author, and successful operations.

---

## 3. Code Organization

The program is organized into six static methods, each with a single, clearly defined responsibility:

| Method | Responsibility |
|--------|---------------|
| `main` | Entry point — initializes Scanner, runs the main while loop |
| `printMenu` | Displays the four menu options |
| `findBook` | Linear search through titles array — returns index or -1 |
| `addBook` | Handles Add Books operation with full validation |
| `borrowBook` | Handles Borrow Books operation with availability check |
| `returnBook` | Handles Return Books operation with membership check |

The three parallel arrays (`titles`, `authors`, `quantity`) and the `bookCount` counter are declared as static class-level variables so all methods can access them without passing them as parameters. The constant `MAX_BOOKS = 100` is declared with `static final` to make its purpose clear and prevent accidental modification.

All variable names follow Java's camelCase convention: `bookCount`, `running`, `index`, `qty`, `title`, `author`. The `boolean running` variable is a flag variable — a signal set in one part of the program and tested in another — as described by Eck (2022, Section 3.3.2). Indentation is consistent at four spaces throughout. Every logical section is preceded by a comment explaining its purpose.

---

## 4. Efficiency and Readability

**Book storage**: The parallel array approach is appropriate for this stage of the course. Three arrays of size 100 store titles, authors, and quantities at matching indices. A `bookCount` integer tracks how many entries are in use, so the `findBook` loop only iterates over actual entries, not empty slots:

```java
static int findBook(String title) {
    for (int i = 0; i < bookCount; i++) {  // only searches used entries
        if (titles[i].equalsIgnoreCase(title)) {
            return i;
        }
    }
    return -1;
}
```

The `equalsIgnoreCase` comparison means "Clean Code" and "clean code" are treated as the same book, which is the correct behavior for a library system.

**Exception handling placement**: The `try-catch` blocks are placed precisely around the `Integer.parseInt()` calls that can throw `NumberFormatException` — not around entire methods. This is the targeted approach Eck (2022, Section 3.7.2) demonstrates: catch only what you expect, at the exact point where it can occur.

**Input reading**: All input is read with `input.nextLine().trim()` rather than `input.nextInt()`. This prevents the common Scanner bug where `nextInt()` leaves a newline in the buffer, causing the next `nextLine()` call to read an empty string. Using `nextLine()` throughout and parsing manually gives complete control over input handling.

**Comments**: Every method has a header comment describing its purpose and return value. Every control structure has an inline comment explaining which structure is being used and why. The Javadoc block at the top of the class lists all control structures used, the author, and the course.

---

## 5. Full Program Code

```java
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
 *   - while loop     : keeps the menu running until the user exits
 *   - switch         : dispatches menu choices to the correct method
 *   - if-else        : validates availability and library membership
 *   - for loop       : searches the book collection by title
 *   - try-catch      : handles invalid numeric input gracefully
 *
 * Author : Nicanor Kyamba
 * Course : CS 1102 — Programming 1, Unit 2
 */
public class LibrarySystem {

    // Maximum number of distinct book titles the library can hold
    static final int MAX_BOOKS = 100;

    // Parallel arrays — index i holds data for the same book across all three
    static String[] titles   = new String[MAX_BOOKS];
    static String[] authors  = new String[MAX_BOOKS];
    static int[]    quantity = new int[MAX_BOOKS];
    static int      bookCount = 0; // number of distinct titles currently stored

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean running = true; // flag variable — set to false to exit the loop

        System.out.println("============================================");
        System.out.println("       Welcome to the Library System        ");
        System.out.println("============================================");

        // while loop: continues until the user selects Exit (option 4)
        while (running) {
            printMenu();
            System.out.print("Enter your choice (1-4): ");

            int choice = 0;
            // try-catch: catches NumberFormatException for non-integer menu input
            try {
                choice = Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.\n");
                continue; // continue: skip to next while iteration, redisplay menu
            }

            // switch: dispatches to the correct operation based on menu choice
            switch (choice) {
                case 1 -> addBook(input);
                case 2 -> borrowBook(input);
                case 3 -> returnBook(input);
                case 4 -> {
                    System.out.println("Thank you for using the Library System. Goodbye!");
                    running = false; // set flag to false — exits the while loop
                }
                default -> System.out.println("Invalid choice. Please enter 1, 2, 3, or 4.\n");
            }
        }

        input.close(); // release Scanner resource
    }

    // Displays the four menu options to the user
    static void printMenu() {
        System.out.println("--------------------------------------------");
        System.out.println("1. Add Books");
        System.out.println("2. Borrow Books");
        System.out.println("3. Return Books");
        System.out.println("4. Exit");
        System.out.println("--------------------------------------------");
    }

    // Searches for a book by title (case-insensitive linear search)
    // Returns: index of the book if found, -1 if not found
    static int findBook(String title) {
        // for loop: counting loop — iterates only over entries in use
        for (int i = 0; i < bookCount; i++) {
            if (titles[i].equalsIgnoreCase(title)) {
                return i; // book found — return its index immediately
            }
        }
        return -1; // book not found
    }

    // Adds a new book to the library, or updates quantity if it already exists
    static void addBook(Scanner input) {
        System.out.println("\n--- Add Books ---");
        System.out.print("Enter book title: ");
        String title = input.nextLine().trim();

        System.out.print("Enter author name: ");
        String author = input.nextLine().trim();

        // if: validate that title and author are not empty strings
        if (title.isEmpty() || author.isEmpty()) {
            System.out.println("Error: Title and author cannot be empty.\n");
            return;
        }

        // try-catch: handle non-integer quantity (NumberFormatException)
        int qty = 0;
        try {
            System.out.print("Enter quantity to add: ");
            qty = Integer.parseInt(input.nextLine().trim());
            // nested if: validate that quantity is a positive number
            if (qty <= 0) {
                System.out.println("Error: Quantity must be a positive number.\n");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid quantity. Please enter a whole number.\n");
            return;
        }

        int index = findBook(title);
        // if-else: update existing book OR add new book
        if (index != -1) {
            // book already exists — update its quantity
            quantity[index] += qty;
            System.out.println("Updated: \"" + titles[index] + "\" — new quantity: "
                    + quantity[index] + "\n");
        } else {
            // new book — check capacity before adding
            if (bookCount >= MAX_BOOKS) {
                System.out.println("Error: Library is full. Cannot add more titles.\n");
                return;
            }
            titles[bookCount]   = title;
            authors[bookCount]  = author;
            quantity[bookCount] = qty;
            bookCount++;
            System.out.println("Added: \"" + title + "\" by " + author
                    + " — quantity: " + qty + "\n");
        }
    }

    // Borrows a specified number of copies if they are available
    static void borrowBook(Scanner input) {
        System.out.println("\n--- Borrow Books ---");
        System.out.print("Enter book title: ");
        String title = input.nextLine().trim();

        // try-catch: handle non-integer quantity input
        int qty = 0;
        try {
            System.out.print("Enter number of books to borrow: ");
            qty = Integer.parseInt(input.nextLine().trim());
            // nested if: validate positive quantity
            if (qty <= 0) {
                System.out.println("Error: Quantity must be a positive number.\n");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid quantity. Please enter a whole number.\n");
            return;
        }

        int index = findBook(title);
        // chained if-else if-else: nested control structure
        // checks existence first, then availability
        if (index == -1) {
            // book does not exist in the library
            System.out.println("Error: \"" + title + "\" is not in the library.\n");
        } else if (quantity[index] < qty) {
            // book exists but not enough copies available
            System.out.println("Error: Only " + quantity[index] + " copy/copies of \""
                    + titles[index] + "\" available. Cannot borrow " + qty + ".\n");
        } else {
            // book exists and sufficient copies available — process borrow
            quantity[index] -= qty;
            System.out.println("Success: You borrowed " + qty + " copy/copies of \""
                    + titles[index] + "\". Remaining: " + quantity[index] + "\n");
        }
    }

    // Returns books to the library if they belong to the system
    static void returnBook(Scanner input) {
        System.out.println("\n--- Return Books ---");
        System.out.print("Enter book title: ");
        String title = input.nextLine().trim();

        // try-catch: handle non-integer quantity input
        int qty = 0;
        try {
            System.out.print("Enter number of books to return: ");
            qty = Integer.parseInt(input.nextLine().trim());
            // nested if: validate positive quantity
            if (qty <= 0) {
                System.out.println("Error: Quantity must be a positive number.\n");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid quantity. Please enter a whole number.\n");
            return;
        }

        int index = findBook(title);
        // if-else: verify book belongs to this library before accepting return
        if (index == -1) {
            // book not in system — cannot accept return
            System.out.println("Error: \"" + title
                    + "\" does not belong to this library system.\n");
        } else {
            // book belongs to library — update quantity
            quantity[index] += qty;
            System.out.println("Success: Returned " + qty + " copy/copies of \""
                    + titles[index] + "\". New quantity: " + quantity[index] + "\n");
        }
    }
}
```

---

## 6. Output (Screenshots)

*Open LibrarySystem.java in IntelliJ IDEA, run the program, and insert screenshots below.*

### Screenshot 1 — IDE Screenshot
*[INSERT: IntelliJ IDEA editor showing the full LibrarySystem.java code with the project panel visible on the left side]*

### Screenshot 2 — Add Books (New and Existing) + Borrow Success
*[INSERT: Console showing the following sequence:*
- *Select 1 → Add "Clean Code" by Robert Martin, qty 3 → "Added: Clean Code by Robert Martin — quantity: 3"*
- *Select 1 → Add "Java Programming" by James Gosling, qty 5 → "Added: Java Programming by James Gosling — quantity: 5"*
- *Select 1 → Add "Clean Code" again, qty 2 → "Updated: Clean Code — new quantity: 5" (existing book updated)*
- *Select 2 → Borrow "Clean Code" qty 3 → "Success: You borrowed 3 copies. Remaining: 2"]*

### Screenshot 3 — Borrow Insufficient Copies + Return Success + Return Unknown Book
*[INSERT: Console showing:*
- *Select 2 → Borrow "Java Programming" qty 10 → "Error: Only 5 available. Cannot borrow 10."*
- *Select 3 → Return "Clean Code" qty 1 → "Success: Returned 1 copy. New quantity: 3"*
- *Select 3 → Return "Unknown Book" qty 1 → "Error: Unknown Book does not belong to this library system."]*

### Screenshot 4 — Invalid Input Handling
*[INSERT: Console showing:*
- *Enter "abc" at menu → "Invalid input. Please enter a number between 1 and 4."*
- *Select 1 → Enter "Clean Code", "Robert Martin", then "xyz" as quantity → "Error: Invalid quantity. Please enter a whole number."*
- *Select 2 → Enter "Clean Code", then "-5" as quantity → "Error: Quantity must be a positive number."]*

---

## 7. References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, Swing ed.). Creative Commons CC 4.0. https://math.hws.edu/javanotes/
