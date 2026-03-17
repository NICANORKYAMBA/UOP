# invert_dict.py — CS1101 Unit 7 Programming Assignment

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
