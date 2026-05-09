# CS 1102 — Unit 5 Programming Assignment
## EnrollmentCourse Enrollment and Grade Management System

**EnrollmentStudent**: Nicanor Kyamba
**EnrollmentCourse**: CS 1102 — Programming 1
**Unit**: 5 — Objects and Classes

---

## 1. System Overview

This project implements a EnrollmentCourse Enrollment and Grade Management System for a university using three Java classes: `EnrollmentStudent`, `EnrollmentCourse`, and `EnrollmentSystem`. The design follows the object-oriented programming principles described by Eck (2022), where objects encapsulate both data and behavior, and classes serve as blueprints for creating those objects (Section 5.1). The system demonstrates:

- **Encapsulation** — all instance variables are `private`; access is controlled through `public` getter and setter methods, following Eck's (2022) recommendation that "almost all member variables should be declared private" (Section 5.1.3)
- **Instance methods** — manipulate the state of individual `EnrollmentStudent` and `EnrollmentCourse` objects; Eck (2022) explains that instance methods belong to individual objects and operate on their specific data (Section 5.1)
- **Static variables and methods** — track enrollment data shared across all instances; Eck (2022) explains that static variables belong to the class itself rather than any individual object, making them ideal for class-wide counters (Section 5.1.1)
- **Object-oriented design** — each class has a single, well-defined responsibility, reflecting the modularity that Liang (2020) identifies as a core benefit of OOP (p. 330)
- **Error handling** — invalid inputs and capacity violations handled using `try-catch` blocks, as demonstrated by Eck (2022, Section 3.7)

---

## 2. How to Run the Program

### Prerequisites
- Java 17 or later installed (`java -version` to check)
- All three files: EnrollmentStudent.java, EnrollmentCourse.java, EnrollmentSystem.java

### Compilation
Open a terminal in the directory containing the files and run:
```
javac CS1102_Programming_1/Unit5_Objects_Classes/Assignment/*.java
```

### Running
```
java -cp . CS1102_Programming_1.Unit5_Objects_Classes.Assignment.EnrollmentSystem
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

## 3. EnrollmentStudent Class — Documentation

### Purpose
Represents a university student. Encapsulates all student data and provides instance methods to enroll in courses and receive grades. Eck (2022) uses a `EnrollmentStudent` class as the primary example for introducing instance variables and methods, noting that each object gets its own copy of the non-static instance variables (Section 5.1.2).

### Private Instance Variables

| Variable | Type | Purpose |
|----------|------|---------|
| `name` | `String` | EnrollmentStudent's full name |
| `studentId` | `int` | Unique student identifier |
| `enrolledCourses` | `ArrayList<EnrollmentCourse>` | List of courses the student is enrolled in |
| `grades` | `HashMap<String, Double>` | Maps course code to numeric grade |

All variables are `private` — enforcing encapsulation. Eck (2022) states that making member variables private gives the programmer "complete control over what can be done with the variable" (Section 5.1.3).

### Constructor
```java
public EnrollmentStudent(String name, int studentId)
```
Initializes all instance variables. Uses `this.name = name` to distinguish the instance variable from the constructor parameter. Eck (2022) explains that `this` is a special variable automatically defined in any instance method or constructor that refers to the current object (Section 5.6.1). A constructor has no return type and must share the class name (Eck, 2022, Section 5.2.2).

### Getter Methods
```java
public String getName()
public int getStudentId()
public ArrayList<EnrollmentCourse> getEnrolledCourses()
public HashMap<String, Double> getGrades()
```
Provide read access to private variables. By convention, getter names begin with "get" followed by the capitalized variable name (Eck, 2022, Section 5.1.3).

### Setter Methods
```java
public void setName(String name)        // rejects null or empty strings
public void setStudentId(int studentId) // rejects non-positive IDs
```
Include validation. Eck (2022) demonstrates this with a `setTitle()` method that rejects null values, noting that setters "can take any action at all" including validation (Section 5.1.3).

### Instance Methods

**`enrollCourse(EnrollmentCourse course)`**
Adds the given course to the student's enrolled courses list. Checks for duplicates. This method manipulates the object's state by modifying `enrolledCourses`. Eck (2022) describes instance methods as subroutines that belong to individual objects and operate on their specific data (Section 5.1).

**`assignGrade(EnrollmentCourse course, double grade)`**
Stores a grade only if the student is enrolled and the grade is between 0.0 and 100.0.

**`isEnrolledIn(EnrollmentCourse course)`**
Returns `true` if the student is enrolled in the given course.

---

## 4. EnrollmentCourse Class — Documentation

### Purpose
Represents a university course. Tracks its own enrollment count and contributes to a class-level total using a static variable. Eck (2022) explains that a class can contain both static and non-static variables — static variables are part of the class itself, while instance variables belong to individual objects (Section 5.1.1).

### Private Instance Variables

| Variable | Type | Purpose |
|----------|------|---------|
| `courseCode` | `String` | Unique identifier (e.g., "CS1102") |
| `courseName` | `String` | Full course name |
| `maxCapacity` | `int` | Maximum students allowed |
| `currentEnrollment` | `int` | Current number of enrolled students |

All variables are `private`. Eck (2022) recommends this as standard practice to maintain encapsulation (Section 5.1.3).

### Static Variable
```java
private static int totalEnrolledStudents = 0;
```
This variable belongs to the **class itself**, not to any individual course object. There is exactly one copy in memory, shared across all `EnrollmentCourse` instances. Eck (2022) illustrates this with the `PlayerData` example: a static variable like `playerCount` is stored as part of the class in memory, while instance variables like `name` exist separately in each object (Section 5.1.1). Every time any student is enrolled in any course, this counter increments.

### Getter Methods
```java
public String getCourseCode()
public String getCourseName()
public int getMaxCapacity()
public int getCurrentEnrollment()
```
All getter methods are `public` to allow read access while keeping the underlying variables `private` (Eck, 2022, Section 5.1.3).

**`hasSpace()`** — returns `true` if `currentEnrollment < maxCapacity`. Used before enrolling a student to prevent exceeding capacity.

**`incrementEnrollment()`** — increments both `currentEnrollment` (instance variable) and `totalEnrolledStudents` (static variable). Called by `EnrollmentSystem.enrollStudent()` after a successful enrollment.

### Static Method
```java
public static int getTotalEnrolledStudents()
```
Returns the class-level total. Called as `EnrollmentCourse.getTotalEnrolledStudents()`. Eck (2022) notes that static methods are members of the class itself and can be called using the class name rather than an object reference (Section 4.2).

---

## 5. EnrollmentSystem Class — Documentation

### Purpose
The central management layer. Stores the system's data in private static variables and provides static methods for all administrative operations. Contains the `main()` method with the interactive administrator interface. Eck (2022) describes this pattern as using a class to group together related subroutines and variables, which is one of the primary purposes of classes in Java (Section 4.2).

### Private Static Variables

```java
private static ArrayList<EnrollmentCourse>  courses  = new ArrayList<>();
private static ArrayList<EnrollmentStudent> students = new ArrayList<>();
```

These are `static` because the course and student lists belong to the system as a whole — not to any particular instance. They are `private` to prevent external code from directly modifying the lists, enforcing encapsulation (Eck, 2022, Section 5.1.3). `ArrayList` is used rather than a fixed array because the number of courses and students is not known in advance — ArrayList's dynamic resizing handles this automatically (Eck, 2022, Section 7.3).

### Static Methods

**`addCourse(String courseCode, String courseName, int maxCapacity)`**
Creates a new `EnrollmentCourse` object using the `new` operator and adds it to the `courses` list. Checks for duplicate course codes. Eck (2022) explains that the `new` operator allocates memory for the object, initializes its instance variables, and returns a reference to the newly created object (Section 5.2.2).

**`addStudent(String name, int studentId)`**
Creates a new `EnrollmentStudent` object and adds it to the `students` list. Checks for duplicate student IDs.

**`enrollStudent(EnrollmentStudent student, EnrollmentCourse course)`**
Validates that the student is not already enrolled and the course has space, then calls `student.enrollCourse(course)` and `course.incrementEnrollment()`. This demonstrates how `EnrollmentSystem` delegates to instance methods on the `EnrollmentStudent` and `EnrollmentCourse` objects — a key aspect of OOP where behavior is defined within the objects that own the data (Eck, 2022, Section 5.1).

**`assignGrade(EnrollmentStudent student, EnrollmentCourse course, double grade)`**
Validates enrollment and grade range, then calls `student.assignGrade(course, grade)`.

**`calculateOverallGrade(EnrollmentStudent student)`**
Iterates over the student's grades HashMap, computes the average, and converts to a letter grade. Liang (2020) notes that computing averages from stored data is a common pattern that demonstrates the practical value of encapsulated data structures (p. 385).

### How Static Methods and Variables Track Enrollment

The `EnrollmentSystem` class uses static variables (`courses`, `students`) to maintain the system state across the entire program. The `EnrollmentCourse` class uses a static variable (`totalEnrolledStudents`) to count all enrollments across all course instances. Because static variables belong to the class rather than any object, they persist and accumulate data regardless of how many objects are created or destroyed. Eck (2022) explains this distinction clearly: static variables are stored as part of the class representation in memory and exist as long as the program runs, while instance variables exist only as long as the object that contains them (Section 5.1.1). This is the key advantage of static variables for system-wide tracking.

---

## 6. Full Program Code

### EnrollmentStudent.java

```java
import java.util.ArrayList;
import java.util.HashMap;

/**
 * EnrollmentStudent.java
 * Represents a university student with encapsulated data and instance methods.
 */
public class EnrollmentStudent {

    private String name;
    private int studentId;
    private ArrayList<EnrollmentCourse> enrolledCourses;
    private HashMap<String, Double> grades;

    public EnrollmentStudent(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
        this.enrolledCourses = new ArrayList<>();
        this.grades = new HashMap<>();
    }

    // Getters
    public String getName()                        { return name; }
    public int getStudentId()                      { return studentId; }
    public ArrayList<EnrollmentCourse> getEnrolledCourses()  { return enrolledCourses; }
    public HashMap<String, Double> getGrades()     { return grades; }

    // Setters with validation
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) this.name = name;
    }
    public void setStudentId(int studentId) {
        if (studentId > 0) this.studentId = studentId;
    }

    // Enroll in a course — instance method that modifies object state
    public void enrollCourse(EnrollmentCourse course) {
        if (!enrolledCourses.contains(course)) enrolledCourses.add(course);
    }

    // Assign a grade — validates enrollment and grade range
    public void assignGrade(EnrollmentCourse course, double grade) {
        if (enrolledCourses.contains(course) && grade >= 0.0 && grade <= 100.0)
            grades.put(course.getCourseCode(), grade);
    }

    // Check enrollment status
    public boolean isEnrolledIn(EnrollmentCourse course) {
        return enrolledCourses.contains(course);
    }

    @Override
    public String toString() {
        return "EnrollmentStudent[ID=" + studentId + ", Name=" + name +
               ", Courses=" + enrolledCourses.size() + "]";
    }
}
```

### EnrollmentCourse.java

```java
/**
 * EnrollmentCourse.java
 * Represents a university course. Uses a static variable to track
 * total enrollments across all EnrollmentCourse instances.
 */
public class EnrollmentCourse {

    private String courseCode;
    private String courseName;
    private int maxCapacity;
    private int currentEnrollment;

    // Static variable — ONE copy shared across ALL EnrollmentCourse instances
    private static int totalEnrolledStudents = 0;

    public EnrollmentCourse(String courseCode, String courseName, int maxCapacity) {
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

### EnrollmentSystem.java

```java
import java.util.ArrayList;
import java.util.Scanner;

/**
 * EnrollmentSystem.java
 * Central management class. Uses private static variables for system data
 * and static methods for all administrative operations.
 * Contains the main() method with the administrator interface.
 */
public class EnrollmentSystem {

    // Private static variables — system-wide data
    private static ArrayList<EnrollmentCourse>  courses  = new ArrayList<>();
    private static ArrayList<EnrollmentStudent> students = new ArrayList<>();

    // Add a new course to the system
    public static void addCourse(String courseCode, String courseName, int maxCapacity) {
        for (EnrollmentCourse c : courses) {
            if (c.getCourseCode().equalsIgnoreCase(courseCode)) {
                System.out.println("Error: EnrollmentCourse code '" + courseCode + "' already exists.");
                return;
            }
        }
        courses.add(new EnrollmentCourse(courseCode, courseName, maxCapacity));
        System.out.println("EnrollmentCourse added: " + courses.get(courses.size() - 1));
    }

    // Add a new student to the system
    public static void addStudent(String name, int studentId) {
        for (EnrollmentStudent s : students) {
            if (s.getStudentId() == studentId) {
                System.out.println("Error: EnrollmentStudent ID " + studentId + " already exists.");
                return;
            }
        }
        students.add(new EnrollmentStudent(name, studentId));
        System.out.println("EnrollmentStudent added: " + students.get(students.size() - 1));
    }

    // Enroll a student in a course — delegates to EnrollmentStudent and EnrollmentCourse instance methods
    public static void enrollStudent(EnrollmentStudent student, EnrollmentCourse course) {
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

    // Assign a grade — delegates to EnrollmentStudent instance method
    public static void assignGrade(EnrollmentStudent student, EnrollmentCourse course, double grade) {
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
    public static void calculateOverallGrade(EnrollmentStudent student) {
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

    private static EnrollmentCourse findCourse(String code) {
        for (EnrollmentCourse c : courses)
            if (c.getCourseCode().equalsIgnoreCase(code)) return c;
        return null;
    }

    private static EnrollmentStudent findStudent(int id) {
        for (EnrollmentStudent s : students)
            if (s.getStudentId() == id) return s;
        return null;
    }

    private static void displayCourses() {
        if (courses.isEmpty()) { System.out.println("No courses available."); return; }
        System.out.println("\nAvailable Courses:");
        for (EnrollmentCourse c : courses) System.out.println("  " + c);
    }

    private static void displayStudents() {
        if (students.isEmpty()) { System.out.println("No students registered."); return; }
        System.out.println("\nRegistered Students:");
        for (EnrollmentStudent s : students) System.out.println("  " + s);
    }

    // Administrator Interface
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("==============================================");
        System.out.println("  EnrollmentCourse Enrollment & Grade Management System");
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
                    System.out.print("EnrollmentCourse code: ");
                    String code = sc.nextLine().trim();
                    System.out.print("EnrollmentCourse name: ");
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
                    System.out.print("EnrollmentStudent name: ");
                    String sName = sc.nextLine().trim();
                    System.out.print("EnrollmentStudent ID: ");
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
                        EnrollmentStudent st = findStudent(sid);
                        EnrollmentCourse co = findCourse(ccode);
                        if (st == null) { System.out.println("EnrollmentStudent ID not found."); break; }
                        if (co == null) { System.out.println("EnrollmentCourse code not found."); break; }
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
                        EnrollmentStudent st = findStudent(sid);
                        EnrollmentCourse co = findCourse(ccode);
                        if (st == null) { System.out.println("EnrollmentStudent ID not found."); break; }
                        if (co == null) { System.out.println("EnrollmentCourse code not found."); break; }
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
                        EnrollmentStudent st = findStudent(sid);
                        if (st == null) { System.out.println("EnrollmentStudent ID not found."); break; }
                        calculateOverallGrade(st);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid student ID.");
                    }
                    break;

                case 6: displayCourses(); break;
                case 7: displayStudents(); break;
                case 8:
                    System.out.println("Total enrollments: " +
                                       EnrollmentCourse.getTotalEnrolledStudents());
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
*[INSERT: IntelliJ editor showing EnrollmentSystem.java with the project panel on the left showing EnrollmentStudent.java, EnrollmentCourse.java, and EnrollmentSystem.java]*

### Screenshot 2 — Console Output: Add Courses and Students, Enroll, Assign Grades
*[INSERT: Console showing:*
- *EnrollmentCourse added: CS1102 — Programming 1 (0/30 enrolled)*
- *EnrollmentCourse added: MATH101 — Calculus (0/25 enrolled)*
- *EnrollmentStudent added: EnrollmentStudent[ID=1001, Name=Alice Smith, Courses=0]*
- *EnrollmentStudent added: EnrollmentStudent[ID=1002, Name=Bob Jones, Courses=0]*
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

Liang, Y. D. (2020). *Introduction to Java programming and data structures* (12th ed.). Pearson.
