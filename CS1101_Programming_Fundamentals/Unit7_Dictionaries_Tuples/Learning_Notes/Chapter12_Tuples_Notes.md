# Chapter 12 — Tuples: Comprehensive Learning Notes

**Course**: CS1101 Programming Fundamentals  
**Unit**: 7  
**Source**: Downey, A. (2015). *Think Python*, Chapter 12

---

## 1. What Is a Tuple?

A tuple is an **immutable sequence** of values. Like lists, tuples can hold any type and support indexing and slicing. Unlike lists, tuples cannot be modified after creation.

```python
t = ('a', 'b', 'c')
print(t[0])     # a
print(t[1:3])   # ('b', 'c')
print(len(t))   # 3
```

Creating tuples:
```python
t1 = (1, 2, 3)          # standard
t2 = 1, 2, 3            # parentheses optional
t3 = ('single',)        # single-element tuple — trailing comma required
t4 = tuple([1, 2, 3])   # from a list
t5 = tuple('abc')       # from a string → ('a', 'b', 'c')
```

> A single value in parentheses without a comma is NOT a tuple: `(5)` is just `5`.

---

## 2. Tuple Immutability

```python
t = (1, 2, 3)
t[0] = 99       # TypeError: 'tuple' object does not support item assignment
```

Because tuples are immutable, they can be used as **dictionary keys** (lists cannot):

```python
locations = {}
locations[(40.7128, -74.0060)] = 'New York'
locations[(51.5074, -0.1278)]  = 'London'
```

---

## 3. Tuple Assignment

Python allows assigning multiple variables in one statement using tuple unpacking:

```python
a, b = 1, 2
print(a, b)     # 1 2

# Swap two variables elegantly
a, b = b, a
print(a, b)     # 2 1

# Unpack from a list or tuple
coords = (10, 20)
x, y = coords
print(x, y)     # 10 20
```

---

## 4. Tuples as Return Values

Functions can return multiple values by returning a tuple:

```python
def min_max(t):
    return min(t), max(t)   # returns a tuple

low, high = min_max([3, 1, 4, 1, 5, 9])
print(low, high)    # 1 9
```

---

## 5. The `zip` Function

`zip` takes two or more sequences and returns an iterator of tuples pairing corresponding elements:

```python
names  = ['Alice', 'Bob', 'Carol']
scores = [92, 85, 78]

for name, score in zip(names, scores):
    print(f'{name}: {score}')
# Alice: 92
# Bob: 85
# Carol: 78
```

`zip` stops at the shortest sequence. To convert to a list of tuples:

```python
pairs = list(zip(names, scores))
# [('Alice', 92), ('Bob', 85), ('Carol', 78)]
```

Building a dictionary from two lists using `zip`:

```python
d = dict(zip(names, scores))
# {'Alice': 92, 'Bob': 85, 'Carol': 78}
```

---

## 6. The `enumerate` Function

`enumerate` adds an index counter to any iterable, returning `(index, value)` tuples:

```python
fruits = ['apple', 'banana', 'cherry']

for i, fruit in enumerate(fruits):
    print(i, fruit)
# 0 apple
# 1 banana
# 2 cherry

# Start index at 1
for i, fruit in enumerate(fruits, start=1):
    print(i, fruit)
# 1 apple
# 2 banana
# 3 cherry
```

---

## 7. The `.items()` Method with Tuples

`dict.items()` returns a view of `(key, value)` tuples, which can be unpacked directly in a `for` loop:

```python
student_grades = {'Alice': 'A', 'Bob': 'B', 'Carol': 'A'}

for student, grade in student_grades.items():
    print(f'{student} received grade {grade}')

# Sort a dictionary by value using items()
sorted_grades = sorted(student_grades.items(), key=lambda x: x[1])
print(sorted_grades)
# [('Alice', 'A'), ('Carol', 'A'), ('Bob', 'B')]
```

---

## 8. Lists and Tuples Together

```python
# List of tuples — common data structure
records = [('Alice', 92), ('Bob', 85), ('Carol', 78)]

for name, score in records:
    print(name, score)

# Convert list of tuples to dict
d = dict(records)
```

---

## 9. Comparing Tuples

Tuples support comparison operators — Python compares element by element, left to right:

```python
(1, 2, 3) < (1, 2, 4)   # True  — first difference at index 2
(0, 1)    < (1, 0)       # True  — first element decides
```

This makes tuples useful for sorting by multiple criteria:

```python
students = [('Bob', 85), ('Alice', 92), ('Carol', 85)]
students.sort()   # sorts by name first (first element of each tuple)
```

---

## Key Differences: List vs Tuple vs Dictionary

| Feature | List | Tuple | Dictionary |
|---|---|---|---|
| Mutable | ✅ | ❌ | ✅ |
| Ordered | ✅ | ✅ | ✅ (insertion order, 3.7+) |
| Indexed by | Integer | Integer | Any immutable key |
| Can be dict key | ❌ | ✅ | ❌ |
| Syntax | `[1, 2]` | `(1, 2)` | `{'a': 1}` |

---

## Reference

Downey, A. (2015). *Think Python: How to think like a computer scientist*. Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf
