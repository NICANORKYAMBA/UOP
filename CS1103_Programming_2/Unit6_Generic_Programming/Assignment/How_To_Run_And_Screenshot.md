# How to Run the Library Catalog and Take the Screenshots

The program is in `Assignment/src`. It needs Java 17 or newer (you have Java 21).

## Option A: IntelliJ
1. Open the `Unit6_Generic_Programming/Assignment/src` folder (or mark it as a Sources Root).
2. Right-click `CatalogTest.java` → **Run**. Take **Screenshot 1** of the PASS lines and the
   "Tests passed: 15, failed: 0" summary.
3. Right-click `LibraryApp.java` → **Run**, then follow the steps below in the Run window.

## Option B: Terminal
```
cd ~/UOP/CS1103_Programming_2/Unit6_Generic_Programming/Assignment/src
javac -d ../bin *.java
java -cp ../bin CatalogTest
java -cp ../bin LibraryApp
```

## What to type in LibraryApp (matches Table 4 in the paper)

**Screenshot 2: adding and errors**
1. `4` (view catalog: 3 sample items)
2. `1`, then `1` (Book), ID `B002`, title `Effective Java`, author `Joshua Bloch`, pages `412`,
   ISBN `978-0-13-468599-1` → "Added: ..."
3. `1`, then `2` (DVD), ID `D001`, title `Duplicate Test`, author `Someone`, runtime `100`,
   rating `PG` → "Error: An item with ID "D001" already exists"
4. `abc` → "Please enter a whole number", then `9` → "Please choose a number from the menu"
   → take **Screenshot 2**

**Screenshot 3: viewing, removing, searching**
5. `3`, ID `B002` → item details
6. `2`, ID `X999` → "Error: No item with ID "X999" exists in the catalog."
7. `2`, ID `D001` → "Removed: ..."
8. `5`, author `bloch` → finds Effective Java
9. `4` → final catalog (B001, M001, B002) → take **Screenshot 3**, then `0` to exit

## Save the screenshots as
`Assignment/figures/fig1_tests.png`, `fig2_add_errors.png`, `fig3_remove_view.png`
(or leave them in Downloads and tell me which is which). Then run, from the Unit 6 folder:
```
python3 build_docx.py
```
