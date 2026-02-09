# Unit 1 Learning Notes - Introduction and Fundamental Concepts

## Course Information
- **Course**: CS1101 Programming Fundamentals
- **Unit**: 1 - Introduction and Fundamental Concepts
- **Topics**: Programming basics, debugging, errors, formal vs natural languages
- **Author**: Nicanor Kyamba
- **Date**: January 2026

---

## Table of Contents
1. [Fundamental Programming Concepts](#fundamental-programming-concepts)
2. [High-Level vs Low-Level Languages](#high-level-vs-low-level-languages)
3. [Formal vs Natural Languages](#formal-vs-natural-languages)
4. [Debugging Basics](#debugging-basics)
5. [Python Basics](#python-basics)

---

## Fundamental Programming Concepts

### What is a Program?

A **program** is a sequence of instructions that specifies how to perform a computation.

**Basic Instructions**:
- **Input**: Get data from keyboard, file, network, or sensor
- **Output**: Display data on screen, save to file, send over network
- **Math**: Perform basic mathematical operations
- **Conditional Execution**: Check conditions and run appropriate code
- **Repetition**: Perform actions repeatedly (loops)

### Problem-Solving Process

1. **Understand the problem**: What are inputs and outputs?
2. **Design solution**: Break into smaller steps
3. **Write code**: Translate solution to programming language
4. **Test**: Run program with different inputs
5. **Debug**: Fix errors and improve

---

## High-Level vs Low-Level Languages

### Low-Level Languages

**Machine Language**:
- Binary code (0s and 1s)
- Directly executed by CPU
- Fast but difficult to write
- Example: `10110000 01100001`

**Assembly Language**:
- Uses mnemonics (ADD, MOV, JMP)
- One-to-one correspondence with machine code
- Requires assembler to convert to machine code
- Example: `MOV AL, 61h`

**Characteristics**:
- ✅ Fast execution
- ✅ Direct hardware control
- ❌ Difficult to write and read
- ❌ Not portable (CPU-specific)

---

### High-Level Languages

**Examples**: Python, Java, C++, JavaScript

**Characteristics**:
- ✅ Easy to read and write
- ✅ Portable (works on different systems)
- ✅ Closer to human language
- ❌ Slower than low-level (requires translation)

**Translation Methods**:

**Interpreter** (Python, JavaScript):
- Executes code line by line
- No separate compilation step
- Easier debugging
- Slower execution

**Compiler** (C, C++, Java):
- Translates entire program at once
- Creates executable file
- Faster execution
- Harder to debug

---

### Language Comparison

| Feature | Low-Level | High-Level |
|---------|-----------|------------|
| **Readability** | Difficult | Easy |
| **Portability** | CPU-specific | Cross-platform |
| **Speed** | Very fast | Slower |
| **Development** | Time-consuming | Quick |
| **Example** | Assembly | Python |

---

## Formal vs Natural Languages

### Natural Languages

**Definition**: Languages people speak (English, Spanish, Chinese)

**Characteristics**:
- **Ambiguous**: Words have multiple meanings
- **Redundant**: Same idea expressed many ways
- **Idiomatic**: Phrases with non-literal meanings
- **Evolving**: Changes over time

**Example**: "I saw her duck"
- Did I see her lower her head?
- Did I see her pet duck?

---

### Formal Languages

**Definition**: Languages designed for specific purposes (math, chemistry, programming)

**Characteristics**:
- **Unambiguous**: One meaning per statement
- **Precise**: Exact syntax rules
- **Literal**: No idioms or metaphors
- **Strict**: Small errors break everything

**Examples**:
- **Mathematics**: 3 + 4 = 7
- **Chemistry**: H₂O
- **Programming**: `print("Hello")`

---

### Programming Languages as Formal Languages

**Syntax Rules**:
- **Tokens**: Basic elements (keywords, operators, identifiers)
- **Structure**: How tokens combine
- **Semantics**: Meaning of statements

**Example in Python**:
```python
print("Hello")  # Correct syntax
prin("Hello")   # Syntax error - wrong token
print "Hello"   # Syntax error - missing parentheses (Python 3)
```

---

### Key Differences

| Aspect | Natural Language | Formal Language |
|--------|------------------|-----------------|
| **Ambiguity** | Common | Not allowed |
| **Redundancy** | High | Minimal |
| **Literalness** | Metaphorical | Literal |
| **Flexibility** | Very flexible | Strict rules |
| **Learning** | Natural | Requires study |

---

## Debugging Basics

### What is Debugging?

**Debugging** is the process of finding and fixing errors (bugs) in programs.

**Origin**: Term coined when actual moth found in computer (1947)

---

### Types of Errors

#### 1. Syntax Errors

**Definition**: Violations of language grammar rules

**Characteristics**:
- Detected before program runs
- Prevents program execution
- Easy to identify (error messages)

**Examples**:
```python
# Missing quotation mark
print("Hello)  # SyntaxError

# Missing parenthesis
print "Hello"  # SyntaxError in Python 3

# Invalid syntax
if x = 5:  # SyntaxError (should be ==)
```

---

#### 2. Runtime Errors (Exceptions)

**Definition**: Errors that occur during program execution

**Characteristics**:
- Program starts but crashes
- Caused by invalid operations
- Can be caught and handled

**Examples**:
```python
# Division by zero
x = 5 / 0  # ZeroDivisionError

# Invalid type conversion
int("hello")  # ValueError

# Undefined variable
print(y)  # NameError (y not defined)
```

---

#### 3. Semantic Errors (Logic Errors)

**Definition**: Program runs but produces wrong results

**Characteristics**:
- Hardest to find
- No error messages
- Program does what you told it, not what you meant

**Examples**:
```python
# Wrong operator
average = (a + b) * 2  # Should be / 2

# Wrong variable
total = x + x  # Should be x + y

# Off-by-one error
for i in range(10):  # Loops 0-9, not 1-10
```

---

### Debugging Strategies

1. **Read error messages carefully**: They tell you what and where
2. **Print statements**: Display variable values
3. **Simplify**: Test small parts separately
4. **Check assumptions**: Verify what you think is true
5. **Take breaks**: Fresh eyes find bugs faster
6. **Explain to someone**: Rubber duck debugging

---

## Python Basics

### Running Python

**Interactive Mode** (Python Shell):
```python
>>> 2 + 2
4
>>> print("Hello")
Hello
```

**Script Mode** (Save as .py file):
```python
# hello.py
print("Hello, World!")
```

Run: `python hello.py`

---

### Basic Operations

#### Arithmetic Operators

```python
>>> 5 + 3      # Addition: 8
>>> 5 - 3      # Subtraction: 2
>>> 5 * 3      # Multiplication: 15
>>> 5 / 3      # Division: 1.6666...
>>> 5 // 3     # Floor division: 1
>>> 5 % 3      # Modulus (remainder): 2
>>> 5 ** 3     # Exponentiation: 125
```

---

#### Python 2 vs Python 3 Differences

**Division**:
```python
# Python 2
>>> 1/2
0  # Integer division

# Python 3
>>> 1/2
0.5  # True division
```

**Print Statement**:
```python
# Python 2
>>> print "Hello"
Hello

# Python 3
>>> print("Hello")  # Function call required
Hello
```

**Leading Zeros**:
```python
# Python 2
>>> 01
1  # Octal number

# Python 3
>>> 01
SyntaxError  # Invalid syntax
>>> 0o1  # Octal prefix required
1
```

---

### Data Types

```python
>>> type(2)
<class 'int'>  # Integer

>>> type(2.0)
<class 'float'>  # Floating-point

>>> type('Hello')
<class 'str'>  # String

>>> type("Hello")
<class 'str'>  # String (double quotes)
```

---

### Print Function

```python
# Single value
print("Hello")

# Multiple values
print("Hello", "World")  # Output: Hello World

# Variables
name = "Alice"
print("Hello", name)  # Output: Hello Alice

# Formatted string
age = 25
print(f"I am {age} years old")  # Output: I am 25 years old
```

---

## Key Takeaways

1. **Programs** are sequences of instructions for computations
2. **High-level languages** (Python) are easier than low-level (Assembly)
3. **Formal languages** (programming) are unambiguous, unlike natural languages
4. **Three error types**: Syntax, Runtime, Semantic
5. **Debugging** is essential skill - learn from mistakes
6. **Python 3** has important differences from Python 2

---

## Study Tips

1. **Practice in Python shell**: Experiment with code
2. **Make mistakes intentionally**: Learn from error messages
3. **Read error messages**: They guide you to problems
4. **Type code yourself**: Don't just copy-paste
5. **Test frequently**: Run code often to catch errors early

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist*. Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

---

**Next**: Unit 2 - Variables, Expressions, Statements, and Functions
