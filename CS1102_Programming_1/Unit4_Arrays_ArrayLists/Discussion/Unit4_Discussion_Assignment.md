# CS 1102 — Unit 4 Discussion Assignment
## Arrays vs ArrayLists: Choosing the Right Data Structure in Java

**Student**: Nicanor Kyamba
**Course**: CS 1102 — Programming 1, Unit 4

---

Choosing between an array and an ArrayList in Java is not a matter of preference — it is a design decision with real consequences for performance, memory usage, and code maintainability. Both structures store sequences of elements, but they differ fundamentally in how they manage memory and what operations they support efficiently. Understanding these differences is essential for writing Java programs that are both correct and efficient.

**Arrays** are the more primitive structure. An array is a fixed-size numbered sequence of elements, all of the same type, where each element is accessed by its index (Eck, 2022, Section 3.8.1). Once created, the length of an array cannot change. This constraint is both a limitation and an advantage. The limitation is obvious: if you do not know in advance how many elements you will need, a fixed-size array forces you to either over-allocate (wasting memory) or under-allocate (causing errors). The advantage is performance: arrays store elements in a contiguous block of memory, so accessing any element by index is an O(1) operation with minimal overhead. For performance-critical code — image processing, numerical simulations, game engines — this matters.

Consider a program that processes exactly 10 days of stock prices. An array is the natural choice:

```java
float[] prices = {102.5f, 98.3f, 105.0f, 99.7f, 107.2f,
                  103.8f, 101.1f, 108.4f, 106.9f, 104.5f};
float sum = 0;
for (float price : prices) {
    sum += price;
}
float average = sum / prices.length;
```

The size is known, the data is homogeneous, and the for-each loop processes it cleanly. There is no reason to use anything more complex.

**ArrayLists**, by contrast, implement a dynamic array that automatically resizes as elements are added or removed (Eck, 2022, Section 7.3). An ArrayList is part of the Java Collections Framework and is declared as a parameterized type — `ArrayList<String>`, `ArrayList<Integer>` — which means it can only hold objects, not primitive types directly. For primitives, you must use wrapper classes (`Integer` for `int`, `Double` for `double`), though Java's autoboxing handles the conversion automatically.

The key advantage of ArrayList is flexibility. When the number of elements is not known at compile time — a list of students that grows as new students enroll, a log of events that accumulates during program execution — ArrayList handles the resizing automatically. It also provides a rich API: `add()`, `remove()`, `contains()`, `indexOf()`, `set()`, and `size()` are all built in, making common operations concise and readable (Eck, 2022, Section 7.3.1).

```java
ArrayList<String> students = new ArrayList<>();
students.add("Alice");
students.add("Bob");
students.remove("Alice");
System.out.println(students.size());  // 1
```

The trade-off is overhead. ArrayList stores elements as objects, which means each element involves an object reference and potential autoboxing for primitives. For large collections of primitive values, this overhead can be significant. Additionally, inserting or removing an element in the middle of an ArrayList requires shifting all subsequent elements — an O(n) operation — whereas arrays do not support insertion at all without manual shifting.

**Memory considerations** also differ. An array allocates exactly the memory it needs. An ArrayList typically allocates more capacity than currently needed, doubling its internal array when it runs out of space. This amortizes the cost of resizing but means the ArrayList may hold unused allocated memory at any given time.

The practical rule is straightforward: use arrays when the size is fixed and performance matters, especially with primitive types. Use ArrayList when the size is dynamic, when you need built-in manipulation methods, or when working with objects. In many real programs, both appear together — an array for fixed-size internal computation, an ArrayList for collecting results whose count is not known in advance.

**Word count: 620**

---

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, Swing ed.). Creative Commons CC 4.0. https://math.hws.edu/javanotes/
