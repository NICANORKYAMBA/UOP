# Chapter 8: Strings - Learning Notes

**Course**: CS1101 Programming Fundamentals  
**Unit**: 5 - Iteration and Strings  
**Source**: Downey, A. (2015). *Think Python* (2nd ed.), Chapter 8 (pp. 71-79)

---

## 8.1 A String is a Sequence

A string is a **sequence of characters**. You can access individual characters using the bracket operator:

```python
fruit = 'banana'
letter = fruit[0]   # 'b'  (index starts at 0)
last = fruit[-1]    # 'a'  (negative index counts from end)
```

**Length**: Use `len()` to get the number of characters:
```python
length = len(fruit)   # 6
last = fruit[length - 1]   # 'a'  (same as fruit[-1])
```

---

## 8.2 len

```python
fruit = 'banana'
print(len(fruit))   # 6
```

**Common mistake**: Using `length` as an index causes IndexError because valid indices are 0 to length-1.

---

## 8.3 Traversal with a for Loop

Iterate over each character in a string:

```python
for letter in 'banana':
    print(letter)
```

**With index**:
```python
fruit = 'banana'
for i in range(len(fruit)):
    print(i, fruit[i])
```

---

## 8.4 String Slices

A **slice** extracts a substring using `[start:end]`:

```python
s = 'Monty Python'
print(s[0:5])    # 'Monty'
print(s[6:12])   # 'Python'
print(s[:5])     # 'Monty'   (start defaults to 0)
print(s[6:])     # 'Python'  (end defaults to len)
print(s[:])      # 'Monty Python'  (full copy)
print(s[::-1])   # 'nohtyP ytnoM'  (reversed)
```

**Slice syntax**: `s[start:end:step]`
- start: inclusive (defaults to 0)
- end: exclusive (defaults to len)
- step: increment (defaults to 1, use -1 to reverse)

---

## 8.5 Strings are Immutable

You **cannot** change a character in a string:

```python
greeting = 'Hello, world!'
greeting[0] = 'J'   # TypeError: 'str' object does not support item assignment
```

Instead, create a new string:
```python
new_greeting = 'J' + greeting[1:]   # 'Jello, world!'
```

---

## 8.6 Searching

Find the index of a character using a loop:

```python
def find(word, letter):
    index = 0
    while index < len(word):
        if word[index] == letter:
            return index
        index += 1
    return -1
```

Python's built-in `find()` method does the same:
```python
word = 'banana'
print(word.find('a'))    # 1  (first occurrence)
print(word.find('na'))   # 2  (works for substrings too)
print(word.find('z'))    # -1 (not found)
```

---

## 8.7 Looping and Counting

Count occurrences of a character:

```python
def count_letter(word, letter):
    count = 0
    for c in word:
        if c == letter:
            count += 1
    return count

# Built-in equivalent:
'banana'.count('a')   # 3
```

---

## 8.8 String Methods

Strings have built-in methods called with dot notation:

```python
word = 'banana'
word.upper()        # 'BANANA'
word.lower()        # 'banana'
word.capitalize()   # 'Banana'
word.strip()        # removes leading/trailing whitespace
word.replace('a', 'o')  # 'bonono'
word.split()        # splits on whitespace → list
```

### Boolean String Methods

```python
'banana'.islower()    # True  - all lowercase?
'BANANA'.isupper()    # True  - all uppercase?
'banana'.isalpha()    # True  - all alphabetic?
'123'.isdigit()       # True  - all digits?
'abc123'.isalnum()    # True  - all alphanumeric?
```

### Checking Membership with `in`

```python
'a' in 'banana'    # True
'z' in 'banana'    # False
'nan' in 'banana'  # True  (works for substrings)
```

---

## 8.9 The in Operator

The `in` operator checks if one string is a substring of another:

```python
def contains_vowel(word):
    for vowel in 'aeiou':
        if vowel in word:
            return True
    return False
```

---

## 8.10 String Comparison

Strings compare lexicographically (alphabetical order):

```python
'apple' < 'banana'   # True  (a comes before b)
'apple' == 'apple'   # True
'Banana' < 'banana'  # True  (uppercase letters have lower ASCII values)
```

**Tip**: Use `.lower()` for case-insensitive comparison:
```python
word.lower() == 'banana'
```

---

## String Methods Quick Reference

| Method | Description | Example |
|--------|-------------|---------|
| `s.upper()` | All uppercase | `'hi'.upper()` → `'HI'` |
| `s.lower()` | All lowercase | `'HI'.lower()` → `'hi'` |
| `s.islower()` | All lowercase? | `'hi'.islower()` → `True` |
| `s.isupper()` | All uppercase? | `'HI'.isupper()` → `True` |
| `s.isalpha()` | All letters? | `'hi'.isalpha()` → `True` |
| `s.isdigit()` | All digits? | `'12'.isdigit()` → `True` |
| `s.strip()` | Remove whitespace | `' hi '.strip()` → `'hi'` |
| `s.find(t)` | Index of t in s | `'banana'.find('a')` → `1` |
| `s.count(t)` | Count t in s | `'banana'.count('a')` → `3` |
| `s.replace(a,b)` | Replace a with b | `'hi'.replace('h','j')` → `'ji'` |
| `s.split()` | Split into list | `'a b'.split()` → `['a','b']` |
| `s.startswith(t)` | Starts with t? | `'hi'.startswith('h')` → `True` |
| `s.endswith(t)` | Ends with t? | `'hi'.endswith('i')` → `True` |

---

## Slicing Cheat Sheet

```python
s = 'Python'
s[0]      # 'P'       - first character
s[-1]     # 'n'       - last character
s[0:3]    # 'Pyt'     - first 3 characters
s[3:]     # 'hon'     - from index 3 to end
s[:3]     # 'Pyt'     - up to index 3
s[::-1]   # 'nohtyP'  - reversed
s[::2]    # 'Pto'     - every other character
```

---

## Key Terms

| Term | Definition |
|------|-----------|
| String | Immutable sequence of characters |
| Index | Integer position of a character (0-based) |
| Slice | Substring extracted using `[start:end]` |
| Traversal | Iterating through each element of a sequence |
| Immutable | Cannot be changed after creation |
| Method | Function associated with an object, called with dot notation |
| Substring | A portion of a string |

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist* (2nd ed.). Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

Khan Academy. (2011, June 30). *Fun with strings* [Video]. YouTube. https://youtu.be/iZAtkS0F-Zo
