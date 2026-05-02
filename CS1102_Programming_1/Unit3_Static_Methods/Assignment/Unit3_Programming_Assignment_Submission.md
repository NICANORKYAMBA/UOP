# CS 1102 — Unit 3 Programming Assignment
## Student Record Management System

**Student**: Nicanor Kyamba
**Course**: CS 1102 — Programming 1
**Unit**: 3 — Static Methods

---

## 1. Program Overview

This program implements a robust student record management system with five menu options: Add New Student, Update Student Information, View Student Details (by ID), View All Students, and Exit. The design separates responsibilities across three classes: `Student` stores per-student data, `StudentManagement` manages shared records using static members, and `StudentRecordApp` provides the administrator interface. The program runs continuously in a menu loop until the administrator exits, and includes input validation and defensive error handling so invalid input does not crash the application.

The implementation directly satisfies the Unit 3 requirements: private instance variables for student data, private static storage and static methods for management operations, a menu-driven interface for administrators, and clear handling for invalid inputs and missing IDs (University of the People, 2026).

---

## 2. Functionality

The system correctly implements all required operations using static methods inside the management layer, with validation before any update to stored data.

**addStudent**: Accepts `name`, `id`, `age`, and `grade`; rejects blank values and negative age; checks for duplicate IDs before inserting. If all checks pass, it creates a new `Student`, adds it to the static list, and increments `totalStudents`.

```java
public static boolean addStudent(String name, String id, int age, String grade) {
  if (isBlank(name) || isBlank(id) || isBlank(grade) || age < 0) {
    return false;
  }

  if (findStudentById(id) != null) {
    return false;
  }

  Student student = new Student(name.trim(), id.trim(), age, grade.trim());
  students.add(student);
  totalStudents++;
  return true;
}
```

**updateStudent**: Finds a student by ID, then selectively updates only non-blank/non-null fields. This supports partial updates (for example, changing only grade while keeping name and age unchanged).

```java
public static boolean updateStudent(String id, String newName, Integer newAge, String newGrade) {
  if (isBlank(id)) {
    return false;
  }

  if (newAge != null && newAge < 0) {
    return false;
  }

  Student student = findStudentById(id);
  if (student == null) {
    return false;
  }

  boolean updated = false;

  if (!isBlank(newName)) {
    student.setName(newName.trim());
    updated = true;
  }
  if (newAge != null && newAge >= 0) {
    student.setAge(newAge);
    updated = true;
  }
  if (!isBlank(newGrade)) {
    student.setGrade(newGrade.trim());
    updated = true;
  }

  return updated;
}
```

**findStudentById / retrieval**: Uses a linear search through the static list and returns the matching `Student` object or `null` if not found. ID matching is case-insensitive, improving usability for administrators.

**Administrator operations** in `StudentRecordApp` correctly route menu choices to management logic:
- Add student flow
- Update student flow
- View by ID flow
- View all students flow

Each operation prints clear success or error messages to support interactive use.

Management-layer validation is also present, so even if the UI is bypassed, invalid IDs and invalid ages are still rejected.

---

## 3. Code Organization

The solution is organized into three classes with clear separation of concerns.

| Class | Responsibility |
|------|----------------|
| `Student` | Encapsulates student data (`name`, `id`, `age`, `grade`) as private instance variables |
| `StudentManagement` | Stores shared records in private static variables and exposes static operations |
| `StudentRecordApp` | Runs menu loop, handles input, validates admin commands, and displays output |

### `Student` class requirements coverage
- Uses private instance variables exactly as required by the rubric.
- Provides getters and controlled setters, preserving encapsulation (Eck, 2022, sec. 5.2).

### `StudentManagement` class requirements coverage
- Uses private static variables for shared student list and total count.
- Uses static methods for add, update, and retrieval behavior.
- Uses a private constructor to prevent accidental object creation for a utility-style class.
- Rejects invalid update requests (blank ID, missing ID, negative age, or no effective changes), which strengthens error handling evidence for the rubric.

### `StudentRecordApp` requirements coverage
- Displays a menu with required options.
- Prompts for inputs and executes operations through `StudentManagement`.
- Handles invalid menu choices and invalid numeric input.

Variable and method names follow Java naming conventions and are descriptive (`getAllStudentsSnapshot`, `readRequired`, `findStudentById`).

---

## 4. Efficiency and Readability

**Data structure choice**: `ArrayList<Student>` is appropriate for this assignment scope because the collection size grows dynamically and supports straightforward insertion and traversal.

**Search strategy**: The program uses linear search for ID lookups:

```java
for (Student student : students) {
  if (student.getId().equalsIgnoreCase(id.trim())) {
    return student;
  }
}
```

For the assignment scale, this is acceptable and easy to read. If the dataset becomes large, a map-based index could improve lookup time.

**Defensive copying**: `getAllStudentsSnapshot()` returns a new list rather than the internal one, preventing external modification of internal state.

```java
public static List<Student> getAllStudentsSnapshot() {
  return new ArrayList<>(students);
}
```

**Input safety**: UI input is handled through helper methods (`readRequired`, `readInt`, `readLine`) to avoid repeated parsing logic and to centralize validation.

**Exception handling**: `NumberFormatException` is handled where parsing occurs, which follows targeted exception handling best practice (Eck, 2022, sec. 3.7.2).

---

## 5. Full Program Code

### `Student.java`

```java
package CS1102_Programming_1.Unit3_Static_Methods.Assignment;

public class Student {
  private String name;
  private String id;
  private int age;
  private String grade;

  public Student(String name, String id, int age, String grade) {
    this.name = name;
    this.id = id;
    this.age = age;
    this.grade = grade;
  }

  public String getName() {
    return name;
  }

  public String getId() {
    return id;
  }

  public int getAge() {
    return age;
  }

  public String getGrade() {
    return grade;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  @Override
  public String toString() {
    return "Student Details\n"
        + "---------------\n"
        + "Name : " + name + "\n"
        + "ID   : " + id + "\n"
        + "Age  : " + age + "\n"
        + "Grade: " + grade;
  }
}
```

### `StudentManagement.java`

```java
package CS1102_Programming_1.Unit3_Static_Methods.Assignment;

import java.util.ArrayList;
import java.util.List;

public class StudentManagement {
  private static final List<Student> students = new ArrayList<>();
  private static int totalStudents = 0;

  private StudentManagement() {
  }

  public static boolean addStudent(String name, String id, int age, String grade) {
    if (isBlank(name) || isBlank(id) || isBlank(grade) || age < 0) {
      return false;
    }

    if (findStudentById(id) != null) {
      return false;
    }

    Student student = new Student(name.trim(), id.trim(), age, grade.trim());
    students.add(student);
    totalStudents++;
    return true;
  }

  public static boolean updateStudent(String id, String newName, Integer newAge, String newGrade) {
    if (isBlank(id)) {
      return false;
    }

    if (newAge != null && newAge < 0) {
      return false;
    }

    Student student = findStudentById(id);
    if (student == null) {
      return false;
    }

    boolean updated = false;

    if (!isBlank(newName)) {
      student.setName(newName.trim());
      updated = true;
    }
    if (newAge != null && newAge >= 0) {
      student.setAge(newAge);
      updated = true;
    }
    if (!isBlank(newGrade)) {
      student.setGrade(newGrade.trim());
      updated = true;
    }

    return updated;
  }

  public static Student findStudentById(String id) {
    if (isBlank(id)) {
      return null;
    }

    for (Student student : students) {
      if (student.getId().equalsIgnoreCase(id.trim())) {
        return student;
      }
    }
    return null;
  }

  public static List<Student> getAllStudentsSnapshot() {
    return new ArrayList<>(students);
  }

  public static int getTotalStudents() {
    return totalStudents;
  }

  private static boolean isBlank(String value) {
    return value == null || value.trim().isEmpty();
  }
}
```

### `StudentRecordApp.java`

```java
package CS1102_Programming_1.Unit3_Static_Methods.Assignment;

import java.util.List;
import java.util.Scanner;

public class StudentRecordApp {
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    boolean running = true;

    while (running) {
      printMenu();
      int choice = readInt("Enter your choice: ");

      switch (choice) {
        case 1:
          addStudentFlow();
          break;
        case 2:
          updateStudentFlow();
          break;
        case 3:
          viewStudentFlow();
          break;
        case 4:
          listStudentsFlow();
          break;
        case 5:
          System.out.println("Exiting system. Goodbye.");
          running = false;
          break;
        default:
          System.out.println("Invalid menu choice. Select 1 to 5.");
      }

      System.out.println();
    }

    scanner.close();
  }

  private static void printMenu() {
    System.out.println("==========================================");
    System.out.println(" Student Record Management System");
    System.out.println("==========================================");
    System.out.println("1. Add New Student");
    System.out.println("2. Update Student Information");
    System.out.println("3. View Student Details (by ID)");
    System.out.println("4. View All Students");
    System.out.println("5. Exit");
    System.out.println("Current total students: " + StudentManagement.getTotalStudents());
    System.out.println("------------------------------------------");
  }

  private static void addStudentFlow() {
    String name = readRequired("Enter student name: ");
    String id = readRequired("Enter student ID: ");
    int age = readInt("Enter student age: ");

    while (age < 0) {
      System.out.println("Age cannot be negative.");
      age = readInt("Enter student age: ");
    }

    String grade = readRequired("Enter student grade: ");

    boolean added = StudentManagement.addStudent(name, id, age, grade);
    if (added) {
      System.out.println("Student added successfully.");
    } else {
      System.out.println("Unable to add student. ID may already exist or data is invalid.");
    }
  }

  private static void updateStudentFlow() {
    String id = readRequired("Enter student ID to update: ");
    Student existing = StudentManagement.findStudentById(id);

    if (existing == null) {
      System.out.println("Student ID not found.");
      return;
    }

    System.out.println("Leave field blank to keep current value.");
    String newName = readLine("New name (current: " + existing.getName() + "): ");
    String ageInput = readLine("New age (current: " + existing.getAge() + "): ");
    String newGrade = readLine("New grade (current: " + existing.getGrade() + "): ");

    Integer newAge = null;
    if (!ageInput.trim().isEmpty()) {
      try {
        int parsed = Integer.parseInt(ageInput.trim());
        if (parsed < 0) {
          System.out.println("Invalid age. Update cancelled.");
          return;
        }
        newAge = parsed;
      } catch (NumberFormatException ex) {
        System.out.println("Age must be numeric. Update cancelled.");
        return;
      }
    }

    boolean updated = StudentManagement.updateStudent(id, newName, newAge, newGrade);
    if (updated) {
      System.out.println("Student updated successfully.");
    } else {
      System.out.println("Update failed.");
    }
  }

  private static void viewStudentFlow() {
    String id = readRequired("Enter student ID: ");
    Student student = StudentManagement.findStudentById(id);

    if (student == null) {
      System.out.println("Student ID not found.");
    } else {
      System.out.println(student);
    }
  }

  private static void listStudentsFlow() {
    List<Student> students = StudentManagement.getAllStudentsSnapshot();
    if (students.isEmpty()) {
      System.out.println("No students available.");
      return;
    }

    System.out.println("All Students");
    System.out.println("-----------");
    for (Student student : students) {
      System.out.println(student);
      System.out.println();
    }
  }

  private static String readRequired(String prompt) {
    while (true) {
      String input = readLine(prompt);
      if (!input.trim().isEmpty()) {
        return input;
      }
      System.out.println("Input cannot be empty.");
    }
  }

  private static int readInt(String prompt) {
    while (true) {
      String input = readLine(prompt);
      try {
        return Integer.parseInt(input.trim());
      } catch (NumberFormatException ex) {
        System.out.println("Invalid number. Try again.");
      }
    }
  }

  private static String readLine(String prompt) {
    System.out.print(prompt);
    return scanner.nextLine();
  }
}
```

---

## 6. Output (Screenshots)

*Open `StudentRecordApp.java` in IntelliJ IDEA or VS Code, run the program, and insert screenshots below.*

### Screenshot 1 — IDE Screenshot
*[INSERT: editor screenshot showing `Student.java`, `StudentManagement.java`, and `StudentRecordApp.java` in the project tree]*

### Screenshot 2 — Add + View by ID
*[INSERT: console screenshot showing menu, adding two students, and viewing one student by ID successfully]*

### Screenshot 3 — Update + View All
*[INSERT: console screenshot showing update of an existing student and listing all students with updated values]*

### Screenshot 4 — Error Handling Cases
*[INSERT: console screenshot showing invalid menu input, invalid age input, and "Student ID not found" message]*

---

## 7. References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, Swing ed.). Creative Commons CC 4.0. https://math.hws.edu/javanotes/

Oracle. (n.d.-a). *Class ArrayList<E> (Java Platform SE)*. Oracle Documentation. https://docs.oracle.com/en/java/javase/

Oracle. (n.d.-b). *Class Scanner (Java Platform SE)*. Oracle Documentation. https://docs.oracle.com/en/java/javase/

University of the People. (2026). *CS 1102 Unit 3 Programming Assignment brief and rubric*.
