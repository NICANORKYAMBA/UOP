# Chapter 10 - Lists: Comprehensive Learning Notes

**Course**: CS1101 Programming Fundamentals  
**Unit**: 6  
**Source**: Downey, A. (2015). *Think Python*, Chapter 10

---

## 1. What Is a List?

A **list** is a sequence of values. Unlike strings (which only hold characters), list elements can be any type — integers, floats, strings, even other lists.

```python
cheeses = ['Cheddar', 'Edam', 'Gouda']
numbers = [42, 123]
empty   = []
mixed   = ['hello', 3.14, True, [1, 2]]
```

Lists are **mutable** — you can change, add, or remove elements after creation. This is the key difference from strings.

---

## 2. Accessing and Traversing Lists

### Index Access
```python
cheeses = ['Cheddar', 'Edam', 'Gouda']
print(cheeses[0])   # Cheddar
print(cheeses[-1])  # Gouda  (negative index counts from end)
```

### Traversal with `for`
```python
for cheese in cheeses:
    print(cheese)
```

### Traversal with index (when you need the index)
```python
numbers = [10, 20, 30]
for i in range(len(numbers)):
    numbers[i] = numbers[i] * 2
# numbers is now [20, 40, 60]
```

### Nested Lists
```python
nested = [[1, 2], [3, 4], [5, 6]]
print(nested[1])     # [3, 4]
print(nested[1][0])  # 3
```

---

## 3. List Operations

### Concatenation (`+`)
```python
a = [1, 2, 3]
b = [4, 5, 6]
c = a + b       # [1, 2, 3, 4, 5, 6]
```

### Repetition (`*`)
```python
[0] * 4         # [0, 0, 0, 0]
[1, 2] * 3      # [1, 2, 1, 2, 1, 2]
```

### Augmented Assignment (`+=`)
```python
a = [1, 2]
a += [3, 4]     # a is now [1, 2, 3, 4]  — modifies in place
```

---

## 4. List Slices

Slices work exactly like string slices — they return a **new list** (a copy).

```python
t = ['a', 'b', 'c', 'd', 'e']
t[1:3]    # ['b', 'c']
t[:3]     # ['a', 'b', 'c']
t[3:]     # ['d', 'e']
t[:]      # ['a', 'b', 'c', 'd', 'e']  — full copy
```

### Modifying with Slices
```python
t = ['a', 'b', 'c', 'd', 'e']
t[1:3] = ['x', 'y']
# t is now ['a', 'x', 'y', 'd', 'e']
```

---

## 5. The Eight List Methods

| Method | What It Does | Example |
|---|---|---|
| `append(x)` | Add `x` to end | `t.append('d')` |
| `extend(seq)` | Add all items from `seq` to end | `t.extend([4, 5])` |
| `insert(i, x)` | Insert `x` at index `i` | `t.insert(1, 'z')` |
| `remove(x)` | Remove first occurrence of `x` | `t.remove('b')` |
| `pop(i)` | Remove & return item at index `i` (default: last) | `t.pop()` |
| `sort()` | Sort in place (ascending by default) | `t.sort()` |
| `reverse()` | Reverse in place | `t.reverse()` |
| `index(x)` | Return index of first occurrence of `x` | `t.index('c')` |

```python
t = [3, 1, 4, 1, 5]
t.append(9)       # [3, 1, 4, 1, 5, 9]
t.sort()          # [1, 1, 3, 4, 5, 9]
t.reverse()       # [9, 5, 4, 3, 1, 1]
t.remove(1)       # [9, 5, 4, 3, 1]
x = t.pop()       # x=1, t=[9, 5, 4, 3]
t.insert(0, 0)    # [0, 9, 5, 4, 3]
```

> **Important**: `sort()`, `reverse()`, `append()`, `extend()` all return `None` — they modify the list in place.

---

## 6. Deleting Elements

Three ways to delete:

```python
t = ['a', 'b', 'c', 'd']

# 1. del by index
del t[1]          # t = ['a', 'c', 'd']

# 2. del by slice
del t[1:3]        # removes a range

# 3. remove by value
t.remove('a')     # removes first 'a'

# 4. pop — removes and returns
x = t.pop(0)      # removes index 0, returns it
```

---

## 7. Map, Filter, and Reduce

### Reduce — accumulate a single result
```python
def add_all(t):
    total = 0
    for x in t:
        total += x
    return total

# Python built-in shortcut:
sum([1, 2, 3, 4])   # 10
```

### Map — apply operation to every element
```python
def capitalize_all(t):
    result = []
    for s in t:
        result.append(s.capitalize())
    return result

# Using list comprehension (cleaner):
result = [s.capitalize() for s in t]
```

### Filter — select elements meeting a condition
```python
def only_upper(t):
    result = []
    for s in t:
        if s.isupper():
            result.append(s)
    return result

# Using list comprehension:
result = [s for s in t if s.isupper()]
```

---

## 8. Objects, Values, and Aliasing

This is the most conceptually important section of Chapter 10.

### Equivalent vs. Identical

```python
a = [1, 2, 3]
b = [1, 2, 3]

print(a == b)   # True  — equivalent (same values)
print(a is b)   # False — not identical (different objects in memory)
```

- `==` checks **value equality**
- `is` checks **object identity** (same memory address)

### Aliasing

```python
a = [1, 2, 3]
b = a           # b is an ALIAS for a — both point to same object

print(a is b)   # True — identical

b.append(4)
print(a)        # [1, 2, 3, 4] — a is also changed!
```

This is aliasing: two variable names referencing the **same object**. Modifying through one alias affects the other.

### Avoiding Aliasing — Use a Slice Copy

```python
a = [1, 2, 3]
b = a[:]        # b is a NEW list with same values

b.append(4)
print(a)        # [1, 2, 3]  — a is unchanged
print(b)        # [1, 2, 3, 4]
```

---

## 9. Lists as Function Arguments

Because lists are mutable and passed by reference, a function can modify the original list:

```python
def delete_head(t):
    del t[0]        # modifies the original list

letters = ['a', 'b', 'c']
delete_head(letters)
print(letters)      # ['b', 'c']
```

### The Danger: Reassignment vs. Modification

```python
def bad_delete_head(t):
    t = t[1:]       # creates a NEW local list — original unchanged!

letters = ['a', 'b', 'c']
bad_delete_head(letters)
print(letters)      # ['a', 'b', 'c']  — unchanged!
```

**Rule**: Operations that *modify* a list (append, del, sort) affect the original. Operations that *create a new list* (slice, +) do not.

---

## 10. `list()` Function and `split()`

### `list()` — convert string to list of characters
```python
s = 'hello'
t = list(s)     # ['h', 'e', 'l', 'l', 'o']
```

### `split()` — convert sentence to word list
```python
s = 'the quick brown fox'
t = s.split()           # ['the', 'quick', 'brown', 'fox']

# With delimiter:
s = 'one-two-three'
t = s.split('-')        # ['one', 'two', 'three']
```

### `join()` — inverse of split
```python
words = ['the', 'quick', 'brown', 'fox']
' '.join(words)         # 'the quick brown fox'
'-'.join(words)         # 'the-quick-brown-fox'
```

---

## 11. Debugging Lists

Common mistakes:

| Mistake | Problem | Fix |
|---|---|---|
| `t = t.sort()` | `sort()` returns `None` | Use `t.sort()` alone |
| `t = t.append(x)` | `append()` returns `None` | Use `t.append(x)` alone |
| Aliasing side effects | Modifying alias changes original | Use `b = a[:]` for a copy |
| `del t[i]` in a loop | Skips elements as indices shift | Iterate backwards or build new list |

---

## Key Vocabulary

| Term | Definition |
|---|---|
| **Mutable** | Object whose value can be changed |
| **Object** | Something a variable can refer to |
| **Reference** | The association between a variable name and an object |
| **Alias** | Two or more variables referring to the same object |
| **Equivalent** | Two objects with the same value (`==`) |
| **Identical** | Two variables pointing to the same object (`is`) |
| **Delimiter** | Character used to separate parts of a string in `split()` |

---

## Reference

Downey, A. (2015). *Think Python: How to think like a computer scientist*. Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf
