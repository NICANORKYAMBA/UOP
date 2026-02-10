#!/usr/bin/env python3
"""
CS1101 Unit 2 Discussion - Example 4
Parameter Scope - Demonstrating NameError with parameters
"""

def calculate_tuition(credit_cost, num_credits):
    """
    Calculate total tuition based on cost per credit.
    Parameters: credit_cost, num_credits
    """
    total = credit_cost * num_credits
    print(f"Total tuition: ${total}")
    return total

print("=== Example 4: Parameter Scope ===\n")

# Call the function
print("Calling calculate_tuition(400, 12):")
result = calculate_tuition(400, 12)
print(f"Function returned: ${result}\n")

# Try to use parameter outside function
print("Attempting to access 'credit_cost' parameter outside function:")
try:
    print(f"Credit cost: ${credit_cost}")  # This will cause an ERROR
except NameError as e:
    print(f"NameError: {e}")
    print("\nExplanation: Parameters are local to the function.")
    print("They are created when the function is called and destroyed when it returns.")
