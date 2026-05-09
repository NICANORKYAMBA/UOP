package CS1102_Programming_1.Unit5_Objects_Classes.Assignment;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Student.java
 *
 * Represents a university student with a name, ID, enrolled courses,
 * and grades. Demonstrates encapsulation through private instance
 * variables and public getter/setter methods.
 *
 * Author : Nicanor Kyamba
 * Course : CS 1102 — Programming 1, Unit 5
 */
public class Student {

    // ── Private instance variables ───────────────────────────────
    private String name;
    private int studentId;
    private ArrayList<Course> enrolledCourses;  // list of enrolled courses
    private HashMap<String, Double> grades;     // courseCode → grade

    // ── Constructor ──────────────────────────────────────────────
    /**
     * Creates a new Student with the given name and ID.
     *
     * @param name       the student's full name
     * @param studentId  the student's unique ID number
     */
    public Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
        this.enrolledCourses = new ArrayList<>();
        this.grades = new HashMap<>();
    }

    // ── Getter methods ───────────────────────────────────────────
    public String getName()      { return name; }
    public int getStudentId()    { return studentId; }

    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public HashMap<String, Double> getGrades() {
        return grades;
    }

    // ── Setter methods ───────────────────────────────────────────
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty())
            this.name = name;
    }

    public void setStudentId(int studentId) {
        if (studentId > 0)
            this.studentId = studentId;
    }

    // ── Enroll in a course ───────────────────────────────────────
    /**
     * Enrolls this student in the given course.
     * Does nothing if the student is already enrolled.
     *
     * @param course  the Course object to enroll in
     */
    public void enrollCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
        }
    }

    // ── Assign a grade ───────────────────────────────────────────
    /**
     * Assigns a grade to this student for the given course.
     * The student must be enrolled in the course.
     * Grade must be between 0.0 and 100.0.
     *
     * @param course  the Course for which the grade is being assigned
     * @param grade   the numeric grade (0.0 – 100.0)
     */
    public void assignGrade(Course course, double grade) {
        if (enrolledCourses.contains(course) && grade >= 0.0 && grade <= 100.0) {
            grades.put(course.getCourseCode(), grade);
        }
    }

    // ── Check enrollment ─────────────────────────────────────────
    /**
     * Returns true if this student is enrolled in the given course.
     */
    public boolean isEnrolledIn(Course course) {
        return enrolledCourses.contains(course);
    }

    // ── toString ─────────────────────────────────────────────────
    @Override
    public String toString() {
        return "Student[ID=" + studentId + ", Name=" + name +
               ", Courses=" + enrolledCourses.size() + "]";
    }
}
