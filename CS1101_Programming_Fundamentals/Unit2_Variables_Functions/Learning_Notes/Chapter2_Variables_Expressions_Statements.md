# CS1101 Unit 2 Learning Notes - Chapter 2: Variables, Expressions, and Statements

**Course**: CS1101 Programming Fundamentals  
**Author**: Nicanor Kyamba  
**Date**: February 2026

---

## Table of Contents
1. [Assignment Statements](#assignment-statements)
2. [Variable Names](#variable-names)
3. [Expressions and Statements](#expressions-and-statements)
4. [Script Mode and Interactive Mode](#script-mode-and-interactive-mode)
5. [Order of Operations](#order-of-operations)
6. [String Operations](#string-operations)
7. [Comments](#comments)
8. [Debugging](#debugging)

---

## Assignment Statements

An **assignment statement** creates a new variable and gives it a value.

```python
message = 'Hello, World!'
n = 17
pi = 3.14159
```

**Key Points**:
- Uses the `=` operator (assignment operator)
- Variable name on the left, value on the right
- Creates the variable if it doesn't exist
- Updates the value if variable already exists

**Type Function**:
```python
type(message)  # <class 'str'>
type(n)        # <class 'int'>
type(pi)       # <class 'float'>
```

---

## Variable Names

### Rules for Variable Names

**Legal Names**:
- Can contain letters, numbers, and underscores
- Must start with a letter or underscore
- Case-sensitive (`name` ≠ `Name`)

```python
# Valid variable names
student_name = "Alice"
age2 = 25
_private = 100
```

**Illegal Names**:
```python
# These will cause SyntaxError
76trombones = 'big parade'  # Can't start with number
more@ = 1000000             # Can't contain @
class = 'Advanced Placement'  # Can't use keywords
```

### Python Keywords (Reserved Words)

Cannot be used as variable names:
```
False      await      else       import     pass
None       break      except     in         raise
True       class      finally    is         return
and        continue   for        lambda     try
as         def        from       nonlocal   while
assert     del        global     not        with
async      elif       if         or         yield
```

### Naming Conventions

**Good Practice**:
```python
# Descriptive names
student_count = 30
total_price = 99.99
is_valid = True

# Use underscores for multi-word names (snake_case)
first_name = "John"
last_name = "Doe"
```

**Bad Practice**:
```python
# Unclear names
x = 30
tp = 99.99
flag = True
```

---

## Expressions and Statements

### Expressions

An **expression** is a combination of values, variables, and operators that produces a value.

```python
# Simple expressions
17
x
x + 17

# Complex expressions
(5 + 3) * 2 - 1
```

### Statements

A **statement** is a unit of code that has an effect (like creating a variable or displaying a value).

```python
# Assignment statement
n = 17

# Print statement
print(n)
```

**Key Difference**:
- Expression: produces a value
- Statement: performs an action

---

## Script Mode and Interactive Mode

### Interactive Mode

```python
>>> miles = 26.2
>>> miles * 1.61
42.182
```
- Expressions are evaluated and displayed immediately
- Good for testing and exploration

### Script Mode

```python
# script.py
miles = 26.2
miles * 1.61  # Result is calculated but not displayed
```
- Expressions are evaluated but not displayed
- Must use `print()` to see results
- Good for writing programs

```python
# script.py with print
miles = 26.2
print(miles * 1.61)  # Output: 42.182
```

---

## Order of Operations

Python follows **PEMDAS** (Parentheses, Exponentiation, Multiplication/Division, Addition/Subtraction):

1. **P**arentheses: `()`
2. **E**xponentiation: `**`
3. **M**ultiplication/Division: `*`, `/`, `//`, `%` (left to right)
4. **A**ddition/Subtraction: `+`, `-` (left to right)

### Examples

```python
# Without parentheses
2 + 3 * 4        # Result: 14 (not 20)
# Calculation: 3 * 4 = 12, then 2 + 12 = 14

# With parentheses
(2 + 3) * 4      # Result: 20
# Calculation: 2 + 3 = 5, then 5 * 4 = 20

# Exponentiation
2 ** 3 ** 2      # Result: 512 (not 64)
# Right to left: 3 ** 2 = 9, then 2 ** 9 = 512

(2 ** 3) ** 2    # Result: 64
# Left to right: 2 ** 3 = 8, then 8 ** 2 = 64
```

### Operators

| Operator | Operation | Example | Result |
|----------|-----------|---------|--------|
| `+` | Addition | `5 + 3` | `8` |
| `-` | Subtraction | `5 - 3` | `2` |
| `*` | Multiplication | `5 * 3` | `15` |
| `/` | Division (float) | `5 / 3` | `1.6666...` |
| `//` | Floor division | `5 // 3` | `1` |
| `%` | Modulus (remainder) | `5 % 3` | `2` |
| `**` | Exponentiation | `5 ** 3` | `125` |

---

## String Operations

### Concatenation

```python
first = 'Hello'
second = 'World'
result = first + ' ' + second  # 'Hello World'
```

### Repetition

```python
'Spam' * 3  # 'SpamSpamSpam'
'=' * 40    # '========================================'
```

### Cannot Mix Types

```python
# This causes TypeError
message = 'The answer is ' + 42  # ERROR

# Solution 1: Convert to string
message = 'The answer is ' + str(42)  # 'The answer is 42'

# Solution 2: Use f-strings (Python 3.6+)
message = f'The answer is {42}'  # 'The answer is 42'
```

---

## Comments

Comments are notes for humans, ignored by Python.

```python
# Single-line comment
x = 5  # Inline comment

# Multi-line comments use multiple # symbols
# This is line 1 of the comment
# This is line 2 of the comment
# This is line 3 of the comment

"""
Multi-line string (can be used as comment)
But technically this is a string literal
"""
```

**Best Practices**:
- Explain WHY, not WHAT
- Keep comments up-to-date
- Don't over-comment obvious code

```python
# Bad comment (obvious)
x = 5  # Assign 5 to x

# Good comment (explains purpose)
x = 5  # Number of retries before timeout
```

---

## Debugging

### Common Errors

#### 1. Syntax Errors

```python
# Missing colon
if x > 5
    print(x)  # SyntaxError

# Misspelled keyword
whlie x > 0:  # SyntaxError (should be 'while')
    x -= 1
```

#### 2. Runtime Errors

```python
# Division by zero
x = 5 / 0  # ZeroDivisionError

# Undefined variable
print(y)  # NameError: name 'y' is not defined
```

#### 3. Semantic Errors

```python
# Logic error - program runs but gives wrong result
# Calculate average of two numbers
a = 10
b = 20
average = a + b / 2  # Wrong! Should be (a + b) / 2
# Result: 20.0 (incorrect)
# Correct: 15.0
```

### Debugging Strategies

1. **Read error messages carefully**
   - Line number
   - Error type
   - Error description

2. **Use print statements**
   ```python
   x = 5
   y = 10
   print(f"x = {x}, y = {y}")  # Check variable values
   result = x + y
   print(f"result = {result}")
   ```

3. **Check one thing at a time**
   - Isolate the problem
   - Test small pieces of code

4. **Take breaks**
   - Fresh eyes catch errors faster

---

## Key Takeaways

1. **Variables** store values and have names following specific rules
2. **Expressions** produce values; **statements** perform actions
3. **Order of operations** follows PEMDAS
4. **Type matters** - can't mix strings and numbers without conversion
5. **Comments** explain code for humans
6. **Debugging** is a systematic process of finding and fixing errors

---

## Practice Exercises

### Exercise 1: Variable Assignment
```python
# Assign values to variables
width = 17
height = 12.0
delimiter = '.'

# What are the types?
print(type(width))     # <class 'int'>
print(type(height))    # <class 'float'>
print(type(delimiter)) # <class 'str'>
```

### Exercise 2: Order of Operations
```python
# Predict the results
print(5 + 3 * 2)      # 11
print((5 + 3) * 2)    # 16
print(5 ** 2 * 3)     # 75
print(5 * 2 ** 3)     # 40
```

### Exercise 3: String Operations
```python
# Create a separator line
print('=' * 50)

# Build a message
name = "Alice"
age = 25
message = name + " is " + str(age) + " years old"
print(message)  # Alice is 25 years old
```

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist* (Chapter 2). Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

---

**Next**: Chapter 3 - Functions
