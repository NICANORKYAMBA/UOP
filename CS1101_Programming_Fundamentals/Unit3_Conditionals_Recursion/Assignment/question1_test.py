#!/usr/bin/env python3
"""
CS1101 Unit 3 Programming Assignment - Question 1
Recursive countdown and countup functions
"""

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

# Test with positive number
print("Test 1: Positive number (3)")
print("Enter a number: 3")
countdown(3)

print("\n" + "="*50 + "\n")

# Test with negative number
print("Test 2: Negative number (-3)")
print("Enter a number: -3")
countup(-3)

print("\n" + "="*50 + "\n")

# Test with zero
print("Test 3: Zero (0)")
print("Enter a number: 0")
countdown(0)

print("\n" + "="*50 + "\n")

# Interactive version (uncomment to test with keyboard input)
print("Interactive Test:")
number = int(input("Enter a number: "))

if number > 0:
    countdown(number)
elif number < 0:
    countup(number)
else:
    countdown(number)
