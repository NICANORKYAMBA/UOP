# CS 1102 — Unit 4 Discussion Assignment
## Arrays vs ArrayLists: Choosing the Right Data Structure in Java

**Student**: Nicanor Kyamba
**Course**: CS 1102 — Programming 1, Unit 4

---

Choosing between an array and an ArrayList in Java is a design decision with real consequences for performance, memory usage, and code maintainability. Both structures store sequences of elements, but they differ fundamentally in how they manage memory, what operations they support, and how they affect code readability. Understanding these differences is essential for writing Java programs that are both correct and efficient.

**Arrays** are the foundational structure. An array is a fixed-size numbered sequence of elements, all of the same type, where each element is accessed by its index (Eck, 2022, Section 3.8.1). Once created, the length cannot change. This constraint is both a limitation and a strength. The limitation is that if the number of elements is not known at compile time, a fixed-size array forces either over-allocation (wasting memory) or under-allocation (causing `ArrayIndexOutOfBoundsException`). The strength is performance: arrays store elements in a contiguous block of memory, so accessing any element by index is an **O(1)** operation with no object overhead. For performance-critical code — image processing, numerical simulations, game engines — this direct memory access matters significantly.

Consider a program that processes exactly 10 days of stock prices. An array is the natural choice:

```java
float[] prices = {102.5f, 98.3f, 105.0f, 99.7f, 107.2f,
                  103.8f, 101.1f, 108.4f, 106.9f, 104.5f};
float sum = 0;
for (float price : prices) {   // for-each loop — Eck Section 7.1.1
    sum += price;
}
float average = sum / prices.length;
```

The size is fixed, the data is a primitive type (`float`), and the for-each loop processes it cleanly. There is no reason to introduce the overhead of ArrayList here.

**ArrayLists**, by contrast, implement a dynamic array that automatically resizes as elements are added or removed (Eck, 2022, Section 7.3). An ArrayList is part of the Java Collections Framework and is declared as a parameterized type — `ArrayList<String>`, `ArrayList<Integer>` — which means it can only hold objects, not primitive types directly. For primitives, wrapper classes are required (`Integer` for `int`, `Double` for `double`), though Java's autoboxing handles the conversion automatically (Eck, 2022, Section 7.3.2).

The key advantage of ArrayList is flexibility. When the number of elements is not known at compile time — a list of students that grows as new students enroll, a log of events that accumulates during program execution — ArrayList handles resizing automatically. It also provides a rich API: `add()`, `remove()`, `contains()`, `indexOf()`, `set()`, and `size()` are all built in, making common operations concise and readable (Eck, 2022, Section 7.3.1). Consider a student enrollment system where students can be added or dropped at any time:

```java
ArrayList<String> enrolled = new ArrayList<>();
enrolled.add("Alice");
enrolled.add("Bob");
enrolled.add("Carol");
enrolled.remove("Bob");   // removes by value — O(n) but clean and readable
System.out.println("Enrolled: " + enrolled.size() + " students");
```

Using an array here would require manual shifting of elements after removal and tracking a separate counter for active students — exactly the partially full array pattern that Eck (2022) describes as error-prone (Section 7.2).

**Time complexity** is a critical factor in this decision. Array element access is O(1). ArrayList element access via `get(i)` is also O(1) because ArrayList is backed by an internal array. However, inserting or removing an element in the middle of an ArrayList is **O(n)** because all subsequent elements must be shifted. Appending to the end with `add()` is **O(1) amortized** — occasionally the internal array must be doubled, but this cost is spread across many operations.

**Memory utilization** also differs. An array allocates exactly the memory it needs. An ArrayList typically allocates more capacity than currently needed, doubling its internal array when it runs out of space. This amortizes resizing cost but means the ArrayList may hold unused memory at any time. For large collections of primitive values, the wrapper class overhead in ArrayList can also be significant — each `Integer` object requires more memory than a raw `int`.

**Code readability** is the third factor. ArrayList's built-in methods make intent explicit: `students.remove("Bob")` is clearer than manually searching an array and shifting elements. However, for simple fixed-size data, an array literal like `int[] days = {1, 2, 3, 4, 5}` is more concise than the equivalent ArrayList construction.

The practical rule: use arrays when the size is fixed, performance is critical, or the data is primitive. Use ArrayList when the size is dynamic, when built-in methods improve readability, or when working with objects. In well-designed Java programs, both often appear together — an array for fixed-size internal computation, an ArrayList for collecting results whose count is not known in advance. The choice of data structure shapes the design of the entire system around it.

**Word count: 727**

---

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, Swing ed.). Creative Commons CC 4.0. https://math.hws.edu/javanotes/

Liang, Y. D. (2020). *Introduction to Java programming and data structures* (12th ed.). Pearson.
