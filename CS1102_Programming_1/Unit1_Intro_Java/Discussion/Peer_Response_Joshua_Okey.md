# Peer Response — Joshua Okey (Unit 1 Discussion)

Hi Joshua,

Your post is one of the most thorough I have read this week. The point you made about `==` behaving differently on primitives versus reference types is something many beginners get wrong for a long time, and you explained it clearly and concisely. That distinction — value comparison versus memory address comparison — is exactly the kind of nuance that separates someone who has merely memorized Java syntax from someone who actually understands how the language manages memory.

Your BODMAS/PEMDAS analogy for operator precedence is a smart way to make the concept immediately accessible to readers coming from a mathematics background. I used a similar approach in my own post, though I focused more on how precedence errors show up in boolean expressions rather than arithmetic ones. Your example of `val > 0 && val < 100` is a great illustration of how relational operators resolve before `&&`, which is a pattern that appears constantly in real programs — input validation, range checks, loop conditions. It is worth noting that Eck (2022) specifically advises using parentheses liberally even when you know the precedence rules, precisely because it makes the intent of the expression explicit to anyone reading the code later, not just to the compiler (Eck, 2022, Section 2.5.7).

One thing I would add to your section on conditionals is the limitation of the ternary operator when it comes to side effects. You correctly note that it can make code dense and harder to debug when overused, but the deeper issue is that the ternary is designed for expressions that produce a value — using it to call methods or trigger actions rather than assign a result is considered poor style in Java. Keeping it strictly for value assignment, as you implied, is the right guideline.

Your observation that `switch` can be optimized by the compiler into a jump table is an excellent point that goes beyond what most introductory posts cover. That is a real performance consideration in high-frequency code paths.

Great work overall — your three-source citation list is solid and your writing is polished throughout.

**References**

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, Swing ed.). Creative Commons CC 4.0. https://math.hws.edu/javanotes/
