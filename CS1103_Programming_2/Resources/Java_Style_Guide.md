# Java Programming Style Guide — CS 1103

Programs are written to be **read, understood, and modified by humans**. In this course,
programs are graded for **style as well as correctness**. Keep these rules in mind for
every programming assignment. (Additional rules may be added as the course progresses.)

---

## The Main Rule

**0. A program should be readable.** This rule overrides all the others. Aim for good
taste, learned by studying how expert programmers write code.

---

## Comments

1. **Every class** (except anonymous inner classes) should have a **Javadoc comment**
   stating its purpose and describing its public interface in general terms. Except for
   nested classes, include an **`@author`** tag with your name.
2. **Every non-private method** should have a **Javadoc comment** explaining what it does.
   Document preconditions (e.g., restrictions on parameter values), the purpose of each
   parameter, the meaning of any return value, and exceptions it may throw. Use
   **`@param`**, **`@return`**, and **`@throws`** tags.
3. **Every variable with a non-trivial role** (member or local) should have a comment
   explaining its purpose. Non-private member variables use Javadoc format. Loop counters
   and trivial local utility variables generally don't need comments.
4. Comments **inside a method** are for explaining logic where needed. Well-written code
   needs few comments.
5. **Never** use comments to explain the Java language itself. Assume the reader knows Java.

---

## Formatting

6. **Use indentation** to show structure. Indent class bodies, method bodies, and each
   level of nested statements. (In Eclipse: highlight code and press **Ctrl-I** to fix
   indentation. **In IntelliJ IDEA** — the IDE used in this repo — use
   **Ctrl+Alt+L** to reformat, or **Ctrl+Alt+I** to auto-indent the selection.)
7. A closing **`}`** goes on a line by itself. The opening **`{`** may sit at the end of a
   line or on its own line — pick one style and be **consistent**.
8. **One statement per line.**
9. **Avoid long lines** — generally keep to **≤ 80 characters**; break longer statements
   across lines.
10. **Avoid deep nesting.** More than two or three levels suggests you should extract
    subroutines.
11. Use **blank spaces and blank lines** for readability: blank lines between methods,
    spaces around operators (`=`, `==`, `!=`, etc.).

---

## Naming

12. Use **meaningful names** for variables, methods, and classes.
13. Use **consistent capitalization**, following Java convention:
    - variables, methods, packages → begin **lowercase**
    - class names → begin **Uppercase**
    - multi-word names → camelCase (e.g., `interestRate`)
14. Use **`final static`** for named constants; consider **`enum`** for related constants.
    Constant names are **UPPER_CASE** with underscores separating words.

---

## Methods

15. A method should have a **clear, single, identifiable task**.
16. Keep method definitions **short** — ideally no longer than one printed page.
17. Instance methods may access instance variables, but **don't use instance variables
    just to pass information between methods** — use **parameters and return values**.

---

## Classes

18. A class should represent a **clear, single, identifiable concept**.
19. Use **`public`, `protected`, `private`** to control access to variables and methods.
20. Member variables should generally be **`private`**; provide **getter/setter** methods
    to access and manipulate them.

---

*Source: CS 1103 course Style Guide (Style Rules for Java Programming).*
