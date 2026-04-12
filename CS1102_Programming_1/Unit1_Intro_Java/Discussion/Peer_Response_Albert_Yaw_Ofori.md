# Peer Response — Albert Yaw Ofori (Unit 1 Discussion)

Hi Albert,

Your post covers all three topics clearly and your code examples are well chosen. I particularly appreciated your point in Part 1 about primitive types being faster and consuming less memory while reference types offer greater flexibility — that trade-off is something programmers actively think about when designing performance-sensitive applications, and it is good to see it framed that way rather than just listing the types.

Your arithmetic example in Part 2 (`5 + 3 * 2 = 11`) is correct and easy to follow. I want to build on it slightly by pointing out that precedence becomes even more consequential in boolean expressions, which tend to appear more frequently in real programs than arithmetic ones. Consider `boolean access = isAdmin || isOwner && isActive;` — because `&&` has higher precedence than `||`, this evaluates as `isAdmin || (isOwner && isActive)`, which may grant access to an admin even when `isActive` is false. That is the kind of silent logic error that compiles cleanly but causes real bugs. Eck (2022) makes this exact point, advising programmers to use parentheses liberally to make intent explicit rather than relying on memorized precedence rules (Eck, 2022, Section 2.5.7).

On your conditionals section, you made a strong observation that `switch` is limited to specific data types. It is worth adding that `switch` also cannot evaluate ranges — you cannot write `case score >= 90` — which is why `if-else if` remains the right tool whenever the branching logic depends on inequalities rather than equality checks against fixed values (Eck, 2022, Section 3.6). Your ternary example is clean and demonstrates exactly the right use case for it.

Well-structured post overall — the word counts per section show good discipline.

**References**

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, Swing ed.). Creative Commons CC 4.0. https://math.hws.edu/javanotes/
