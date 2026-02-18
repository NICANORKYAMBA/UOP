# Chapter 5: Conditionals and Recursion - CS1101 Unit 3

**Course**: CS1101 Programming Fundamentals  
**Topic**: Conditionals and Recursion  
**Source**: Downey, A. (2015). Think Python (Chapter 5)  
**Date**: February 2026

---

## 📚 Overview

This chapter covers:
- Floor division and modulus operators
- Boolean expressions and logical operators
- Conditional execution (if, elif, else)
- Chained and nested conditionals
- Recursion and stack diagrams
- Keyboard input

---

## 🔢 Floor Division and Modulus

### Floor Division (`//`)
Returns the quotient without the remainder (rounds down to nearest integer)

```python
quotient = 7 // 3  # Result: 2
quotient = 10 // 4  # Result: 2
quotient = -7 // 3  # Result: -3 (rounds down, not toward zero)
```

### Modulus (`%`)
Returns the remainder after division

```python
remainder = 7 % 3  # Result: 1
remainder = 10 % 4  # Result: 2
remainder = 8 % 4  # Result: 0 (evenly divisible)
```

### Common Uses
- **Check if even/odd**: `n % 2 == 0` (even if True)
- **Extract digits**: `n % 10` (last digit)
- **Check divisibility**: `n % d == 0` (divisible by d)

---

## ✅ Boolean Expressions

### Comparison Operators
```python
x == y  # Equal to
x != y  # Not equal to
x > y   # Greater than
x < y   # Less than
x >= y  # Greater than or equal to
x <= y  # Less than or equal to
```

### Boolean Values
- `True` and `False` (capitalized in Python)
- Result of comparison operations

```python
5 == 5  # True
5 == 6  # False
type(True)  # <class 'bool'>
```

---

## 🔗 Logical Operators

### `and` Operator
Both conditions must be True

```python
x > 0 and x < 10  # True if x is between 0 and 10
```

### `or` Operator
At least one condition must be True

```python
x < 0 or x > 10  # True if x is outside range 0-10
```

### `not` Operator
Negates the boolean value

```python
not (x > y)  # True if x <= y
```

### Truth Tables

**AND**:
| A | B | A and B |
|---|---|---------|
| T | T | T |
| T | F | F |
| F | T | F |
| F | F | F |

**OR**:
| A | B | A or B |
|---|---|--------|
| T | T | T |
| T | F | T |
| F | T | T |
| F | F | F |

**NOT**:
| A | not A |
|---|-------|
| T | F |
| F | T |

---

## 🔀 Conditional Execution

### Simple If Statement
```python
if x > 0:
    print("x is positive")
```

### If-Else Statement
```python
if x % 2 == 0:
    print("x is even")
else:
    print("x is odd")
```

### Chained Conditionals (if-elif-else)
```python
if x < y:
    print("x is less than y")
elif x > y:
    print("x is greater than y")
else:
    print("x and y are equal")
```

**Key Points**:
- Conditions checked in order
- Only first True condition executes
- `else` is optional
- Can have multiple `elif` branches

---

## 🪆 Nested Conditionals

Conditionals inside other conditionals

```python
if x == y:
    print("x and y are equal")
else:
    if x < y:
        print("x is less than y")
    else:
        print("x is greater than y")
```

### Problems with Nesting
- Hard to read
- Easy to make mistakes
- Difficult to maintain

### Simplification Strategy
Use logical operators to flatten nested conditionals

**Nested** (harder to read):
```python
if 0 < x:
    if x < 10:
        print("x is a positive single-digit number")
```

**Simplified** (easier to read):
```python
if 0 < x < 10:
    print("x is a positive single-digit number")
```

Or:
```python
if 0 < x and x < 10:
    print("x is a positive single-digit number")
```

---

## 🔁 Recursion

### Definition
A function that calls itself

### Components
1. **Base case**: Condition that stops recursion
2. **Recursive case**: Function calls itself with modified argument

### Example: Countdown
```python
def countdown(n):
    if n <= 0:  # Base case
        print("Blastoff!")
    else:  # Recursive case
        print(n)
        countdown(n - 1)
```

**Execution**:
```
>>> countdown(3)
3
2
1
Blastoff!
```

### How It Works
1. `countdown(3)` prints 3, calls `countdown(2)`
2. `countdown(2)` prints 2, calls `countdown(1)`
3. `countdown(1)` prints 1, calls `countdown(0)`
4. `countdown(0)` prints "Blastoff!", returns
5. Each function returns in reverse order

---

## 📚 Stack Diagrams for Recursion

Visual representation of function calls

```
countdown(3)
    countdown(2)
        countdown(1)
            countdown(0)
                print("Blastoff!")
            return
        return
    return
return
```

Each function call creates a new **frame** on the stack

---

## 🔢 Recursive Example: Factorial

```python
def factorial(n):
    if n == 0:  # Base case
        return 1
    else:  # Recursive case
        return n * factorial(n - 1)
```

**Execution** for `factorial(3)`:
```
factorial(3)
    return 3 * factorial(2)
        return 2 * factorial(1)
            return 1 * factorial(0)
                return 1
            return 1 * 1 = 1
        return 2 * 1 = 2
    return 3 * 2 = 6
```

---

## ⌨️ Keyboard Input

### Python 3: `input()`
```python
text = input("Enter your name: ")
print("Hello, " + text)
```

### Converting Input
```python
# String to integer
age = int(input("Enter your age: "))

# String to float
price = float(input("Enter price: "))
```

### Example Program
```python
def main():
    n = int(input("Enter a number: "))
    if n > 0:
        print("Positive")
    elif n < 0:
        print("Negative")
    else:
        print("Zero")

main()
```

---

## ⚠️ Infinite Recursion

### Problem
Recursion without proper base case or progress toward base case

```python
def bad_countdown(n):
    print(n)
    bad_countdown(n - 1)  # Never stops!
```

**Result**: `RecursionError: maximum recursion depth exceeded`

### Prevention
1. Always have a base case
2. Ensure recursive case makes progress toward base case
3. Test with small inputs

---

## 🎯 Recursion vs. Iteration

### Recursion
**Pros**:
- Elegant for naturally recursive problems
- Easier to understand for some problems

**Cons**:
- Uses more memory (stack frames)
- Can cause stack overflow
- Often slower

### Iteration (Loops)
**Pros**:
- More efficient (less memory)
- Faster execution
- No stack overflow risk

**Cons**:
- Can be more complex for some problems

### When to Use Recursion
- Tree/graph traversal
- Divide-and-conquer algorithms
- Problems with recursive structure (factorial, Fibonacci)
- When code clarity is more important than efficiency

---

## 💡 Key Takeaways

1. **Boolean expressions** evaluate to True or False
2. **Logical operators** (`and`, `or`, `not`) combine conditions
3. **Chained conditionals** check multiple conditions in sequence
4. **Nested conditionals** can often be simplified with logical operators
5. **Recursion** requires base case and progress toward it
6. **Stack diagrams** help visualize recursive execution
7. **Keyboard input** uses `input()` function (returns string)

---

## 📚 Reference

Downey, A. (2015). *Think Python: How to think like a computer scientist*. Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

---

**Last Updated**: February 2026
