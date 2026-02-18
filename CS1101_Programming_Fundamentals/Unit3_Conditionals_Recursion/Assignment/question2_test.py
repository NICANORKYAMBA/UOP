#!/usr/bin/env python3
"""
CS1101 Unit 3 Programming Assignment - Question 2
Division by zero error handling demonstration
"""

def divide_without_handling():
    """Division program without error handling - demonstrates runtime error."""
    print("=== Division Program (Without Error Handling) ===")
    num1 = float(input("Enter the first number (numerator): "))
    num2 = float(input("Enter the second number (denominator): "))
    
    result = num1 / num2
    print(f"Result: {num1} / {num2} = {result}")

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

# Automated tests
print("AUTOMATED TESTS")
print("="*60)

# Test 1: Division by zero without error handling
print("\nTest 1: Without Error Handling (Division by Zero)")
print("This will cause a runtime error:")
try:
    num1, num2 = 10.0, 0.0
    print(f"Attempting: {num1} / {num2}")
    result = num1 / num2
except ZeroDivisionError as e:
    print(f"ZeroDivisionError: {e}")

print("\n" + "="*60 + "\n")

# Test 2: With error handling - valid input
print("Test 2: With Error Handling (Valid Input)")
print("Simulating input: 10, 2")
try:
    num1, num2 = 10.0, 2.0
    if num2 == 0:
        raise ZeroDivisionError("Cannot divide by zero. Please enter a non-zero denominator.")
    result = num1 / num2
    print(f"Result: {num1} / {num2} = {result:.2f}")
except ZeroDivisionError as e:
    print(f"Error: {e}")

print("\n" + "="*60 + "\n")

# Test 3: With error handling - division by zero
print("Test 3: With Error Handling (Division by Zero)")
print("Simulating input: 10, 0")
try:
    num1, num2 = 10.0, 0.0
    if num2 == 0:
        raise ZeroDivisionError("Cannot divide by zero. Please enter a non-zero denominator.")
    result = num1 / num2
    print(f"Result: {num1} / {num2} = {result:.2f}")
except ZeroDivisionError as e:
    print(f"Error: {e}")

print("\n" + "="*60 + "\n")

# Interactive version
print("INTERACTIVE TEST")
print("="*60)
divide_with_handling()
