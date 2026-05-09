/**
 * Course.java
 *
 * Represents a university course with a code, name, and maximum capacity.
 * Uses a static variable to track the total number of enrolled students
 * across ALL instances of the Course class.
 *
 * Author : Nicanor Kyamba
 * Course : CS 1102 — Programming 1, Unit 5
 */
public class Course {

    // ── Private instance variables ───────────────────────────────
    private String courseCode;
    private String courseName;
    private int maxCapacity;
    private int currentEnrollment;

    // ── Static variable: shared across ALL Course instances ──────
    private static int totalEnrolledStudents = 0;

    // ── Constructor ──────────────────────────────────────────────
    /**
     * Creates a new Course with the given code, name, and maximum capacity.
     *
     * @param courseCode   unique identifier (e.g., "CS1102")
     * @param courseName   full name of the course
     * @param maxCapacity  maximum number of students allowed
     */
    public Course(String courseCode, String courseName, int maxCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maxCapacity = maxCapacity;
        this.currentEnrollment = 0;
    }

    // ── Getter methods ───────────────────────────────────────────
    public String getCourseCode()    { return courseCode; }
    public String getCourseName()    { return courseName; }
    public int getMaxCapacity()      { return maxCapacity; }
    public int getCurrentEnrollment(){ return currentEnrollment; }

    // ── Check if course has space ────────────────────────────────
    /**
     * Returns true if the course has not yet reached maximum capacity.
     */
    public boolean hasSpace() {
        return currentEnrollment < maxCapacity;
    }

    // ── Increment enrollment ─────────────────────────────────────
    /**
     * Increments the enrollment count for this course and the global total.
     * Called when a student is successfully enrolled.
     */
    public void incrementEnrollment() {
        if (hasSpace()) {
            currentEnrollment++;
            totalEnrolledStudents++;  // update the class-level static counter
        }
    }

    // ── Static method: retrieve total enrolled across all courses ─
    /**
     * Returns the total number of student enrollments across all courses.
     * This is a static method — it belongs to the class, not any instance.
     *
     * @return total number of enrollments across all Course instances
     */
    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }

    // ── toString ─────────────────────────────────────────────────
    @Override
    public String toString() {
        return courseCode + " — " + courseName +
               " (" + currentEnrollment + "/" + maxCapacity + " enrolled)";
    }
}
