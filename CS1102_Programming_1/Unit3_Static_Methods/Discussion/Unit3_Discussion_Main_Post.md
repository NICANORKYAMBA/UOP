# CS 1102 - Unit 3 Discussion Assignment
## Static and Non-Static Methods and Variables in Java

**Student**: Nicanor Kyamba  
**Course**: CS 1102 - Programming 1  
**Unit**: 3 - Static Methods and Member Variables

---

## Part 1: Fundamental Distinctions and Practical Use Cases

In Java, static and non-static members operate at different design levels. A static member belongs to the class itself, while a non-static member belongs to each object created from that class. Eck (2022, Section 4.2) frames this as a structural distinction: static members support class-level behavior, while non-static members model object-level state and behavior.

The distinction is easiest to see through variables. In a university student system, fields such as name, ID, age, and grade should be instance variables because each student has unique values. In contrast, a total student counter should be static because it represents one shared class-wide value (Eck, 2022, Section 4.2.4).

```java
class Student {
    private String name;          // instance variable
    private String id;            // instance variable
    private int age;              // instance variable
    private String grade;         // instance variable
    private static int total = 0; // static variable (shared)

    public Student(String name, String id, int age, String grade) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.grade = grade;
        total++;
    }

    public static int getTotalStudents() {
        return total;
    }
}
```

Methods follow the same principle. A static method is suitable when behavior does not depend on one object's state. For example, ID format validation is utility logic, so static is appropriate. In contrast, methods that mutate one object's state should be non-static.

```java
class StudentUtils {
    public static boolean isValidId(String id) {
        return id != null && id.matches("S\\d{3}");
    }
}

class StudentAccount {
    private double balance;

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}
```

These examples illustrate a practical rule: if logic depends on shared class-level data, static is usually appropriate; if logic depends on one object's state, non-static is usually required.

**Word count: 331**

---

## Part 2: Advantages, Limitations, and Implications in OOP

Static and non-static elements influence memory management, code organization, and access scope.

From a memory perspective, static variables are allocated once when the class is loaded and then reused, while instance variables are allocated per object (Eck, 2022, Section 4.2.4). If a system creates 5,000 Student objects, there are 5,000 copies of instance fields like name, but still one shared copy of a static field such as total. This makes static storage efficient for shared state, but only when shared state is semantically correct.

From a code organization perspective, static methods are concise and useful for helper logic. However, overusing static methods can make code procedural, with behavior detached from object state. Non-static methods typically improve encapsulation because data and behavior stay together. This aligns with Eck's emphasis on clear interfaces through parameters and return values (Eck, 2022, Sections 4.3 and 4.4).

Access scope is also critical. Both static and non-static members can be private, and private access is often best because it protects class invariants and limits unintended modification (Eck, 2022, Sections 4.2.1 and 4.8.4). For example, a private static counter should be exposed through a controlled getter, while private instance fields should be updated through validated methods.

The advantages of static elements include shared state, efficient class-wide storage, and easy utility reuse. Their limitations include tighter coupling when static state is treated like a global variable, lower flexibility for object-centric extension, and testing complexity if shared state is not reset. Non-static elements provide stronger real-world modeling, cleaner encapsulation, and better extensibility. Their trade-off is the need for object instantiation, which is normally expected in object-oriented programming.

In conclusion, static and non-static members are complementary design tools, not competing ones. Strong Java programs combine both intentionally, based on ownership of data, method responsibility, memory implications, and access control clarity (Eck, 2022; Neso Academy, 2020).

**Word count: 309**

---

**Total Word Count: 630**

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, JavaFX ed.). https://math.hws.edu/javanotes/

Neso Academy. (2020, June 23). *Static variables and static methods in Java* [Video]. YouTube. https://www.youtube.com/watch?v=ej5m9XjJ0x8
