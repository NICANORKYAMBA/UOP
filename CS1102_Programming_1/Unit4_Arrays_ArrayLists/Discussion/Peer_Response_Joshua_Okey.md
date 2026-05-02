# Peer Response — Joshua Okey (CS 1102 Unit 4 Discussion)

Hi Joshua,

Your post is one of the most technically complete in this discussion. The performance comparison table is particularly useful — having O(1) access for both structures side by side makes it immediately clear that the performance difference is not in reading data but in writing and resizing it. That is a nuance many posts miss.

Your point about the 50% growth factor for ArrayList is worth a small correction. The standard Java implementation (OpenJDK) actually grows by approximately 50% — specifically `newCapacity = oldCapacity + (oldCapacity >> 1)` — rather than doubling. This is different from some other languages and from what many textbooks describe. Eck (2022) describes the general principle of amortized resizing without specifying the exact factor, but the practical implication is the same: the cost of occasional resizing is spread across many insertions, keeping the amortized cost at O(1) per append (Section 7.3).

The technical debt framing in your conclusion is the strongest part of the post. The example of using an array for an indefinitely growing data stream is exactly the kind of design mistake that causes real maintenance problems — not because the code is wrong initially, but because the manual resizing logic that gets added later is fragile and easy to get wrong. Eck (2022) describes this exact scenario as the "partially full array" pattern and notes that it requires careful management of a separate counter variable to track how many positions are actually in use (Section 7.2). ArrayList eliminates that entire class of error.

One dimension worth adding to your analysis is the interaction between ArrayList and garbage collection. You mention GC overhead from wrapper objects in high-frequency trading, which is correct. The deeper issue is that each autoboxed `Integer` or `Double` is a separate heap object, and when the ArrayList is cleared or goes out of scope, all those wrapper objects become eligible for GC simultaneously. For latency-sensitive systems, this can cause GC pauses at unpredictable times — which is why libraries like Eclipse Collections and Trove provide primitive-specialized collections that avoid autoboxing entirely.

Three well-chosen sources and a clean, structured analysis throughout.

**References**

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, Swing ed.). Creative Commons CC 4.0. https://math.hws.edu/javanotes/
