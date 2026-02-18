# CS1101 Unit 3 Programming Assignment

**Name**: Nicanor Kyamba  
**Course**: CS1101 Programming Fundamentals  
**Unit**: 3 - Conditionals and Recursion  
**Date**: February 2026

---

## Question 1: Recursive Functions - Countdown and Countup

### Technical Explanation

Recursion is a programming technique where a function calls itself to solve a problem by breaking it down into smaller subproblems (Downey, 2015, p. 51). The countdown function demonstrates recursion by checking a base case (`n <= 0`) that terminates the recursion, and a recursive case that prints the current number and calls itself with a decremented value. For the countup function, the logic is inverted: the base case remains the same, but the recursive call increments the value (`n+1`) instead of decrementing it, allowing the function to count upward from negative numbers toward zero.

The main program uses conditional statements to determine which function to call based on user input. According to Downey (2015), conditional execution allows programs to make decisions by checking boolean expressions and executing different code paths accordingly (p. 43). For zero input, I chose to call the countdown function because zero represents the boundary between positive and negative numbers, and countdown naturally handles zero as its base case by immediately printing "Blastoff!" without recursion. This design choice maintains consistency with the original countdown function's behavior and provides immediate feedback for the boundary condition.

### Code Implementation

```python
def countdown(n):
    """Recursive function that counts down from n to zero."""
    if n <= 0:
        print('Blastoff!')
    else:
        print(n)
        countdown(n-1)

def countup(n):
    """Recursive function that counts up from negative n to zero."""
    if n <= 0:
        print(n)
        if n == 0:
            print('Blastoff!')
        else:
            countup(n+1)

# Main program
number = int(input("Enter a number: "))

if number > 0:
    countdown(number)
elif number < 0:
    countup(number)
else:
    countdown(number)
```

### Output for Positive Number

```
Enter a number: 3
3
2
1
Blastoff!
```

**Explanation**: When the user enters 3, the program evaluates the condition `number > 0` as true and calls `countdown(3)`. The function prints 3, then recursively calls `countdown(2)`, which prints 2, then `countdown(1)`, which prints 1, and finally `countdown(0)`, which triggers the base case and prints "Blastoff!".

### Output for Negative Number

```
Enter a number: -3
-3
-2
-1
0
Blastoff!
```

**Explanation**: When the user enters -3, the program evaluates the condition `number < 0` as true and calls `countup(-3)`. The function prints -3, then recursively calls `countup(-2)`, which prints -2, then `countup(-1)`, which prints -1, then `countup(0)`, which prints 0 and "Blastoff!" because it reaches the base case.

### Output for Zero

```
Enter a number: 0
Blastoff!
```

**Explanation**: When the user enters 0, both conditions `number > 0` and `number < 0` evaluate to false, so the else clause executes and calls `countdown(0)`. Since 0 satisfies the base case condition `n <= 0`, the function immediately prints "Blastoff!" without any recursive calls.

### Choice Explanation for Zero Input

I chose to call the countdown function for zero input because zero represents the natural termination point for counting sequences. The countdown function is designed with zero as its base case, making it the most semantically appropriate choice. Additionally, calling countdown(0) provides consistent behavior with the mathematical concept of counting down to zero, where zero is the final number before "Blastoff!". This design decision ensures that zero is treated as a boundary condition rather than requiring special handling, maintaining code simplicity and logical consistency.

---

## Question 2: Division by Zero Error Handling

### Technical Explanation

Runtime errors occur during program execution when the interpreter encounters an operation that cannot be completed, such as dividing by zero (Downey, 2015, p. 195). In Python, division by zero raises a `ZeroDivisionError` exception, which immediately terminates the program unless handled properly. Exception handling using try-except blocks allows programs to anticipate and gracefully manage runtime errors by providing alternative code paths when errors occur (Bro Code, 2024).

Error handling is crucial in expressions and conditions because it prevents program crashes and provides meaningful feedback to users. Without error handling, a division by zero error would terminate the entire program abruptly, potentially losing unsaved data or leaving the system in an inconsistent state. By implementing try-except blocks, developers can catch specific exceptions, display user-friendly error messages, and allow the program to continue executing or terminate gracefully. This approach improves user experience, enhances program reliability, and facilitates debugging by providing clear error information.

The significance of error handling extends beyond preventing crashes. In production environments, unhandled exceptions can expose sensitive system information through error messages, create security vulnerabilities, or cause cascading failures in interconnected systems. For the division by zero scenario, proper error handling ensures that invalid user input does not compromise program stability, allows for input validation and correction, and maintains professional software quality standards.

### Code Without Error Handling (Demonstrating Runtime Error)

```python
def divide_without_handling():
    """Division program without error handling - demonstrates runtime error."""
    print("=== Division Program (Without Error Handling) ===")
    num1 = float(input("Enter the first number (numerator): "))
    num2 = float(input("Enter the second number (denominator): "))
    
    result = num1 / num2
    print(f"Result: {num1} / {num2} = {result}")

# Uncomment to test runtime error
# divide_without_handling()
```

### Output Demonstrating Runtime Error

```
=== Division Program (Without Error Handling) ===
Enter the first number (numerator): 10
Enter the second number (denominator): 0
Traceback (most recent call last):
  File "division_program.py", line 6, in divide_without_handling
    result = num1 / num2
ZeroDivisionError: float division by zero
```

**Error Analysis**: The runtime error occurs at line 6 when the program attempts to execute `num1 / num2` with `num2 = 0`. Python raises a `ZeroDivisionError` exception because division by zero is mathematically undefined. The traceback shows the exact location of the error, the function name, and the specific exception type, providing developers with diagnostic information to identify and fix the issue.

### Code With Error Handling (Proper Implementation)

```python
def divide_with_handling():
    """Division program with proper error handling."""
    print("=== Division Program (With Error Handling) ===")
    
    try:
        num1 = float(input("Enter the first number (numerator): "))
        num2 = float(input("Enter the second number (denominator): "))
        
        if num2 == 0:
            raise ZeroDivisionError("Cannot divide by zero. Please enter a non-zero denominator.")
        
        result = num1 / num2
        print(f"Result: {num1} / {num2} = {result:.2f}")
        
    except ValueError:
        print("Error: Invalid input. Please enter numeric values only.")
    except ZeroDivisionError as e:
        print(f"Error: {e}")
    except Exception as e:
        print(f"Unexpected error occurred: {e}")

# Test the function
divide_with_handling()
```

### Output With Error Handling (Division by Zero)

```
=== Division Program (With Error Handling) ===
Enter the first number (numerator): 10
Enter the second number (denominator): 0
Error: Cannot divide by zero. Please enter a non-zero denominator.
```

**Explanation**: The try block contains the potentially dangerous code. When the user enters 0 as the denominator, the condition `num2 == 0` evaluates to true, and the program explicitly raises a `ZeroDivisionError` with a custom message. The except block catches this exception and prints the user-friendly error message, allowing the program to terminate gracefully without a crash.

### Output With Error Handling (Valid Input)

```
=== Division Program (With Error Handling) ===
Enter the first number (numerator): 10
Enter the second number (denominator): 2
Result: 10.0 / 2.0 = 5.00
```

**Explanation**: When valid input is provided, the try block executes completely without raising any exceptions. The division operation completes successfully, and the result is displayed with two decimal places using formatted string output.

### Output With Error Handling (Invalid Input)

```
=== Division Program (With Error Handling) ===
Enter the first number (numerator): abc
Error: Invalid input. Please enter numeric values only.
```

**Explanation**: When the user enters non-numeric input, the `float()` conversion raises a `ValueError` exception. The except block catches this specific exception and displays an appropriate error message, demonstrating comprehensive error handling for multiple error types.

### Significance of Error Handling

Error handling in expressions and conditions is essential for creating robust, production-ready software. The division by zero scenario illustrates three critical aspects of error handling:

1. **Program Stability**: Without error handling, a single invalid input crashes the entire program. With error handling, the program catches the exception, displays a meaningful message, and can continue execution or terminate gracefully.

2. **User Experience**: Unhandled exceptions expose technical stack traces that confuse non-technical users. Proper error handling provides clear, actionable feedback that guides users to correct their input.

3. **Debugging and Maintenance**: Custom error messages help developers quickly identify the cause of errors during testing and production. The explicit check for zero (`if num2 == 0`) makes the code's intent clear and facilitates future maintenance.

The potential impact of not handling division by zero errors includes data loss from abrupt program termination, poor user experience from cryptic error messages, security vulnerabilities from exposed system information, and increased support costs from user confusion. In critical systems such as financial applications, medical software, or industrial control systems, unhandled exceptions can have severe consequences including financial losses, safety hazards, or regulatory compliance violations. Therefore, implementing comprehensive error handling is not optional but a fundamental requirement for professional software development.

---

## References

Bro Code. (2024, June 29). *Learn Python EXCEPTION HANDLING in 5 minutes!* [Video]. YouTube. https://www.youtube.com/watch?v=V_NXT2-QIlE

Downey, A. (2015). *Think Python: How to think like a computer scientist* (2nd ed.). Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

---

**Word Count**: 1,247 words (excluding code, output examples, and references)
