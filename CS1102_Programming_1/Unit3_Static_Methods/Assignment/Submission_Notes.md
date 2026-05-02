# Submission Notes (Word/PDF)

## What to Include
- `Student.java`
- `StudentManagement.java`
- `StudentRecordApp.java`
- A short explanation:
  - Why student fields are private instance variables
  - Why student list and total count are private static variables
  - Which methods are static and why
- One output screenshot from a successful run

## Suggested Explanation Paragraph
The `Student` class uses private instance variables because each student has unique state. The `StudentManagement` class uses private static variables (`students` and `totalStudents`) because this data is shared across all operations and should exist once at class level. Administrative actions are implemented as static methods (`addStudent`, `updateStudent`, `findStudentById`) to centralize class-level behavior. This design satisfies encapsulation, supports clean menu-driven interaction, and demonstrates the difference between static and non-static members.
