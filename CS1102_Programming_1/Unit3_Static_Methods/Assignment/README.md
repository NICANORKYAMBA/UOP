# Programming Assignment Unit 3 - Student Record Management System

## Overview
This Java console application provides an administrator menu to:
- Add new student records
- Update existing student information
- View student details by ID
- View all students

The implementation demonstrates:
- private instance variables in `Student`
- private static variables in `StudentManagement`
- static methods for student operations
- input and ID error handling

## File Structure
- `Student.java`: Student model with private instance fields (`name`, `id`, `age`, `grade`)
- `StudentManagement.java`: Class-level storage and operations using private static fields and static methods
- `StudentRecordApp.java`: Menu-driven administrator interface
- `Sample_Run_Output.txt`: Example output transcript

## How to Compile
From repository root, run:

```bash
javac CS1102_Programming_1/Unit3_Static_Methods/Assignment/*.java
```

## How to Run
```bash
java CS1102_Programming_1.Unit3_Static_Methods.Assignment.StudentRecordApp
```

## Example Workflow
1. Add two students
2. View student by ID
3. Update student grade
4. View all students
5. Exit

## Error Handling Implemented
- Non-numeric age input
- Negative age rejection
- Empty required fields
- Duplicate student ID protection
- Student ID not found during view/update

## Notes for Submission
For your Word or PDF submission, include:
1. Program code (the three Java files)
2. Short explanation of class roles and static vs non-static design
3. Output screenshot (you can use `Sample_Run_Output.txt` as the scripted run reference)
