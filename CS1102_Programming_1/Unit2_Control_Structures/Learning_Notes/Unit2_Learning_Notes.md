# CS 1102 — Unit 2: Control Structures
## Comprehensive Learning Notes
### Based on Eck (2022), Sections 3.3, 3.4, 3.7

---

## Part 1: The while and do-while Statements (Eck, 2022, Section 3.3)

### 1.1 Understanding Control Structures

Java statements are either **simple** (assignment, subroutine calls) or **compound**. Compound statements are called **control structures** because they control the order in which statements execute. The while loop, do-while loop, for loop, if statement, and switch statement are all control structures. Each one is considered a single statement, but it contains other statements inside itself (Eck, 2022, Section 3.3).

---

### 1.2 The while Statement (Section 3.3.1)

**Syntax:**
```java
while ( boolean-expression ) {
    statements
}
```

The `boolean-expression` is called the **continuation condition** or **test**. The body of the loop repeats as long as the condition is `true`.

**Critical points from Eck (2022, Section 3.3.1):**

1. **The body may execute zero times.** If the condition is `false` before the loop starts, the body never runs at all. This is a fundamental difference from do-while.

2. **The condition is only checked at the top.** If the condition becomes `false` in the middle of the loop body, the loop does NOT stop immediately. The computer finishes executing the entire body, then jumps back to the top and checks the condition again.

3. **Priming the loop.** Before a while loop starts, you must ensure the condition makes sense on the first evaluation. Setting things up so the test is meaningful the first time is called **priming the loop**.

**Sentinel value pattern — a classic while loop use case:**

A **sentinel value** is a special input value that signals the end of data. For example, asking the user to enter 0 to stop entering positive integers:

```java
int sum = 0;
int count = 0;
double average;

// Prime the loop — read the first value before the loop starts
System.out.print("Enter your first positive integer: ");
int inputNumber = sc.nextInt();

while (inputNumber != 0) {
    sum += inputNumber;   // add to running total
    count++;              // count valid inputs
    System.out.print("Enter next integer, or 0 to end: ");
    inputNumber = sc.nextInt();
}

// After the loop, compute the average
if (count == 0) {
    System.out.println("You didn't enter any data!");
} else {
    average = ((double) sum) / count;  // cast to double to avoid integer division
    System.out.printf("Average: %.3f%n", average);
}
```

**Why the cast `(double) sum`?** Because `sum` and `count` are both `int`, the expression `sum / count` performs integer division and truncates the decimal. Casting one operand to `double` forces floating-point division (Eck, 2022, Section 3.3.1).

**Off-by-one errors:** Eck (2022) warns that counting is harder than it looks. A common mistake is including the sentinel value in the count or sum. The loop above correctly excludes the sentinel because the loop ends before processing the zero.

---

### 1.3 The do-while Statement (Section 3.3.2)

**Syntax:**
```java
do {
    statements
} while ( boolean-expression );   // semicolon is REQUIRED
```

The key difference: the condition is tested **at the end**, after the body executes. Therefore, **the body always executes at least once**, regardless of the condition.

**When to use do-while:**
Use do-while when the action must happen before it makes sense to ask whether to continue. The classic example is a game loop:

```java
boolean wantsToContinue;
do {
    playGame();
    System.out.print("Do you want to play again? (yes/no): ");
    wantsToContinue = sc.nextBoolean();
} while (wantsToContinue);
```

Eck (2022, Section 3.3.2) explains that using a while loop here would require duplicating the `playGame()` call before the loop — the do-while avoids this redundancy. The variable `wantsToContinue` is an example of a **flag variable** — a boolean used as a signal that is set in one part of the program and tested in another.

**Equivalence of while and do-while:**
Any do-while loop can be rewritten as a while loop, and vice versa. They do not add new power to the language — they are convenience structures. The do-while:
```java
do { doSomething(); } while (condition);
```
is exactly equivalent to:
```java
doSomething();
while (condition) { doSomething(); }
```

---

### 1.4 break and continue (Section 3.3.3)

Sometimes the most natural place to test a loop condition is in the **middle** of the loop body, not at the top or bottom. Java provides `break` and `continue` for this.

**break** — immediately exits the loop entirely. Execution continues with the first statement after the loop:

```java
while (true) {   // infinite loop — will be terminated by break
    System.out.print("Enter a positive number: ");
    int N = sc.nextInt();
    if (N > 0)
        break;   // exit the loop when valid input is received
    System.out.println("Your answer must be > 0. Try again.");
}
// execution continues here after break
```

`while (true)` is a legitimate infinite loop that relies on `break` to terminate. This pattern is useful when the termination condition can only be determined inside the loop body.

**continue** — skips the rest of the current iteration and jumps back to the loop's condition check (for while/do-while) or to the update step (for for loops):

```java
for (int i = 1; i <= 20; i++) {
    if (i % 2 != 0)
        continue;   // skip odd numbers
    System.out.println(i);   // only prints even numbers: 2, 4, 6, ..., 20
}
```

**Labeled break for nested loops:**
In nested loops, a plain `break` only exits the innermost loop. A **labeled break** lets you break out of an outer loop:

```java
boolean nothingInCommon = true;
outerLoop: for (int i = 0; i < s1.length(); i++) {
    for (int j = 0; j < s2.length(); j++) {
        if (s1.charAt(i) == s2.charAt(j)) {
            nothingInCommon = false;
            break outerLoop;   // exits BOTH loops
        }
    }
}
```

Without the label, `break` would only exit the inner `for` loop, and the outer loop would continue (Eck, 2022, Section 3.3.3).

---

## Part 2: The for Statement (Eck, 2022, Section 3.4)

### 2.1 Why for Loops Exist

Any `for` loop can be rewritten as a `while` loop — the language gains no new power from having `for`. However, for a certain type of problem, a `for` loop is easier to write and easier to read. Eck (2022, Section 3.4) notes that for loops likely outnumber while loops in real programs.

The reason is that many while loops follow this exact pattern:
```
initialization
while (condition) {
    body
    update
}
```
The `for` loop compresses this into one line, keeping all loop control in one place.

---

### 2.2 for Loop Syntax and Execution (Section 3.4.1)

**Syntax:**
```java
for ( initialization ; continuation-condition ; update ) {
    statements
}
```

**Execution order:**
1. `initialization` executes **once**, before the loop starts
2. `continuation-condition` is checked **before each iteration** (including the first)
3. If condition is `true`, the body executes
4. `update` executes **at the end of each iteration**
5. Go back to step 2

**Example — equivalent while and for loops:**
```java
// while version
int years = 0;
while (years < 5) {
    principal += principal * rate;
    System.out.println(principal);
    years++;
}

// for version — identical behavior, more readable
for (int years = 0; years < 5; years++) {
    principal += principal * rate;
    System.out.println(principal);
}
```

**The counting loop** — the most common for loop pattern:
```java
for (variable = min; variable <= max; variable++) {
    // body executes for each value from min to max inclusive
}
```

**Important:** Java programmers often start at 0 and use `<` instead of `<=`:
```java
for (int i = 0; i < 10; i++) { ... }   // iterates 10 times: i = 0,1,2,...,9
for (int i = 1; i <= 10; i++) { ... }  // iterates 10 times: i = 1,2,...,10
```
Using `<` vs `<=` incorrectly is a common source of **off-by-one errors** (Eck, 2022, Section 3.4.1).

**Counting down:**
```java
for (int N = 10; N >= 1; N--) {
    System.out.println(N);   // prints 10, 9, 8, ..., 1
}
```

**Loop control variable:** The variable whose value is tested in the condition and updated each iteration. It is often declared inside the `for` statement itself (`for (int i = 0; ...)`), which limits its scope to the loop body.

---

### 2.3 Nested for Loops (Section 3.4.3)

Control structures can be nested inside each other. A for loop inside another for loop is called a **nested loop**. The inner loop completes all its iterations for each single iteration of the outer loop.

**Example — multiplication table:**
```java
for (int row = 1; row <= 12; row++) {
    for (int col = 1; col <= 12; col++) {
        System.out.printf("%4d", row * col);   // print in 4-character columns
    }
    System.out.println();   // newline after each row
}
```

For a 12×12 table, the inner loop body executes 12 × 12 = 144 times total.

**Example — finding letters in a string (break in nested loop):**
```java
String str = "Hello World".toUpperCase();
int count = 0;
for (char letter = 'A'; letter <= 'Z'; letter++) {
    for (int i = 0; i < str.length(); i++) {
        if (letter == str.charAt(i)) {
            System.out.print(letter + " ");
            count++;
            break;   // break inner loop — avoid counting same letter twice
        }
    }
}
System.out.println("\nDifferent letters: " + count);
```

The `break` here exits only the inner loop. The outer loop continues with the next letter. Without `break`, a letter appearing multiple times in the string would be counted multiple times (Eck, 2022, Section 3.4.3).

---

## Part 3: Introduction to Exceptions and try-catch (Eck, 2022, Section 3.7)

### 3.1 What is an Exception? (Section 3.7.1)

An **exception** is an event that disrupts the normal flow of control in a program. The term "exception" is preferred over "error" because not every exception is truly an error — sometimes an exception is just another way to organize program flow (Eck, 2022, Section 3.7.1).

When an exception occurs, we say it is **thrown**. If nothing catches it, the program **crashes** and prints an error message. Java makes it possible to **catch** exceptions and respond to them gracefully.

Exceptions in Java are represented as **objects** of type `Exception`. Different subclasses of `Exception` represent different types of exceptions.

**Two key exception types introduced in Section 3.7:**

| Exception | When it is thrown |
|-----------|------------------|
| `NumberFormatException` | `Integer.parseInt(str)` or `Double.parseDouble(str)` is called with a string that is not a valid number (e.g., `"fred"`) |
| `IllegalArgumentException` | An illegal value is passed as a parameter to a subroutine |

---

### 3.2 The try-catch Statement (Section 3.7.2)

**Syntax:**
```java
try {
    statements-1
}
catch ( ExceptionClassName variableName ) {
    statements-2
}
```

**How it executes:**
1. The computer executes `statements-1` inside the `try` block
2. If **no exception** occurs, the `catch` block is skipped entirely and the program continues normally
3. If an exception of the specified type occurs during `statements-1`, the computer **immediately jumps** to the `catch` block, skipping any remaining statements in `try`
4. The `variableName` inside `catch` represents the exception object — you can print it to see the error message
5. After the `catch` block finishes, the program continues with whatever comes after the entire `try-catch`

**Important:** The braces `{ }` in try-catch are **always required**, even if there is only one statement. This is different from if statements and loops where braces around a single statement are optional (Eck, 2022, Section 3.7.2).

**Example — handling invalid number input:**
```java
double x;
String str = sc.next();
try {
    x = Double.parseDouble(str);
    System.out.println("The number is " + x);   // skipped if exception occurs
}
catch (NumberFormatException e) {
    System.out.println("Not a legal number.");
    x = Double.NaN;   // Double.NaN = "not a number" special value
}
```

If `str` is `"3.14"`, the try block succeeds and the catch block is skipped. If `str` is `"hello"`, `parseDouble` throws `NumberFormatException`, the print statement in try is skipped, and the catch block runs.

---

### 3.3 Combining try-catch with Loops

A powerful pattern is using try-catch inside a loop to handle bad input and keep asking the user until valid input is received:

```java
double total = 0;
int count = 0;
String str;

System.out.println("Enter numbers. Press Enter on a blank line to stop.");
while (true) {
    System.out.print("? ");
    str = sc.nextLine();
    if (str.equals("")) {
        break;   // blank line signals end of input
    }
    try {
        double number = Double.parseDouble(str);
        total += number;
        count++;
    }
    catch (NumberFormatException e) {
        System.out.println("Not a legal number! Try again.");
        // loop continues — bad input is ignored
    }
}

if (count > 0) {
    System.out.printf("Average of %d numbers: %.6f%n", count, total / count);
}
```

This is the `ComputeAverage2` pattern from Eck (2022, Section 3.7.2). The exception is caught, a message is printed, and the loop continues — the program does not crash.

---

### 3.4 Exceptions as Flow Control

Eck (2022, Section 3.7.3) shows an advanced pattern where an exception is used as the expected signal to end a loop — for example, reading numbers from a file until the end-of-file exception is thrown:

```java
try {
    while (true) {
        double number = readNextNumber();   // throws exception at end of file
        count++;
        sum += number;
    }
}
catch (IllegalArgumentException e) {
    // end of file reached — this is expected, not an error
    // do nothing here, just proceed with the rest of the program
}
```

This is described as "using an exception as part of the expected flow of control" — not every exception represents a bug (Eck, 2022, Section 3.7.3).

---

## Part 4: Summary and Comparison

### 4.1 Choosing the Right Loop

| Situation | Best loop | Reason |
|-----------|-----------|--------|
| Number of iterations known in advance | `for` | Compact, all control in one line |
| Number of iterations unknown, may be zero | `while` | Condition checked first, body may be skipped |
| Body must execute at least once | `do-while` | Condition checked after body |
| Loop termination condition is in the middle | `while (true)` + `break` | Most natural expression of the logic |

### 4.2 Key Concepts to Remember

- **Sentinel value**: a special input value that signals end of data (e.g., 0 to stop entering positive integers)
- **Priming a loop**: reading the first value before a while loop so the condition makes sense on the first check
- **Flag variable**: a boolean variable used as a signal, set in one place and tested in another
- **Off-by-one error**: using `<` vs `<=` incorrectly, or including/excluding the sentinel value
- **Loop control variable**: the variable initialized, tested, and updated in a for loop
- **Labeled break**: breaks out of a specific outer loop in nested loop structures
- **Exception**: an object representing an abnormal event; thrown when it occurs, caught by try-catch
- **NumberFormatException**: thrown by `Integer.parseInt()` or `Double.parseDouble()` when the string is not a valid number

### 4.3 Common Mistakes

1. **Forgetting the semicolon** after `do { } while (condition)` — syntax error
2. **Infinite loop** — forgetting to update the loop control variable so the condition never becomes false
3. **Off-by-one** — using `<` when `<=` is needed, or vice versa
4. **Integer division** — computing `sum / count` when both are `int` gives a truncated result; cast one to `double`
5. **Not priming a while loop** — testing a variable before it has been assigned a value
6. **Catching the wrong exception type** — only the specified exception type is caught; others still crash the program
7. **Missing braces in try-catch** — unlike if/while, braces are always required in try-catch

---

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, Swing ed.). Creative Commons CC 4.0. https://math.hws.edu/javanotes/
