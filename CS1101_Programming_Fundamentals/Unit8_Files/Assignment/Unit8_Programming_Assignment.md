# CS1101 Unit 8 Programming Assignment — File Dictionary Inversion

**Name**: Nicanor Kyamba  
**Course**: CS1101 Programming Fundamentals  
**Unit**: 8 — Files  
**Date**: March 2026

---

## Overview

One of the most practical skills in programming is being able to store data in a file and retrieve it later. In this assignment, I built a program that reads a dictionary from a plain text file, inverts it so that values become keys and keys become grouped values, and writes the result to a separate output file. The program uses exception handling throughout so that file errors are caught and reported gracefully rather than crashing the program. All three components — the input file, the Python program, and the output file — are shown below with a full technical explanation.

---

## Component 1: Input File — `fruits.txt`

```
apple: red
banana: yellow
cherry: red
mango: yellow
grapes: black
blueberry: blue
plum: purple
lemon: yellow
```

The input file contains eight fruit-to-color mappings, one per line, using the format `key: value`. I chose this dataset because it has deliberate repetition — three fruits share the color `yellow`, two share `red`, and the remaining three have unique colors. This makes the inversion interesting: the output will show how multiple original keys collapse into a single new key with a list of values.

---

## Component 2: Python Program — `file_dict.py`

```python
# file_dict.py — CS1101 Unit 8 Programming Assignment
# Reads a dictionary from a text file, inverts it, and writes the result to a new file.
# Uses exception handling throughout for robust file error management.

def read_dict_from_file(filename):
    """
    Read key:value pairs from a text file and return them as a dictionary.
    Each line must have the format:  key: value
    Lines that are blank or malformed are skipped.
    """
    d = {}
    try:
        with open(filename, 'r') as f:
            for line in f:
                line = line.strip()
                if not line:          # skip blank lines
                    continue
                if ':' not in line:   # skip malformed lines
                    continue
                key, value = line.split(':', 1)
                d[key.strip()] = value.strip()
    except FileNotFoundError:
        print(f"Error: Input file '{filename}' not found.")
    except PermissionError:
        print(f"Error: No permission to read '{filename}'.")
    return d


def invert_dict(d):
    """
    Invert a dictionary so that each value becomes a key mapping to a list
    of all original keys that had that value.
    Example: {'apple': 'red', 'cherry': 'red'} -> {'red': ['apple', 'cherry']}
    """
    inverse = {}
    for key, value in d.items():
        if value not in inverse:
            inverse[value] = [key]
        else:
            inverse[value].append(key)
    return inverse


def write_dict_to_file(d, filename):
    """
    Write an inverted dictionary to a text file.
    Each line has the format:  key: value1, value2, ...
    """
    try:
        with open(filename, 'w') as f:
            for key, values in d.items():
                line = key + ': ' + ', '.join(values)
                f.write(line + '\n')
        print(f"Inverted dictionary written to '{filename}'.")
    except PermissionError:
        print(f"Error: No permission to write to '{filename}'.")


# ── Main program ──────────────────────────────────────────────────────────────

INPUT_FILE  = 'fruits.txt'
OUTPUT_FILE = 'fruits_inverted.txt'

# Step 1: Read the original dictionary from file
original = read_dict_from_file(INPUT_FILE)

print("Original dictionary (read from file):")
for fruit, color in original.items():
    print(f"  {fruit}: {color}")

# Step 2: Invert the dictionary
inverted = invert_dict(original)

print("\nInverted dictionary:")
for color, fruits in inverted.items():
    print(f"  {color}: {', '.join(fruits)}")

# Step 3: Write the inverted dictionary to a new file
print()
write_dict_to_file(inverted, OUTPUT_FILE)
```

---

## Console Output

```
Original dictionary (read from file):
  apple: red
  banana: yellow
  cherry: red
  mango: yellow
  grapes: black
  blueberry: blue
  plum: purple
  lemon: yellow

Inverted dictionary:
  red: apple, cherry
  yellow: banana, mango, lemon
  black: grapes
  blue: blueberry
  purple: plum

Inverted dictionary written to 'fruits_inverted.txt'.
```

---

## Component 3: Output File — `fruits_inverted.txt`

```
red: apple, cherry
yellow: banana, mango, lemon
black: grapes
blue: blueberry
purple: plum
```

The output file has five lines — one for each unique color in the original dictionary. Colors that appeared multiple times in the input now map to a comma-separated list of all the fruits that had that color.

---

## Technical Explanation

This program is organized into three functions — `read_dict_from_file`, `invert_dict`, and `write_dict_to_file` — each responsible for exactly one step of the process. Keeping the responsibilities separate makes the code easier to read, test, and reuse. I will explain each function in turn, then discuss the exception handling strategy.

**Reading the file into a dictionary**

The `read_dict_from_file` function opens `fruits.txt` using Python's built-in `open()` function in read mode (`'r'`). Rather than calling `f.close()` manually, I used the `with` statement as a context manager. As Downey (2015) explains, the `with` statement guarantees that the file is closed automatically when the block exits, even if an error occurs inside it — which prevents resource leaks that can accumulate in longer-running programs (p. 141).

Inside the `with` block, the function iterates over the file line by line using a `for` loop. This is more memory-efficient than reading the entire file at once with `f.read()`, because Python loads only one line into memory at a time — an important consideration when working with large files (Schafer, 2016). Each line is processed with `.strip()` to remove leading and trailing whitespace, including the newline character `\n` that Python includes at the end of each line it reads. Lines that are blank after stripping are skipped with `continue`, as are lines that do not contain a colon — this defensive check prevents the program from crashing on malformed input. The remaining lines are split on the first colon using `line.split(':', 1)`. The `1` argument is important: it limits the split to a single occurrence, so a value that itself contains a colon — such as a URL — would not be incorrectly split into three parts. The resulting key and value are stripped of any extra whitespace and stored in the dictionary `d`.

**Inverting the dictionary**

The `invert_dict` function iterates over the original dictionary using `.items()`, which yields each key-value pair as a tuple on every iteration. For each pair, the original value (the color) becomes the new key in the `inverse` dictionary, and the original key (the fruit name) is added to a list of values. The logic uses a conditional check: if the color has not been seen before, a new list is created containing just the current fruit; if the color already exists as a key, the current fruit is appended to the existing list. This check-and-append pattern is the standard way to build a dictionary of lists in Python (Downey, 2015, p. 143). The result is that `red` maps to `['apple', 'cherry']` and `yellow` maps to `['banana', 'mango', 'lemon']`, correctly grouping all fruits that share a color.

**Writing the inverted dictionary to a file**

The `write_dict_to_file` function opens `fruits_inverted.txt` in write mode (`'w'`). As W3Schools (n.d.) notes, write mode creates the file if it does not already exist, or overwrites it completely if it does — which is the correct behavior here since we always want a fresh output. For each color key, the list of fruit names is converted into a comma-separated string using `', '.join(values)`. The `join()` method is the idiomatic Python way to concatenate a list of strings with a separator, and it handles lists of any length without requiring a loop. Each formatted line is written to the file followed by `'\n'` to ensure each entry appears on its own line.

**Exception handling**

Both file-touching functions wrap their `open()` calls in `try`/`except` blocks with named exception types. In `read_dict_from_file`, `FileNotFoundError` is caught to handle the case where `fruits.txt` does not exist, and `PermissionError` is caught to handle access restriction. In `write_dict_to_file`, `PermissionError` is caught to handle the case where the program cannot write to the output location. As Downey (2015) explains, naming specific exceptions in `except` clauses — rather than using a bare `except:` — is best practice because it ensures that only anticipated errors are handled, while unexpected errors still propagate and get noticed (p. 145). If `read_dict_from_file` encounters an error, it returns an empty dictionary `{}` rather than crashing, which allows the rest of the program to handle the empty result gracefully.

The overall design — three focused functions, defensive input parsing, named exception handling, and the `with` statement for automatic resource management — reflects the programming principles covered throughout CS1101 and demonstrates how file I/O, dictionary operations, and exception handling work together in a complete, practical program.

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist* (2nd ed.). Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

Schafer, C. (2016, April 29). *Python tutorial: File objects - Reading and writing to files* [Video]. YouTube. https://youtu.be/Uh2ebFW8OYM

W3Schools. (n.d.). *Python file open*. https://www.w3schools.com/python/python_file_open.asp

---

**Word Count**: ~750 words (explanation section, excluding code, title, and references)
