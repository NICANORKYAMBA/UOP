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
