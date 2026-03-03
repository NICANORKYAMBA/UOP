# CS1101 Unit 5 Programming Assignment

**Name**: Nicanor Kyamba  
**Course**: CS1101 Programming Fundamentals  
**Unit**: 5 - Iteration and Strings  
**Date**: February 2026

---

## String Operations on a Name

### Introduction

This assignment demonstrates three fundamental string operations in Python using the name "Nicanor Kyamba" as the subject string. According to Downey (2015), strings are immutable sequences of characters that support indexing, slicing, and a rich set of built-in methods (p. 71). The three operations — displaying n characters from the left, counting vowels, and reversing the string — each illustrate a core concept from Chapters 7 and 8 of the textbook: user input and iteration, the counter pattern with for loops, and slice notation with a negative step.

Python strings are zero-indexed, meaning the first character occupies index 0, the second occupies index 1, and so on. This indexing system is the foundation for both slicing and traversal operations. Downey (2015) explains that a slice of the form `s[m:n]` returns the part of the string from the mth character to the nth character, including the first but excluding the last (p. 73). Understanding this behavior is essential for correctly extracting substrings and reversing strings.

Iteration, covered in Chapter 7, is the mechanism that makes vowel counting possible. A for loop traverses a string character by character, and a conditional statement inside the loop checks whether each character meets a specified criterion (Downey, 2015, p. 65). This combination of iteration and selection is one of the most fundamental patterns in programming and appears in virtually every string-processing algorithm.

---

## Part 1(a): Display Name and n Characters from Left

### Technical Explanation

The program first displays the full name, then prompts the user to enter a value for n using `int(input())`. The `input()` function reads a string from the keyboard, and `int()` converts it to an integer so it can be used as a slice index (Downey, 2015, p. 63). The slice `name[:n]` extracts characters from index 0 up to but not including index n, effectively returning the first n characters of the string. This approach requires no loop — Python's slice notation handles the extraction in a single expression, making the code concise and readable.

For example, if the name is `"Nicanor Kyamba"` and the user enters 7, `name[:7]` returns `"Nicanor"` because indices 0 through 6 correspond to the characters N, i, c, a, n, o, r. If the user enters 3, `name[:3]` returns `"Nic"`, the first three characters.

### Code

```python
# CS1101 Unit 5 Programming Assignment
# String operations on the name "Nicanor Kyamba"

name = "Nicanor Kyamba"
print(f"Full name: {name}")
print("-" * 35)

# Part 1(a): Display n characters from left
# Accept n as input from the user
n = int(input("Enter number of characters to display from left: "))
print(f"First {n} character(s) from left: {name[:n]}")
```

### Output — Part 1(a)

**Run 1 (n = 7):**
```
Full name: Nicanor Kyamba
-----------------------------------
Enter number of characters to display from left: 7
First 7 character(s) from left: Nicanor
```

**Run 2 (n = 3):**
```
Full name: Nicanor Kyamba
-----------------------------------
Enter number of characters to display from left: 3
First 3 character(s) from left: Nic
```

**Run 3 (n = 14):**
```
Full name: Nicanor Kyamba
-----------------------------------
Enter number of characters to display from left: 14
First 14 character(s) from left: Nicanor Kyamba
```

### Explanation of Output

In Run 1, the user enters 7, so `name[:7]` extracts indices 0–6, producing `"Nicanor"` — the first name only. In Run 2, the user enters 3, so `name[:3]` extracts indices 0–2, producing `"Nic"`. In Run 3, the user enters 14 (the full length of the string), so `name[:14]` returns the entire name. These three runs demonstrate that the slice adapts dynamically to any valid user input, confirming that n is correctly accepted from the keyboard at runtime.

---

## Part 1(b): Count the Number of Vowels

### Technical Explanation

Vowel counting uses the counter pattern described by Downey (2015): initialize a counter variable to zero before the loop, traverse the string character by character using a for loop, and increment the counter each time the condition is satisfied (p. 67). The condition checks whether each character belongs to the string `'aeiouAEIOU'` using Python's `in` operator. Both lowercase and uppercase vowels are included in the check string to ensure the count is case-insensitive, which is important because the name "Nicanor Kyamba" contains the uppercase letter N at the start.

The for loop iterates over all 14 characters in `"Nicanor Kyamba"`, including the space character. The space is not a vowel and is therefore skipped. The vowels present in the name are: `i` (index 1), `a` (index 3), `o` (index 5), `a` (index 10), and `a` (index 13), giving a total of 5 vowels.

### Code

```python
# Part 1(b): Count the number of vowels
vowel_count = 0
for char in name:
    if char in 'aeiouAEIOU':
        vowel_count += 1
print(f"Number of vowels in '{name}': {vowel_count}")
```

### Output — Part 1(b)

```
Number of vowels in 'Nicanor Kyamba': 5
```

### Explanation of Output

The for loop visits each of the 14 characters in `"Nicanor Kyamba"`. The characters `i`, `a`, `o`, `a`, and `a` satisfy the condition `char in 'aeiouAEIOU'`, so `vowel_count` is incremented five times. The consonants N, c, n, r, K, y, m, b and the space character do not satisfy the condition and are skipped. The final value of `vowel_count` is 5, which is printed as the result. Note that `y` is not counted as a vowel because it is not included in the check string `'aeiouAEIOU'`, consistent with standard vowel classification in English.

---

## Part 1(c): Reverse the Name

### Technical Explanation

Reversing a string in Python is accomplished using the extended slice notation `s[::-1]`. According to Downey (2015), a slice of the form `s[::step]` traverses the string with the given step value; a step of -1 causes Python to traverse the string from the last character to the first, effectively reversing it (p. 73). This approach is both concise and efficient — it requires no explicit loop, no temporary variable, and no manual index management.

The expression `name[::-1]` applied to `"Nicanor Kyamba"` produces `"abmayK ronaciN"`. The space character is preserved in its mirrored position (between `K` and `r` in the reversed string), demonstrating that slicing treats all characters — including whitespace — uniformly. The capital `N` from the start of the original name appears at the end of the reversed string, and the capital `K` from `Kyamba` appears in the middle.

### Code

```python
# Part 1(c): Reverse the name
reversed_name = name[::-1]
print(f"Reversed name: {reversed_name}")
```

### Output — Part 1(c)

```
Reversed name: abmayK ronaciN
```

### Explanation of Output

The slice `name[::-1]` steps through `"Nicanor Kyamba"` backwards, starting from the last character `a` (index 13) and ending at the first character `N` (index 0). The result `"abmayK ronaciN"` is the exact mirror of the original string. The capital letters `N` and `K` retain their case in the reversed output because slicing does not alter character values — it only changes the order in which they appear. This confirms that the reversal is character-accurate and preserves all original characters including spaces.

---

## Complete Program and Full Output

### Complete Code

```python
# CS1101 Unit 5 Programming Assignment
# String operations on the name "Nicanor Kyamba"

name = "Nicanor Kyamba"
print(f"Full name: {name}")
print("-" * 35)

# Part 1(a): Display n characters from left
n = int(input("Enter number of characters to display from left: "))
print(f"First {n} character(s) from left: {name[:n]}")

# Part 1(b): Count the number of vowels
vowel_count = 0
for char in name:
    if char in 'aeiouAEIOU':
        vowel_count += 1
print(f"Number of vowels in '{name}': {vowel_count}")

# Part 1(c): Reverse the name
reversed_name = name[::-1]
print(f"Reversed name: {reversed_name}")
```

### Complete Output (n = 7)

```
Full name: Nicanor Kyamba
-----------------------------------
Enter number of characters to display from left: 7
First 7 character(s) from left: Nicanor
Number of vowels in 'Nicanor Kyamba': 5
Reversed name: abmayK ronaciN
```

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist* (2nd ed.). Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

Khan Academy. (2011, June 30). *Fun with strings* [Video]. YouTube. https://youtu.be/iZAtkS0F-Zo

Khan Academy. (2011, June 30). *For loops in Python* [Video]. YouTube. https://youtu.be/9LgyKiq_hU0

---

**Word Count**: 847 words (excluding code, output, and references)
