
/**
 * Employee.java
 * Data model representing an employee with name, age, department, and salary.
 *
 * @author Nicanor Kyamba
 * @course CS 1102 — Programming 1, Unit 8
 */
public class Employee {

    private String name;
    private int age;
    private String department;
    private double salary;

    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%-15s | Age: %2d | Dept: %-12s | Salary: $%,.2f",
                name, age, department, salary);
    }
}
