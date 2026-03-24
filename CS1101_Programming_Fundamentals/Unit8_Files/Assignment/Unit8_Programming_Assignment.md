# CS1101 Unit 8 Programming Assignment — File Dictionary Inversion

**Name**: Nicanor Kyamba  
**Course**: CS1101 Programming Fundamentals  
**Unit**: 8 — Files  
**Date**: March 2026

---

## Assignment Overview

This program reads a dictionary from a text file, inverts it so that values become keys mapping to lists of original keys, and writes the inverted dictionary to a new output file. Exception handling is used throughout to manage file errors gracefully.

---

## Input File: `fruits.txt`

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

The input file contains eight fruit-to-color mappings, one per line, in `key: value` format. Three fruits share the color `yellow`, two share `red`, and the remaining three have unique colors.

---

## Python Program: `file_dict.py`

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

## Output File: `fruits_inverted.txt`

```
red: apple, cherry
yellow: banana, mango, lemon
black: grapes
blue: blueberry
purple: plum
```

---

## Technical Explanation

This program demonstrates three core concepts from Chapter 14 of Downey (2015): reading from files, writing to files, and catching exceptions.

**Reading the file**: The `read_dict_from_file` function opens `fruits.txt` using Python's built-in `open()` function in read mode (`'r'`). The `with` statement is used as a context manager, which guarantees the file is closed automatically when the block exits — even if an error occurs inside it (Downey, 2015, p. 141). The function iterates over the file line by line using a `for` loop. Each line is stripped of leading and trailing whitespace using `.strip()`, then split on the first colon using `line.split(':', 1)`. The `1` argument limits the split to one occurrence, which prevents problems if a value itself contains a colon. Blank lines and malformed lines (those without a colon) are skipped using `continue`. The resulting key-value pairs are stored in a dictionary `d`, which is returned to the caller.

**Inverting the dictionary**: The `invert_dict` function iterates over the original dictionary using `.items()`, which yields each key-value pair as a tuple. For each pair, the original value becomes the new key in the `inverse` dictionary, and the original key is appended to a list of values. The check `if value not in inverse` handles the first occurrence of each color — creating a new list — while the `else` branch appends to the existing list for subsequent occurrences. This is the same pattern used in the Unit 7 assignment, now applied to file-sourced data (Downey, 2015, p. 121).

**Writing the output file**: The `write_dict_to_file` function opens `fruits_inverted.txt` in write mode (`'w'`), which creates the file if it does not exist or overwrites it if it does (Schafer, 2016). For each color key, the list of fruit names is joined into a comma-separated string using `', '.join(values)`, then written as a single line followed by a newline character `'\n'`.

**Exception handling**: Both file functions wrap their `open()` calls in `try`/`except` blocks. `FileNotFoundError` is caught in the read function to handle the case where `fruits.txt` does not exist. `PermissionError` is caught in both functions to handle access restriction errors. As Downey (2015) explains, catching specific named exceptions — rather than using a bare `except:` — is best practice because it allows unexpected errors to propagate normally rather than being silently swallowed (p. 145). The `read_dict_from_file` function returns an empty dictionary `{}` if an error occurs, allowing the rest of the program to handle the empty result gracefully rather than crashing.

The program cleanly separates its three responsibilities — reading, inverting, and writing — into three distinct functions, making each independently testable and reusable. This modular design reflects the structured programming principles covered throughout CS1101.

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist* (2nd ed.). Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

Schafer, C. (2016, April 29). *Python tutorial: File objects - Reading and writing to files* [Video]. YouTube. https://youtu.be/Uh2ebFW8OYM

W3Schools. (n.d.). *Python file open*. https://www.w3schools.com/python/python_file_open.asp

---

**Word Count**: ~560 words (explanation section, excluding code, title, and references)
