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
