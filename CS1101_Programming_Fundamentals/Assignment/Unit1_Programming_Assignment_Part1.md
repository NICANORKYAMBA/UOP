# Unit 1 Programming Assignment - Part 1: Learning from Mistakes

## Student Information
- **Name**: Nicanor Kyamba
- **Course**: CS1101 Programming Fundamentals
- **Unit**: 1 - Introduction and Fundamental Concepts
- **Date**: January 2025

---

## Part 1: Understanding Common Programming Errors

This section explores frequently occurring errors in Python programming by intentionally making mistakes and analyzing the results. As suggested in Chapter 1, Section 1.9 of "Think Python," experimenting with errors helps understand error messages and remember programming concepts.

---

### Question (a): Missing Quotation Marks

**Task**: Print your name with missing quotation marks

#### Experiment 1: Missing One Quotation Mark

**Code**:
```python
print("Nicanor Kyamba)
```

**Output**:
```
  File "<stdin>", line 1
    print("Nicanor Kyamba)
          ^
SyntaxError: unterminated string literal (detected at line 1)
```

**Technical Explanation**:
When one quotation mark is missing, Python raises a **SyntaxError: unterminated string literal**. This occurs because Python expects strings to be enclosed in matching quotation marks (either both single `'` or both double `"`). When the opening quote is present but the closing quote is missing, Python continues looking for the closing quote until the end of the line. Since it doesn't find a matching quote, it cannot determine where the string ends, resulting in a syntax error. The error message "unterminated string literal" clearly indicates that a string was started but not properly closed. The caret (^) symbol points to where Python detected the problem.

---

#### Experiment 2: Missing Both Quotation Marks

**Code**:
```python
print(Nicanor Kyamba)
```

**Output**:
```
  File "<stdin>", line 1
    print(Nicanor Kyamba)
                  ^^^^^^
SyntaxError: invalid syntax
```

**Technical Explanation**:
When both quotation marks are missing, Python raises a **SyntaxError: invalid syntax**. Without quotes, Python interprets `Nicanor` and `Kyamba` as variable names rather than string literals. Since variable names in Python cannot contain spaces, the space between `Nicanor` and `Kyamba` creates invalid syntax. Python expects either a comma (for multiple arguments), an operator, or the closing parenthesis after `Nicanor`, but instead finds a space and another identifier. This demonstrates that strings must be explicitly marked with quotation marks to distinguish them from variable names and keywords.

---

#### Correct Code:
```python
print("Nicanor Kyamba")
```

**Output**:
```
Nicanor Kyamba
```

---

### Question (b): Difference Between * and ** Operators

**Task**: Explain the difference between `*` and `**` operators with examples

#### Operator 1: * (Multiplication)

**Code**:
```python
# Multiplication operator
result1 = 5 * 3
print("5 * 3 =", result1)

# String repetition
result2 = "Python" * 3
print("'Python' * 3 =", result2)
```

**Output**:
```
5 * 3 = 15
'Python' * 3 = PythonPythonPython
```

**Technical Explanation**:
The `*` operator performs **multiplication** when used with numbers. In the example, `5 * 3` multiplies 5 by 3, resulting in 15. However, the `*` operator is **overloaded** in Python, meaning it behaves differently depending on the data types of its operands. When used with a string and an integer, it performs **string repetition**. The expression `"Python" * 3` repeats the string "Python" three times, concatenating them into "PythonPythonPython". This demonstrates Python's flexibility and operator overloading capabilities.

---

#### Operator 2: ** (Exponentiation)

**Code**:
```python
# Exponentiation operator
result3 = 5 ** 3
print("5 ** 3 =", result3)

# Square root using fractional exponent
result4 = 16 ** 0.5
print("16 ** 0.5 =", result4)

# Negative exponent (reciprocal)
result5 = 2 ** -3
print("2 ** -3 =", result5)
```

**Output**:
```
5 ** 3 = 125
16 ** 0.5 = 4.0
2 ** -3 = 0.125
```

**Technical Explanation**:
The `**` operator performs **exponentiation** (raising to a power). In the expression `5 ** 3`, it calculates 5³ = 5 × 5 × 5 = 125. The `**` operator is more versatile than simple multiplication:
- It can handle **fractional exponents**: `16 ** 0.5` calculates the square root of 16, which equals 4.0
- It supports **negative exponents**: `2 ** -3` calculates 2⁻³ = 1/(2³) = 1/8 = 0.125

This operator is essential for mathematical calculations involving powers, roots, and exponential growth/decay.

---

#### Summary Comparison:

| Operator | Name | Example | Result | Use Case |
|----------|------|---------|--------|----------|
| `*` | Multiplication | `5 * 3` | `15` | Multiply numbers |
| `*` | Repetition | `"Hi" * 3` | `"HiHiHi"` | Repeat strings |
| `**` | Exponentiation | `5 ** 3` | `125` | Raise to power |
| `**` | Root | `16 ** 0.5` | `4.0` | Calculate roots |

---

### Question (c): Displaying Integer with Leading Zero

**Task**: Determine if it's possible to display an integer like 09 in Python

#### Experiment: Leading Zero

**Code**:
```python
print(09)
```

**Output**:
```
  File "<stdin>", line 1
    print(09)
          ^^
SyntaxError: leading zeros in decimal integer literals are not permitted; use an 0o prefix for octal integers
```

**Technical Explanation**:
**No, it is not possible** to display an integer like `09` directly in Python 3. The code raises a **SyntaxError** because Python 3 does not allow leading zeros in decimal integer literals. This restriction was introduced to prevent confusion with octal (base-8) numbers. In Python 2, a leading zero indicated an octal number (e.g., `010` meant octal 10 = decimal 8), which was a common source of bugs when programmers accidentally added leading zeros.

Python 3 requires explicit prefixes for non-decimal number systems:
- **Octal**: `0o` prefix (e.g., `0o9` for octal 9 = decimal 9)
- **Hexadecimal**: `0x` prefix (e.g., `0x9` for hex 9 = decimal 9)
- **Binary**: `0b` prefix (e.g., `0b1001` for binary 1001 = decimal 9)

---

#### Correct Alternatives:

**Option 1: Remove leading zero**
```python
print(9)
```
**Output**: `9`

**Option 2: Use string for display purposes**
```python
print("09")
```
**Output**: `09`

**Option 3: Format as string with leading zero**
```python
number = 9
print(f"{number:02d}")  # Format with 2 digits, zero-padded
```
**Output**: `09`

**Justification**: If the goal is to display a number with a leading zero (e.g., for formatting dates, times, or IDs), the best approach is to use string formatting. The integer value should be stored without the leading zero, and formatting should be applied only when displaying.

---

### Question (d): Difference Between type('67') and type(67)

**Task**: Run type('67') and type(67) and explain the difference

#### Experiment 1: type('67')

**Code**:
```python
result1 = type('67')
print("type('67') =", result1)
```

**Output**:
```
type('67') = <class 'str'>
```

---

#### Experiment 2: type(67)

**Code**:
```python
result2 = type(67)
print("type(67) =", result2)
```

**Output**:
```
type(67) = <class 'int'>
```

---

#### Technical Explanation:

The difference in output is due to the **data types** of the arguments:

**type('67')** returns `<class 'str'>` because `'67'` is a **string literal**. The quotation marks indicate that this is text data, not a number. Even though the string contains numeric characters, Python treats it as a sequence of characters. You cannot perform mathematical operations directly on strings (e.g., `'67' + 1` would cause a TypeError).

**type(67)** returns `<class 'int'>` because `67` is an **integer literal**. Without quotation marks, Python interprets this as a numeric value. Integers can be used in mathematical operations (e.g., `67 + 1 = 68`).

**Key Differences**:

| Aspect | '67' (String) | 67 (Integer) |
|--------|---------------|--------------|
| **Type** | str | int |
| **Quotation marks** | Required | Not allowed |
| **Math operations** | Not directly possible | Fully supported |
| **Concatenation** | Can concatenate with strings | Must convert first |
| **Storage** | Sequence of characters | Numeric value |

**Practical Example**:
```python
# String '67'
print('67' + '33')  # Output: '6733' (concatenation)

# Integer 67
print(67 + 33)      # Output: 100 (addition)

# Type conversion
print(int('67') + 33)  # Output: 100 (convert string to int first)
```

This demonstrates the importance of understanding data types in Python. The same sequence of digits can represent different things depending on whether it's enclosed in quotation marks.

---

## Summary of Learning Outcomes

Through these experiments, I learned:

1. **Syntax errors** are caught before program execution and provide helpful error messages
2. **Quotation marks** are essential for string literals and must be properly matched
3. **Operators** can be overloaded (`*` for multiplication and repetition)
4. **Exponentiation** (`**`) is more powerful than multiplication, supporting powers, roots, and negative exponents
5. **Leading zeros** are not allowed in Python 3 decimal integers to prevent confusion
6. **Data types** fundamentally change how Python interprets and processes values
7. **Error messages** in Python 3 are informative and guide toward solutions

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist* (2nd ed.). Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

Python Software Foundation. (2024). *Built-in types*. Python Documentation. https://docs.python.org/3/library/stdtypes.html

---

**Word Count (Part 1)**: 1,245 words (excluding code blocks and tables)

---

**Continue to Part 2** →
