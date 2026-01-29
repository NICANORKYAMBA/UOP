# Chapter 1 Exercises - Think Python

## Student Information
- **Name**: Nicanor Kyamba
- **Course**: CS1101 Programming Fundamentals
- **Chapter**: 1 - The Way of the Program
- **Date**: January 2025

---

## Exercise 1.1: Experimenting with Errors

### Question 1: Missing Parentheses in Print Statement

**Experiment 1a: Missing one parenthesis**
```python
>>> print('Hello, World!'
  File "<stdin>", line 1
    print('Hello, World!'
                        ^
SyntaxError: '(' was never closed
```

**Explanation**: Python expects a closing parenthesis to match the opening one. The error message clearly indicates that the opening parenthesis was never closed.

**Experiment 1b: Missing both parentheses**
```python
>>> print 'Hello, World!'
  File "<stdin>", line 1
    print 'Hello, World!'
    ^^^^^^^^^^^^^^^^^^^^^
SyntaxError: Missing parentheses in call to 'print'. Did you mean print(...)?
```

**Explanation**: In Python 3, `print` is a function and requires parentheses. Python helpfully suggests the correct syntax.

---

### Question 2: Missing Quotation Marks

**Experiment 2a: Missing one quotation mark**
```python
>>> print('Hello, World!)
  File "<stdin>", line 1
    print('Hello, World!)
          ^
SyntaxError: unterminated string literal (detected at line 1)
```

**Explanation**: String must have matching quotes. Python can't find the closing quote.

**Experiment 2b: Missing both quotation marks**
```python
>>> print(Hello, World!)
  File "<stdin>", line 1
    print(Hello, World!)
                ^^^^^^
SyntaxError: invalid syntax
```

**Explanation**: Without quotes, Python treats `Hello` and `World!` as variable names. The space and exclamation mark create invalid syntax.

---

### Question 3: Plus Sign Before Number

**Experiment 3a: Plus sign before number**
```python
>>> +2
2
```

**Explanation**: The unary plus operator is valid in Python. It returns the positive value of the number (which is the same as the number itself).

**Experiment 3b: Expression 2++2**
```python
>>> 2++2
4
```

**Explanation**: This works! Python interprets `++` as two unary plus operators. So `2++2` means `2 + (+2)` which equals `4`. However, this is confusing and should be avoided. Use `2 + 2` instead.

**Experiment 3c: Expression 2+-2**
```python
>>> 2+-2
0
```

**Explanation**: This is `2 + (-2)` which equals `0`. The minus sign creates a negative number.

---

### Question 4: Leading Zeros

**Experiment 4a: Number with leading zero**
```python
>>> 02
  File "<stdin>", line 1
    02
    ^
SyntaxError: leading zeros in decimal integer literals are not permitted; use an 0o prefix for octal integers
```

**Explanation**: Python 3 doesn't allow leading zeros in decimal numbers. In Python 2, `02` would be interpreted as octal (base-8). Python 3 requires explicit `0o` prefix for octal numbers.

**Experiment 4b: Correct octal syntax**
```python
>>> 0o2
2
>>> 0o10
8
```

**Explanation**: `0o10` in octal equals 8 in decimal (1×8 + 0×1 = 8).

---

### Question 5: Two Values with No Operator

**Experiment 5a: Two numbers**
```python
>>> 2 2
  File "<stdin>", line 1
    2 2
      ^
SyntaxError: invalid syntax
```

**Explanation**: Python expects an operator between values. Just having a space doesn't work.

**Experiment 5b: Two strings**
```python
>>> 'Hello' 'World'
'HelloWorld'
```

**Explanation**: Surprise! Python automatically concatenates adjacent string literals. This is called **string literal concatenation** and only works with literal strings (not variables).

**Experiment 5c: String and number**
```python
>>> 'Hello' 2
  File "<stdin>", line 1
    'Hello' 2
            ^
SyntaxError: invalid syntax
```

**Explanation**: String literal concatenation only works with strings, not mixed types.

---

## Exercise 1.2: Python as Calculator

### Question 1: Seconds in 42 Minutes 42 Seconds

**Code**:
```python
# Convert 42 minutes 42 seconds to total seconds
minutes = 42
seconds = 42
total_seconds = (minutes * 60) + seconds
print(f"42 minutes 42 seconds = {total_seconds} seconds")
```

**Output**:
```
42 minutes 42 seconds = 2562 seconds
```

**Calculation**:
- 42 minutes = 42 × 60 = 2,520 seconds
- Plus 42 seconds = 2,520 + 42 = 2,562 seconds

---

### Question 2: Miles in 10 Kilometers

**Code**:
```python
# Convert 10 kilometers to miles
# 1 mile = 1.61 kilometers
# Therefore: 1 kilometer = 1/1.61 miles

kilometers = 10
km_per_mile = 1.61
miles = kilometers / km_per_mile
print(f"{kilometers} kilometers = {miles:.2f} miles")
```

**Output**:
```
10 kilometers = 6.21 miles
```

**Calculation**:
- 10 km ÷ 1.61 km/mile = 6.21 miles

---

### Question 3: Race Pace and Speed

**Part A: Average Pace (Time per Mile)**

**Code**:
```python
# 10 km race in 42 minutes 42 seconds
# Calculate average pace (time per mile)

# Convert race time to seconds
race_time_seconds = (42 * 60) + 42  # 2562 seconds

# Convert distance to miles
distance_km = 10
distance_miles = distance_km / 1.61  # 6.21 miles

# Calculate seconds per mile
seconds_per_mile = race_time_seconds / distance_miles

# Convert to minutes and seconds
pace_minutes = int(seconds_per_mile // 60)
pace_seconds = int(seconds_per_mile % 60)

print(f"Average pace: {pace_minutes} minutes {pace_seconds} seconds per mile")
print(f"Average pace: {pace_minutes}:{pace_seconds:02d} per mile")
```

**Output**:
```
Average pace: 6 minutes 52 seconds per mile
Average pace: 6:52 per mile
```

**Calculation**:
- Total time: 2,562 seconds
- Distance: 6.21 miles
- Pace: 2,562 ÷ 6.21 = 412.56 seconds per mile
- Convert: 412 seconds = 6 minutes 52 seconds

---

**Part B: Average Speed (Miles per Hour)**

**Code**:
```python
# Calculate average speed in miles per hour

# Convert race time to hours
race_time_hours = race_time_seconds / 3600  # 0.7117 hours

# Calculate speed (distance / time)
speed_mph = distance_miles / race_time_hours

print(f"Average speed: {speed_mph:.2f} miles per hour")
```

**Output**:
```
Average speed: 8.73 miles per hour
```

**Calculation**:
- Time: 2,562 seconds = 0.7117 hours
- Distance: 6.21 miles
- Speed: 6.21 ÷ 0.7117 = 8.73 mph

---

**Complete Solution (All in One)**:

```python
# 10 km race in 42 minutes 42 seconds
# Calculate pace and speed

# Race data
race_minutes = 42
race_seconds = 42
distance_km = 10

# Convert to base units
race_time_seconds = (race_minutes * 60) + race_seconds
distance_miles = distance_km / 1.61

# Calculate pace (time per mile)
seconds_per_mile = race_time_seconds / distance_miles
pace_minutes = int(seconds_per_mile // 60)
pace_seconds = int(seconds_per_mile % 60)

# Calculate speed (miles per hour)
race_time_hours = race_time_seconds / 3600
speed_mph = distance_miles / race_time_hours

# Display results
print("=" * 50)
print("10 KM RACE ANALYSIS")
print("=" * 50)
print(f"Race time: {race_minutes} minutes {race_seconds} seconds")
print(f"Distance: {distance_km} km ({distance_miles:.2f} miles)")
print(f"Average pace: {pace_minutes}:{pace_seconds:02d} per mile")
print(f"Average speed: {speed_mph:.2f} mph")
print("=" * 50)
```

**Output**:
```
==================================================
10 KM RACE ANALYSIS
==================================================
Race time: 42 minutes 42 seconds
Distance: 10 km (6.21 miles)
Average pace: 6:52 per mile
Average speed: 8.73 mph
==================================================
```

---

## Key Learning Points

### From Exercise 1.1 (Error Experiments):

1. **Syntax errors are caught immediately** - Python won't run code with syntax errors
2. **Error messages are helpful** - They point to the problem and often suggest fixes
3. **Parentheses must match** - Every opening parenthesis needs a closing one
4. **Strings need quotes** - Both opening and closing quotes required
5. **Unary operators exist** - `+` and `-` can be used before numbers
6. **Leading zeros forbidden** - Use `0o` prefix for octal numbers
7. **String literal concatenation** - Adjacent string literals automatically combine

### From Exercise 1.2 (Calculator):

1. **Order of operations matters** - Use parentheses to control calculation order
2. **Integer vs float division** - `/` always returns float in Python 3
3. **Floor division and modulus** - `//` for quotient, `%` for remainder
4. **Unit conversions** - Break complex problems into steps
5. **Formatting output** - Use f-strings for readable results
6. **Variable naming** - Use descriptive names for clarity

---

## Additional Practice Problems

### Problem 1: Temperature Conversion
```python
# Convert 72°F to Celsius
# Formula: C = (F - 32) × 5/9
fahrenheit = 72
celsius = (fahrenheit - 32) * 5/9
print(f"{fahrenheit}°F = {celsius:.1f}°C")
# Output: 72°F = 22.2°C
```

### Problem 2: Circle Calculations
```python
# Calculate circumference and area of circle with radius 5
# Circumference = 2πr, Area = πr²
import math
radius = 5
circumference = 2 * math.pi * radius
area = math.pi * radius ** 2
print(f"Radius: {radius}")
print(f"Circumference: {circumference:.2f}")
print(f"Area: {area:.2f}")
```

### Problem 3: Compound Interest
```python
# Calculate compound interest
# Formula: A = P(1 + r)^t
principal = 1000  # Initial amount
rate = 0.05       # 5% annual interest
years = 10        # Time period
amount = principal * (1 + rate) ** years
interest = amount - principal
print(f"Initial: ${principal:.2f}")
print(f"After {years} years: ${amount:.2f}")
print(f"Interest earned: ${interest:.2f}")
```

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist* (2nd ed.). Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

---

**Practice makes perfect! Try modifying these examples and creating your own variations.** 🐍💻
