# Unit 5 Quick Study Guide: Iteration and Strings

**Course**: CS1101 Programming Fundamentals  
**Unit**: 5 - Iteration and Strings

---

## Loop Comparison

| | for loop | while loop |
|--|----------|------------|
| **Use when** | Iterating over a sequence | Condition-based repetition |
| **Iteration** | Definite (known count) | Indefinite (unknown count) |
| **Syntax** | `for item in sequence:` | `while condition:` |
| **Risk** | None | Infinite loop |
| **Best for** | Strings, lists, ranges | User input, convergence |

---

## String Essentials

```python
s = 'Nicanor'

# Indexing
s[0]       # 'N'   (first)
s[-1]      # 'r'   (last)

# Slicing
s[:3]      # 'Nic'  (first 3)
s[3:]      # 'anor' (from index 3)
s[::-1]    # 'ronacin' (reversed)

# Length
len(s)     # 7

# Membership
'a' in s   # True
```

---

## Key String Methods

```python
s.islower()    # all lowercase?
s.isupper()    # all uppercase?
s.lower()      # convert to lowercase
s.upper()      # convert to uppercase
s.find('a')    # index of first 'a', -1 if not found
s.count('a')   # count occurrences of 'a'
s.replace('a','o')  # replace all 'a' with 'o'
```

---

## Common Patterns

```python
# Count vowels
count = 0
for c in s:
    if c in 'aeiouAEIOU':
        count += 1

# Reverse a string
reversed_s = s[::-1]

# First n characters
n = 3
print(s[:n])

# Search for lowercase
def has_lower(s):
    for c in s:
        if c.islower():
            return True
    return False
```

---

## Discussion Assignment — 5 Functions Analysis

| Function | What it does | Correct? | Bug |
|----------|-------------|----------|-----|
| `any_lowercase1` | Checks only first character | ❌ | Returns after first char |
| `any_lowercase2` | Always returns `'True'` (string) | ❌ | Checks `'c'` (literal), not `c` (variable) |
| `any_lowercase3` | Returns result for last character only | ❌ | Overwrites flag each iteration |
| `any_lowercase4` | Correctly checks all characters | ✅ | None |
| `any_lowercase5` | Returns False if ANY char is not lowercase | ❌ | Returns True only if ALL chars are lowercase |

---

## Exam Tips

- Strings are **immutable** — operations return new strings
- Indices start at **0**, negative indices count from end
- `for c in s` iterates character by character
- `break` exits the loop immediately
- `while True` with `break` is the sentinel pattern
- `s[::-1]` is the Pythonic way to reverse a string
- `islower()` returns False for non-letter characters (digits, spaces)

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist* (2nd ed.). Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf
