#!/usr/bin/env python3
"""
CS1101 Unit 2 Discussion - Example 3
Local Variable Scope - Demonstrating NameError
"""

def calculate_gpa(grade_points, credits):
    """Calculate GPA for a single course."""
    gpa = grade_points / credits  # gpa is a LOCAL variable
    print(f"Course GPA: {gpa:.2f}")
    return gpa

print("=== Example 3: Local Variable Scope ===\n")

# Call the function
print("Calling calculate_gpa(12, 3):")
result = calculate_gpa(12, 3)
print(f"Function returned: {result}\n")

# Try to access local variable outside function
print("Attempting to access 'gpa' outside function:")
try:
    print(gpa)  # This will cause an ERROR
except NameError as e:
    print(f"NameError: {e}")
    print("\nExplanation: The variable 'gpa' only exists inside calculate_gpa().")
    print("It is destroyed when the function completes execution.")
