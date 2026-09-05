# Unit 1 Learning Notes — Exception Handling & String Handling

**Course:** CS 1103 Programming 2
**Student:** Nicanor Kyamba
**Topics:** Exceptions (try/catch/throw/finally, hierarchy, custom exceptions) and Java Strings (immutability, methods, StringBuilder/StringBuffer)

> These are my own study notes, written in my own words from the Unit 1 readings and
> videos. Direct sources are cited inline in APA style; full references are at the end.

---

## Part A — Exception Handling

### 1. What an exception is

An **exception** is an object representing an error or an unusual condition that arises
while a program runs and disrupts the normal flow of control (Morelli & Wade, 2017).
Typical examples include dividing an integer by zero, indexing past the end of an array,
or trying to parse the word "hello" as a number. If nothing handles the exception, the
program stops and prints a stack trace.

Key vocabulary:
- **Throw** — the act of signaling that an exceptional condition has occurred.
- **Catch** — the act of responding to a thrown exception.
- **Handler** — the block of code (a `catch` clause) that responds.
- **Propagation** — if a method does not catch an exception, it passes up the call stack
  to the method that called it (Morelli & Wade, 2017).

### 2. The `try..catch` statement

Eck (2022) presents `try..catch` as the core mechanism a program uses to catch and
respond to run-time errors rather than crashing. Structure:

```java
try {
    // code that might throw an exception
} catch (ExceptionType e) {
    // code that handles the exception
}
```

- Code inside `try` is monitored.
- If an exception is thrown, execution jumps immediately to the matching `catch`.
- `e.getMessage()` returns a description; `e.printStackTrace()` prints the call trace.
- You can chain multiple `catch` blocks for different exception types (most specific first).

### 3. The exception hierarchy

All exceptions descend from `java.lang.Throwable`. The two branches (Morelli & Wade, 2017):

```
Throwable
├── Error            (serious JVM problems, e.g. OutOfMemoryError — usually not caught)
└── Exception
    ├── RuntimeException      (unchecked: NullPointerException,
    │                          ArrayIndexOutOfBoundsException,
    │                          ArithmeticException, NumberFormatException)
    └── (other Exceptions)    (checked: IOException, FileNotFoundException, ...)
```

**Checked vs. unchecked** — this distinction matters for the assignments:
- **Checked exceptions** (e.g., `IOException`) must be either caught or declared with
  `throws` in the method signature; the compiler enforces this.
- **Unchecked exceptions** (subclasses of `RuntimeException`) do not have to be declared.
  They usually signal programming bugs that better logic could prevent.

### 4. `throw` and `throws`

- **`throw`** raises an exception on purpose. Morelli and Wade (2017) compare throwing an
  exception to pulling a fire alarm to signal an abnormal condition.
  ```java
  if (balance < 0) {
      throw new IllegalArgumentException("Balance cannot be negative.");
  }
  ```
- **`throws`** appears in a method header to declare that the method may pass a checked
  exception up to its caller rather than handling it itself.
  ```java
  public void readFile(String name) throws IOException { ... }
  ```

### 5. The `finally` block

`finally` runs **no matter what** — whether the `try` completed normally, a `catch` ran,
or an exception propagated. It is the standard place for cleanup such as closing files or
network connections and releasing resources.

```java
Scanner in = new Scanner(System.in);
try {
    // work
} catch (Exception e) {
    // handle
} finally {
    in.close();   // always executes
}
```

### 6. Custom exceptions

You can define your own exception class by extending `Exception` (checked) or
`RuntimeException` (unchecked). This makes error messages meaningful to your domain
(Morelli & Wade, 2017).

```java
public class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
```

### 7. Robust program design (best practices)

Morelli and Wade (2017) stress that error handling should be built into a program from
the earliest design stages, not patched on later. Practical rules I want to follow:
- Catch **specific** exceptions, not a blanket `catch (Exception e)`, unless it is a true
  top-level safety net.
- Give the user a clear, actionable message; never expose a raw stack trace as the UX.
- Validate input first (prevention) so fewer exceptions are needed at all.
- Always release resources in `finally` (or use try-with-resources).
- Don't "swallow" exceptions with an empty `catch` block — that hides bugs.

### 8. try-with-resources (modern note)

Since Java 7, resources that implement `AutoCloseable` can be declared in the `try`
header and closed automatically:

```java
try (Scanner in = new Scanner(System.in)) {
    // use in
}   // in.close() called automatically
```

---

## Part B — String Handling

### 1. Strings are objects and are immutable

In Java, `String` is a class, not a primitive. A `String` value is **immutable**: once
created, its contents cannot be changed (Samoylov, 2018). Methods that appear to "modify"
a string actually return a **new** string and leave the original untouched.

```java
String s = "hello";
s.toUpperCase();          // returns "HELLO" but does NOT change s
s = s.toUpperCase();      // now s refers to the new "HELLO"
```

Why immutability matters: it makes strings safe to share, usable as `HashMap` keys, and
thread-safe, but repeatedly concatenating in a loop creates many throwaway objects, which
is inefficient (Samoylov, 2018).

### 2. Common String methods (used in the assignment)

| Method | Returns | Purpose |
|--------|---------|---------|
| `length()` | int | number of characters |
| `charAt(i)` | char | character at index `i` |
| `substring(a, b)` | String | portion from `a` to `b-1` |
| `indexOf(x)` | int | first position of `x`, or −1 |
| `toLowerCase()` / `toUpperCase()` | String | case conversion (for case-insensitive work) |
| `trim()` / `strip()` | String | remove surrounding whitespace |
| `split(regex)` | String[] | break into tokens (e.g., `split("\\s+")`) |
| `equals(other)` | boolean | exact content comparison |
| `equalsIgnoreCase(other)` | boolean | content comparison ignoring case |
| `contains(seq)` | boolean | substring test |
| `replace(a, b)` | String | replace characters/sequences |

**Important gotcha:** use `equals()` / `equalsIgnoreCase()` to compare string *content*.
The `==` operator compares object references, not contents, and will give wrong results
for strings built at run time.

### 3. StringBuilder vs. StringBuffer

When a string is built or changed many times, use a mutable helper instead of `String`
(Samoylov, 2018):

| Class | Mutable? | Thread-safe? | Use when |
|-------|----------|--------------|----------|
| `String` | No | Yes (immutable) | fixed text, keys, sharing |
| `StringBuilder` | Yes | No | building strings in a single thread (fastest) |
| `StringBuffer` | Yes | Yes (synchronized) | building strings across multiple threads |

```java
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 5; i++) {
    sb.append(i).append(",");
}
String result = sb.toString();   // "0,1,2,3,4,"
```

### 4. How this connects to the programming assignment

- **Character count** → `length()`.
- **Word count / unique words** → `trim()` + `split("\\s+")`.
- **Case-insensitive frequency** → `toLowerCase()` before comparing, or
  `equalsIgnoreCase()` for whole words.
- **Most common character** → iterate with `charAt()`, tally in a `HashMap`.
- Exception handling wraps the workflow, and `finally` closes the `Scanner`.

---

## Quick Self-Check (from the unit learning outcomes)

1. Can I illustrate `try`, `catch`, `throw`, and `finally` with a working example? ✅
2. Can I define a Java String and explain immutability? ✅
3. Can I list common string operations and when to use `StringBuilder`/`StringBuffer`? ✅

---

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, JavaFX ed.).
Hobart and William Smith Colleges. Licensed under CC BY-NC-SA 4.0.
https://math.hws.edu/javanotes/

Morelli, R., & Wade, R. (2017). *Java, Java, Java: Object-oriented problem solving*
(3rd ed., Chapter 10: Exceptions—When things go wrong). LibreTexts. Licensed under CC BY 4.0.
https://eng.libretexts.org/Bookshelves/Computer_Science/Programming_Languages/Java_Java_Java_-_Object-Oriented_Programming_(Morelli_and_Walde)/10%3A_Exceptions-_When_Things_Go_Wrong

Samoylov, N. (2018). *Introduction to programming: Learn to program in Java with data
structures, algorithms, and logic*. Packt Publishing.
