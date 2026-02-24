# Incremental Development - CS1101 Unit 4

**Course**: CS1101 Programming Fundamentals  
**Topic**: Step-by-Step Function Development and Debugging Strategy  
**Date**: February 2026

---

## 📚 What is Incremental Development?

**Incremental development** is a programming strategy where you build a function in small, testable steps rather than writing the whole thing at once. At each step, you:

1. Add a small piece of code
2. Test it to confirm it works
3. Move to the next piece

This avoids the nightmare of writing 50 lines and having no idea where the bug is.

---

## 🎯 Why Use Incremental Development?

| Benefit | Explanation |
|---------|-------------|
| **Easier debugging** | You know exactly which addition caused the bug |
| **Confidence building** | Each test confirms you're on track |
| **Manageable complexity** | Small steps are easier to think about |
| **Documentation** | Each stage documents your thought process |
| **Fewer errors** | Catching mistakes early prevents cascading bugs |

---

## 🔄 The 5-Stage Process

### Stage 1: Stub / Skeleton
Write a function that:
- Takes the correct parameters
- Returns a dummy value (of the expected type)
- **Goal**: Verify the function is callable

```python
def distance(x1, y1, x2, y2):
    """Calculate distance between two points."""
    return 0.0  # Dummy value — just testing structure

# Test
print(distance(1, 2, 4, 6))  # 0.0 — it runs!
```

**Why a dummy return?** 
- You can call the function without errors
- Confirms parameter names and count are correct
- Returns the expected TYPE (float)

---

### Stage 2: Add First Computation + Scaffolding
Add the first piece of real computation. Use `print()` to verify.

```python
def distance(x1, y1, x2, y2):
    dx = x2 - x1
    dy = y2 - y1
    print(f"dx = {dx}")   # Scaffolding
    print(f"dy = {dy}")   # Scaffolding
    return 0.0

# Test
print(distance(1, 2, 4, 6))
# Output:
# dx = 3
# dy = 4
# 0.0
```

**Check**: dx = 4-1 = 3 ✅, dy = 6-2 = 4 ✅

---

### Stage 3: Add Next Computation
Build on the verified computation.

```python
def distance(x1, y1, x2, y2):
    dx = x2 - x1
    dy = y2 - y1
    dsquared = dx**2 + dy**2
    print(f"dsquared = {dsquared}")  # Scaffolding
    return 0.0

# Test
print(distance(1, 2, 4, 6))
# Output:
# dsquared = 25
# 0.0
```

**Check**: 3² + 4² = 9 + 16 = 25 ✅

---

### Stage 4: Compute Final Result
Replace the dummy return with the actual result.

```python
import math

def distance(x1, y1, x2, y2):
    dx = x2 - x1
    dy = y2 - y1
    dsquared = dx**2 + dy**2
    result = math.sqrt(dsquared)
    print(f"result = {result}")  # Scaffolding
    return result

# Test
print(distance(1, 2, 4, 6))
# Output:
# result = 5.0
# 5.0
```

**Check**: √25 = 5.0 ✅

---

### Stage 5: Clean Up (Remove Scaffolding)
Remove all temporary `print()` statements. Optionally simplify the code.

```python
import math

def distance(x1, y1, x2, y2):
    """Calculate the Euclidean distance between two points."""
    return math.sqrt((x2 - x1)**2 + (y2 - y1)**2)

# Final tests
print(distance(1, 2, 4, 6))    # 5.0
print(distance(0, 0, 3, 4))    # 5.0
print(distance(0, 0, 0, 0))    # 0.0
```

---

## 🏗️ Scaffolding Explained

**Scaffolding** = temporary code used during development to peek inside your function. Like actual scaffolding on a building — useful during construction, removed when complete.

### Types of Scaffolding
```python
# 1. Print intermediate values
print(f"dx = {dx}")

# 2. Print function entry/exit
print(f"Entering function with args: {a}, {b}")
print(f"Returning: {result}")

# 3. Print types
print(f"Type of result: {type(result)}")

# 4. Assert expected values
assert dx == 3, f"Expected dx=3, got {dx}"
```

### When to Remove
- When the function passes all tests
- When you're confident in the logic
- Before submitting your code

### When to Keep (as comments)
Sometimes converting scaffolding to comments is useful for future debugging:
```python
def distance(x1, y1, x2, y2):
    dx = x2 - x1
    dy = y2 - y1
    # print(f"dx={dx}, dy={dy}")  # Uncomment for debugging
    return math.sqrt(dx**2 + dy**2)
```

---

## 📝 Full Worked Example: Hypotenuse Calculator

This is directly relevant to your **Programming Assignment Part 1**.

### The Problem
Create a function that takes two legs of a right triangle and returns the hypotenuse.

Formula: $c = \sqrt{a^2 + b^2}$

### Stage 1: Skeleton
```python
def hypotenuse(a, b):
    """Calculate the hypotenuse of a right triangle."""
    return 0.0

print(hypotenuse(3, 4))  # 0.0 — function runs
```

### Stage 2: Square the Sides
```python
def hypotenuse(a, b):
    a_squared = a ** 2
    b_squared = b ** 2
    print(f"a² = {a_squared}, b² = {b_squared}")
    return 0.0

print(hypotenuse(3, 4))
# a² = 9, b² = 16
# 0.0
```

### Stage 3: Sum the Squares
```python
def hypotenuse(a, b):
    a_squared = a ** 2
    b_squared = b ** 2
    sum_squares = a_squared + b_squared
    print(f"a² + b² = {sum_squares}")
    return 0.0

print(hypotenuse(3, 4))
# a² + b² = 25
# 0.0
```

### Stage 4: Take the Square Root
```python
import math

def hypotenuse(a, b):
    a_squared = a ** 2
    b_squared = b ** 2
    sum_squares = a_squared + b_squared
    result = math.sqrt(sum_squares)
    print(f"hypotenuse = {result}")
    return result

print(hypotenuse(3, 4))
# hypotenuse = 5.0
# 5.0
```

### Stage 5: Clean Up
```python
import math

def hypotenuse(a, b):
    """Calculate the hypotenuse of a right triangle given two legs."""
    return math.sqrt(a**2 + b**2)

# Test with known Pythagorean triples
print(hypotenuse(3, 4))    # 5.0     (3-4-5 triangle)
print(hypotenuse(5, 12))   # 13.0    (5-12-13 triangle)
print(hypotenuse(8, 15))   # 17.0    (8-15-17 triangle)
```

---

## 💡 Tips for the Programming Assignment

1. **Show EVERY stage** — document each step with code and output
2. **Explain WHY** — don't just show code, explain what each stage adds
3. **Use known test cases** — Pythagorean triples are perfect for Part 1
4. **Part 2 creativity** — choose a function that's genuinely useful (BMI calculator, grade converter, compound interest, etc.)
5. **Print scaffolding first** — then show the clean final version
6. **Test with edge cases** — what about `hypotenuse(0, 5)`? `hypotenuse(1, 1)`?
