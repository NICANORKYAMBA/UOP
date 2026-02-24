# Chapter 6: Fruitful Functions - CS1101 Unit 4

**Course**: CS1101 Programming Fundamentals  
**Topic**: Fruitful Functions (Functions with Return Values)  
**Source**: Downey, A. (2015). Think Python (Chapter 6)  
**Date**: February 2026

---

## 📚 Overview

This chapter covers the concept of **fruitful functions** — functions that return a value to the caller. Unlike void functions (which perform actions but return `None`), fruitful functions produce results that can be stored, used in expressions, or passed to other functions.

**Key Topics**:
- Return values and the `return` statement
- Incremental development strategy
- Composition of functions
- Boolean functions
- Recursion with return values
- Debugging fruitful functions (preconditions & postconditions)

---

## 🔄 Void Functions vs. Fruitful Functions

### Void Functions (Unit 2-3)
Functions that perform an action but don't return a useful value.

```python
def greet(name):
    print(f"Hello, {name}!")  # Performs action, returns None

result = greet("Nicanor")
print(result)  # None
```

### Fruitful Functions (Unit 4)
Functions that compute and **return** a value.

```python
def add(a, b):
    return a + b  # Returns computed value

result = add(3, 4)
print(result)  # 7
```

### Key Differences

| Aspect | Void Function | Fruitful Function |
|--------|--------------|-------------------|
| **Purpose** | Performs action | Computes & returns value |
| **return** | No return (or `return` alone) | `return value` |
| **Result** | Returns `None` | Returns computed value |
| **Usage** | Called for side effects | Used in expressions |
| **Example** | `print()`, `time.sleep()` | `abs()`, `math.sqrt()`, `len()` |

---

## 📤 The `return` Statement

### Basic Syntax
```python
def function_name(parameters):
    # computation
    return value
```

### Key Rules

**1. `return` immediately exits the function**
```python
def absolute_value(x):
    if x < 0:
        return -x    # Exits here if x is negative
    return x          # Exits here if x is non-negative
```

**2. Code after `return` is never executed (dead code)**
```python
def bad_function():
    return 42
    print("This never runs!")  # Dead code — unreachable
```

**3. Every path through the function should hit a `return`**
```python
# ❌ BAD: Missing return path
def absolute_value(x):
    if x < 0:
        return -x
    if x > 0:
        return x
    # What if x == 0? Returns None!

# ✅ GOOD: All paths covered
def absolute_value(x):
    if x < 0:
        return -x
    else:
        return x  # Handles x >= 0
```

**4. Multiple return values are possible (as tuples)**
```python
def divide_and_remainder(a, b):
    quotient = a // b
    remainder = a % b
    return quotient, remainder  # Returns a tuple

q, r = divide_and_remainder(17, 5)
print(q, r)  # 3 2
```

---

## 🔧 Incremental Development

### What is Incremental Development?

A strategy for developing complex functions by:
1. Starting with a simple working version
2. Adding small pieces of functionality
3. Testing at each stage
4. Building up to the complete solution

### Why Use It?
- Easier to **debug** (you know which addition broke things)
- Builds **confidence** at each step
- Prevents **overwhelming complexity**
- Creates a **documented development process**

### The Process (5 Stages)

#### Stage 1: Write the Skeleton
Start with a function that takes the right parameters and returns a dummy value.

```python
def hypotenuse(a, b):
    return 0.0  # Dummy return — just testing structure

# Test
print(hypotenuse(3, 4))  # 0.0 — structure works!
```

#### Stage 2: Add Intermediate Computation
Add one piece of the calculation.

```python
def hypotenuse(a, b):
    a_squared = a**2
    b_squared = b**2
    print(f"a_squared = {a_squared}, b_squared = {b_squared}")  # Scaffolding
    return 0.0

# Test
print(hypotenuse(3, 4))  # a_squared = 9, b_squared = 16 → correct!
```

#### Stage 3: Add More Computation
Add the next piece.

```python
import math

def hypotenuse(a, b):
    a_squared = a**2
    b_squared = b**2
    sum_of_squares = a_squared + b_squared
    print(f"sum_of_squares = {sum_of_squares}")  # Scaffolding
    return 0.0

# Test
print(hypotenuse(3, 4))  # sum_of_squares = 25 → correct!
```

#### Stage 4: Compute the Final Result
Replace the dummy return with the actual computation.

```python
import math

def hypotenuse(a, b):
    a_squared = a**2
    b_squared = b**2
    sum_of_squares = a_squared + b_squared
    result = math.sqrt(sum_of_squares)
    print(f"result = {result}")  # Scaffolding
    return result

# Test
print(hypotenuse(3, 4))  # result = 5.0 → correct!
```

#### Stage 5: Clean Up (Remove Scaffolding)
Remove print statements used for debugging.

```python
import math

def hypotenuse(a, b):
    return math.sqrt(a**2 + b**2)

# Final tests
print(hypotenuse(3, 4))    # 5.0
print(hypotenuse(5, 12))   # 13.0
print(hypotenuse(8, 15))   # 17.0
```

### Key Concept: Scaffolding
**Scaffolding** = temporary code (usually `print` statements) added during development to verify intermediate values. It gets removed in the final version.

---

## 🧩 Composition

### What is Composition?
**Composition** is calling one function from within another function to build complex operations from simpler ones.

### Simple Example
```python
def square(x):
    return x ** 2

def sum_of_squares(a, b):
    return square(a) + square(b)  # Composes square() calls

print(sum_of_squares(3, 4))  # 25
```

### Building Up with Composition
```python
import math

def distance(x1, y1, x2, y2):
    """Calculate distance between two points using composition."""
    dx = x2 - x1
    dy = y2 - y1
    return math.sqrt(square(dx) + square(dy))

def circle_area(xc, yc, xp, yp):
    """Calculate area of circle given center and a point on the perimeter."""
    radius = distance(xc, yc, xp, yp)  # Composes distance()
    return area(radius)                  # Composes area()

def area(radius):
    """Calculate area of circle given radius."""
    return math.pi * radius ** 2
```

### Composition Chain
```
circle_area() → calls distance() → calls square()
             → calls area()
```

**Each function does ONE thing well, and bigger functions combine them.**

---

## ✅ Boolean Functions

### What are Boolean Functions?
Functions that return `True` or `False`. They are useful for encapsulating complex conditional tests.

### Basic Example
```python
def is_divisible(x, y):
    """Return True if x is divisible by y."""
    if x % y == 0:
        return True
    else:
        return False

print(is_divisible(10, 5))  # True
print(is_divisible(10, 3))  # False
```

### Cleaner Version (Pythonic)
Since `x % y == 0` already IS a boolean expression:
```python
def is_divisible(x, y):
    """Return True if x is divisible by y."""
    return x % y == 0  # Returns the boolean directly!
```

### Using Boolean Functions in Conditionals
```python
def is_even(n):
    return n % 2 == 0

def is_positive(n):
    return n > 0

# Use in if statements
if is_even(x) and is_positive(x):
    print(f"{x} is a positive even number")
```

### Naming Convention
Boolean functions typically start with:
- `is_` → `is_divisible()`, `is_even()`, `is_valid()`
- `has_` → `has_permission()`, `has_value()`
- `can_` → `can_vote()`, `can_access()`

---

## 🔁 Recursion with Return Values

### Factorial (Classic Example)
```python
def factorial(n):
    """Compute n! recursively."""
    if n == 0:          # Base case
        return 1
    else:               # Recursive case
        return n * factorial(n - 1)

print(factorial(5))  # 120
```

**How it works (stack trace)**:
```
factorial(5)
  → 5 * factorial(4)
       → 4 * factorial(3)
            → 3 * factorial(2)
                 → 2 * factorial(1)
                      → 1 * factorial(0)
                           → returns 1
                      → returns 1 * 1 = 1
                 → returns 2 * 1 = 2
            → returns 3 * 2 = 6
       → returns 4 * 6 = 24
  → returns 5 * 24 = 120
```

### Fibonacci (Another Classic)
```python
def fibonacci(n):
    """Compute nth Fibonacci number recursively."""
    if n == 0:
        return 0
    elif n == 1:
        return 1
    else:
        return fibonacci(n - 1) + fibonacci(n - 2)

print(fibonacci(10))  # 55
```

### Leap of Faith
**Leap of faith** = when writing recursive functions, you TRUST that the recursive call returns the correct result. Instead of tracing every call, you assume:
- The base case works (verify this)
- If the recursive call works for smaller inputs, the whole function works

**Example thought process for `factorial(n)`**:
> "Can `factorial(n-1)` correctly compute `(n-1)!`? If yes, then `n * factorial(n-1)` correctly computes `n!`."

---

## 🐛 Debugging Fruitful Functions (Section 6.9)

### Three Debugging Possibilities

When a function isn't working, there are three possibilities:

#### 1. Precondition Violation
**What**: Something wrong with the arguments BEFORE the function runs.

**Precondition** = the conditions that must be true about the input BEFORE the function executes.

```python
def factorial(n):
    """Precondition: n must be a non-negative integer."""
    if n == 0:
        return 1
    return n * factorial(n - 1)

# Precondition violation:
factorial(-1)   # Infinite recursion! n is never >= 0
factorial(3.5)  # Won't terminate properly
```

**Fix**: Validate inputs or add a guardian check:
```python
def factorial(n):
    if not isinstance(n, int) or n < 0:
        print(f"Error: {n} is not a valid input. Must be non-negative integer.")
        return None
    if n == 0:
        return 1
    return n * factorial(n - 1)
```

#### 2. Postcondition Violation
**What**: Something wrong with the return value AFTER the function runs.

**Postcondition** = the conditions that must be true about the output AFTER the function executes.

```python
def absolute_value(x):
    """Postcondition: result should always be >= 0."""
    if x < 0:
        return -x
    elif x > 0:
        return x
    # Bug: missing case for x == 0, returns None!

result = absolute_value(0)
print(result)  # None — postcondition violated!
```

**Fix**: Ensure all code paths return the correct value:
```python
def absolute_value(x):
    if x < 0:
        return -x
    else:
        return x  # Covers x == 0 and x > 0
```

#### 3. Something Wrong with the Function Body
**What**: The logic inside the function itself is incorrect.

```python
def celsius_to_fahrenheit(celsius):
    """Should use formula: F = C * 9/5 + 32"""
    return celsius * 5/9 + 32  # Bug! Formula is inverted (5/9 instead of 9/5)

print(celsius_to_fahrenheit(100))  # 87.56 — should be 212!
```

**Fix**: Check the algorithm/formula:
```python
def celsius_to_fahrenheit(celsius):
    return celsius * 9/5 + 32  # Correct formula

print(celsius_to_fahrenheit(100))  # 212.0 ✅
```

### Debugging Strategy
1. **Check preconditions first** — are the inputs valid?
2. **Add print statements** (scaffolding) to see intermediate values
3. **Check postconditions** — is the return value what you expect?
4. **Test with known inputs** — use cases where you know the answer
5. **Simplify** — test with the smallest possible input first

---

## 📖 Key Vocabulary

| Term | Definition |
|------|-----------|
| **Fruitful function** | A function that returns a value |
| **Void function** | A function that returns `None` |
| **Return value** | The value a function sends back to the caller |
| **Dead code** | Code that can never be executed (after `return`) |
| **Scaffolding** | Temporary code used during development for debugging |
| **Incremental development** | Building programs by adding/testing small pieces |
| **Composition** | Calling a function from within another function |
| **Boolean function** | A function that returns `True` or `False` |
| **Precondition** | Conditions required of arguments before function runs |
| **Postcondition** | Conditions expected of return value after function runs |
| **Leap of faith** | Trusting recursive calls return correct results |
| **Guardian** | A check at the start of a function to handle invalid inputs |
