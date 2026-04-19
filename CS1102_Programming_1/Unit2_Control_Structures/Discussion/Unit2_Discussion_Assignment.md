# CS 1102 — Unit 2 Discussion Assignment
## Control Structures in Java

**Student**: Nicanor Kyamba
**Course**: CS 1102 — Programming 1, Unit 2

---

## Part 1: Looping Control Structures — while, do-while, and for

Java provides three looping control structures, each designed for a different programming scenario. Understanding their nuances — not just their syntax but their behavioral differences — is essential for writing correct, readable programs.

The **while** loop tests its continuation condition before executing the body. This means the body may execute zero times if the condition is false from the very start. Eck (2022) illustrates this with the sentinel value pattern: a program that reads positive integers until the user enters zero must read the first integer before the loop begins — a technique called priming the loop — so that the condition is meaningful on the first evaluation (Section 3.3.1). If the user immediately enters zero, the loop body never runs, which is the correct behavior. A critical subtlety is that even if the condition becomes false in the middle of the loop body, the loop does not stop immediately — the computer finishes the entire body before jumping back to check the condition again (Eck, 2022, Section 3.3.1).

The **do-while** loop moves the condition test to the end, guaranteeing the body executes at least once. Eck (2022) uses a game-playing example to show why this matters: a game must be played before the user can be asked whether to play again, so testing the condition first would require duplicating the game-playing code before the loop (Section 3.3.2). The do-while eliminates this redundancy. The boolean variable used to store the user's response is an example of a flag variable — a signal set in one part of the program and tested in another. One syntax detail that causes errors: the semicolon after the closing `while (condition)` is required and its omission is a syntax error (Eck, 2022, Section 3.3.2).

The **for** loop consolidates initialization, condition, and update into a single line. Eck (2022) explains that any for loop is equivalent to a while loop — the language gains no new power — but for a certain class of problems, particularly counted iteration, the for loop is easier to construct and easier to read because all loop control stays in one place (Section 3.4). The most common form is the counting loop, where a loop control variable takes on every integer value between a minimum and maximum. A frequent source of bugs is using `<` when `<=` is needed, or vice versa — what Eck (2022) calls an off-by-one error (Section 3.4.1).

The selection criterion is clear: use `for` when the number of iterations is known in advance; use `while` when the number is unknown and the body may need to be skipped entirely; use `do-while` when the body must execute at least once before the condition is meaningful.

**Word count: 390**

---

## Part 2: if-else vs switch Statements

Both if-else and switch implement conditional branching, but they differ in what conditions they can express, how the compiler handles them, and when each produces cleaner code.

The **if-else** statement evaluates any boolean expression. It handles range conditions, compound logic involving multiple variables, and any combination of relational and logical operators. For example, `if (score >= 90 && attempts <= 3)` tests two variables with a range condition — something a switch statement fundamentally cannot do. Eck (2022) describes if-else as the most general conditional tool, capable of expressing any branching logic (Section 3.5). Its limitation is verbosity: when testing a single variable against many fixed values, each branch repeats the variable name and comparison operator, making the code harder to scan.

The **switch** statement tests a single expression against a list of constant values and jumps directly to the matching case. Eck (2022) specifies that switch works with `int`, `short`, `byte`, `char`, `String`, and enum types, but explicitly cannot be used with `double` or `float` values, and cannot evaluate range conditions (Section 3.6). For menu-driven programs, day-of-week logic, or command dispatchers, switch is significantly more readable than an equivalent if-else chain. Java 17 introduced arrow syntax (`case "A" ->`) that eliminates the fall-through problem of the traditional syntax, where omitting a `break` causes execution to continue into the next case unintentionally — a common and difficult-to-debug error.

In terms of **performance**, the Java compiler can optimize switch statements on integer types into a jump table, making them faster than a long if-else chain when there are many branches. For a small number of conditions, the difference is negligible.

In practice, the two constructs are often combined. In the Unit 1 quiz game, I used if statements for input validation — checking whether the user's answer was one of A, B, C, or D — and switch statements for answer evaluation, where each case corresponded to a specific option. This pattern leverages the strengths of both: if for boolean range checks, switch for discrete value dispatch. The selection criterion is straightforward: use if-else when conditions involve ranges, multiple variables, or complex boolean logic; use switch when testing one variable against many known constant values.

**Word count: 360**

---

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, Swing ed.). Creative Commons CC 4.0. https://math.hws.edu/javanotes/
