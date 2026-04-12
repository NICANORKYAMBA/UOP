# CS 1102 — Unit 1 Discussion Assignment
## Introduction to Java Programming

---

**Part 1: Variables and Data Types in Java**

Understanding variables and data types is foundational to writing correct, efficient Java programs. A variable is a named container in memory that holds a value, and its data type determines what kind of value it can store and how much memory it occupies (Eck, 2022, §2.2). Without this understanding, a programmer cannot reliably store, retrieve, or manipulate data.

Java offers two broad categories of data types. Primitive types are the eight built-in types that store values directly in memory: `byte`, `short`, `int`, `long`, `float`, `double`, `char`, and `boolean`. For example, `int score = 95;` stores the integer 95 directly in the variable. Reference types, by contrast, store a memory address pointing to an object. `String name = "Nicanor";` stores a reference to a String object, not the characters themselves. This distinction matters because assigning one reference variable to another copies the address, not the object — a common source of bugs for beginners.

Among primitive types, `int` is the default choice for whole numbers and `double` for real numbers, as Eck (2022) recommends. Choosing the wrong type causes problems: storing a decimal in an `int` truncates it silently, and using `float` instead of `double` loses precision. For instance, `float pi = 3.14159265358979f;` rounds to approximately 3.1415927, while `double pi = 3.14159265358979;` preserves full precision.

Variables and data types work together: the type constrains what operations are valid. You can perform arithmetic on `int` and `double`, but not on `boolean`. This type safety is one of Java's strengths — it catches mismatches at compile time rather than at runtime.

**Word count: 240**

---

**Part 2: Operator Precedence in Java**

Operator precedence defines the order in which Java evaluates operators within an expression when no parentheses are present. Misunderstanding precedence is a frequent source of logic errors that compile successfully but produce wrong results (Eck, 2022, §2.5.7).

Java's precedence hierarchy, from highest to lowest, is: unary operators (`++`, `--`, `!`), then multiplication and division (`*`, `/`, `%`), then addition and subtraction (`+`, `-`), then relational operators (`<`, `>`, `<=`, `>=`), then equality (`==`, `!=`), then logical AND (`&&`), then logical OR (`||`), then the ternary operator (`?:`), and finally assignment operators (`=`, `+=`, etc.).

Consider this example: `int result = 2 + 3 * 4;`. A programmer expecting left-to-right evaluation would predict 20, but Java evaluates multiplication first, giving 14. The fix is explicit parentheses: `int result = (2 + 3) * 4;` yields 20. Similarly, `boolean check = 5 > 3 || 2 > 8 && false;` evaluates the `&&` before `||`, giving `true || false` = `true` — which may not be the intended logic.

Eck (2022) advises programmers to "use parentheses liberally" rather than relying on memorized precedence rules (p. 55). This improves both correctness and readability. In complex boolean expressions controlling conditionals or loops, a misplaced precedence assumption can cause entire branches to execute incorrectly. Understanding precedence also helps when reading others' code — recognizing that `a += b * c` means `a = a + (b * c)` prevents misinterpretation.

**Word count: 233**

---

**Part 3: Conditional Statements in Java**

Conditional statements are the mechanism by which Java programs make decisions, executing different code paths based on runtime conditions. Without them, programs would execute the same sequence of instructions every time, regardless of input (Eck, 2022, §3.5).

Java provides three main conditional constructs. The **if-else** statement evaluates any boolean expression and branches accordingly. It handles range checks and complex conditions naturally: `if (score >= 90) { grade = 'A'; } else if (score >= 80) { grade = 'B'; }`. Its strength is flexibility — any boolean expression works. Its limitation is verbosity when testing many discrete values.

The **switch** statement tests a single expression against a list of constant values. It works with `int`, `char`, `String`, and enum types, but not `double` or `float` (Eck, 2022, §3.6). Switch excels at menu-driven programs and fixed-value dispatch. Java 17 introduced a cleaner arrow syntax (`case "A" -> ...`) that eliminates the fall-through problem of the traditional syntax, where forgetting a `break` causes execution to continue into the next case unintentionally.

The **ternary operator** (`condition ? valueIfTrue : valueIfFalse`) is a compact single-line conditional best suited for simple value assignments: `String label = (score >= 60) ? "Pass" : "Fail";`. It reduces boilerplate but becomes unreadable when nested.

The choice between them depends on the situation: use if-else for range conditions or complex logic, switch for equality checks against many fixed values, and ternary for concise single-value assignments. Selecting the right construct improves both program clarity and maintainability.

**Word count: 245**

---

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, Swing ed.). Creative Commons CC 4.0. https://math.hws.edu/javanotes/
