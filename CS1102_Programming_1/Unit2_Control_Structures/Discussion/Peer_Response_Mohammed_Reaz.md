# Peer Response — Mohammed Reaz (CS 1102 Unit 2 Discussion)

Hi Mohammed,

Your post covers the core distinctions clearly and your personal experience section — using if-else for multi-condition input validation and switch for fixed command options — reflects exactly the pattern that works best in practice. That combination is not just a stylistic preference; it maps directly to the logical structure of the problem. Validation inherently involves ranges and compound conditions that switch cannot express, while command dispatch involves discrete constant values that switch handles more cleanly than a long if-else chain.

I want to add some precision to your point about the do-while executing "unnecessarily if the condition is already false." This is technically accurate, but Eck (2022) frames it more usefully: the do-while is the right tool precisely when the body must execute before the condition can be meaningfully evaluated (Section 3.3.2). In a menu-driven program, for example, the user cannot choose to exit before seeing the menu — so the condition "does the user want to continue?" has no valid answer until after the first execution. The "unnecessary execution" concern only applies when a programmer uses do-while in a situation where while would have been the correct choice. Matching the loop structure to the problem eliminates the issue entirely.

On the while loop, your description is accurate but there is one nuance worth adding. Eck (2022) introduces the concept of priming the loop — reading the first input value before the loop begins so the condition is meaningful on the first check (Section 3.3.1). Without priming, a while loop that tests an uninitialized variable produces undefined behavior. This is a common beginner mistake that the do-while avoids by design, since the first read happens inside the body before any condition is checked.

Your point about deeply nested if-else reducing readability is well-taken. One practical solution is to extract each branch into a separate method, which keeps the conditional structure flat and each method focused on a single responsibility — a technique that becomes central in Unit 3 when we cover static methods.

Good foundational post — adding specific section references from the textbook would strengthen the citations further.

**References**

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, Swing ed.). Creative Commons CC 4.0. https://math.hws.edu/javanotes/
