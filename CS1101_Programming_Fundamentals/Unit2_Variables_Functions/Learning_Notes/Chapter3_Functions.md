# CS1101 Unit 2 Learning Notes - Chapter 3: Functions

**Course**: CS1101 Programming Fundamentals  
**Author**: Nicanor Kyamba  
**Date**: February 2026

---

## Table of Contents
1. [Function Calls](#function-calls)
2. [Math Functions](#math-functions)
3. [Composition](#composition)
4. [Adding New Functions](#adding-new-functions)
5. [Definitions and Uses](#definitions-and-uses)
6. [Flow of Execution](#flow-of-execution)
7. [Parameters and Arguments](#parameters-and-arguments)
8. [Variables and Parameters are Local](#variables-and-parameters-are-local)
9. [Fruitful Functions and Void Functions](#fruitful-functions-and-void-functions)
10. [Why Functions?](#why-functions)
11. [Debugging](#debugging)

---

## Function Calls

A **function** is a named sequence of statements that performs a computation.

```python
# Built-in function call
type(42)  # <class 'int'>

# Function name: type
# Argument: 42
# Result: <class 'int'>
```

**Anatomy of a Function Call**:
- **Function name**: identifies which function to call
- **Arguments**: values passed to the function (in parentheses)
- **Return value**: result produced by the function

---

## Math Functions

Python has a `math` module with mathematical functions.

### Importing the Math Module

```python
import math

# Access functions using dot notation
print(math.sqrt(16))  # 4.0
```

### Common Math Functions

```python
import math

# Square root
math.sqrt(25)        # 5.0

# Logarithms
math.log10(100)      # 2.0 (base 10)
math.log(2.718)      # 1.0 (natural log, base e)

# Trigonometry (angles in radians)
math.sin(math.pi/2)  # 1.0
math.cos(0)          # 1.0

# Constants
math.pi              # 3.141592653589793
math.e               # 2.718281828459045

# Rounding
math.ceil(3.2)       # 4 (round up)
math.floor(3.8)      # 3 (round down)

# Power
math.pow(2, 3)       # 8.0 (same as 2 ** 3)
```

### Module Object

```python
import math

# math is a module object
print(type(math))  # <class 'module'>

# See all functions in module
print(dir(math))   # Lists all functions and constants
```

---

## Composition

**Composition** means using the result of one function as an argument to another.

```python
import math

# Simple composition
x = math.sqrt(16)
y = math.log(x)
print(y)  # 1.3862943611198906

# Nested composition (more compact)
y = math.log(math.sqrt(16))
print(y)  # 1.3862943611198906

# Complex composition
degrees = 45
radians = degrees / 180.0 * math.pi
height = math.sin(radians)
print(height)  # 0.7071067811865475
```

**Benefits**:
- More concise code
- Fewer intermediate variables
- Can be harder to read if overused

---

## Adding New Functions

### Function Definition

```python
def print_lyrics():
    """Print the lyrics of a song."""
    print("I'm a lumberjack, and I'm okay.")
    print("I sleep all night and I work all day.")

# Call the function
print_lyrics()
```

**Syntax**:
- `def` keyword starts the definition
- Function name follows naming rules (like variables)
- Empty parentheses `()` (no parameters in this example)
- Colon `:` ends the header
- Indented body contains statements
- Docstring (optional but recommended) describes the function

### Function with Multiple Statements

```python
def repeat_lyrics():
    """Print lyrics twice."""
    print_lyrics()
    print_lyrics()

repeat_lyrics()
```

**Output**:
```
I'm a lumberjack, and I'm okay.
I sleep all night and I work all day.
I'm a lumberjack, and I'm okay.
I sleep all night and I work all day.
```

---

## Definitions and Uses

### Function Definition vs Function Call

```python
# DEFINITION (creates the function)
def greet():
    print("Hello!")

# CALL (executes the function)
greet()  # Output: Hello!
```

**Key Points**:
- Definition must come before the first call
- Can define once, call many times
- Definition doesn't execute the code—just creates the function

### Example: Order Matters

```python
# This works
def say_hello():
    print("Hello")

say_hello()  # Output: Hello

# This causes NameError
say_goodbye()  # ERROR: name 'say_goodbye' is not defined

def say_goodbye():
    print("Goodbye")
```

---

## Flow of Execution

**Flow of execution** is the order in which statements execute.

```python
def main():
    print("Starting program")
    helper()
    print("Ending program")

def helper():
    print("Helper function called")

main()
```

**Execution Order**:
1. Program starts at the top
2. `main()` definition is read (not executed)
3. `helper()` definition is read (not executed)
4. `main()` is called
5. "Starting program" prints
6. `helper()` is called
7. "Helper function called" prints
8. Control returns to `main()`
9. "Ending program" prints

**Output**:
```
Starting program
Helper function called
Ending program
```

---

## Parameters and Arguments

### Parameters

**Parameters** are variables in the function definition.

```python
def print_twice(message):  # 'message' is a parameter
    print(message)
    print(message)
```

### Arguments

**Arguments** are values passed when calling the function.

```python
print_twice("Hello")  # "Hello" is an argument
```

### Multiple Parameters

```python
def calculate_area(length, width):
    """Calculate rectangle area."""
    area = length * width
    print(f"Area: {area}")

# Call with arguments
calculate_area(5, 3)  # Output: Area: 15
```

### Parameter vs Argument

```python
def greet(name):      # 'name' is PARAMETER
    print(f"Hello, {name}!")

greet("Alice")        # "Alice" is ARGUMENT
```

**Remember**:
- **Parameter**: placeholder in function definition
- **Argument**: actual value passed to function

---

## Variables and Parameters are Local

### Local Scope

Variables created inside a function are **local** to that function.

```python
def calculate_sum(a, b):
    total = a + b  # 'total' is local
    print(f"Sum: {total}")

calculate_sum(5, 3)  # Output: Sum: 8

print(total)  # ERROR: NameError: name 'total' is not defined
```

### Parameters are Local Too

```python
def double(number):
    result = number * 2
    print(result)

double(5)  # Output: 10

print(number)  # ERROR: NameError: name 'number' is not defined
```

### Global vs Local Variables

```python
# Global variable
x = 10

def modify():
    # Local variable (different from global x)
    x = 20
    print(f"Inside function: x = {x}")

modify()  # Output: Inside function: x = 20
print(f"Outside function: x = {x}")  # Output: Outside function: x = 10
```

**Key Point**: Local variables don't affect global variables with the same name.

---

## Fruitful Functions and Void Functions

### Fruitful Functions

**Fruitful functions** return a value.

```python
def calculate_area(radius):
    """Calculate circle area."""
    import math
    area = math.pi * radius ** 2
    return area  # Returns a value

# Use the returned value
result = calculate_area(5)
print(f"Area: {result}")  # Area: 78.53981633974483
```

### Void Functions

**Void functions** don't return a value (or return `None`).

```python
def print_greeting(name):
    """Print a greeting."""
    print(f"Hello, {name}!")
    # No return statement

# Function executes but returns None
result = print_greeting("Alice")  # Output: Hello, Alice!
print(result)  # Output: None
```

### Return Statement

```python
def add(a, b):
    return a + b  # Return value immediately

def subtract(a, b):
    result = a - b
    return result  # Return stored value

# Both work the same way
print(add(5, 3))       # 8
print(subtract(5, 3))  # 2
```

### Multiple Return Statements

```python
def absolute_value(x):
    """Return absolute value of x."""
    if x < 0:
        return -x
    else:
        return x

print(absolute_value(-5))  # 5
print(absolute_value(5))   # 5
```

---

## Why Functions?

### 1. Code Reusability

```python
# Without function (repetitive)
print("=" * 40)
print("Welcome to Python")
print("=" * 40)

print("=" * 40)
print("Thank you")
print("=" * 40)

# With function (reusable)
def print_banner(message):
    print("=" * 40)
    print(message)
    print("=" * 40)

print_banner("Welcome to Python")
print_banner("Thank you")
```

### 2. Abstraction

Hide complex details behind simple interface.

```python
def calculate_grade(score):
    """Convert numeric score to letter grade."""
    if score >= 90:
        return 'A'
    elif score >= 80:
        return 'B'
    elif score >= 70:
        return 'C'
    elif score >= 60:
        return 'D'
    else:
        return 'F'

# Simple to use, complex logic hidden
print(calculate_grade(85))  # B
```

### 3. Organization

Break large programs into manageable pieces.

```python
def main():
    """Main program logic."""
    display_menu()
    choice = get_user_choice()
    process_choice(choice)

def display_menu():
    """Show menu options."""
    print("1. Add")
    print("2. Subtract")
    print("3. Exit")

def get_user_choice():
    """Get user input."""
    return input("Enter choice: ")

def process_choice(choice):
    """Process user's choice."""
    if choice == '1':
        print("Adding...")
    elif choice == '2':
        print("Subtracting...")
    elif choice == '3':
        print("Goodbye!")

main()
```

### 4. Debugging

Easier to test and debug small functions.

```python
def calculate_tax(amount, rate):
    """Calculate tax on amount."""
    return amount * rate

# Easy to test
assert calculate_tax(100, 0.1) == 10
assert calculate_tax(50, 0.2) == 10
```

---

## Debugging

### Common Function Errors

#### 1. Forgetting Parentheses

```python
def greet():
    print("Hello")

# Wrong - refers to function object
print(greet)  # <function greet at 0x...>

# Correct - calls the function
greet()  # Hello
```

#### 2. Wrong Number of Arguments

```python
def add(a, b):
    return a + b

add(5)  # ERROR: missing 1 required positional argument: 'b'
add(5, 3, 2)  # ERROR: takes 2 positional arguments but 3 were given
```

#### 3. Undefined Function

```python
calculate_sum(5, 3)  # ERROR: name 'calculate_sum' is not defined

def calculate_sum(a, b):
    return a + b
```

### Debugging Strategies

1. **Use print statements**
   ```python
   def calculate_average(a, b):
       print(f"a = {a}, b = {b}")  # Debug
       result = (a + b) / 2
       print(f"result = {result}")  # Debug
       return result
   ```

2. **Test with simple inputs**
   ```python
   def complex_calculation(x):
       return x ** 2 + 2 * x + 1
   
   # Test with simple values
   print(complex_calculation(0))  # Should be 1
   print(complex_calculation(1))  # Should be 4
   ```

3. **Check function independently**
   ```python
   # Test each function separately
   def helper():
       return 42
   
   print(helper())  # Verify it works
   
   def main():
       result = helper()
       print(result)
   ```

---

## Key Takeaways

1. **Functions** encapsulate reusable code
2. **Parameters** are placeholders; **arguments** are actual values
3. **Local variables** exist only within their function
4. **Fruitful functions** return values; **void functions** don't
5. **Composition** allows combining functions
6. **Flow of execution** determines statement order
7. Functions improve **organization**, **reusability**, and **debugging**

---

## Practice Exercises

### Exercise 1: Simple Function
```python
def print_name():
    """Print my name."""
    print("Nicanor Kyamba")

print_name()
```

### Exercise 2: Function with Parameters
```python
def calculate_rectangle_area(length, width):
    """Calculate and return rectangle area."""
    return length * width

area = calculate_rectangle_area(5, 3)
print(f"Area: {area}")  # Area: 15
```

### Exercise 3: Function Composition
```python
import math

def distance(x1, y1, x2, y2):
    """Calculate distance between two points."""
    dx = x2 - x1
    dy = y2 - y1
    return math.sqrt(dx**2 + dy**2)

d = distance(0, 0, 3, 4)
print(f"Distance: {d}")  # Distance: 5.0
```

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist* (Chapter 3). Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

---

**Previous**: Chapter 2 - Variables, Expressions, and Statements  
**Next**: Chapter 4 - Case Study: Interface Design
