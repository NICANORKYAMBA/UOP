# Programming Assignment Unit 6: Generic Library Catalog

**Course:** CS 1103 Programming 2
**Student:** Nicanor Maswili
**Instructor:** Dr. Abeena Azad
**Due:** October 14, 2026

## Overview

This program is a generic library catalog in Java that stores and manages different kinds of
library items: books, DVDs, and magazines. Generics let one catalog class and one item class work
with many data types while the compiler still checks every type, which removes the need for casts
and catches mistakes at compile time instead of at run time (Divertitto, 2022; Eck, 2022). The
program has a command-line menu for adding, removing, viewing, and searching items, custom
exceptions for every error case, and an automated test class.

## Design

The program is made of seven small classes, each with one job.

**Table 1**

*Classes in the Program*

| Class | Kind | Role |
|---|---|---|
| LibraryItem<T> | generic class | One item: itemID, title, author, and type-specific details of type T |
| BookDetails, DvdDetails, MagazineDetails | records | The type-specific details (pages and ISBN; runtime and rating; issue and month) |
| Catalog<T extends LibraryItem<?>> | generic class | Stores items and provides add, remove, retrieve, list, search, and map operations |
| ItemNotFoundException | checked exception | Thrown when an ID is not in the catalog |
| DuplicateItemException | checked exception | Thrown when an ID is already used |
| LibraryApp | main program | The command-line menu |
| CatalogTest | test program | 16 automated checks of the catalog and items |

```
                  +--------------------------------------+
                  |  Catalog<T extends LibraryItem<?>>   |
                  |  addItem(T)        removeItem(id)    |
                  |  getItem(id)       getAllItems()     |
                  |  findItems(Predicate<? super T>)     |
                  |  <R> mapItems(Function<..., R>)      |
                  |  <E> printItems(label, List<E>)      |
                  +------------------+-------------------+
                                     | stores many
                                     v
                  +--------------------------------------+
                  |  LibraryItem<T>                      |
                  |  itemID, title, author, T details    |
                  +----+-------------+--------------+----+
                       |             |              |
                BookDetails     DvdDetails    MagazineDetails
```

### How Generics Are Used

1. **A generic class for items.** LibraryItem<T> keeps the fields every item shares (title,
   author, itemID) and stores the type-specific data in a field of type T. A
   LibraryItem<BookDetails> therefore returns BookDetails from getDetails(), so the program reads
   the page count directly, without a cast. Adding a new item type, such as an audiobook, only
   needs a new details record; LibraryItem and Catalog do not change.
2. **A bounded generic class for the catalog.** Catalog<T extends LibraryItem<?>> accepts any kind
   of library item but nothing else. Eck (2022) explains that a bounded type parameter restricts
   the types that can be used while keeping full type checking. The same class works in two ways:
   a Catalog<LibraryItem<DvdDetails>> accepts only DVDs, while the menu program uses a
   Catalog<LibraryItem<?>> that holds a mix of books, DVDs, and magazines.
3. **Wildcards for flexible methods.** findItems takes a Predicate<? super T>, so a search
   condition written for the general type LibraryItem<?> can be reused on a catalog of books. A
   lower-bounded wildcard, written with super, accepts the named type or any of its supertypes,
   which is exactly what a reusable condition needs (Coding with John, 2021; Kumar, 2023).
4. **Generic methods.** A generic method declares its own type parameter before its return type
   (Bro Code, 2020; Eck, 2022). The catalog has two. The static method
   <E extends LibraryItem<?>> printItems(String, List<E>) prints any list of library items, so the
   same code displays the full catalog and the search results. The instance method
   <R> List<R> mapItems(Function<? super T, ? extends R>) turns every item into a value of
   whatever type R the caller chooses, for example a list of titles (List<String>).
5. **A type-safe collection inside.** The catalog stores items in a LinkedHashMap<String, T>, part
   of the Java Collection Framework, keyed by the upper-case ID. Lookups by ID are fast, IDs are
   case-insensitive, and items are listed in the order they were added (Eck, 2022).

### Error Handling

Every error is caught and turned into a clear message, so the program never crashes.

**Table 2**

*Error Cases and How They Are Handled*

| Situation | Handling | Message shown |
|---|---|---|
| Removing or viewing an ID that does not exist | ItemNotFoundException | No item with ID "X999" exists in the catalog. |
| Adding an ID that is already used | DuplicateItemException | An item with ID "D001" already exists in the catalog. |
| A blank title, author, or ID | IllegalArgumentException from the constructor | Title cannot be empty. |
| Zero or negative pages, runtime, or issue | IllegalArgumentException from the record | Pages must be greater than zero. |
| Letters typed where a number is expected | NumberFormatException, caught; the prompt repeats | Please enter a whole number. |
| A menu number that does not exist | default case of the switch | Please choose a number from the menu. |

Making ItemNotFoundException and DuplicateItemException **checked** exceptions means the compiler
forces every caller of removeItem, getItem, and addItem to handle them.

## Requirements Checklist

**Table 3**

*Assignment Requirements and Where They Are Met*

| Requirement | Where it is met |
|---|---|
| Generic catalog class for books, DVDs, magazines | Catalog<T extends LibraryItem<?>> |
| Generic LibraryItem class with title, author, itemID | LibraryItem<T> |
| LibraryItem compatible with the catalog | The bound T extends LibraryItem<?> |
| Add, remove, and retrieve item details | addItem, removeItem, getItem (plus getAllItems and findItems) |
| Error handling for removing a non-existent item | ItemNotFoundException with a clear message |
| Command-line interface: add, remove, view catalog | LibraryApp menu options 1 to 5 |
| Comprehensive testing with various item types | CatalogTest: 16 checks covering books, DVDs, magazines, and mixed catalogs |

## Compile and Run

From the src folder (Java 17 or newer, because the details classes are records):

```
javac -d ../bin *.java
java -cp ../bin CatalogTest      (runs the automated tests)
java -cp ../bin LibraryApp       (starts the menu program)
```

The code compiles with javac -Xlint:all with no errors and no warnings.

## Testing

### Automated Tests

CatalogTest checks the catalog with every item type, a mixed catalog, both generic methods, and every
error case. All 16 checks pass:

```
PASS  add then retrieve returns the same item
PASS  retrieved details keep their type
PASS  size is 1 after one add
PASS  DVD catalog returns DvdDetails without casting
PASS  magazine catalog works with MagazineDetails
PASS  mixed catalog holds books, DVDs, and magazines
PASS  items are listed in the order added
PASS  remove returns the removed item
PASS  catalog shrinks after remove
PASS  removing a missing item throws ItemNotFoundException
PASS  viewing a missing item throws ItemNotFoundException
PASS  adding a duplicate ID throws DuplicateItemException
PASS  a blank title is rejected
PASS  zero pages is rejected
PASS  search by author finds the matching item
PASS  generic mapItems returns each item's title

Tests passed: 16, failed: 0
```

### Menu Program Test Run

The menu program was run through the steps in Table 4, which use every operation and every error
message.

**Table 4**

*Menu Test Steps and Results*

| Step | Action | Result |
|---|---|---|
| 1 | View the catalog | Shows the 3 sample items (a book, a DVD, a magazine) |
| 2 | Add book B002, "Effective Java" by Joshua Bloch | Added: [B002] "Effective Java" by Joshua Bloch, 412 pages |
| 3 | Add a DVD with the existing ID D001 | Error: an item with ID "D001" already exists |
| 4 | Type "abc", then 9, at the menu | "Please enter a whole number", then "Please choose a number from the menu" |
| 5 | View details of B002 | Shows its ID, title, author, and book details |
| 6 | Remove X999 | Error: no item with ID "X999" exists |
| 7 | Remove D001 | Removed: The Imitation Game |
| 8 | Search for author "bloch" | Finds Effective Java |
| 9 | View the catalog | 3 items: B001, M001, B002 |

## Screenshots of Output

**Figure 1**

*Automated Tests: All 16 Checks Pass*

[FIGURE figures/fig1_tests.png]

**Figure 2**

*Adding an Item, and the Duplicate-ID and Invalid-Input Errors*

[FIGURE figures/fig2_add_errors.png]

**Figure 3**

*Viewing Details, Removing a Missing and an Existing Item, Searching, and the Final Catalog*

[FIGURE figures/fig3_remove_view.png]

## Source Code

[CODE src/LibraryItem.java]

[CODE src/BookDetails.java]

[CODE src/DvdDetails.java]

[CODE src/MagazineDetails.java]

[CODE src/ItemNotFoundException.java]

[CODE src/DuplicateItemException.java]

[CODE src/Catalog.java]

[CODE src/LibraryApp.java]

[CODE src/CatalogTest.java]

## References

Bro Code. (2020, July 27). *Java generics* [Video]. YouTube. https://www.youtube.com/watch?v=jUcAyZ5OUm0

Coding with John. (2021, December 20). *Generics in Java - Full simple tutorial* [Video]. YouTube.
https://www.youtube.com/watch?v=K1iu1kXkVoA

Divertitto, A. (2022, August 18). *Java generics: How to use angled brackets in practice*. CodeGym.
https://codegym.cc/groups/posts/generics-in-java

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, JavaFX ed.). Hobart and
William Smith Colleges. https://math.hws.edu/javanotes/c10/s5.html

Kumar, A. (2023, April 18). *Mastering generics in Java: A comprehensive guide for Java developers*.
Tech Thoughts Explorer.
https://techthoughtsexplorer.hashnode.dev/mastering-generics-in-java-a-comprehensive-guide-for-java-developers
