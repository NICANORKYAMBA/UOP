# CS 1102 — Unit 2 Discussion Assignment
## Control Structures in Java

**Student**: Nicanor Kyamba
**Course**: CS 1102 — Programming 1, Unit 2

---

## Part 1: Looping Control Structures — while, do-while, and for

Java provides three looping control structures, each suited to a different programming scenario. Understanding their behavioral differences — not just their syntax — is what separates code that works from code that works correctly.

The **while** loop evaluates its continuation condition before executing the body, which means the body may execute zero times if the condition is false from the start. Eck (2022) illustrates this with the sentinel value pattern: a program reading positive integers until the user enters zero must read the first value before the loop begins — a technique called priming the loop — so the condition is meaningful on the first check (Section 3.3.1). A critical nuance is that even if the condition becomes false mid-body, the loop does not stop immediately. The computer finishes the entire body, then jumps back to re-evaluate the condition. This makes while the right choice when the number of iterations is unknown and the body may legitimately need to be skipped entirely.

The **do-while** loop moves the condition test to the end, guaranteeing the body executes at least once. Eck (2022) demonstrates this with a game-playing example: a game must be played before the user can be asked whether to continue, so testing the condition first would require duplicating code before the loop (Section 3.3.2). The do-while eliminates that redundancy. The boolean variable storing the user's response is what Eck calls a flag variable — a signal set in one place and tested in another. One syntax point worth noting: the semicolon after `while (condition)` is required, and omitting it is a syntax error.

The **for** loop consolidates initialization, condition, and update into one line. Eck (2022) notes that any for loop is equivalent to a while loop — the language gains no new power — but for counted iteration, the for loop is easier to read because all loop control stays in one place (Section 3.4). The most common form is the counting loop, where a loop control variable steps through a range of integers. A frequent source of bugs is using `<` when `<=` is needed, or vice versa — what Eck (2022) calls an off-by-one error (Section 3.4.1).

The selection rule is straightforward: use `for` when the iteration count is known; use `while` when it is unknown and the body may be skipped; use `do-while` when the body must run at least once before the condition makes sense.

**Word count: 352**

---

## Part 2: if-else vs switch Statements

Both if-else and switch implement conditional branching, but they differ in what conditions they can express, how the compiler handles them, and when each produces cleaner, more maintainable code.

The **if-else** statement evaluates any boolean expression. It handles range conditions, compound logic across multiple variables, and any combination of relational and logical operators. For example, `if (score >= 90 && attempts <= 3)` tests two variables with a range condition — something switch fundamentally cannot do. Eck (2022) describes if-else as the most general conditional tool in Java, capable of expressing any branching logic (Section 3.5). Its drawback is verbosity: when testing one variable against many fixed values, each branch repeats the variable name and comparison operator, making the code harder to scan and maintain.

The **switch** statement tests a single expression against a list of constant values and jumps directly to the matching case. Eck (2022) specifies that switch works with `int`, `char`, `String`, and enum types, but cannot handle `double` or `float` values, and cannot evaluate ranges (Section 3.6). For menu-driven programs, day-of-week logic, or command dispatchers, switch is significantly more readable than an equivalent if-else chain. Java 17 introduced arrow syntax (`case "A" ->`) that eliminates the fall-through problem of the traditional syntax, where a missing `break` causes execution to continue into the next case — a subtle and difficult-to-debug error. In terms of performance, the compiler can optimize integer switch statements into a jump table, making them faster than long if-else chains, though for a small number of conditions the difference is negligible (Liang, 2020, p. 142).

In practice, combining both constructs often produces the cleanest solution. In the Unit 1 quiz game I wrote for this course, I used `if` for input validation — checking whether the user's answer was one of A, B, C, or D — and `switch` for answer evaluation, where each case matched a specific option. This pattern works well because the validation step requires a boolean range check, while the dispatch step involves discrete constant values. Using switch for validation would require listing all invalid inputs, which is impractical; using if-else for dispatch would be verbose and harder to extend.

The guiding principle is this: use if-else when conditions involve ranges, multiple variables, or complex boolean logic; use switch when testing one variable against many known constant values; and combine both when a problem has distinct validation and dispatch phases.

**Word count: 370**

---

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, Swing ed.). Creative Commons CC 4.0. https://math.hws.edu/javanotes/

Liang, Y. D. (2020). *Introduction to Java programming and data structures* (12th ed.). Pearson.
