#!/usr/bin/env python3
"""
CS1101 Unit 2 Discussion - Example 1
Function with Argument - Parameter vs Argument demonstration
"""

def calculate_study_hours(credits):
    """
    Calculate recommended weekly study hours based on course credits.
    Parameter: credits - number of course credits (integer)
    """
    study_hours = credits * 3  # Rule of thumb: 3 hours per credit
    print(f"For {credits} credits, study {study_hours} hours per week")
    return study_hours

# Function call
print("=== Example 1: Function with Argument ===")
result = calculate_study_hours(4)
print(f"Returned value: {result}\n")

print("Identification:")
print("- Parameter: 'credits' (in function definition)")
print("- Argument: 4 (value passed when calling function)")
