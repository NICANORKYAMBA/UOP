# CS 1102 — Unit 2 Discussion Assignment
## Control Structures in Java

**Student**: Nicanor Kyamba
**Course**: CS 1102 — Programming 1, Unit 2

---

## Part 1: Looping Control Structures — while, do-while, and for

Java provides three looping control structures, each suited to different programming scenarios. Understanding their nuances is essential for writing efficient, readable code.

The **while** loop tests its continuation condition before executing the body, meaning the body may execute zero times if the condition is false from the start (Eck, 2022, Section 3.3.1). This makes it the right choice when the number of iterations is unknown and the loop may legitimately need to be skipped entirely. A practical example is reading user input until a sentinel value is entered — if the user immediately enters the sentinel, the loop body never runs, which is the correct behavior.

The **do-while** loop moves the condition test to the end, guaranteeing the body executes at least once (Eck, 2022, Section 3.3.2). This is the natural choice for menus, input validation prompts, and game loops — situations where the action must occur before it makes sense to ask whether to continue. For instance, a menu must be displayed before the user can choose to exit. Using a while loop here would require duplicating the display code before the loop, which violates the DRY (Don't Repeat Yourself) principle.

The **for** loop consolidates initialization, condition, and update into a single line, making it the most readable structure for counted iteration (Eck, 2022, Section 3.4). Traversing an array, printing a multiplication table, or repeating an action a fixed number of times are all natural fits. Eck (2022) observes that for loops likely outnumber while loops in real programs precisely because keeping all loop control in one place reduces cognitive load for the reader (Section 3.4).

The key trade-off is between flexibility and clarity. The while loop is the most general — any for or do-while loop can be rewritten as a while loop — but the for loop's compact syntax wins on readability for counted iteration, and the do-while's guaranteed first execution eliminates redundant code in menu-driven programs. Choosing the right loop structure is not just a stylistic preference; it communicates intent to anyone reading the code.

**Word count: 320**

---

## Part 2: if-else vs switch Statements

Both if-else and switch statements implement conditional branching, but they differ significantly in syntax, performance, readability, and appropriate use cases.

The **if-else** statement is the most general conditional tool in Java. It evaluates any boolean expression, handles range conditions, compound logic, and multiple variables simultaneously. For example, `if (score >= 90 && attempts <= 3)` tests two variables with a range condition — something switch cannot do. Its strength is flexibility; its limitation is verbosity when testing a single variable against many fixed values, since each branch repeats the variable name and comparison operator (Eck, 2022, Section 3.5).

The **switch** statement tests a single expression against a list of constant values and jumps directly to the matching case. It works with `int`, `char`, `String`, and enum types, but cannot evaluate ranges or floating-point values (Eck, 2022, Section 3.6). For menu-driven programs, command dispatchers, or day-of-week logic, switch is significantly more readable than an equivalent if-else chain. Java 17 introduced arrow syntax (`case "A" ->`) that eliminates the fall-through problem of the traditional syntax, where omitting a `break` causes execution to continue into the next case unintentionally.

In terms of **performance**, the Java compiler can optimize switch statements into jump tables for integer types, making them faster than long if-else chains when there are many branches. For a small number of conditions, the difference is negligible.

In my own experience writing the Unit 1 quiz game, I used if statements for input validation — checking whether the answer was one of A, B, C, or D — and switch statements for answer evaluation, where each case corresponded to a specific option. This combination leveraged the strengths of both: if for the boolean range check, switch for the discrete value dispatch. This pattern — if for validation, switch for dispatch — is a common and effective design in interactive Java programs.

The selection criterion is straightforward: use if-else when conditions involve ranges, multiple variables, or complex boolean logic; use switch when testing one variable against many known constant values; combine both when the problem has distinct validation and dispatch phases.

**Word count: 320**

---

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, Swing ed.). Creative Commons CC 4.0. https://math.hws.edu/javanotes/
