# CS1101 Unit 7 Programming Assignment

**Name**: Nicanor Kyamba  
**Course**: CS1101 Programming Fundamentals  
**Unit**: 7 — Dictionaries and Tuples  
**Date**: March 2026

---

## Assignment: Inverting a Student-Course Dictionary

### Problem Statement

A teacher maintains a dictionary in which each key is a student identifier and each value is a list of three courses that student is enrolled in. The teacher needs the inverse structure: a dictionary where each course code is a key and its value is a list of all students enrolled in that course. This requires a function that iterates over the original dictionary and restructures it so that each individual item in the original value lists becomes a separate key in the inverted dictionary, with the original keys collected into lists as the new values.

---

### The `invert_dict` Function

```python
def invert_dict(d):
    # Create an empty dictionary to hold the inverted result
    inverse = {}

    # Outer loop: iterate over each student and their list of courses
    for student, courses in d.items():

        # Inner loop: treat each course as a potential key in the inverse dict
        for course in courses:

            if course not in inverse:
                # First time seeing this course: create a new list with this student
                inverse[course] = [student]
            else:
                # Course already exists: append this student to the existing list
                inverse[course].append(student)

    return inverse
```

---

### Full Program and Output

```python
# Original dictionary: 2 students, each enrolled in 3 courses
student_courses = {
    'Stud1': ['CS1101', 'CS2402', 'CS2001'],
    'Stud2': ['CS2402', 'CS2001', 'CS1102'],
}

# Print the original dictionary
print('Original dictionary:')
for student, courses in student_courses.items():
    print(f'  {student}: {courses}')

# Call the invert function
inverted = invert_dict(student_courses)

# Print the inverted dictionary
print()
print('Inverted dictionary:')
for course, students in inverted.items():
    print(f'  {course}: {students}')
```

**Output**:
```
Original dictionary:
  Stud1: ['CS1101', 'CS2402', 'CS2001']
  Stud2: ['CS2402', 'CS2001', 'CS1102']

Inverted dictionary:
  CS1101: ['Stud1']
  CS2402: ['Stud1', 'Stud2']
  CS2001: ['Stud1', 'Stud2']
  CS1102: ['Stud2']
```

---

### Technical Explanation

The `invert_dict` function solves a data restructuring problem by reversing the relationship between keys and values in a dictionary. In the original dictionary, each student identifier — `'Stud1'` and `'Stud2'` — is a key that maps to a list of three course codes. The inverted dictionary must map each course code to a list of all students enrolled in it. This is a classic dictionary inversion problem described by Downey (2015), who notes that "each value in the original dictionary becomes a key in the new dictionary, and the corresponding keys become a list of values" (p. 114).

The function begins by initializing an empty dictionary called `inverse`. It then enters a nested loop structure. The outer loop uses `d.items()`, which returns `(key, value)` tuples — here unpacked as `(student, courses)` — allowing simultaneous access to both the student name and their course list on each iteration (Downey, 2015, p. 113). The inner loop then iterates over each individual course string within that student's list, treating each course as a candidate key for the inverted dictionary.

The conditional logic inside the inner loop is the core of the inversion. For each course, the function checks whether that course already exists as a key in `inverse` using the `in` operator. If it does not exist, a new entry is created with a list containing only the current student — `inverse[course] = [student]`. If the course already exists, the current student is appended to the existing list using `append()`. This check-and-append pattern is the standard approach for building one-to-many mappings in Python, as confirmed by Raj (2022) and W3Schools (n.d.) in their coverage of dictionary manipulation techniques.

The output confirms the logic precisely. `CS1101` appears only in `Stud1`'s course list, so its inverted entry is `['Stud1']`. `CS2402` and `CS2001` appear in both students' lists, so their entries are `['Stud1', 'Stud2']`. `CS1102` appears only in `Stud2`'s list, so its entry is `['Stud2']`. This matches the expected output from the assignment specification exactly. The function is general-purpose: it handles any number of students and any number of courses per student, making it a reusable solution for any similar data inversion task. The combination of `d.items()`, nested iteration, and in-place list mutation via `append()` demonstrates three fundamental Python dictionary and list operations working together (kjdElectronics, 2017).

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist* (2nd ed.). Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

kjdElectronics. (2017, August 5). *Python beginner tutorial 8 - For loop, lists, and dictionaries* [Video]. YouTube. https://youtu.be/bE6mSBNp4YU

Raj, A. (2022, March 3). *Reverse a dictionary in Python*. PythonForBeginners. https://www.pythonforbeginners.com/dictionary/reverse-a-dictionary-in-python

W3Schools. (n.d.). *Python dictionaries*. https://www.w3schools.com/python/python_dictionaries.asp

---

**Word Count**: ~560 words (technical explanation: ~340 words)
