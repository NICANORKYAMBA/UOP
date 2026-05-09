# CS 1102 — Unit 5 Programming Assignment
## Course Enrollment and Grade Management System

**Student**: Nicanor Kyamba
**Course**: CS 1102 — Programming 1
**Unit**: 5 — Objects and Classes

---

## 1. System Overview

This system implements a Course Enrollment and Grade Management System for a university using three Java classes: `Student`, `Course`, and `CourseManagement`. The design demonstrates the core OOP principles covered in Unit 5 — encapsulation through private instance variables and public getter/setter methods, constructors for object initialization, static variables and methods for class-level data, and an interactive administrator interface with full error handling.

---

## 2. Student Class

The `Student` class encapsulates all data and behavior related to a university student. All instance variables are declared `private`, enforcing encapsulation as Eck (2022) recommends — "almost all member variables should be declared private" to give complete control over what can be done with the variable (Section 5.1.3).

**Private instance variables:**
- `String name` — student's full name
- `int studentId` — unique identifier
- `ArrayList<Course> enrolledCourses` — list of courses the student is enrolled in
- `HashMap<String, Double> grades` — maps course code to numeric grade

**Constructor:**
```java
public Student(String name, int studentId) {
    this.name = name;
    this.studentId = studentId;
    this.enrolledCourses = new ArrayList<>();
    this.grades = new HashMap<>();
}
```
The `this` keyword distinguishes instance variables from constructor parameters — a key use of `this` described by Eck (2022, Section 5.6.1).

**Public getter and setter methods** provide controlled access. Setters include validation:
```java
public void setName(String name) {
    if (name != null && !name.trim().isEmpty())
        this.name = name;   // reject null or empty names
}
```

**Key instance methods:**
- `enrollCourse(Course course)` — adds a course to the student's enrolled list
- `assignGrade(Course course, double grade)` — stores a grade only if the student is enrolled and the grade is valid (0.0–100.0)
- `isEnrolledIn(Course course)` — returns true if the student is enrolled in the given course

---

## 3. Course Class

The `Course` class encapsulates course information and uses a **static variable** to track total enrollments across all course instances.

**Private instance variables:**
- `String courseCode` — unique identifier (e.g., "CS1102")
- `String courseName` — full course name
- `int maxCapacity` — maximum students allowed
- `int currentEnrollment` — current number of enrolled students

**Static variable:**
```java
private static int totalEnrolledStudents = 0;
```
This variable belongs to the `Course` class itself, not to any individual course object. Every time a student is enrolled in any course, this counter increments. Eck (2022) explains that static variables are shared across all instances — there is only one copy, and it persists as long as the program runs (Section 5.1.1).

**Static method:**
```java
public static int getTotalEnrolledStudents() {
    return totalEnrolledStudents;
}
```
This method is called as `Course.getTotalEnrolledStudents()` — it belongs to the class, not any instance.

**Key instance methods:**
- `hasSpace()` — returns true if `currentEnrollment < maxCapacity`
- `incrementEnrollment()` — increments both the instance counter and the static total

---

## 4. CourseManagement Class

The `CourseManagement` class is the central management layer. It uses **private static variables** to store the lists of courses and students, and **static methods** for all operations.

**Private static variables:**
```java
private static ArrayList<Course>  courses  = new ArrayList<>();
private static ArrayList<Student> students = new ArrayList<>();
```

**Static methods:**
- `addCourse(String code, String name, int capacity)` — creates a new Course, checks for duplicate codes
- `addStudent(String name, int id)` — creates a new Student, checks for duplicate IDs
- `enrollStudent(Student, Course)` — validates enrollment (not already enrolled, course has space), then calls `student.enrollCourse()` and `course.incrementEnrollment()`
- `assignGrade(Student, Course, double)` — validates that student is enrolled and grade is in range, then calls `student.assignGrade()`
- `calculateOverallGrade(Student)` — iterates over the student's grades, computes average, converts to letter grade

**Error handling** is implemented throughout:
- Duplicate course codes and student IDs are rejected
- Enrollment in a full course is rejected with a clear message
- Assigning a grade to a non-enrolled student is rejected
- Invalid numeric inputs are caught with `try-catch (NumberFormatException)`
- Grades outside 0.0–100.0 are rejected

---

## 5. Administrator Interface

The `main()` method in `CourseManagement` provides a 9-option menu-driven interface:

```
1. Add a new course
2. Add a new student
3. Enroll student in course
4. Assign grade to student
5. Calculate overall grade for student
6. View all courses
7. View all students
8. View total enrollments
9. Exit
```

The menu runs in a `while` loop controlled by a `boolean running` flag variable. Menu input is read with `Integer.parseInt(sc.nextLine().trim())` inside a `try-catch` block to handle non-integer input gracefully.

---

## 6. Full Program Code

### Student.java

```java
import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    private String name;
    private int studentId;
    private ArrayList<Course> enrolledCourses;
    private HashMap<String, Double> grades;

    public Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
        this.enrolledCourses = new ArrayList<>();
        this.grades = new HashMap<>();
    }

    public String getName()      { return name; }
    public int getStudentId()    { return studentId; }
    public ArrayList<Course> getEnrolledCourses() { return enrolledCourses; }
    public HashMap<String, Double> getGrades()    { return grades; }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) this.name = name;
    }
    public void setStudentId(int studentId) {
        if (studentId > 0) this.studentId = studentId;
    }

    public void enrollCourse(Course course) {
        if (!enrolledCourses.contains(course)) enrolledCourses.add(course);
    }

    public void assignGrade(Course course, double grade) {
        if (enrolledCourses.contains(course) && grade >= 0.0 && grade <= 100.0)
            grades.put(course.getCourseCode(), grade);
    }

    public boolean isEnrolledIn(Course course) {
        return enrolledCourses.contains(course);
    }

    @Override
    public String toString() {
        return "Student[ID=" + studentId + ", Name=" + name +
               ", Courses=" + enrolledCourses.size() + "]";
    }
}
```

### Course.java

```java
public class Course {
    private String courseCode;
    private String courseName;
    private int maxCapacity;
    private int currentEnrollment;
    private static int totalEnrolledStudents = 0;

    public Course(String courseCode, String courseName, int maxCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maxCapacity = maxCapacity;
        this.currentEnrollment = 0;
    }

    public String getCourseCode()     { return courseCode; }
    public String getCourseName()     { return courseName; }
    public int getMaxCapacity()       { return maxCapacity; }
    public int getCurrentEnrollment() { return currentEnrollment; }

    public boolean hasSpace() { return currentEnrollment < maxCapacity; }

    public void incrementEnrollment() {
        if (hasSpace()) { currentEnrollment++; totalEnrolledStudents++; }
    }

    public static int getTotalEnrolledStudents() { return totalEnrolledStudents; }

    @Override
    public String toString() {
        return courseCode + " — " + courseName +
               " (" + currentEnrollment + "/" + maxCapacity + " enrolled)";
    }
}
```

### CourseManagement.java (main class — see full file for complete code)

Key static methods:
```java
public static void addCourse(String code, String name, int cap) { ... }
public static void addStudent(String name, int id) { ... }
public static void enrollStudent(Student s, Course c) { ... }
public static void assignGrade(Student s, Course c, double grade) { ... }
public static void calculateOverallGrade(Student s) { ... }
```

---

## 7. Sample Output

**Test run: Add courses, add students, enroll, assign grades, calculate overall:**

```
Course added: CS1102 — Programming 1 (0/30 enrolled)
Course added: MATH101 — Calculus (0/25 enrolled)
Student added: Student[ID=1001, Name=Alice Smith, Courses=0]
Student added: Student[ID=1002, Name=Bob Jones, Courses=0]
Enrolled: Alice Smith in CS1102
Enrolled: Bob Jones in CS1102
Enrolled: Alice Smith in MATH101
Grade assigned: Alice Smith — CS1102 — 92.5
Grade assigned: Alice Smith — MATH101 — 88.0
Grade assigned: Bob Jones — CS1102 — 75.0

Grades for Alice Smith:
  MATH101    : 88.0
  CS1102     : 92.5
  Overall Average: 90.25
  Letter Grade: A

Total enrollments across all courses: 3
```

---

## 8. Output (Screenshots)

*Open CourseManagement.java in IntelliJ IDEA and insert screenshots below.*

### Screenshot 1 — IDE Screenshot
*[INSERT: IntelliJ editor showing CourseManagement.java with project panel showing all three Java files]*

### Screenshot 2 — Console Output (Add courses, students, enroll, assign grades)
*[INSERT: Console showing the full test run above — course additions, student additions, enrollments, grade assignments]*

### Screenshot 3 — Console Output (Calculate overall grade + error handling)
*[INSERT: Console showing calculateOverallGrade output for Alice Smith (90.25, Letter A) and an error message when attempting to enroll a student in a full course or assign a grade to a non-enrolled student]*

---

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, Swing ed.). Creative Commons CC 4.0. https://math.hws.edu/javanotes/
