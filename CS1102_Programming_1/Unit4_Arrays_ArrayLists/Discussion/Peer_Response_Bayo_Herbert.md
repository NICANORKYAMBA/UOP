# Peer Response — Bayo Herbert (CS 1102 Unit 4 Discussion)

Hi Bayo,

Your post is well-argued and your practical framing — "do you prioritize raw performance or development speed?" — is a clean way to present the decision. The 2D array point is one that most posts in this discussion have not addressed, and it is genuinely important. When working with fixed grids like game boards or coordinate systems, a 2D array (`int[][]`) is not just more efficient than nested ArrayLists — it is also more natural to read and reason about. Eck (2022) explains that a 2D array in Java is actually an array of arrays, where each row is a separate `int[]` object, which gives it a clean structure for grid-based problems (Section 7.6).

I want to build on your point about ArrayList's 50% extra allocation. You are correct that ArrayList pre-allocates extra capacity, but the 50% figure refers to the growth factor when resizing — not the constant overhead. When you first create `new ArrayList<>()`, the default initial capacity is 10 elements. The ArrayList only allocates more than it needs when it has to grow. So for small lists that never exceed the initial capacity, the memory overhead is actually just the object wrapper itself, not a persistent 50% surplus. The 50% growth factor kicks in when the list is full and needs to expand (Eck, 2022, Section 7.3).

Your observation that ArrayList's internal shift operations are "highly optimized" compared to a manual array loop is worth examining more carefully. Both operations are O(n) — ArrayList uses `System.arraycopy()` internally, which is a native method and faster than a Java for loop, but the time complexity is the same. The real advantage of ArrayList's remove is not speed but correctness: it handles the shift and size decrement atomically, whereas a manual array shift requires careful index management that is easy to get wrong.

One addition worth considering: you mention that arrays are better for primitives, which is true. But it is worth noting that Java 17 does not yet have primitive-specialized collections in the standard library — if you need a dynamic list of `int` values without autoboxing overhead, you either use an array with manual resizing or reach for a third-party library like Eclipse Collections.

Solid, practical post overall.

**References**

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, Swing ed.). Creative Commons CC 4.0. https://math.hws.edu/javanotes/
