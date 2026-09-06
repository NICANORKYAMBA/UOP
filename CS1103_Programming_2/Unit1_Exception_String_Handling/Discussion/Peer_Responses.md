# CS 1103 Unit 1 — Peer Responses

*(Minimum two substantive replies, 75+ words each, 3–4 sentences, connecting to the peer's
post and adding value. Post by Wednesday. Reply under each person's thread.)*

---

## Peer Response 1 — to Abdulrehman Syed

Hi Abdulrehman,

Your driving analogy works really well, especially pairing the `throw` statement with
"deliberately reporting a problem," because that captures the difference between an error
Java raises on its own and one the programmer chooses to raise. I also appreciated that you
mentioned try-with-resources as the modern alternative to a manual `finally`, since that is
an important detail many beginners miss. To answer your question about a bank or shopping
system: I think a custom exception with `throw` beats a plain `if` when the invalid condition
needs to travel up several method calls, such as an `InsufficientFundsException` during a
withdrawal. A simple `if` can only return a value or print locally, but a thrown exception
carries a meaningful name and message to whichever layer is best equipped to handle it, which
keeps business rules consistent (Morelli & Wade, 2017). Where would you draw the line between
a recoverable exception and one that should stop the transaction entirely?

Reference: Morelli, R., & Wade, R. (2017). *Java, Java, Java: Object-oriented problem solving*
(3rd ed.). LibreTexts.

(Word count: 160)

---

## Peer Response 2 — to Jagot Chakma

Hi Jagot,

This is an excellent, well-sourced post, and the tightrope-and-safety-net image made the
purpose of `try`/`catch` immediately clear. I especially liked how you connected `substring`
throwing a `StringIndexOutOfBoundsException` to Samoylov's explanation of begin/end indexes,
because it shows exception handling and string handling are really the same week's ideas in
action. Your `finally` file-closing example is also a strong choice, since it demonstrates
exactly why cleanup cannot live only in the `try` block. To engage your question about when to
let default handling terminate the program: I think it is often better to let an unchecked
exception like `ArithmeticException` crash during development, because a division by zero
usually signals a programming bug that a silent `catch` would only hide. In production,
though, I would validate the input first so the exception never arises. Do you think that same
"fail fast in development" reasoning applies to `NullPointerException`, or is that one worth
catching more defensively?

Reference: Samoylov, N. (2018). *Introduction to programming: Learn to program in Java with
data structures, algorithms, and logic*. Packt Publishing.

(Word count: 165)

---

## (Optional) Peer Response 3 — to Ayhab Benashur

Hi Ayhab,

Your road-trip analogy is clear and consistent, and I like that you framed `throw` as
"raising a custom flag" for business-rule violations rather than technical errors, which is a
distinction beginners often struggle with. Your `AgeValidator` example is a clean
demonstration, and pairing it with the `finally` cleanup message makes the control flow easy
to follow. Answering your question about resource leaks: omitting `finally` is most dangerous
with resources that the garbage collector does not automatically release, such as open file
handles, database connections, or network sockets. A `catch` block alone is insufficient
because it only runs when a matching exception occurs, so on the success path (or on an
unexpected exception type) the cleanup would be skipped entirely and the resource would stay
open (Morelli & Wade, 2017). Would you say try-with-resources has now made most manual
`finally` cleanup unnecessary, or are there still cases where you would prefer the explicit
block?

Reference: Morelli, R., & Wade, R. (2017). *Java, Java, Java: Object-oriented problem solving*
(3rd ed.). LibreTexts.

(Word count: 160)
