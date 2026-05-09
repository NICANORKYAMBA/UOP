# CS 1102 — Unit 5 Programming Assignment
## Course Enrollment and Grade Management System

**Student**: Nicanor Kyamba
**Course**: CS 1102 — Programming 1
**Unit**: 5 — Objects and Classes

---

## 1. System Overview

This project implements a Course Enrollment and Grade Management System for a university using three Java classes: `Student`, `Course`, and `CourseManagement`. The system demonstrates:

- **Encapsulation** — all instance variables are `private`; access is controlled through `public` getter and setter methods
- **Instance methods** — manipulate the state of individual `Student` and `Course` objects
- **Static variables and methods** — track enrollment data shared across all instances of the `Course` class
- **Object-oriented design** — each class has a single, well-defined responsibility
- **Error handling** — invalid inputs, duplicate IDs, and capacity violations are all handled gracefully

---

## 2. How to Run the Program

### Prerequisites
- Java 17 or later installed (`java -version` to check)
- All three files in the same directory: `Student.java`, `Course.java`, `CourseManagement.java`

### Compilation
Open a terminal in the directory containing the files and run:
```
javac Student.java Course.java CourseManagement.java
```

### Running
```
java CourseManagement
```

### Using the Administrator Interface
The program displays a 9-option menu. Type the number and press Enter for each operation:

```
1 — Add a new course       (enter code, name, max capacity)
2 — Add a new student      (enter name, student ID)
3 — Enroll student         (enter student ID, then course code)
4 — Assign grade           (enter student ID, course code, grade 0.0–100.0)
5 — Calculate overall grade (enter student ID)
6 — View all courses
7 — View all students
8 — View total enrollments
9 — Exit
```

**Suggested test sequence:**
1. Add course: `CS1102`, `Programming 1`, capacity `30`
2. Add course: `MATH101`, `Calculus`, capacity `25`
3. Add student: `Alice Smith`, ID `1001`
4. Add student: `Bob Jones`, ID `1002`
5. Enroll student `1001` in `CS1102`
6. Enroll student `1001` in `MATH101`
7. Enroll student `1002` in `CS1102`
8. Assign grade: student `1001`, course `CS1102`, grade `92.5`
9. Assign grade: student `1001`, course `MATH101`, grade `88.0`
10. Calculate overall grade for student `1001`

---

## 3. Student Class — Documentation

### Purpose
Represents a university student. Encapsulates all student data and provides instance methods to enroll in courses and receive grades.

### Private Instance Variables

| Variable | Type | Purpose |
|----------|------|---------|
| `name` | `String` | Student's full name |
| `studentId` | `int` | Unique student identifier |
| `enrolledCourses` | `ArrayList<Course>` | List of courses the student is enrolled in |
| `grades` | `HashMap<String, Double>` | Maps course code to numeric grade |

All variables are `private` — enforcing encapsulation. No external code can directly read or modify them.

### Constructor
```java
public Student(String name, int studentId)
```
Initializes all instance variables. Uses `this.name = name` to distinguish the instance variable from the constructor parameter — the `this` keyword refers to the current object being constructed.

### Getter Methods
```java
public String getName()
public int getStudentId()
public ArrayList<Course> getEnrolledCourses()
public HashMap<String, Double> getGrades()
```
Provide read access to private variables without exposing the variables themselves.

### Setter Methods
```java
public void setName(String name)       // rejects null or empty strings
public void setStudentId(int studentId) // rejects non-positive IDs
```
Include validation — setters enforce data integrity before accepting a new value.

### Instance Methods

**`enrollCourse(Course course)`**
Adds the given course to the student's enrolled courses list. Checks for duplicates — a student cannot be enrolled in the same course twice. This method manipulates the object's state by modifying `enrolledCourses`.

**`assignGrade(Course course, double grade)`**
Stores a grade for the given course. Only executes if the student is enrolled in the course AND the grade is between 0.0 and 100.0. Manipulates the `grades` HashMap.

**`isEnrolledIn(Course course)`**
Returns `true` if the student is enrolled in the given course. Used by `CourseManagement` before enrolling or grading.

---

## 4. Course Class — Documentation

### Purpose
Represents a university course. Tracks its own enrollment count and contributes to a class-level total enrollment counter using a static variable.

### Private Instance Variables

| Variable | Type | Purpose |
|----------|------|---------|
| `courseCode` | `String` | Unique identifier (e.g., "CS1102") |
| `courseName` | `String` | Full course name |
| `maxCapacity` | `int` | Maximum students allowed |
| `currentEnrollment` | `int` | Current number of enrolled students |

### Static Variable
```java
private static int totalEnrolledStudents = 0;
```
This variable belongs to the **class itself**, not to any individual course object. There is exactly one copy of it in memory, shared across all `Course` instances. Every time any student is enrolled in any course, this counter increments. This is how static variables track information across multiple instances — they persist at the class level, not the object level.

### Getter Methods
```java
public String getCourseCode()
public String getCourseName()
public int getMaxCapacity()
public int getCurrentEnrollment()
```

### Instance Methods

**`hasSpace()`** — returns `true` if `currentEnrollment < maxCapacity`. Used before enrolling a student to prevent exceeding capacity.

**`incrementEnrollment()`** — increments both `currentEnrollment` (instance variable) and `totalEnrolledStudents` (static variable). Called by `CourseManagement.enrollStudent()` after a successful enrollment.

### Static Method
```java
public static int getTotalEnrolledStudents()
```
Returns the class-level total. Called as `Course.getTotalEnrolledStudents()` — it belongs to the class, not any instance. This is the correct way to access data that is shared across all instances.

---

## 5. CourseManagement Class — Documentation

### Purpose
The central management layer. Stores the system's data in private static variables and provides static methods for all administrative operations. Contains the `main()` method with the interactive administrator interface.

### Private Static Variables

```java
private static ArrayList<Course>  courses  = new ArrayList<>();
private static ArrayList<Student> students = new ArrayList<>();
```

These are `static` because the course and student lists belong to the system as a whole — they are not associated with any particular instance of `CourseManagement`. They are `private` to prevent external code from directly modifying the lists.

### Static Methods

**`addCourse(String courseCode, String courseName, int maxCapacity)`**
Creates a new `Course` object and adds it to the `courses` list. Checks for duplicate course codes before adding.

**`addStudent(String name, int studentId)`**
Creates a new `Student` object and adds it to the `students` list. Checks for duplicate student IDs before adding.

**`enrollStudent(Student student, Course course)`**
Validates that the student is not already enrolled and the course has space, then calls `student.enrollCourse(course)` and `course.incrementEnrollment()`. This demonstrates how `CourseManagement` delegates to instance methods on the `Student` and `Course` objects.

**`assignGrade(Student student, Course course, double grade)`**
Validates enrollment and grade range, then calls `student.assignGrade(course, grade)`.

**`calculateOverallGrade(Student student)`**
Iterates over the student's grades HashMap, computes the average, and converts to a letter grade using the private helper `getLetterGrade()`.

### How Static Methods and Variables Track Enrollment

The `CourseManagement` class uses static variables (`courses`, `students`) to maintain the system state across the entire program. The `Course` class uses a static variable (`totalEnrolledStudents`) to count all enrollments across all course instances. Because static variables belong to the class rather than any object, they persist and accumulate data regardless of how many objects are created or destroyed. This is the key advantage of static variables for system-wide tracking.

---

## 6. Full Program Code

### Student.java

```java
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Student.java
 * Represents a university student with encapsulated data and instance methods.
 */
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

    // Getters
    public String getName()                        { return name; }
    public int getStudentId()                      { return studentId; }
    public ArrayList<Course> getEnrolledCourses()  { return enrolledCourses; }
    public HashMap<String, Double> getGrades()     { return grades; }

    // Setters with validation
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) this.name = name;
    }
    public void setStudentId(int studentId) {
        if (studentId > 0) this.studentId = studentId;
    }

    // Enroll in a course — instance method that modifies object state
    public void enrollCourse(Course course) {
        if (!enrolledCourses.contains(course)) enrolledCourses.add(course);
    }

    // Assign a grade — validates enrollment and grade range
    public void assignGrade(Course course, double grade) {
        if (enrolledCourses.contains(course) && grade >= 0.0 && grade <= 100.0)
            grades.put(course.getCourseCode(), grade);
    }

    // Check enrollment status
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
/**
 * Course.java
 * Represents a university course. Uses a static variable to track
 * total enrollments across all Course instances.
 */
public class Course {

    private String courseCode;
    private String courseName;
    private int maxCapacity;
    private int currentEnrollment;

    // Static variable — ONE copy shared across ALL Course instances
    private static int totalEnrolledStudents = 0;

    public Course(String courseCode, String courseName, int maxCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maxCapacity = maxCapacity;
        this.currentEnrollment = 0;
    }

    // Getter methods
    public String getCourseCode()     { return courseCode; }
    public String getCourseName()     { return courseName; }
    public int getMaxCapacity()       { return maxCapacity; }
    public int getCurrentEnrollment() { return currentEnrollment; }

    // Check capacity
    public boolean hasSpace() { return currentEnrollment < maxCapacity; }

    // Increment both instance and static counters
    public void incrementEnrollment() {
        if (hasSpace()) {
            currentEnrollment++;
            totalEnrolledStudents++;
        }
    }

    // Static method — belongs to the class, not any instance
    public static int getTotalEnrolledStudents() { return totalEnrolledStudents; }

    @Override
    public String toString() {
        return courseCode + " — " + courseName +
               " (" + currentEnrollment + "/" + maxCapacity + " enrolled)";
    }
}
```

### CourseManagement.java

```java
import java.util.ArrayList;
import java.util.Scanner;

/**
 * CourseManagement.java
 * Central management class. Uses private static variables for system data
 * and static methods for all administrative operations.
 * Contains the main() method with the administrator interface.
 */
public class CourseManagement {

    // Private static variables — system-wide data
    private static ArrayList<Course>  courses  = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();

    // Add a new course to the system
    public static void addCourse(String courseCode, String courseName, int maxCapacity) {
        for (Course c : courses) {
            if (c.getCourseCode().equalsIgnoreCase(courseCode)) {
                System.out.println("Error: Course code '" + courseCode + "' already exists.");
                return;
            }
        }
        courses.add(new Course(courseCode, courseName, maxCapacity));
        System.out.println("Course added: " + courses.get(courses.size() - 1));
    }

    // Add a new student to the system
    public static void addStudent(String name, int studentId) {
        for (Student s : students) {
            if (s.getStudentId() == studentId) {
                System.out.println("Error: Student ID " + studentId + " already exists.");
                return;
            }
        }
        students.add(new Student(name, studentId));
        System.out.println("Student added: " + students.get(students.size() - 1));
    }

    // Enroll a student in a course — delegates to Student and Course instance methods
    public static void enrollStudent(Student student, Course course) {
        if (student.isEnrolledIn(course)) {
            System.out.println("Error: " + student.getName() +
                               " is already enrolled in " + course.getCourseCode());
            return;
        }
        if (!course.hasSpace()) {
            System.out.println("Error: " + course.getCourseCode() +
                               " has reached maximum capacity (" +
                               course.getMaxCapacity() + " students).");
            return;
        }
        student.enrollCourse(course);
        course.incrementEnrollment();
        System.out.println("Enrolled: " + student.getName() + " in " + course.getCourseCode());
    }

    // Assign a grade — delegates to Student instance method
    public static void assignGrade(Student student, Course course, double grade) {
        if (!student.isEnrolledIn(course)) {
            System.out.println("Error: " + student.getName() +
                               " is not enrolled in " + course.getCourseCode());
            return;
        }
        if (grade < 0.0 || grade > 100.0) {
            System.out.println("Error: Grade must be between 0.0 and 100.0.");
            return;
        }
        student.assignGrade(course, grade);
        System.out.println("Grade assigned: " + student.getName() +
                           " — " + course.getCourseCode() + " — " + grade);
    }

    // Calculate and display overall grade for a student
    public static void calculateOverallGrade(Student student) {
        if (student.getGrades().isEmpty()) {
            System.out.println(student.getName() + " has no grades recorded.");
            return;
        }
        double total = 0;
        int count = 0;
        System.out.println("\nGrades for " + student.getName() + ":");
        for (String code : student.getGrades().keySet()) {
            double grade = student.getGrades().get(code);
            System.out.printf("  %-10s : %.1f%n", code, grade);
            total += grade;
            count++;
        }
        double overall = total / count;
        System.out.printf("  Overall Average: %.2f%n", overall);
        System.out.println("  Letter Grade: " + getLetterGrade(overall));
    }

    private static String getLetterGrade(double grade) {
        if (grade >= 90) return "A";
        if (grade >= 80) return "B";
        if (grade >= 70) return "C";
        if (grade >= 60) return "D";
        return "F";
    }

    private static Course findCourse(String code) {
        for (Course c : courses)
            if (c.getCourseCode().equalsIgnoreCase(code)) return c;
        return null;
    }

    private static Student findStudent(int id) {
        for (Student s : students)
            if (s.getStudentId() == id) return s;
        return null;
    }

    private static void displayCourses() {
        if (courses.isEmpty()) { System.out.println("No courses available."); return; }
        System.out.println("\nAvailable Courses:");
        for (Course c : courses) System.out.println("  " + c);
    }

    private static void displayStudents() {
        if (students.isEmpty()) { System.out.println("No students registered."); return; }
        System.out.println("\nRegistered Students:");
        for (Student s : students) System.out.println("  " + s);
    }

    // Administrator Interface
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("==============================================");
        System.out.println("  Course Enrollment & Grade Management System");
        System.out.println("==============================================");

        while (running) {
            System.out.println("\n--- Administrator Menu ---");
            System.out.println("1. Add a new course");
            System.out.println("2. Add a new student");
            System.out.println("3. Enroll student in course");
            System.out.println("4. Assign grade to student");
            System.out.println("5. Calculate overall grade for student");
            System.out.println("6. View all courses");
            System.out.println("7. View all students");
            System.out.println("8. View total enrollments");
            System.out.println("9. Exit");
            System.out.print("Enter choice (1-9): ");

            int choice = 0;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number 1-9.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Course code: ");
                    String code = sc.nextLine().trim();
                    System.out.print("Course name: ");
                    String cname = sc.nextLine().trim();
                    System.out.print("Max capacity: ");
                    try {
                        int cap = Integer.parseInt(sc.nextLine().trim());
                        if (cap <= 0) { System.out.println("Capacity must be positive."); break; }
                        addCourse(code, cname, cap);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid capacity.");
                    }
                    break;

                case 2:
                    System.out.print("Student name: ");
                    String sName = sc.nextLine().trim();
                    System.out.print("Student ID: ");
                    try {
                        int id = Integer.parseInt(sc.nextLine().trim());
                        if (id <= 0) { System.out.println("ID must be positive."); break; }
                        addStudent(sName, id);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                    }
                    break;

                case 3:
                    displayStudents(); displayCourses();
                    System.out.print("Enter student ID: ");
                    try {
                        int sid = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Enter course code: ");
                        String ccode = sc.nextLine().trim();
                        Student st = findStudent(sid);
                        Course co = findCourse(ccode);
                        if (st == null) { System.out.println("Student ID not found."); break; }
                        if (co == null) { System.out.println("Course code not found."); break; }
                        enrollStudent(st, co);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid student ID.");
                    }
                    break;

                case 4:
                    displayStudents(); displayCourses();
                    System.out.print("Enter student ID: ");
                    try {
                        int sid = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Enter course code: ");
                        String ccode = sc.nextLine().trim();
                        System.out.print("Enter grade (0.0 - 100.0): ");
                        double grade = Double.parseDouble(sc.nextLine().trim());
                        Student st = findStudent(sid);
                        Course co = findCourse(ccode);
                        if (st == null) { System.out.println("Student ID not found."); break; }
                        if (co == null) { System.out.println("Course code not found."); break; }
                        assignGrade(st, co, grade);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input.");
                    }
                    break;

                case 5:
                    displayStudents();
                    System.out.print("Enter student ID: ");
                    try {
                        int sid = Integer.parseInt(sc.nextLine().trim());
                        Student st = findStudent(sid);
                        if (st == null) { System.out.println("Student ID not found."); break; }
                        calculateOverallGrade(st);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid student ID.");
                    }
                    break;

                case 6: displayCourses(); break;
                case 7: displayStudents(); break;
                case 8:
                    System.out.println("Total enrollments: " +
                                       Course.getTotalEnrolledStudents());
                    break;
                case 9:
                    System.out.println("Exiting system. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1-9.");
            }
        }
        sc.close();
    }
}
```

---

## 7. Output (Screenshots)

*Open all three Java files in IntelliJ IDEA and insert screenshots below.*

### Screenshot 1 — IDE Screenshot
*[INSERT: IntelliJ editor showing CourseManagement.java with the project panel on the left showing Student.java, Course.java, and CourseManagement.java]*

### Screenshot 2 — Console Output: Add Courses and Students, Enroll, Assign Grades
*[INSERT: Console showing:*
- *Course added: CS1102 — Programming 1 (0/30 enrolled)*
- *Course added: MATH101 — Calculus (0/25 enrolled)*
- *Student added: Student[ID=1001, Name=Alice Smith, Courses=0]*
- *Student added: Student[ID=1002, Name=Bob Jones, Courses=0]*
- *Enrolled: Alice Smith in CS1102*
- *Enrolled: Alice Smith in MATH101*
- *Grade assigned: Alice Smith — CS1102 — 92.5*
- *Grade assigned: Alice Smith — MATH101 — 88.0]*

### Screenshot 3 — Console Output: Calculate Overall Grade and Error Handling
*[INSERT: Console showing:*
- *Grades for Alice Smith: CS1102: 92.5, MATH101: 88.0, Overall Average: 90.25, Letter Grade: A*
- *Error message when trying to enroll a student in a full course*
- *Error message when entering an invalid menu choice]*

---

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, Swing ed.). Creative Commons CC 4.0. https://math.hws.edu/javanotes/
