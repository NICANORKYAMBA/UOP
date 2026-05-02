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
