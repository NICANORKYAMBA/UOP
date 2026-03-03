# CS1101 Unit 5 Programming Assignment

**Name**: Nicanor Kyamba  
**Course**: CS1101 Programming Fundamentals  
**Unit**: 5 - Iteration and Strings  
**Date**: February 2026

---

## String Operations on a Name

### Technical Explanation

This program demonstrates three fundamental string operations in Python using the name "Nicanor Kyamba" as the subject string. According to Downey (2015), strings are immutable sequences of characters that support indexing, slicing, and a rich set of built-in methods (p. 71). The three operations — displaying n characters from the left, counting vowels, and reversing the string — each illustrate a core concept from Chapter 8: string slicing, iteration with conditionals, and slice notation with a negative step.

**Operation 1 — Display n characters from left** uses Python's slice notation `s[:n]`, which extracts a substring from index 0 up to (but not including) index n. The value of n is accepted from the user via `int(input())`, demonstrating how programs interact with users at runtime (Downey, 2015, p. 63).

**Operation 2 — Count vowels** uses a for loop to traverse every character in the string and a conditional check against the string `'aeiouAEIOU'` using the `in` operator. This is the counter pattern described by Downey (2015, p. 67): initialize a counter to zero before the loop, then increment it each time the condition is satisfied.

**Operation 3 — Reverse the string** uses the slice `s[::-1]`, where the step value of -1 causes Python to traverse the string from the last character to the first. This is the most Pythonic and efficient way to reverse a string, as it avoids an explicit loop entirely (Downey, 2015, p. 73).

Together, these three operations demonstrate the power of Python's string model: slicing provides concise substring extraction, for loops enable character-by-character processing, and string methods and operators reduce the need for verbose manual implementations. Understanding these fundamentals is essential for any string-processing algorithm, from input validation to text analysis.

---

### Code Implementation

```python
# CS1101 Unit 5 Programming Assignment
# String operations on a name

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
reversed_name = name[::-1]
print(f"\nReversed name: {reversed_name}")
```

---

### Output

**Run 1 — n = 7**:
```
Name: Nicanor Kyamba
------------------------------
Enter number of characters to display from left: 7

First 7 characters: Nicanor

Number of vowels in 'Nicanor Kyamba': 5

Reversed name: abmayK ronaciN
```

**Run 2 — n = 3**:
```
Name: Nicanor Kyamba
------------------------------
Enter number of characters to display from left: 3

First 3 characters: Nic

Number of vowels in 'Nicanor Kyamba': 5

Reversed name: abmayK ronaciN
```

---

### Output Explanation

**Operation 1**: `name[:7]` extracts characters at indices 0 through 6, producing `'Nicanor'`. When n = 3, `name[:3]` produces `'Nic'`. The slice notation is efficient because Python handles the boundary internally — no loop or manual index tracking is needed.

**Operation 2**: The for loop iterates over all 14 characters in `'Nicanor Kyamba'` (including the space). The vowels found are: `i`, `a`, `o`, `a` — wait, let me verify:

```
N-i-c-a-n-o-r- -K-y-a-m-b-a
  i a   o       a       a
```

Vowels: `i` (index 1), `a` (index 3), `o` (index 5), `a` (index 10), `a` (index 13) = **5 vowels**. The space and consonants are skipped because they are not in `'aeiouAEIOU'`.

**Operation 3**: `name[::-1]` reverses the string by stepping through it backwards. `'Nicanor Kyamba'` becomes `'abmayK ronaciN'`. The space is preserved in its mirrored position, demonstrating that slicing treats all characters — including whitespace — uniformly.

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist* (2nd ed.). Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

Khan Academy. (2011, June 30). *Fun with strings* [Video]. YouTube. https://youtu.be/iZAtkS0F-Zo

---

**Word Count**: 512 words (excluding code, output, and references)
