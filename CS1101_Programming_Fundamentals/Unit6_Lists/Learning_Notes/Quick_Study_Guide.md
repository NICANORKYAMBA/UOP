# Unit 6 Quick Study Guide — Lists

**Course**: CS1101 Programming Fundamentals

---

## The Big Picture

Lists are Python's most versatile sequence type. The key insight of this unit:  
**Mutability creates power but also risk** — aliasing means changes can propagate unexpectedly.

---

## Mnemonic: AEIRSP — The 6 Core List Concepts

| Letter | Concept | One-liner |
|---|---|---|
| **A** | Aliasing | Two names, one object |
| **E** | Equivalent vs. Identical | `==` vs. `is` |
| **I** | In-place methods | `sort()`, `append()` return `None` |
| **R** | Reference passing | Functions get the real list |
| **S** | Slice = copy | `t[:]` makes a new list |
| **P** | Pop/del/remove | Three ways to delete |

---

## Essential Syntax Cheat Sheet

```python
# Create
t = [1, 2, 3]

# Access
t[0]        # first element
t[-1]       # last element
t[1:3]      # slice → new list

# Modify
t[0] = 99           # change element
t.append(4)         # add to end
t.extend([5, 6])    # add multiple
t.insert(1, 'x')    # insert at index

# Delete
del t[0]            # by index
t.remove(99)        # by value
x = t.pop()         # remove last, return it

# Info
len(t)              # length
t.index(3)          # find index of value
3 in t              # membership test → True/False

# Sort
t.sort()            # in place, returns None
sorted(t)           # returns NEW sorted list

# Copy
copy = t[:]         # slice copy
copy = list(t)      # list() copy

# String ↔ List
'hello'.split()     # string → word list
' '.join(t)         # list → string
```

---

## Equivalent vs. Identical — The Core Distinction

```python
a = [1, 2, 3]
b = [1, 2, 3]
c = a

a == b   # True  — same values (equivalent)
a is b   # False — different objects
a is c   # True  — same object (identical/alias)
```

**Memory model**:
- `a` and `b` → two separate boxes, both containing `[1, 2, 3]`
- `a` and `c` → two labels on the **same** box

---

## Aliasing Danger

```python
original = [1, 2, 3]
alias = original        # ALIAS — same object
safe_copy = original[:] # COPY — new object

alias.append(99)
print(original)   # [1, 2, 3, 99]  ← changed!
print(safe_copy)  # [1, 2, 3]      ← safe
```

---

## Functions and Lists

```python
# This WORKS — modifies original
def add_item(lst, item):
    lst.append(item)

# This FAILS — reassignment is local only
def bad_add(lst, item):
    lst = lst + [item]   # new list, original unchanged
```

---

## Map / Filter / Reduce Pattern

```python
nums = [1, 2, 3, 4, 5]

# Reduce
total = sum(nums)                          # 15

# Map (list comprehension)
doubled = [x * 2 for x in nums]           # [2, 4, 6, 8, 10]

# Filter (list comprehension)
evens = [x for x in nums if x % 2 == 0]  # [2, 4]
```

---

## Common Exam Questions

**Q: What does `a is b` test?**  
A: Whether `a` and `b` refer to the exact same object in memory (identity, not equality).

**Q: Why does `t = t.sort()` break your code?**  
A: `sort()` returns `None`. Use `t.sort()` alone.

**Q: How do you safely copy a list?**  
A: `copy = t[:]` or `copy = list(t)`.

**Q: What is aliasing?**  
A: When two variables reference the same list object. Modifying one modifies both.

**Q: What's the difference between `append()` and `extend()`?**  
A: `append([4,5])` adds the list as one element; `extend([4,5])` adds each element individually.

```python
t = [1, 2]
t.append([3, 4])   # [1, 2, [3, 4]]
t = [1, 2]
t.extend([3, 4])   # [1, 2, 3, 4]
```

---

## Reference

Downey, A. (2015). *Think Python: How to think like a computer scientist*. Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf
