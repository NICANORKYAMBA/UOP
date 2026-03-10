# CS1101 Unit 6 Programming Assignment

**Name**: Nicanor Kyamba  
**Course**: CS1101 Programming Fundamentals  
**Unit**: 6 — Lists  
**Date**: March 2026

---

## Part (a): Employee List Operations

This section demonstrates six sequential list operations on an HR employee dataset: slicing, appending, deletion, merging, in-place updating, and sorting. All operations use Python list features covered in Chapter 10 of Downey (2015).

---

### Step 1 — Create the Employee List and Split into Sub-Lists

A list of 10 employee names is defined, then divided into two equal sub-lists using slice notation. `employees[:5]` extracts indices 0 through 4 into `subList1`, and `employees[5:]` extracts indices 5 through 9 into `subList2`. Slicing creates new independent list objects — modifying one sub-list does not affect the other or the original (Downey, 2015, p. 100).

```python
employees = [
    'Alice Johnson', 'Bob Martinez', 'Carol White', 'David Lee', 'Emma Davis',
    'Frank Wilson', 'Grace Taylor', 'Henry Brown', 'Isla Clark', 'James Moore'
]

subList1 = employees[:5]   # indices 0-4
subList2 = employees[5:]   # indices 5-9

print("subList1:", subList1)
print("subList2:", subList2)
```

**Output**:
```
subList1: ['Alice Johnson', 'Bob Martinez', 'Carol White', 'David Lee', 'Emma Davis']
subList2: ['Frank Wilson', 'Grace Taylor', 'Henry Brown', 'Isla Clark', 'James Moore']
```

---

### Step 2 — Add New Employee to subList2

The `append()` method adds a single element to the end of a list, modifying it in place and returning `None`. The new hire 'Kriti Brown' is appended to `subList2`, which now holds 6 names.

```python
subList2.append('Kriti Brown')
print("subList2 after append:", subList2)
```

**Output**:
```
subList2 after append: ['Frank Wilson', 'Grace Taylor', 'Henry Brown', 'Isla Clark', 'James Moore', 'Kriti Brown']
```

---

### Step 3 — Remove the Second Employee from subList1

Python uses zero-based indexing, so the second employee is at index 1. The `del` statement removes the element at that index and shifts all subsequent elements one position to the left. `subList1` shrinks from 5 to 4 elements.

```python
del subList1[1]   # removes 'Bob Martinez' (index 1)
print("subList1 after deletion:", subList1)
```

**Output**:
```
subList1 after deletion: ['Alice Johnson', 'Carol White', 'David Lee', 'Emma Davis']
```

---

### Step 4 — Merge Both Lists

The `+` operator concatenates two lists and returns a new list containing all elements of both operands in order. `subList1` (4 names) and `subList2` (6 names) merge into a 10-element list representing the current workforce.

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

### Step 5 — Apply 4% Raise to salaryList

A `salaryList` of 10 salaries — one per employee in the merged list — is defined. A `for` loop iterates over each index using `range(len(salaryList))`, multiplying each salary by `1.04` (a 4% increase) and writing the result back to the same index. `round(..., 2)` ensures clean two-decimal currency values. Because lists are mutable, each index assignment updates the original list object in place (Downey, 2015, p. 97).

```python
salaryList = [52000, 61000, 47000, 73000, 55000, 68000, 49000, 82000, 57000, 63000]
print("Salaries before raise:", salaryList)

for i in range(len(salaryList)):
    salaryList[i] = round(salaryList[i] * 1.04, 2)

print("Salaries after 4% raise:", salaryList)
```

**Output**:
```
Salaries before raise: [52000, 61000, 47000, 73000, 55000, 68000, 49000, 82000, 57000, 63000]
Salaries after 4% raise: [54080.0, 63440.0, 48880.0, 75920.0, 57200.0, 70720.0, 50960.0, 85280.0, 59280.0, 65520.0]
```

---

### Step 6 — Sort salaryList and Show Top 3 Salaries

`salaryList.sort(reverse=True)` sorts the list in descending order in place. A slice `[:3]` then extracts the first three elements — the three highest post-raise salaries.

```python
salaryList.sort(reverse=True)
print("Top 3 salaries:", salaryList[:3])
```

**Output**:
```
Top 3 salaries: [85280.0, 75920.0, 70720.0]
```

After the 4% raise, the three highest salaries are $85,280.00 (Henry Brown), $75,920.00 (David Lee), and $70,720.00 (Frank Wilson).

---

## Part (b): Sentence to Reversed Word List

This section converts a sentence string into a list of words using `split()`, then reverses that list in place using `reverse()`. It demonstrates the string-to-list relationship and the behaviour of in-place list methods.

```python
sentence = "Python lists are powerful and flexible"

# split() breaks the string on whitespace, returning a list of words
word_list = sentence.split()
print("Original word list:", word_list)

# reverse() reverses the list in place and returns None
word_list.reverse()
print("Reversed word list:", word_list)
```

**Output**:
```
Original word list: ['Python', 'lists', 'are', 'powerful', 'and', 'flexible']
Reversed word list: ['flexible', 'and', 'powerful', 'are', 'lists', 'Python']
```

### Technical Explanation

`sentence.split()` called with no argument splits on any whitespace character (spaces, tabs, newlines) and returns a new list where each word is a separate string element. The six-word sentence produces a six-element list: `['Python', 'lists', 'are', 'powerful', 'and', 'flexible']`.

`word_list.reverse()` is an in-place method — it rearranges the elements of the existing list object directly, without creating a new list, and returns `None`. After the call, the element that was at the last index (index 5, `'flexible'`) moves to index 0, and the element at index 0 (`'Python'`) moves to index 5. Every element's position is mirrored around the centre of the list.

This pattern — `split()` followed by `reverse()` — is a practical text-processing technique. It can be used to reverse the word order of a sentence, check whether a sentence reads the same forwards and backwards at the word level, or reorder structured data fields stored as delimited strings. Downey (2015) notes that `split()` is the inverse of `join()`, making it straightforward to convert between string and list representations of the same data (p. 102).

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist*. Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

---

**Word Count**: ~780 words
