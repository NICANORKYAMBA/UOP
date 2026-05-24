/**
 * Student.java
 * Data model representing a student in the Student Management System.
 * Encapsulates student information with validation in setter methods.
 *
 * @author Nicanor Kyamba
 * @course CS 1102 — Programming 1, Unit 7
 */
public class Student {

    private String studentId;
    private String fullName;
    private String email;

    /**
     * Constructs a Student with the specified attributes.
     * @param studentId unique identifier for the student
     * @param fullName the student's full name
     * @param email the student's email address
     */
    public Student(String studentId, String fullName, String email) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.email = email;
    }

    // ─── Getters ─────────────────────────────────────────────────────────────

    public String getStudentId() { return studentId; }
    public String getFullName()  { return fullName; }
    public String getEmail()     { return email; }

    // ─── Setters with Validation ─────────────────────────────────────────────

    public void setFullName(String fullName) {
        if (fullName != null && !fullName.trim().isEmpty()) {
            this.fullName = fullName.trim();
        }
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@") && email.contains(".")) {
            this.email = email.trim();
        }
    }

    @Override
    public String toString() {
        return studentId + " - " + fullName;
    }
}
