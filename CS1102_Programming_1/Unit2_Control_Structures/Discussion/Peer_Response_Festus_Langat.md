# Peer Response — Festus Langat (CS 1102 Unit 2 Discussion)

Hi Festus,

Your precision agriculture example in the conditionals section is the strongest part of your post — it makes the abstract distinction between if-else and switch concrete in a way that most posts in this discussion do not. Overlapping sensor ranges are a perfect illustration of why if-else is indispensable for range-based logic: a temperature reading of 32.7°C cannot be matched against a constant in a switch case, but `if (temp >= 30 && temp < 40)` handles it naturally.

I want to build on your point about infinite loops in while loops. You correctly identify that omitting the update expression is the common cause, but Eck (2022) points out a subtler version of this problem: the update may be present but placed inside a conditional branch, so it only executes on some iterations (Section 3.3.1). For example, if the loop control variable is only incremented when a certain condition is true, the loop will run forever whenever that condition is false. The for loop eliminates this entire class of error because the update step is in the loop header and executes unconditionally at the end of every iteration — which is one of the reasons Eck (2022) notes that for loops likely outnumber while loops in real programs (Section 3.4).

Your description of the do-while as essential for command-line menus is accurate and well-placed. Eck (2022) uses exactly this scenario — a game that must be played at least once before asking the user whether to continue — to explain why the post-test structure exists (Section 3.3.2). The key insight is that the condition in a do-while often cannot be meaningfully evaluated until after the body has run, which is precisely the situation your menu example describes.

On the hybrid switch/if-else pattern — your framing of switch for broad category and if-else for sub-conditions within a case is a clean way to think about it. This is the pattern I applied in the Unit 2 library system: switch dispatches the menu choice, and nested if-else handles the availability and membership checks within each case.

Three well-chosen sources and a strong real-world grounding throughout.

**References**

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, Swing ed.). Creative Commons CC 4.0. https://math.hws.edu/javanotes/
