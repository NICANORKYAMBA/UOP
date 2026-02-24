# Quick Study Guide - CS1101 Unit 4

**Course**: CS1101 Programming Fundamentals  
**Unit 4**: Functions and Return Values (Chapter 6: Fruitful Functions)  
**Date**: February 2026

---

## 🎯 One-Page Cheat Sheet

### The 5 Key Concepts in 5 Lines

1. **Fruitful functions** use `return value` — void functions just do things
2. **Incremental development** = build functions step-by-step, testing at each stage
3. **Composition** = using functions as building blocks inside other functions
4. **Boolean functions** return `True`/`False` and work as conditions in `if`/`while`
5. **Fruitful recursion** = recursive functions that `return` computed values

---

## 📋 Quick Reference Tables

### Void vs. Fruitful Functions

| Feature | Void | Fruitful |
|---------|------|----------|
| `return` statement | No (or bare `return`) | `return value` |
| Calling it | `my_func()` | `result = my_func()` |
| In expressions | Cannot use | Can use: `3 + my_func()` |
| Default return | `None` | Whatever you specify |
| Example | `print_greeting()` | `calculate_area()` |

### Return Value Rules

| Rule | Example |
|------|---------|
| Every branch must return | Both `if` and `else` need `return` |
| `return` exits immediately | Code after `return` is dead code |
| Return any type | `int`, `float`, `str`, `bool`, `list`, etc. |
| No return = `None` | Missing `return` gives `None` |
| `return` ≠ `print` | `return` sends value to caller, `print` displays |

---

### Incremental Development Steps

| Step | Action | Test Output |
|------|--------|-------------|
| 1 | Write skeleton, return dummy value | `0.0` |
| 2 | Add first computation | Intermediate value |
| 3 | Add `print` scaffolding to check | Debugging values |
| 4 | Complete the computation | Final value |
| 5 | Remove scaffolding, clean up | Clean result |

---

### Boolean Function Patterns

```python
# ❌ Beginner (works but verbose)        # ✅ Pythonic
def is_even(n):                           def is_even(n):
    if n % 2 == 0:                            return n % 2 == 0
        return True
    else:
        return False

# Using boolean functions as conditions
if is_even(x):        # ✅ Clean
if is_even(x) == True:  # ❌ Redundant
```

---

### Recursion with Returns Template

```python
def recursive_func(n):
    if base_case:           # When to stop
        return base_value   # Simplest answer
    else:
        return combine(n, recursive_func(smaller_n))  # Build answer
```

| Example | Base Case | Recursive Case |
|---------|-----------|---------------|
| `factorial(n)` | `n == 0 → return 1` | `return n * factorial(n-1)` |
| `fibonacci(n)` | `n ≤ 1 → return n` | `return fib(n-1) + fib(n-2)` |
| `power(b, e)` | `e == 0 → return 1` | `return b * power(b, e-1)` |
| `sum_digits(n)` | `n < 10 → return n` | `return n%10 + sum_digits(n//10)` |

---

### Debugging Checklist (Section 6.9)

When your function returns the wrong value, check:

| Possibility | Question | Fix |
|------------|----------|-----|
| **Precondition violation** | Are the arguments valid? | Add input validation |
| **Postcondition violation** | Is the return value correct? | Fix the computation |
| **Neither violated** | Is there a bug in the body? | Trace through logic |

**Precondition**: what must be true BEFORE the function runs  
**Postcondition**: what must be true AFTER the function returns

---

## 🔢 Key Formulas

### Distance Between Two Points
$$d = \sqrt{(x_2 - x_1)^2 + (y_2 - y_1)^2}$$

```python
import math

def distance(x1, y1, x2, y2):
    dx = x2 - x1
    dy = y2 - y1
    return math.sqrt(dx**2 + dy**2)
```

### Hypotenuse (Programming Assignment!)
$$c = \sqrt{a^2 + b^2}$$

```python
import math

def hypotenuse(a, b):
    return math.sqrt(a**2 + b**2)
```

### Circle Area with Composition
$$A = \pi r^2$$

```python
import math

def area(radius):
    return math.pi * radius**2

# Composed with distance:
def circle_area(xc, yc, xp, yp):
    radius = distance(xc, yc, xp, yp)
    return area(radius)
```

---

## ⚡ Top 10 Mistakes to Avoid

| # | Mistake | Fix |
|---|---------|-----|
| 1 | Forgetting `return` | Add `return` before the value |
| 2 | `print()` instead of `return` | `return value` not `print(value)` |
| 3 | Dead code after `return` | Move code before the `return` |
| 4 | Missing return path | Every `if/elif/else` needs `return` |
| 5 | `if is_valid == True` | Just `if is_valid:` |
| 6 | Not returning recursive call | `return func(n-1)` not just `func(n-1)` |
| 7 | Wrong base case | Test with smallest possible input |
| 8 | Not making progress | Ensure parameter shrinks each call |
| 9 | Removing scaffolding too early | Keep debug prints until it works |
| 10 | Not testing incrementally | Test after EVERY change |

---

## 📖 Vocabulary Quick Reference

| Term | Definition |
|------|-----------|
| **Fruitful function** | A function that returns a value |
| **Void function** | A function that returns `None` |
| **Return value** | The value a function sends back to the caller |
| **Dead code** | Code after a `return` that never executes |
| **Scaffolding** | Temporary code used during development |
| **Incremental development** | Building a program piece by piece |
| **Composition** | Using one function's output as another's input |
| **Boolean function** | A function that returns `True` or `False` |
| **Guardian** | A pattern that checks conditions before proceeding |
| **Precondition** | Condition that must be true before a function runs |
| **Postcondition** | Condition that must be true after a function returns |
| **Temporary variable** | A variable used for development/debugging |
| **Leap of faith** | Trusting the recursive call works correctly |

---

## 📝 Assignment Prep Quick Notes

### Discussion Forum (Section 6.9)
- Describe the **3 debugging possibilities** when a function returns wrong values
- Define **precondition** and **postcondition**
- Write a Python code example demonstrating debugging
- Minimum 150 words + code with output

### Programming Assignment
**Part 1: `hypotenuse(a, b)` function**
- Use incremental development (show ALL stages)
- Test with `hypotenuse(3, 4)` → `5.0`
- Two additional test calls

**Part 2: Custom useful function**
- Your own creation using incremental development
- Show all development stages
- Three test calls
- Minimum 200 words explanation

---

## 🧮 Practice Problems

Test yourself with these — try without looking at notes!

1. Write `absolute_value(n)` that returns the absolute value
2. Write `is_between(x, y, z)` that returns `True` if `x ≤ y ≤ z`
3. Write `sum_range(a, b)` that recursively sums all integers from a to b
4. Write `reverse_string(s)` that recursively reverses a string
5. Trace `factorial(5)` — what value does each recursive call return?

### Answers

```python
# 1. Absolute value
def absolute_value(n):
    if n < 0:
        return -n
    return n

# 2. Between check  
def is_between(x, y, z):
    return x <= y <= z

# 3. Sum range (recursive)
def sum_range(a, b):
    if a > b:
        return 0
    return a + sum_range(a + 1, b)

# 4. Reverse string (recursive)
def reverse_string(s):
    if len(s) <= 1:
        return s
    return reverse_string(s[1:]) + s[0]

# 5. factorial(5) trace:
# factorial(5) = 5 * 24 = 120
# factorial(4) = 4 * 6 = 24
# factorial(3) = 3 * 2 = 6
# factorial(2) = 2 * 1 = 2
# factorial(1) = 1 * 1 = 1
# factorial(0) = 1
```
