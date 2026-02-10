#!/usr/bin/env python3
"""
CS1101 Unit 2 Discussion - Example 2
Three Types of Arguments: Value, Variable, Expression
"""

def calculate_study_hours(credits):
    """
    Calculate recommended weekly study hours based on course credits.
    Parameter: credits - number of course credits (integer)
    """
    study_hours = credits * 3  # Rule of thumb: 3 hours per credit
    print(f"For {credits} credits, study {study_hours} hours per week")
    return study_hours

print("=== Example 2: Three Types of Arguments ===\n")

# Call 1: Value (literal)
print("Call 1 - Value argument:")
calculate_study_hours(3)  # Argument: 3 (integer value)
print("Argument type: Value (literal integer 3)\n")

# Call 2: Variable
print("Call 2 - Variable argument:")
course_credits = 5
calculate_study_hours(course_credits)  # Argument: course_credits (variable)
print("Argument type: Variable (course_credits = 5)\n")

# Call 3: Expression
print("Call 3 - Expression argument:")
calculate_study_hours(2 + 2)  # Argument: 2 + 2 (expression)
print("Argument type: Expression (2 + 2 evaluates to 4)")
