# CS1101 Unit 7 Discussion Assignment

**Name**: Nicanor Kyamba  
**Course**: CS1101 Programming Fundamentals  
**Unit**: 7 — Dictionaries and Tuples  
**Date**: March 2026

---

## Tuples with Loops: zip, enumerate, and items

Tuples are immutable sequences that become especially powerful when combined with Python's built-in looping tools. Downey (2015) notes that tuples are useful for "iterating through multiple lists at once, and iterating through the key-value pairs in a dictionary" (p. 121). This post demonstrates all three tools — `zip`, `enumerate`, and `.items()` — with original examples from a student grade tracking context.

---

### 1. The `zip` Function

`zip` takes two or more sequences and returns an iterator of tuples, pairing corresponding elements by position. It stops at the shortest sequence, so both lists must be the same length for complete pairing.

```python
students = ['Alice', 'Bob', 'Carol', 'David']
grades   = [88, 74, 95, 61]

# zip pairs each student with their grade as a tuple
for student, grade in zip(students, grades):
    print(f'{student}: {grade}')

# zip can also build a dictionary directly
grade_dict = dict(zip(students, grades))
print('Grade dictionary:', grade_dict)
```

**Output**:
```
Alice: 88
Bob: 74
Carol: 95
David: 61
Grade dictionary: {'Alice': 88, 'Bob': 74, 'Carol': 95, 'David': 61}
```

Each iteration unpacks a `(student, grade)` tuple produced by `zip`. The second use of `zip` inside `dict()` constructs a dictionary directly from two parallel lists — a concise and readable pattern for building key-value mappings from separate sequences.

---

### 2. The `enumerate` Function

`enumerate` wraps any iterable and yields `(index, value)` tuples, providing an automatic counter without needing a separate index variable. The `start` parameter controls the initial counter value.

```python
courses = ['CS1101', 'CS2402', 'CS2001', 'ENGL1102']

# enumerate yields (index, value) tuples starting at 1
for index, course in enumerate(courses, start=1):
    print(f'Course {index}: {course}')
```

**Output**:
```
Course 1: CS1101
Course 2: CS2402
Course 3: CS2001
Course 4: ENGL1102
```

Without `enumerate`, this would require `for i in range(len(courses))` and manual indexing. `enumerate` makes the intent clearer — we want both the position and the value — and eliminates the risk of off-by-one errors when the start index matters (Downey, 2015, p. 122).

---

### 3. The `.items()` Method

`dict.items()` returns a view of `(key, value)` tuples from a dictionary. Unpacking these tuples directly in a `for` loop is the idiomatic way to iterate over both keys and values simultaneously.

```python
grade_dict = {'Alice': 88, 'Bob': 74, 'Carol': 95, 'David': 61}

# .items() yields (key, value) tuples — unpack directly
for student, grade in grade_dict.items():
    status = 'Pass' if grade >= 70 else 'Fail'
    print(f'{student}: {grade} -> {status}')
```

**Output**:
```
Alice: 88 -> Pass
Bob: 74 -> Pass
Carol: 95 -> Pass
David: 61 -> Fail
```

Each `(student, grade)` pair is a tuple produced by `.items()`. The loop unpacks it into two named variables, making the code self-documenting. The conditional on the same line demonstrates how `.items()` enables compact, readable processing of dictionary data — in this case, classifying each student's result in a single pass.

---

## Discussion Question

All three tools — `zip`, `enumerate`, and `.items()` — yield tuples that are immediately unpacked in the loop header. What would happen if you needed to use `zip` on three lists simultaneously instead of two, and how would the tuple unpacking in the loop header change to accommodate the third value?

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist*. Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

---

**Word Count**: ~530 words
