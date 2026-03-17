# invert_dict.py — CS1101 Unit 7 Programming Assignment

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
