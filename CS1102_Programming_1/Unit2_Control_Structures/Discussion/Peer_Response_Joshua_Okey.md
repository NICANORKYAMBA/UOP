# Peer Response — Joshua Okey (CS 1102 Unit 2 Discussion)

Hi Joshua,

Your post is well-structured and your real-world examples — structural engineering software for loops and building design for the switch/if-else hybrid — are the most concrete I have seen in this discussion. Grounding abstract control structures in domain-specific scenarios makes the analysis genuinely useful rather than just syntactically correct.

Your point about the while loop risking logic errors when the loop control variable is not updated correctly is worth developing further. Eck (2022) identifies this as one of the most common sources of infinite loops — the programmer updates the variable in one branch of an if statement inside the loop but forgets to update it in another, so the condition never becomes false (Section 3.3.1). The fix is exactly what you imply: the for loop's enforced update step eliminates this class of error entirely for counted iteration, because the update is part of the loop header and cannot be accidentally omitted.

On the do-while and off-by-one errors — I think the risk you describe is real but comes from a slightly different source than the loop structure itself. Off-by-one errors in do-while typically occur when the programmer forgets that the body has already executed once before the condition is first checked, and then writes the condition as if it hasn't. Eck (2022) notes that the do-while is most natural when the action must precede the decision, and that any do-while can be rewritten as a while loop with the body duplicated before it — which is a useful mental check for verifying the logic is correct (Section 3.3.2).

Your hybrid switch/if-else pattern in Part 2 is exactly the approach I used in the Unit 1 quiz game: switch for dispatching discrete answer options, if-else for the range-based score feedback at the end. Schildt (2018) is right that the jump table optimization makes switch faster for large case sets, but as you note, the more important factor in most programs is readability and maintainability — the performance difference only becomes meaningful at very high call frequencies.

One addition worth considering: the enhanced switch expression introduced in Java 14 (and standardized in Java 16) can return a value directly, which allows it to replace if-else in assignment contexts — `String label = switch (grade) { case "A" -> "Excellent"; default -> "Other"; }` — further blurring the boundary between the two constructs.

Well-argued post overall.

**References**

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, Swing ed.). Creative Commons CC 4.0. https://math.hws.edu/javanotes/
