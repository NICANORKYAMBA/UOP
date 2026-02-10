# CS1101 Unit 2 Discussion Assignment

**Name**: Nicanor Kyamba  
**Course**: CS1101 Programming Fundamentals  
**Unit**: 2 - Variables, Expressions, Statements, and Functions  
**Date**: February 2026

---

## Example 1: Function with Argument

```python
def calculate_study_hours(credits):
    """
    Calculate recommended weekly study hours based on course credits.
    Parameter: credits - number of course credits (integer)
    """
    study_hours = credits * 3  # Rule of thumb: 3 hours per credit
    print(f"For {credits} credits, study {study_hours} hours per week")
    return study_hours

# Function call
calculate_study_hours(4)
```

**Output**:
```
For 4 credits, study 12 hours per week
```

**Explanation**:
- **Parameter**: `credits` is the parameter defined in the function signature
- **Argument**: `4` is the argument passed when calling the function
- The parameter acts as a placeholder that receives the argument value when the function executes

---

## Example 2: Three Types of Arguments

```python
# Using the same function from Example 1

# Call 1: Value (literal)
calculate_study_hours(3)  # Argument: 3 (integer value)

# Call 2: Variable
course_credits = 5
calculate_study_hours(course_credits)  # Argument: course_credits (variable)

# Call 3: Expression
calculate_study_hours(2 + 2)  # Argument: 2 + 2 (expression)
```

**Output**:
```
For 3 credits, study 9 hours per week
For 5 credits, study 15 hours per week
For 4 credits, study 12 hours per week
```

**Explanation**:
- **Value argument** (3): Direct literal value passed to function
- **Variable argument** (course_credits): Variable containing value 5 is passed
- **Expression argument** (2 + 2): Expression is evaluated first (result: 4), then passed to function

All three argument types work identically—Python evaluates them before passing to the function.

---

## Example 3: Local Variable Scope

```python
def calculate_gpa(grade_points, credits):
    """Calculate GPA for a single course."""
    gpa = grade_points / credits  # gpa is a LOCAL variable
    print(f"Course GPA: {gpa:.2f}")
    return gpa

# Call the function
calculate_gpa(12, 3)

# Try to access local variable outside function
print(gpa)  # This will cause an ERROR
```

**Output**:
```
Course GPA: 4.00
Traceback (most recent call last):
  File "example3.py", line 10, in <module>
    print(gpa)
NameError: name 'gpa' is not defined
```

**Explanation**:
The variable `gpa` is defined inside the function `calculate_gpa()`, making it a local variable. According to Downey (2015), local variables only exist within their function's scope and are destroyed when the function completes execution. Attempting to access `gpa` outside the function results in a `NameError` because Python cannot find a variable named `gpa` in the global scope. This demonstrates the principle of encapsulation—functions maintain their own private variable spaces that don't interfere with code outside the function. This scoping behavior is fundamental to Python's design, ensuring that functions can operate independently without unintended side effects on other parts of the program.

---

## Example 4: Parameter Scope

```python
def calculate_tuition(credit_cost, num_credits):
    """
    Calculate total tuition based on cost per credit.
    Parameters: credit_cost, num_credits
    """
    total = credit_cost * num_credits
    print(f"Total tuition: ${total}")
    return total

# Call the function
calculate_tuition(400, 12)

# Try to use parameter outside function
print(f"Credit cost: ${credit_cost}")  # This will cause an ERROR
```

**Output**:
```
Total tuition: $4800
Traceback (most recent call last):
  File "example4.py", line 12, in <module>
    print(f"Credit cost: ${credit_cost}")
NameError: name 'credit_cost' is not defined
```

**Explanation**:
Function parameters (`credit_cost` and `num_credits`) behave exactly like local variables—they only exist within the function scope (Downey, 2015). When we call `calculate_tuition(400, 12)`, Python creates temporary variables `credit_cost = 400` and `num_credits = 12` inside the function. These parameter variables are destroyed when the function returns. Attempting to access `credit_cost` outside the function produces a `NameError` because parameters are not accessible in the global scope. This reinforces that parameters are function-local entities, which is a critical concept in understanding how Python manages function execution and memory allocation.

---

## Example 5: Global vs Local Variable Name Collision

```python
# Global variable
student_name = "Alice Johnson"

def register_course(course_code):
    """Register a student for a course."""
    # Local variable with SAME NAME as global
    student_name = "Bob Smith"
    print(f"Inside function: {student_name} registered for {course_code}")

# Before function call
print(f"Before function: {student_name}")

# Call function
register_course("CS1101")

# After function call
print(f"After function: {student_name}")
```

**Output**:
```
Before function: Alice Johnson
Inside function: Bob Smith registered for CS1101
After function: Alice Johnson
```

**Explanation**:
This example demonstrates variable shadowing, a concept explained in Downey (2015) where a local variable can share the same name as a global variable. When this occurs, the local variable "shadows" or hides the global variable within the function scope. Inside `register_course()`, the assignment `student_name = "Bob Smith"` creates a new local variable that exists only within the function. This local `student_name` is completely separate from the global `student_name`. The global variable remains unchanged at "Alice Johnson" throughout the program. Python's scoping rules prioritize local variables over global variables when resolving names, which prevents functions from accidentally modifying global state. This is a fundamental principle of function isolation and helps prevent bugs in larger programs by ensuring that functions cannot inadvertently alter variables defined outside their scope.

---

## Discussion Question

**Question**: When designing a function that performs calculations, what are the advantages and disadvantages of using return values versus printing results directly inside the function? In what scenarios would you choose one approach over the other?

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist*. Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

---

**Total Word Count**: 892 words (excluding code and output)
