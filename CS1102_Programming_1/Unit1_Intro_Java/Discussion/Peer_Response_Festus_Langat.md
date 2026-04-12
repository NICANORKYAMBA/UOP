# Peer Response — Festus Langat (Unit 1 Discussion)

Hi Festus,

This is a well-researched post and your three-source citation list reflects genuine engagement with the course material. The stack versus heap distinction in Part 1 is something many introductory posts skip over, but it is actually fundamental to understanding why primitives and reference types behave differently — not just in terms of what they store, but in terms of how memory is allocated and reclaimed. Your framing of variables as "labels" and data types as "templates" is a clean mental model that I think will stick with readers.

Your arithmetic example in Part 2 is correct — `10 + 5 * 2` evaluates as `10 + (5 * 2)` = `10 + 10` = 20, not `(10 + 5) * 2` = 30. I want to build on it by pointing out that precedence errors are even more dangerous in boolean expressions than in arithmetic ones, because the compiler gives no warning and the program still runs. Consider `boolean valid = x > 0 || x < 100 && x != 50;` — because `&&` has higher precedence than `||`, this evaluates as `x > 0 || (x < 100 && x != 50)`, which may not match the programmer's intent at all. Eck (2022) specifically advises using parentheses liberally for exactly this reason — not because the compiler needs them, but because the human reader does (Eck, 2022, Section 2.5.7).

Your point about "spaghetti code" from deeply nested conditionals in Part 3 is the most practically valuable observation in your entire post — and one that most Unit 1 discussions do not reach. Eck (2022) addresses this indirectly by recommending that complex branching logic be refactored into subroutines, which keeps individual methods short and readable (Eck, 2022, Section 4.2). That is a natural bridge to what we will cover in Unit 3 on static methods, so you are already thinking ahead.

Strong work overall — the depth across all three parts is consistent and well-supported.

**References**

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, Swing ed.). Creative Commons CC 4.0. https://math.hws.edu/javanotes/
