# Boolean Functions & Composition - CS1101 Unit 4

**Course**: CS1101 Programming Fundamentals  
**Topic**: Boolean Functions and Function Composition  
**Date**: February 2026

---

## 📚 Part 1: Boolean Functions

### What are Boolean Functions?

**Boolean functions** are functions that return `True` or `False`. They are used to encapsulate complex conditional logic into a clean, reusable, readable form.

### Why Use Them?
- **Readability**: `if is_leap_year(year)` reads like English
- **Reusability**: Define the logic once, use it everywhere
- **Testability**: Easy to verify True/False outcomes
- **Encapsulation**: Hide complex checks behind a simple name

---

### Writing Boolean Functions

#### Pattern 1: The Long Way (Explicit)
```python
def is_even(n):
    if n % 2 == 0:
        return True
    else:
        return False
```

#### Pattern 2: The Pythonic Way (Direct Return)
Since `n % 2 == 0` is ALREADY a boolean expression, just return it:
```python
def is_even(n):
    return n % 2 == 0
```

**Both do the exact same thing** — but Pattern 2 is cleaner and preferred.

---

### Practical Examples

```python
def is_positive(n):
    """Check if a number is positive."""
    return n > 0

def is_divisible(x, y):
    """Check if x is divisible by y."""
    return x % y == 0

def is_between(x, low, high):
    """Check if x is between low and high (inclusive)."""
    return low <= x <= high

def is_valid_triangle(a, b, c):
    """Check if three sides can form a valid triangle."""
    return (a + b > c) and (b + c > a) and (a + c > b)

def is_leap_year(year):
    """Check if a year is a leap year."""
    return (year % 4 == 0 and year % 100 != 0) or (year % 400 == 0)

def is_prime(n):
    """Check if a number is prime."""
    if n < 2:
        return False
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            return False
    return True
```

---

### Using Boolean Functions in Conditionals

```python
# Clean and readable
if is_leap_year(2024):
    print("2024 is a leap year")

# As guards
def factorial(n):
    if not is_positive(n) and n != 0:
        return None
    if n == 0:
        return 1
    return n * factorial(n - 1)

# In list comprehensions
even_numbers = [x for x in range(20) if is_even(x)]
primes = [x for x in range(2, 50) if is_prime(x)]
```

---

### Naming Conventions

Boolean functions should read like yes/no questions:

| Prefix | Example | Returns |
|--------|---------|---------|
| `is_` | `is_even(4)` | `True` |
| `has_` | `has_vowel("hello")` | `True` |
| `can_` | `can_vote(age)` | `True/False` |
| `should_` | `should_retry(count)` | `True/False` |

---

## 📚 Part 2: Composition

### What is Composition?

**Composition** is the technique of building complex functions by calling simpler functions inside them. Each function does one specific task, and larger functions combine them.

Think of it like cooking:
- `chop_vegetables()` — one task
- `boil_water()` — one task
- `make_soup()` — calls `chop_vegetables()` and `boil_water()`

---

### Basic Composition

```python
def square(x):
    """Return x squared."""
    return x ** 2

def add(a, b):
    """Return sum of a and b."""
    return a + b

def sum_of_squares(a, b):
    """Return a² + b² using composition."""
    return add(square(a), square(b))  # Composes square() and add()

print(sum_of_squares(3, 4))  # 25
```

**Call chain**: `sum_of_squares(3,4)` → `add(square(3), square(4))` → `add(9, 16)` → `25`

---

### Building Up: The Distance Example

The textbook builds a `circle_area` function by composing simpler functions:

```python
import math

# Level 1: Basic operations
def square(x):
    return x ** 2

# Level 2: Composes Level 1
def distance(x1, y1, x2, y2):
    """Distance between two points."""
    dx = x2 - x1
    dy = y2 - y1
    return math.sqrt(square(dx) + square(dy))

# Level 2: Independent function
def area(radius):
    """Area of a circle."""
    return math.pi * square(radius)

# Level 3: Composes Level 2
def circle_area(xc, yc, xp, yp):
    """Area of circle given center (xc,yc) and point on perimeter (xp,yp)."""
    radius = distance(xc, yc, xp, yp)
    return area(radius)

# Use it
print(circle_area(0, 0, 3, 4))  # ~78.54
```

### Composition Hierarchy
```
circle_area(xc, yc, xp, yp)
    ├── distance(xc, yc, xp, yp)
    │       └── square(dx), square(dy)
    └── area(radius)
            └── square(radius)
```

---

### Composition Patterns

#### Pattern 1: Sequential Composition
One function's output becomes another's input:
```python
result = outer_func(inner_func(x))
```

```python
def celsius_to_fahrenheit(c):
    return c * 9/5 + 32

def format_temperature(f):
    return f"{f:.1f}°F"

# Compose: convert then format
print(format_temperature(celsius_to_fahrenheit(100)))  # "212.0°F"
```

#### Pattern 2: Parallel Composition
Multiple functions provide inputs to another:
```python
result = combining_func(func_a(x), func_b(y))
```

```python
def width(x1, x2):
    return abs(x2 - x1)

def height(y1, y2):
    return abs(y2 - y1)

def rectangle_area(x1, y1, x2, y2):
    return width(x1, x2) * height(y1, y2)  # Both feed into multiplication

print(rectangle_area(0, 0, 5, 3))  # 15
```

#### Pattern 3: Recursive Composition
A function calls itself as part of its computation:
```python
def power(base, exp):
    if exp == 0:
        return 1
    return base * power(base, exp - 1)  # Composes with itself!
```

---

### Benefits of Composition

| Benefit | Explanation |
|---------|-------------|
| **Modularity** | Each function does ONE thing |
| **Reusability** | `square()` is used in multiple places |
| **Readability** | `circle_area()` reads like the math formula |
| **Testability** | Test each function independently |
| **Maintainability** | Fix a bug in `square()`, fixes everything using it |

---

## 💡 Pro Tips

1. **Break problems down**: If a function is getting complex, ask "Can I extract a helper function?"
2. **Name clearly**: Boolean functions → `is_/has_/can_`; computation functions → describe what they compute
3. **Test bottom-up**: Test `square()` first, then `distance()`, then `circle_area()`
4. **Return booleans directly**: Don't write `if x: return True else: return False` — just `return x`
5. **Compose in return statements**: `return math.sqrt(square(a) + square(b))` is clean and readable
6. **Keep functions small**: If a function does more than one conceptual thing, split it up
