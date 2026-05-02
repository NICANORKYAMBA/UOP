# Peer Response — Young Pastor Tawiah (CS 1102 Unit 4 Discussion)

Hi Young Pastor,

Your post covers the core trade-offs clearly and your code comparison between the array and ArrayList versions of adding elements is a good illustration of the readability difference. The ArrayList version is genuinely more readable for dynamic data, and your point about reducing index-out-of-bounds errors is well-taken — ArrayList's `add()` method handles bounds management internally, which eliminates an entire category of runtime errors that arrays expose.

I want to add some precision to your description of ArrayList resizing. You correctly identify that resizing takes O(n) time, but it is worth clarifying that this cost does not occur on every insertion — only when the internal array is full. Because the ArrayList grows by a fixed factor each time it resizes (approximately 50% in OpenJDK), the total cost of n insertions is O(n) overall, which means the amortized cost per insertion is O(1). Eck (2022) describes this dynamic array pattern and notes that it is the mechanism that makes ArrayList practical for general use despite the occasional resizing cost (Section 7.3). This distinction matters because it means ArrayList's `add()` at the end is not as expensive as it might appear from a worst-case analysis.

Your point about insertion and deletion in the middle being costly is accurate and important. Eck (2022) explains that when an element is removed from an ArrayList, all subsequent elements must shift one position to fill the gap (Section 7.3.1). This is O(n) in the worst case and is one of the genuine performance disadvantages of ArrayList compared to other data structures like linked lists. For applications that require frequent middle insertions or deletions, a `LinkedList` from the Java Collections Framework would be a better choice than either an array or an ArrayList.

One thing worth adding to your analysis is the behavior of arrays with primitive types. Your ArrayList example uses raw `ArrayList` without a type parameter — in modern Java, it is better practice to use the parameterized form `ArrayList<Integer>` to get compile-time type safety. This also makes the autoboxing behavior explicit: when you call `numbers.add(10)`, Java automatically converts the `int` literal 10 to an `Integer` object, which is a small but real overhead that arrays avoid entirely (Eck, 2022, Section 7.3.2).

Well-structured post with good practical examples.

**References**

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, Swing ed.). Creative Commons CC 4.0. https://math.hws.edu/javanotes/
