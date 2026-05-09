import java.util.ArrayList;
import java.util.Scanner;

/**
 * CourseManagement.java
 *
 * Central management class for the Course Enrollment and Grade Management System.
 * Uses private static variables to store the list of courses and students.
 * Provides static methods for all administrative operations.
 * Contains the main() method with the interactive administrator interface.
 *
 * Static variables are used here because the course and student lists are
 * shared across the entire system — they do not belong to any single instance.
 *
 * Author : Nicanor Kyamba
 * Course : CS 1102 — Programming 1, Unit 5
 */
public class CourseManagement {

    // ── Private static variables ─────────────────────────────────
    private static ArrayList<Course>  courses  = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();

    // ── addCourse ────────────────────────────────────────────────
    /**
     * Creates a new Course and adds it to the course list.
     *
     * @param courseCode   unique course identifier (e.g., "CS1102")
     * @param courseName   full name of the course
     * @param maxCapacity  maximum number of students
     */
    public static void addCourse(String courseCode, String courseName, int maxCapacity) {
        // Check for duplicate course code
        for (Course c : courses) {
            if (c.getCourseCode().equalsIgnoreCase(courseCode)) {
                System.out.println("Error: Course code '" + courseCode + "' already exists.");
                return;
            }
        }
        Course newCourse = new Course(courseCode, courseName, maxCapacity);
        courses.add(newCourse);
        System.out.println("Course added: " + newCourse);
    }

    // ── addStudent ───────────────────────────────────────────────
    /**
     * Creates a new Student and adds them to the student list.
     *
     * @param name       student's full name
     * @param studentId  unique student ID
     */
    public static void addStudent(String name, int studentId) {
        for (Student s : students) {
            if (s.getStudentId() == studentId) {
                System.out.println("Error: Student ID " + studentId + " already exists.");
                return;
            }
        }
        Student newStudent = new Student(name, studentId);
        students.add(newStudent);
        System.out.println("Student added: " + newStudent);
    }

    // ── enrollStudent ────────────────────────────────────────────
    /**
     * Enrolls a student in a course.
     * Checks that the student exists, the course exists, the student is not
     * already enrolled, and the course has not reached maximum capacity.
     *
     * @param student  the Student to enroll
     * @param course   the Course to enroll them in
     */
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
        System.out.println("Enrolled: " + student.getName() +
                           " in " + course.getCourseCode());
    }

    // ── assignGrade ──────────────────────────────────────────────
    /**
     * Assigns a grade to a student for a specific course.
     * The student must be enrolled in the course.
     * Grade must be between 0.0 and 100.0.
     *
     * @param student  the Student receiving the grade
     * @param course   the Course for which the grade is assigned
     * @param grade    numeric grade (0.0 – 100.0)
     */
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

    // ── calculateOverallGrade ────────────────────────────────────
    /**
     * Calculates and displays the overall average grade for a student
     * across all courses in which they have received a grade.
     *
     * @param student  the Student whose overall grade is calculated
     */
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

    // ── Helper: convert numeric grade to letter grade ────────────
    private static String getLetterGrade(double grade) {
        if (grade >= 90) return "A";
        if (grade >= 80) return "B";
        if (grade >= 70) return "C";
        if (grade >= 60) return "D";
        return "F";
    }

    // ── Helper: find course by code ──────────────────────────────
    private static Course findCourse(String code) {
        for (Course c : courses) {
            if (c.getCourseCode().equalsIgnoreCase(code)) return c;
        }
        return null;
    }

    // ── Helper: find student by ID ───────────────────────────────
    private static Student findStudent(int id) {
        for (Student s : students) {
            if (s.getStudentId() == id) return s;
        }
        return null;
    }

    // ── Display all courses ──────────────────────────────────────
    private static void displayCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        System.out.println("\nAvailable Courses:");
        for (Course c : courses) {
            System.out.println("  " + c);
        }
    }

    // ── Display all students ─────────────────────────────────────
    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }
        System.out.println("\nRegistered Students:");
        for (Student s : students) {
            System.out.println("  " + s);
        }
    }

    // ── Main: Administrator Interface ────────────────────────────
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

                case 1: // Add course
                    System.out.print("Course code: ");
                    String code = sc.nextLine().trim();
                    System.out.print("Course name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Max capacity: ");
                    try {
                        int cap = Integer.parseInt(sc.nextLine().trim());
                        if (cap <= 0) { System.out.println("Capacity must be positive."); break; }
                        addCourse(code, name, cap);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid capacity. Please enter a whole number.");
                    }
                    break;

                case 2: // Add student
                    System.out.print("Student name: ");
                    String sName = sc.nextLine().trim();
                    System.out.print("Student ID: ");
                    try {
                        int id = Integer.parseInt(sc.nextLine().trim());
                        if (id <= 0) { System.out.println("ID must be positive."); break; }
                        addStudent(sName, id);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Please enter a whole number.");
                    }
                    break;

                case 3: // Enroll student
                    displayStudents();
                    displayCourses();
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

                case 4: // Assign grade
                    displayStudents();
                    displayCourses();
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
                        System.out.println("Invalid input. Check ID and grade format.");
                    }
                    break;

                case 5: // Calculate overall grade
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
                    System.out.println("Total enrollments across all courses: " +
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
