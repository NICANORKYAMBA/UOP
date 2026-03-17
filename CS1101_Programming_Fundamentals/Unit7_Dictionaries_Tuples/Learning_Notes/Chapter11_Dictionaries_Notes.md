# Chapter 11 — Dictionaries: Comprehensive Learning Notes

**Course**: CS1101 Programming Fundamentals  
**Unit**: 7  
**Source**: Downey, A. (2015). *Think Python*, Chapter 11

---

## 1. What Is a Dictionary?

A dictionary is a mapping from **keys** to **values**. Unlike a list (which maps integer indices to values), a dictionary can use almost any immutable type as a key.

```python
# Create a dictionary
eng2sp = {'one': 'uno', 'two': 'dos', 'three': 'tres'}

# Access by key
print(eng2sp['two'])    # dos

# Add a new key-value pair
eng2sp['four'] = 'cuatro'

# Check length
print(len(eng2sp))      # 4
```

Key rules:
- Keys must be **immutable** (strings, integers, tuples)
- Values can be **any type** (lists, other dicts, etc.)
- Each key is **unique** — assigning to an existing key updates its value
- Dictionaries are **unordered** in concept (though Python 3.7+ preserves insertion order)

---

## 2. Dictionary Operations

```python
d = {'a': 1, 'b': 2, 'c': 3}

# Membership test — checks KEYS only
'a' in d        # True
1 in d          # False (1 is a value, not a key)

# Delete a key-value pair
del d['b']

# Get all keys, values, items
d.keys()        # dict_keys(['a', 'c'])
d.values()      # dict_values([1, 3])
d.items()       # dict_items([('a', 1), ('c', 3)])

# Safe access with get()
d.get('z', 0)   # returns 0 if 'z' not found (no KeyError)
```

---

## 3. Looping Through a Dictionary

```python
scores = {'Alice': 92, 'Bob': 85, 'Carol': 78}

# Loop over keys (default)
for name in scores:
    print(name, scores[name])

# Loop over key-value pairs with .items()
for name, score in scores.items():
    print(f'{name}: {score}')

# Loop over values only
for score in scores.values():
    print(score)
```

---

## 4. Reverse Lookup

A forward lookup finds a value given a key. A **reverse lookup** finds a key given a value. Since values are not unique, this may return multiple keys.

```python
def reverse_lookup(d, v):
    """Return list of keys whose value equals v."""
    return [k for k, val in d.items() if val == v]

grades = {'Alice': 'A', 'Bob': 'B', 'Carol': 'A'}
print(reverse_lookup(grades, 'A'))   # ['Alice', 'Carol']
```

---

## 5. Dictionaries and Lists

Values in a dictionary can be lists, enabling one-to-many mappings:

```python
# Build a dict mapping each letter to the words containing it
def invert(d):
    inverse = {}
    for key, value in d.items():
        if value not in inverse:
            inverse[value] = [key]
        else:
            inverse[value].append(key)
    return inverse
```

---

## 6. Global Variables

A **global variable** is defined outside all functions and accessible from anywhere in the module. To *modify* a global variable inside a function, you must declare it with `global`.

```python
count = 0   # global variable

def increment():
    global count    # declare intent to modify global
    count += 1

increment()
increment()
print(count)    # 2
```

Without `global`, assigning to `count` inside the function creates a new local variable instead.

---

## 7. Memos and Caching with Dictionaries

Dictionaries are ideal for memoization — caching previously computed results:

```python
memo = {}

def fibonacci(n):
    if n in memo:
        return memo[n]
    if n <= 1:
        result = n
    else:
        result = fibonacci(n-1) + fibonacci(n-2)
    memo[n] = result
    return result
```

---

## 8. Dictionary Methods Summary

| Method | Description |
|---|---|
| `d[key]` | Access value by key (raises `KeyError` if missing) |
| `d.get(key, default)` | Safe access with fallback default |
| `d[key] = value` | Add or update key-value pair |
| `del d[key]` | Remove key-value pair |
| `key in d` | Membership test on keys |
| `d.keys()` | View of all keys |
| `d.values()` | View of all values |
| `d.items()` | View of all (key, value) tuples |
| `d.update(other)` | Merge another dict into `d` |
| `d.pop(key)` | Remove and return value for key |

---

## Reference

Downey, A. (2015). *Think Python: How to think like a computer scientist*. Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf
