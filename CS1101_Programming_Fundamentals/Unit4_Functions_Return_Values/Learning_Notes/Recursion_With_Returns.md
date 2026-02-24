# Recursion with Return Values - CS1101 Unit 4

**Course**: CS1101 Programming Fundamentals  
**Topic**: Recursive Functions that Return Computed Results  
**Date**: February 2026

---

## 📚 Recursion Recap (from Unit 3)

In Unit 3, you learned void recursion — functions that call themselves to DO things:

```python
# Unit 3 style: recursion that PRINTS (void)
def countdown(n):
    if n <= 0:
        print("Blastoff!")
    else:
        print(n)
        countdown(n - 1)
```

In Unit 4, we level up to **fruitful recursion** — functions that call themselves to COMPUTE and RETURN values.

---

## 🎯 The Big Difference

| Aspect | Void Recursion (Unit 3) | Fruitful Recursion (Unit 4) |
|--------|------------------------|----------------------------|
| **Purpose** | Perform actions | Compute values |
| **Uses `return`?** | No (or `return` alone) | Yes, `return value` |
| **Recursive call** | `func(n-1)` | `return n * func(n-1)` |
| **Result** | Side effects (printing) | A computed value |
| **Example** | Countdown printer | Factorial calculator |

### Key Pattern
```python
# Void recursion: just calls itself
def void_recursive(n):
    if base_case:
        do_something()
    else:
        do_something()
        void_recursive(n - 1)    # No return

# Fruitful recursion: returns the result of the recursive call
def fruitful_recursive(n):
    if base_case:
        return base_value        # Return a value
    else:
        return combine(n, fruitful_recursive(n - 1))  # Return combined result
```

---

## 📝 Classic Examples

### 1. Factorial

$n! = n \times (n-1) \times (n-2) \times \ldots \times 1$ and $0! = 1$

```python
def factorial(n):
    if n == 0:           # Base case
        return 1
    else:                # Recursive case
        return n * factorial(n - 1)
```

**Trace for `factorial(4)`**:
```
factorial(4)
  = 4 * factorial(3)
  = 4 * (3 * factorial(2))
  = 4 * (3 * (2 * factorial(1)))
  = 4 * (3 * (2 * (1 * factorial(0))))
  = 4 * (3 * (2 * (1 * 1)))        ← base case returns 1
  = 4 * (3 * (2 * 1))
  = 4 * (3 * 2)
  = 4 * 6
  = 24
```

---

### 2. Fibonacci

$F(0) = 0, \quad F(1) = 1, \quad F(n) = F(n-1) + F(n-2)$

```python
def fibonacci(n):
    if n == 0:           # Base case 1
        return 0
    elif n == 1:         # Base case 2
        return 1
    else:                # Recursive case
        return fibonacci(n - 1) + fibonacci(n - 2)
```

**Trace for `fibonacci(5)`**:
```
fibonacci(5)
  = fibonacci(4) + fibonacci(3)
  = (fibonacci(3) + fibonacci(2)) + (fibonacci(2) + fibonacci(1))
  = ((fibonacci(2) + fibonacci(1)) + (fibonacci(1) + fibonacci(0))) + ((fibonacci(1) + fibonacci(0)) + 1)
  = (((1 + 0) + 1) + (1 + 0)) + ((1 + 0) + 1)
  = ((1 + 1) + 1) + (1 + 1)
  = (2 + 1) + 2
  = 3 + 2
  = 5
```

**Fibonacci sequence**: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55...

---

### 3. Power (Exponentiation)

$base^{exp} = base \times base^{exp-1}$ and $base^0 = 1$

```python
def power(base, exp):
    if exp == 0:          # Base case
        return 1
    else:                 # Recursive case
        return base * power(base, exp - 1)

print(power(2, 10))  # 1024
print(power(3, 4))   # 81
print(power(5, 0))   # 1
```

---

### 4. Sum of Digits

```python
def sum_digits(n):
    """Return sum of digits of a non-negative integer."""
    if n < 10:            # Base case: single digit
        return n
    else:                 # Recursive case
        return (n % 10) + sum_digits(n // 10)

print(sum_digits(1234))  # 10 (1+2+3+4)
print(sum_digits(999))   # 27 (9+9+9)
```

**Trace for `sum_digits(1234)`**:
```
sum_digits(1234)
  = 4 + sum_digits(123)       # 1234 % 10 = 4, 1234 // 10 = 123
  = 4 + (3 + sum_digits(12))  # 123 % 10 = 3, 123 // 10 = 12
  = 4 + (3 + (2 + sum_digits(1)))  # 12 % 10 = 2, 12 // 10 = 1
  = 4 + (3 + (2 + 1))         # Base case: 1 < 10, return 1
  = 4 + (3 + 3)
  = 4 + 6
  = 10
```

---

### 5. Counting Occurrences

```python
def count_char(s, target):
    """Count occurrences of target character in string s."""
    if s == "":           # Base case: empty string
        return 0
    elif s[0] == target:  # First char matches
        return 1 + count_char(s[1:], target)
    else:                 # First char doesn't match
        return count_char(s[1:], target)

print(count_char("mississippi", "s"))  # 4
print(count_char("hello", "l"))        # 2
```

---

## 🧠 The Leap of Faith

### What is It?
The **leap of faith** is a mental strategy for writing recursive functions without tracing every call. You simply:

1. **Trust** that the recursive call correctly handles the smaller problem
2. **Focus** on combining that result to solve the current problem
3. **Verify** only the base case

### Applying the Leap of Faith

**Writing `factorial(n)`**:
1. Base case: `factorial(0) = 1` ← I can verify this directly ✅
2. Recursive case: IF `factorial(n-1)` correctly returns `(n-1)!`, THEN `n * factorial(n-1)` correctly returns `n!` ✅
3. Done! No need to trace through every call.

**Writing `fibonacci(n)`**:
1. Base cases: `fibonacci(0) = 0`, `fibonacci(1) = 1` ← Verified ✅
2. IF `fibonacci(n-1)` and `fibonacci(n-2)` return correct values, THEN their sum is correct ✅
3. Done!

### Why It Works
Recursion is like mathematical induction:
- **Base case** = base case in induction
- **Recursive case** = inductive step
- If the base case works AND each step correctly builds on the previous, the whole thing works

---

## ⚠️ Common Mistakes

### 1. Forgetting to Return the Recursive Call
```python
# ❌ BUG: Doesn't return the recursive result
def factorial(n):
    if n == 0:
        return 1
    else:
        factorial(n - 1)  # Calls but DISCARDS the result!

print(factorial(5))  # None!

# ✅ FIX
def factorial(n):
    if n == 0:
        return 1
    else:
        return n * factorial(n - 1)  # RETURN the result
```

### 2. Wrong Base Case
```python
# ❌ BUG: Base case is wrong
def factorial(n):
    if n == 1:
        return 1
    return n * factorial(n - 1)

factorial(0)  # RecursionError! 0 never equals 1

# ✅ FIX
def factorial(n):
    if n == 0:  # Correct base case
        return 1
    return n * factorial(n - 1)
```

### 3. Not Making Progress Toward Base Case
```python
# ❌ BUG: n never changes!
def countdown(n):
    if n == 0:
        return "Done"
    return countdown(n)  # Same n forever → infinite recursion

# ✅ FIX
def countdown(n):
    if n == 0:
        return "Done"
    return countdown(n - 1)  # n decreases each call
```

---

## 📊 The Recursion Template

```python
def recursive_function(parameter):
    # BASE CASE: the simplest version that doesn't need recursion
    if base_condition:
        return base_value
    
    # RECURSIVE CASE: break down, recurse, combine
    else:
        smaller_result = recursive_function(smaller_parameter)
        return combine(parameter, smaller_result)
```

### Checklist for Every Recursive Function
- [ ] **Base case defined?** — When does recursion stop?
- [ ] **Base case returns a value?** — What value for the simplest case?
- [ ] **Recursive call uses `return`?** — Don't discard the result!
- [ ] **Progress toward base case?** — Parameter gets smaller each call?
- [ ] **Combination is correct?** — How does current step use the recursive result?

---

## 💡 Pro Tips

1. **Always start with the base case** — it's the foundation
2. **Use the leap of faith** — don't trace every call mentally
3. **Test with small inputs first** — `factorial(0)`, `factorial(1)`, `factorial(2)`
4. **Draw the call stack** — helps visualize the recursion flow
5. **Remember `return`** — the #1 bug is forgetting to return the recursive result
6. **Think mathematically** — recursive definitions often mirror math formulas
