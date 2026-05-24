/**
 * Course.java
 * Data model representing a course in the Student Management System.
 * Stores course code, name, and provides a formatted display string.
 *
 * @author Nicanor Kyamba
 * @course CS 1102 — Programming 1, Unit 7
 */
public class Course {

    private String courseCode;
    private String courseName;

    /**
     * Constructs a Course with the specified code and name.
     * @param courseCode the unique course identifier (e.g., "CS1102")
     * @param courseName the descriptive course name (e.g., "Programming 1")
     */
    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    // ─── Getters ─────────────────────────────────────────────────────────────

    public String getCourseCode() { return courseCode; }
    public String getCourseName() { return courseName; }

    /**
     * Returns the full display name combining code and name.
     * @return formatted string like "CS1102 - Programming 1"
     */
    public String getDisplayName() {
        return courseCode + " - " + courseName;
    }

    @Override
    public String toString() {
        return getDisplayName();
    }
}
