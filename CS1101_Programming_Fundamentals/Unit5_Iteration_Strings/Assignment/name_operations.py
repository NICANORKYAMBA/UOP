#!/usr/bin/env python3
"""CS1101 Unit 5 Programming Assignment - String operations on a name"""

name = "Nicanor Kyamba"
print(f"Name: {name}")
print("-" * 30)

# Operation 1: Display n characters from left
n = int(input("Enter number of characters to display from left: "))
print(f"\nFirst {n} characters: {name[:n]}")

# Operation 2: Count vowels
vowel_count = 0
for char in name:
    if char in 'aeiouAEIOU':
        vowel_count += 1
print(f"\nNumber of vowels in '{name}': {vowel_count}")

# Operation 3: Reverse the string
print(f"\nReversed name: {name[::-1]}")
