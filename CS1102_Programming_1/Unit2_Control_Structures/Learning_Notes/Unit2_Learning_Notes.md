# CS 1102 — Unit 2: Control Structures
## Learning Notes | Eck (2022) Sections 3.3, 3.4, 3.7

---

## 1. The while Loop (Eck §3.3.1)

Tests condition **before** body. Body executes zero or more times.

```java
while (boolean-expression) {
    // body
}

// Example: sum until user enters 0
int sum = 0, num;
Scanner sc = new Scanner(System.in);
num = sc.nextInt();
while (num != 0) {
    sum += num;
    num = sc.nextInt();
}
System.out.println("Sum: " + sum);
```

**Best for**: unknown number of iterations; body may need to be skipped entirely.

---

## 2. The do-while Loop (Eck §3.3.2)

Tests condition **after** body. Body always executes **at least once**.

```java
do {
    // body
} while (boolean-expression);  // semicolon required

// Example: menu that must show at least once
String response;
do {
    System.out.print("Play again? (yes/no): ");
    response = sc.next();
} while (response.equals("yes"));
```

**Best for**: menus, input validation, game loops — any scenario where the body must run before the condition is meaningful (Eck, 2022, Section 3.3.2).

---

## 3. The for Loop (Eck §3.4)

Consolidates initialization, condition, and update into one line. Equivalent to a while loop but more readable for counted iteration.

```java
for (initialization; condition; update) {
    // body
}

// Example: print 1 to 10
for (int i = 1; i <= 10; i++) {
    System.out.println(i);
}
```

**Best for**: loops with a known number of iterations — counting, array traversal, fixed repetition. Eck (2022) notes for loops likely outnumber while loops in real programs because all loop control stays in one place (Section 3.4).

---

## 4. Comparison Table

| Feature | while | do-while | for |
|---------|-------|----------|-----|
| Condition tested | Before body | After body | Before body |
| Minimum executions | 0 | 1 | 0 |
| Best for | Unknown iterations | Must run at least once | Known/counted iterations |
| Loop control | Spread out | Spread out | All in one line |

---

## 5. break and continue

**`break`** — exits the loop immediately:
```java
for (int i = 0; i < 10; i++) {
    if (i == 5) break;
    System.out.println(i); // prints 0,1,2,3,4
}
```

**`continue`** — skips rest of current iteration, jumps to next:
```java
for (int i = 0; i < 10; i++) {
    if (i % 2 == 0) continue;
    System.out.println(i); // prints 1,3,5,7,9
}
```

In nested loops, both apply only to the **innermost** enclosing loop.

---

## 6. Exception Handling: try-catch-finally (Eck §3.7)

An **exception** is an event that disrupts normal program flow. Without handling, exceptions crash the program. Java's `try-catch` catches exceptions and allows graceful recovery (Eck, 2022, Section 3.7).

```java
try {
    // code that might throw an exception
} catch (ExceptionType e) {
    // handle the exception
} finally {
    // always executes — cleanup code
}
```

**Common exception types:**

| Exception | Cause |
|-----------|-------|
| `NumberFormatException` | `Integer.parseInt("abc")` — invalid string |
| `IllegalArgumentException` | Invalid parameter passed to a method |
| `ArrayIndexOutOfBoundsException` | Array index out of range |
| `NullPointerException` | Method called on null reference |

**Example:**
```java
try {
    int num = Integer.parseInt(input);
    System.out.println("You entered: " + num);
} catch (NumberFormatException e) {
    System.out.println("Invalid input: " + e.getMessage());
} finally {
    System.out.println("Processing complete.");
}
```

The `finally` block runs whether or not an exception occurred — used for cleanup like closing scanners or files (Eck, 2022, Section 3.7).

---

## 7. Nested Loops

Inner loop completes all iterations for each single iteration of the outer loop.

```java
// 3x3 multiplication table
for (int i = 1; i <= 3; i++) {
    for (int j = 1; j <= 3; j++) {
        System.out.printf("%4d", i * j);
    }
    System.out.println();
}
// Output:
//    1   2   3
//    2   4   6
//    3   6   9
```

---

## Quick Reference

```
while    → test first, may skip entirely
do-while → test last, always runs once
for      → counted iteration, all control in one line
break    → exit loop immediately
continue → skip to next iteration
try-catch-finally → handle exceptions, prevent crash, cleanup
```

---

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, Swing ed.). Creative Commons CC 4.0. https://math.hws.edu/javanotes/
