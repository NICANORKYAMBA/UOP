# CS1101 Unit 7 Programming Assignment

**Name**: Nicanor Kyamba  
**Course**: CS1101 Programming Fundamentals  
**Unit**: 7 — Dictionaries and Tuples  
**Date**: March 2026

---

## Assignment: Inverting a Student-Course Dictionary

### Problem Statement

A teacher has a dictionary where each key is a student name and each value is a list of three courses that student is enrolled in. The teacher needs the inverse: a dictionary where each key is a course name and each value is a list of all students enrolled in that course. This requires writing a function that iterates over the original dictionary and restructures it so that each list item in the original values becomes a separate key in the inverted dictionary.

---

### The `invert_dict` Function

```python
def invert_dict(d):
    """
    Inverts a student->courses dictionary into a course->students dictionary.
    Each course key maps to a list of students enrolled in that course.
    """
    inverse = {}
    for student, courses in d.items():      # iterate over each student and their course list
        for course in courses:              # iterate over each course in the student's list
            if course not in inverse:
                inverse[course] = [student] # first student for this course
            else:
                inverse[course].append(student)  # add to existing list
    return inverse
```

---

### Full Program with Output

```python
# Original dictionary: student -> list of 3 courses
student_courses = {
    'Stud1': ['CS1101', 'CS2402', 'CS2001'],
    'Stud2': ['CS2402', 'CS2001', 'CS1102'],
    'Stud3': ['CS1101', 'CS1102', 'CS2402'],
}

print('Original dictionary:')
for student, courses in student_courses.items():
    print(f'  {student}: {courses}')

inverted = invert_dict(student_courses)

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
  Stud3: ['CS1101', 'CS1102', 'CS2402']

Inverted dictionary:
  CS1101: ['Stud1', 'Stud3']
  CS2402: ['Stud1', 'Stud2', 'Stud3']
  CS2001: ['Stud1', 'Stud2']
  CS1102: ['Stud2', 'Stud3']
```

---

### Technical Explanation

The `invert_dict` function solves the problem of restructuring a one-to-many dictionary mapping by reversing the relationship between keys and values. In the original dictionary, each student name (a string) maps to a list of three course codes. The inverted dictionary must map each course code to a list of all students enrolled in it — a fundamentally different structure where the original values become keys and the original keys become values.

The function begins by creating an empty dictionary called `inverse`. It then uses a nested loop structure to process the original dictionary. The outer loop calls `d.items()`, which returns `(key, value)` tuples — in this case, `(student, courses)` pairs. This is the idiomatic way to iterate over both keys and values simultaneously in Python (Downey, 2015, p. 113). The inner loop then iterates over each individual course in the student's course list, treating each course as a potential key in the inverted dictionary.

For each course encountered, the function checks whether that course already exists as a key in `inverse`. If it does not, a new entry is created with a list containing just the current student as its first element. If the course already exists — meaning a previous student was also enrolled in it — the current student's name is appended to the existing list using `append()`. This conditional check-and-append pattern is the standard approach for building a one-to-many mapping in Python, as described by Downey (2015, p. 114) in the context of inverting dictionaries.

The output confirms the logic: CS2402 appears in all three students' course lists, so its inverted entry contains all three — `['Stud1', 'Stud2', 'Stud3']`. CS1101 appears only in Stud1 and Stud3's lists, so its entry contains `['Stud1', 'Stud3']`. The function handles any number of students and any number of courses per student, making it a general-purpose dictionary inversion solution. The use of `d.items()` and list mutation via `append()` demonstrates two core dictionary and list operations working together to solve a practical data restructuring problem.

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist* (2nd ed.). Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

kjdElectronics. (2017, August 5). *Python beginner tutorial 8 - For loop, lists, and dictionaries* [Video]. YouTube. https://youtu.be/bE6mSBNp4YU

---

**Word Count**: ~490 words (technical explanation: ~310 words)
