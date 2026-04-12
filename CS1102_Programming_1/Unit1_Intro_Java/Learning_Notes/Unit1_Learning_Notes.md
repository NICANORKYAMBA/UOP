# CS 1102 — Unit 1: Introduction to Java Programming
## Learning Notes | Eck (2022) Chapters 2 & 3

---

## 1. The Basic Java Application (Eck §2.1)

Java programs are written as **classes**. Every program needs a `main` method — the entry point the JVM calls when the program runs.

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
```

Key terms:
- **Syntax** — rules for what is grammatically valid Java
- **Semantics** — the meaning/behavior of the code
- **Bytecode** — what `javac` compiles `.java` files into; runs on the JVM
- **JVM (Java Virtual Machine)** — interprets bytecode, enabling platform independence ("write once, run anywhere")

Compilation workflow:
```
HelloWorld.java  →  javac  →  HelloWorld.class  →  java  →  output
   (source)        (compile)    (bytecode)         (run)
```

---

## 2. Variables and Primitive Types (Eck §2.2)

### Identifiers (variable names)
- Must start with a letter or underscore
- Can contain letters, digits, underscores
- Case-sensitive: `rate` ≠ `Rate`
- Convention: camelCase for variables (`interestRate`), PascalCase for classes (`HelloWorld`)

### Primitive Data Types (8 types)

| Type | Size | Range / Values | Use |
|------|------|----------------|-----|
| `byte` | 8 bits | -128 to 127 | Small integers |
| `short` | 16 bits | -32,768 to 32,767 | Medium integers |
| `int` | 32 bits | ~-2.1B to 2.1B | **Default integer type** |
| `long` | 64 bits | ~-9.2 × 10¹⁸ to 9.2 × 10¹⁸ | Large integers |
| `float` | 32 bits | ~7 significant digits | Real numbers (less precise) |
| `double` | 64 bits | ~15 significant digits | **Default real type** |
| `char` | 16 bits | Single Unicode character | Characters |
| `boolean` | — | `true` or `false` | Logic/conditions |

```java
int score = 95;
double gpa = 3.85;
char grade = 'A';
boolean passed = true;
```

### Reference Data Types
Unlike primitives, reference types store a **reference (address)** to an object in memory.

| Type | Example |
|------|---------|
| `String` | `"Hello"` |
| Arrays | `int[] scores` |
| Classes/Objects | `Scanner input` |

```java
String name = "Nicanor";   // reference type
int age = 25;              // primitive type
```

Key difference: primitives hold the value directly; reference types hold a pointer to the object.

### Variable Declaration and Assignment
```java
int x;          // declaration
x = 10;         // assignment
int y = 20;     // declaration + initialization
```

---

## 3. Operators and Expressions (Eck §2.5)

### Arithmetic Operators
| Operator | Meaning | Example |
|----------|---------|---------|
| `+` | Addition | `5 + 3 = 8` |
| `-` | Subtraction | `5 - 3 = 2` |
| `*` | Multiplication | `5 * 3 = 15` |
| `/` | Division | `10 / 3 = 3` (integer division) |
| `%` | Modulo (remainder) | `10 % 3 = 1` |
| `++` | Increment | `x++` |
| `--` | Decrement | `x--` |

**Integer division truncates**: `10 / 3` gives `3`, not `3.33`.

### Operator Precedence (highest → lowest)
```
1. Unary:        ++, --, !, unary -, unary +, (type-cast)
2. Multiply:     *, /, %
3. Add/Sub:      +, -
4. Relational:   <, >, <=, >=
5. Equality:     ==, !=
6. Boolean AND:  &&
7. Boolean OR:   ||
8. Ternary:      ?:
9. Assignment:   =, +=, -=, *=, /=, %=
```

**Why it matters:**
```java
int result = 2 + 3 * 4;    // = 14, not 20 (multiplication first)
int result = (2 + 3) * 4;  // = 20 (parentheses override)

boolean check = 5 > 3 && 2 < 1;  // false (both must be true)
```

Eck (2022) advises: "use parentheses liberally" to avoid confusion (p. 55).

### Relational and Boolean Operators
```java
==   // equal to
!=   // not equal to
>    // greater than
<    // less than
>=   // greater than or equal
<=   // less than or equal
&&   // logical AND
||   // logical OR
!    // logical NOT
```

### Ternary Operator
```java
// condition ? valueIfTrue : valueIfFalse
String result = (score >= 60) ? "Pass" : "Fail";
```

---

## 4. Conditional Statements (Eck §3.5, §3.6)

### if-else Statement (Eck §3.5)

**Basic if:**
```java
if (score >= 60) {
    System.out.println("You passed!");
}
```

**if-else:**
```java
if (score >= 60) {
    System.out.println("Pass");
} else {
    System.out.println("Fail");
}
```

**if-else if-else (multiway branch):**
```java
if (score >= 90) {
    grade = 'A';
} else if (score >= 80) {
    grade = 'B';
} else if (score >= 70) {
    grade = 'C';
} else {
    grade = 'F';
}
```

**Dangling else problem** — always use braces `{}` to avoid ambiguity (Eck, 2022, §3.5.1).

### switch Statement (Eck §3.6)

Works with: `int`, `short`, `byte`, `char`, `String`, enum types. **Cannot use `double` or `float`.**

**New syntax (Java 17+):**
```java
switch (day) {
    case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" ->
        System.out.println("Weekday");
    case "Saturday", "Sunday" ->
        System.out.println("Weekend");
    default ->
        System.out.println("Unknown");
}
```

**Traditional syntax (still common in existing code):**
```java
switch (choice) {
    case 1:
        System.out.println("One");
        break;
    case 2:
        System.out.println("Two");
        break;
    default:
        System.out.println("Other");
}
```

**Important**: In traditional syntax, `break` is required to prevent **fall-through** (executing the next case).

### Comparison: if-else vs switch vs ternary

| Feature | if-else | switch | ternary |
|---------|---------|--------|---------|
| Condition type | Any boolean | Equality only | Any boolean |
| Multiple conditions | Yes | Yes (cases) | No (single) |
| Range checks | Yes (`>`, `<`) | No | No |
| Readability | Good for complex logic | Good for many equal values | Good for simple assignments |
| Best for | Complex/range conditions | Menu selections, fixed values | Simple value assignment |

---

## 5. Programming Environments (Eck §2.6)

- **Command line**: `javac HelloWorld.java` → `java HelloWorld`
- **Eclipse IDE**: GUI-based, auto-compiles, has debugger
- **IntelliJ IDEA**: Popular alternative IDE

---

## Quick Reference

### Java Program Template
```java
public class ClassName {
    public static void main(String[] args) {
        // your code here
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        System.out.println("Value: " + x);
    }
}
```

### Common Scanner Methods
```java
import java.util.Scanner;
Scanner sc = new Scanner(System.in);

sc.nextInt()      // reads int
sc.nextDouble()   // reads double
sc.next()         // reads one word (String)
sc.nextLine()     // reads full line
```

---

## Key Mnemonics

- **8 primitive types**: **B**yte **S**hort **I**nt **L**ong **F**loat **D**ouble **C**har **B**oolean → **BS IL FD CB**
- **Operator precedence**: **U**nary **M**ultiply **A**dd **R**elational **E**quality **A**nd **O**r **T**ernary **A**ssign → **UMAREOATA**
- **switch cannot use**: `double`, `float`, `long` — only int-compatible types and String

---

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, Swing ed.). Creative Commons CC 4.0. https://math.hws.edu/javanotes/
