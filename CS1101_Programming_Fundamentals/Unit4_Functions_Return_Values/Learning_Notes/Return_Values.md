# Return Values Deep Dive - CS1101 Unit 4

**Course**: CS1101 Programming Fundamentals  
**Topic**: Understanding Return Values in Python Functions  
**Date**: February 2026

---

## 📚 What are Return Values?

A **return value** is the result a function sends back to the code that called it. When a function uses the `return` statement, it:
1. Evaluates the expression after `return`
2. Sends that value back to the caller
3. Immediately exits the function

---

## 🎯 The `return` Statement in Detail

### Basic Return
```python
def double(x):
    return x * 2

result = double(5)
print(result)  # 10
```

### Return Exits Immediately
```python
def first_positive(a, b, c):
    if a > 0:
        return a      # Exits here if a > 0
    if b > 0:
        return b      # Exits here if b > 0
    if c > 0:
        return c      # Exits here if c > 0
    return None        # None of them positive

print(first_positive(-1, 5, 10))  # 5 (never checks c)
```

### Return Without a Value
```python
def greet(name):
    if name == "":
        return          # Returns None, exits early
    print(f"Hello, {name}!")

greet("")           # Nothing happens — returned early
greet("Nicanor")    # "Hello, Nicanor!"
```

---

## 📊 What Can You Return?

### Any Data Type
```python
# Integer
def square(x):
    return x ** 2           # Returns int

# Float
def average(a, b):
    return (a + b) / 2      # Returns float

# String
def full_name(first, last):
    return f"{first} {last}" # Returns string

# Boolean
def is_adult(age):
    return age >= 18         # Returns bool

# List
def first_n(n):
    return list(range(1, n+1))  # Returns list

# Tuple (multiple values)
def min_max(numbers):
    return min(numbers), max(numbers)  # Returns tuple
```

### Multiple Return Values
Python allows returning multiple values as a tuple:

```python
def divide(a, b):
    quotient = a // b
    remainder = a % b
    return quotient, remainder

# Unpack the tuple
q, r = divide(17, 5)
print(f"17 / 5 = {q} remainder {r}")  # 17 / 5 = 3 remainder 2

# Or keep as tuple
result = divide(17, 5)
print(result)      # (3, 2)
print(result[0])   # 3
print(result[1])   # 2
```

---

## ⚠️ Common Pitfalls

### Pitfall 1: Forgetting to Return
```python
# ❌ BUG: Computes but doesn't return
def add(a, b):
    result = a + b    # Computes it...
    # Forgot: return result

x = add(3, 4)
print(x)  # None — the value was lost!

# ✅ FIX
def add(a, b):
    result = a + b
    return result      # Or simply: return a + b
```

### Pitfall 2: Printing Instead of Returning
```python
# ❌ BUG: Prints but doesn't return
def square(x):
    print(x ** 2)      # Outputs to screen, returns None

result = square(5)     # Prints "25" but...
print(result)          # None!
total = square(3) + square(4)  # TypeError: None + None

# ✅ FIX
def square(x):
    return x ** 2       # Returns to caller

result = square(5)
print(result)           # 25
total = square(3) + square(4)  # 25
```

### Pitfall 3: Dead Code After Return
```python
# ❌ Code after return never executes
def calculate(x):
    return x * 2
    print("Done!")      # DEAD CODE — never reached
    x = x + 1           # DEAD CODE — never reached

# ✅ Put important code before return
def calculate(x):
    result = x * 2
    print("Done!")       # Runs before return
    return result
```

### Pitfall 4: Missing Return Path
```python
# ❌ BUG: Not all paths return a value
def classify(n):
    if n > 0:
        return "positive"
    elif n < 0:
        return "negative"
    # What about n == 0? Returns None!

print(classify(0))  # None

# ✅ FIX: Cover all cases
def classify(n):
    if n > 0:
        return "positive"
    elif n < 0:
        return "negative"
    else:
        return "zero"
```

---

## 🔄 Using Return Values

### In Variables
```python
area = circle_area(5)
```

### In Expressions
```python
total = circle_area(5) + circle_area(3)
```

### In Print Statements
```python
print(f"Area: {circle_area(5)}")
```

### In Conditions
```python
if is_valid(input_data):
    process(input_data)
```

### As Arguments to Other Functions
```python
result = math.sqrt(sum_of_squares(3, 4))
```

### In Return Statements (Composition)
```python
def hypotenuse(a, b):
    return math.sqrt(square(a) + square(b))
```

---

## 💡 Pro Tips

1. **Return, don't print** — Functions should return values; the caller decides what to do with them
2. **One return value concept** — Each function should compute ONE logical result
3. **Check all paths** — Every `if/elif/else` branch should have a `return`
4. **Test return values** — Always assign the result and verify: `result = func(args); print(result)`
5. **Type consistency** — A function should always return the same type (don't return `int` sometimes and `str` other times)
