import java.util.ArrayList;
import java.util.HashMap;

/**
 * DataManager.java
 * Centralized data storage and business logic for the Student Management System.
 * Manages students, courses, enrollments, and grades.
 * Separates data operations from the GUI layer.
 *
 * @author Nicanor Kyamba
 * @course CS 1102 — Programming 1, Unit 7
 */
public class DataManager {

    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    private HashMap<String, ArrayList<String>> enrollments;  // studentId -> list of course display names
    private HashMap<String, HashMap<String, String>> grades; // studentId -> {courseDisplayName: grade}

    /**
     * Constructs the DataManager and initializes available courses.
     */
    public DataManager() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        enrollments = new HashMap<>();
        grades = new HashMap<>();

        // Initialize available courses
        courses.add(new Course("CS1101", "Programming Fundamentals"));
        courses.add(new Course("CS1102", "Programming 1"));
        courses.add(new Course("MATH101", "Calculus I"));
        courses.add(new Course("ENGL1102", "English Composition"));
        courses.add(new Course("ECON1580", "Applied Economics"));
    }

    // ─── Student Operations ──────────────────────────────────────────────────

    /**
     * Adds a new student to the system.
     * @param student the Student object to add
     * @throws IllegalArgumentException if ID already exists
     */
    public void addStudent(Student student) {
        for (Student s : students) {
            if (s.getStudentId().equals(student.getStudentId())) {
                throw new IllegalArgumentException(
                    "Student ID '" + student.getStudentId() + "' already exists.");
            }
        }
        students.add(student);
        enrollments.put(student.getStudentId(), new ArrayList<>());
        grades.put(student.getStudentId(), new HashMap<>());
    }

    /**
     * Returns the list of all students.
     */
    public ArrayList<Student> getStudents() { return students; }

    /**
     * Finds a student by ID.
     * @return the Student object, or null if not found
     */
    public Student findStudent(String studentId) {
        for (Student s : students) {
            if (s.getStudentId().equals(studentId)) return s;
        }
        return null;
    }

    // ─── Course Operations ───────────────────────────────────────────────────

    /**
     * Returns the list of all available courses.
     */
    public ArrayList<Course> getCourses() { return courses; }

    // ─── Enrollment Operations ───────────────────────────────────────────────

    /**
     * Enrolls a student in a course.
     * @throws IllegalArgumentException if already enrolled
     */
    public void enrollStudent(String studentId, String courseDisplayName) {
        ArrayList<String> studentCourses = enrollments.get(studentId);
        if (studentCourses == null) {
            throw new IllegalArgumentException("Student ID not found.");
        }
        if (studentCourses.contains(courseDisplayName)) {
            throw new IllegalArgumentException(
                "Student is already enrolled in " + courseDisplayName + ".");
        }
        studentCourses.add(courseDisplayName);
    }

    /**
     * Checks if a student is enrolled in a specific course.
     */
    public boolean isEnrolled(String studentId, String courseDisplayName) {
        ArrayList<String> studentCourses = enrollments.get(studentId);
        return studentCourses != null && studentCourses.contains(courseDisplayName);
    }

    /**
     * Returns the list of courses a student is enrolled in.
     */
    public ArrayList<String> getEnrolledCourses(String studentId) {
        return enrollments.getOrDefault(studentId, new ArrayList<>());
    }

    /**
     * Returns all enrollments as a list of [studentId, studentName, course] arrays.
     */
    public ArrayList<String[]> getAllEnrollments() {
        ArrayList<String[]> result = new ArrayList<>();
        for (Student s : students) {
            ArrayList<String> studentCourses = enrollments.get(s.getStudentId());
            if (studentCourses != null) {
                for (String course : studentCourses) {
                    result.add(new String[]{s.getStudentId(), s.getFullName(), course});
                }
            }
        }
        return result;
    }

    // ─── Grade Operations ────────────────────────────────────────────────────

    /**
     * Assigns a grade to a student for a specific course.
     * @throws IllegalArgumentException if grade is invalid
     */
    public void assignGrade(String studentId, String courseDisplayName, String grade) {
        String[] validGrades = {"A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "F"};
        boolean isValid = false;
        for (String g : validGrades) {
            if (g.equals(grade)) { isValid = true; break; }
        }
        if (!isValid) {
            throw new IllegalArgumentException(
                "Invalid grade '" + grade + "'. Valid: A, A-, B+, B, B-, C+, C, C-, D+, D, F");
        }
        HashMap<String, String> studentGrades = grades.get(studentId);
        if (studentGrades == null) {
            throw new IllegalArgumentException("Student ID not found.");
        }
        studentGrades.put(courseDisplayName, grade);
    }

    /**
     * Returns the grade for a student in a specific course, or "Not Assigned".
     */
    public String getGrade(String studentId, String courseDisplayName) {
        HashMap<String, String> studentGrades = grades.get(studentId);
        if (studentGrades != null && studentGrades.containsKey(courseDisplayName)) {
            return studentGrades.get(courseDisplayName);
        }
        return "Not Assigned";
    }
}
