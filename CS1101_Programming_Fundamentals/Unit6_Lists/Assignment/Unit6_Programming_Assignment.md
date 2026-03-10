# CS1101 Unit 6 Programming Assignment

**Name**: Nicanor Kyamba  
**Course**: CS1101 Programming Fundamentals  
**Unit**: 6 — Lists  
**Date**: February 2026

---

## Part (a): Employee List Operations

### Overview

This section demonstrates list creation, slicing, appending, deletion, merging, in-place modification with a loop, and sorting — all core list operations covered in Chapter 10 of Downey (2015).

---

### Step 1: Create the Employee List and Split into Sub-Lists

A list of 10 employee names is created, then split into two sub-lists of 5 using slice notation. Slicing with `[:5]` extracts indices 0–4 and `[5:]` extracts indices 5–9, producing two independent sub-lists (Downey, 2015, p. 100).

```python
employees = [
    'Alice Johnson', 'Bob Martinez', 'Carol White', 'David Lee', 'Emma Davis',
    'Frank Wilson', 'Grace Taylor', 'Henry Brown', 'Isla Clark', 'James Moore'
]

subList1 = employees[:5]
subList2 = employees[5:]
print("subList1:", subList1)
print("subList2:", subList2)
```

**Output**:
```
subList1: ['Alice Johnson', 'Bob Martinez', 'Carol White', 'David Lee', 'Emma Davis']
subList2: ['Frank Wilson', 'Grace Taylor', 'Henry Brown', 'Isla Clark', 'James Moore']
```

---

### Step 2: Add New Employee to subList2

The `append()` method adds a single element to the end of a list, modifying it in place. The new employee 'Kriti Brown' is added to `subList2`.

```python
subList2.append('Kriti Brown')
print("subList2 after append:", subList2)
```

**Output**:
```
subList2 after append: ['Frank Wilson', 'Grace Taylor', 'Henry Brown', 'Isla Clark', 'James Moore', 'Kriti Brown']
```

---

### Step 3: Remove Second Employee from subList1

The second employee is at index 1 (Python uses zero-based indexing). The `del` statement removes the element at that index, shifting all subsequent elements left by one position.

```python
del subList1[1]
print("subList1 after removing 2nd employee:", subList1)
```

**Output**:
```
subList1 after removing 2nd employee: ['Alice Johnson', 'Carol White', 'David Lee', 'Emma Davis']
```

'Bob Martinez' (index 1) is removed. `subList1` now contains 4 employees.

---

### Step 4: Merge Both Lists

The `+` operator concatenates two lists, creating a new merged list. `subList1` (4 names) and `subList2` (6 names, including Kriti Brown) combine into a 10-element list.

```python
merged = subList1 + subList2
print("Merged list:", merged)
print("Total employees:", len(merged))
```

**Output**:
```
Merged list: ['Alice Johnson', 'Carol White', 'David Lee', 'Emma Davis', 'Frank Wilson', 'Grace Taylor', 'Henry Brown', 'Isla Clark', 'James Moore', 'Kriti Brown']
Total employees: 10
```

---

### Step 5: Apply 4% Raise to salaryList

A `salaryList` of 11 salaries (one per current employee) is defined. A `for` loop with `range(len(salaryList))` iterates over each index, multiplying each salary by `1.04` to apply a 4% raise and updating the element in place. `round(..., 2)` ensures clean two-decimal currency values.

```python
salaryList = [52000, 61000, 47000, 73000, 55000, 68000, 49000, 82000, 57000, 63000, 45000]
print("Salaries before raise:", salaryList)

for i in range(len(salaryList)):
    salaryList[i] = round(salaryList[i] * 1.04, 2)

print("Salaries after 4% raise:", salaryList)
```

**Output**:
```
Salaries before raise: [52000, 61000, 47000, 73000, 55000, 68000, 49000, 82000, 57000, 63000, 45000]
Salaries after 4% raise: [54080.0, 63440.0, 48880.0, 75920.0, 57200.0, 70720.0, 50960.0, 85280.0, 59280.0, 65520.0, 46800.0]
```

Because lists are mutable, each `salaryList[i] = ...` assignment directly updates the element at that index in the original list.

---

### Step 6: Sort and Show Top 3 Salaries

`sort(reverse=True)` sorts `salaryList` in descending order in place. A slice `[:3]` then extracts the first three elements — the three highest salaries.

```python
salaryList.sort(reverse=True)
print("Top 3 salaries:", salaryList[:3])
```

**Output**:
```
Top 3 salaries: [85280.0, 75920.0, 70720.0]
```

The top three salaries after the 4% raise are $85,280.00, $75,920.00, and $70,720.00.

---

## Part (b): Sentence to Reversed Word List

### Overview

This section uses `split()` to convert a sentence string into a list of words, then `reverse()` to reverse the list in place. This demonstrates the relationship between strings and lists, and the use of in-place list methods (Downey, 2015, p. 102).

```python
sentence = "Python lists are powerful and flexible"
word_list = sentence.split()
print("Original word list:", word_list)

word_list.reverse()
print("Reversed word list:", word_list)
```

**Output**:
```
Original word list: ['Python', 'lists', 'are', 'powerful', 'and', 'flexible']
Reversed word list: ['flexible', 'and', 'powerful', 'are', 'lists', 'Python']
```

### Technical Explanation

`sentence.split()` with no argument splits on any whitespace, returning a list where each word is a separate string element. The result is `['Python', 'lists', 'are', 'powerful', 'and', 'flexible']` — a 6-element list.

`word_list.reverse()` reverses the list in place, meaning it modifies the original list object directly and returns `None`. The last word 'flexible' becomes the first element, and 'Python' moves to the last position. This is the inverse of the original sentence's word order.

The combination of `split()` and `reverse()` is a practical pattern for text processing tasks such as reversing sentence word order, checking palindromes at the word level, or reordering data fields in a pipeline.

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist*. Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

---

**Word Count**: ~750 words
