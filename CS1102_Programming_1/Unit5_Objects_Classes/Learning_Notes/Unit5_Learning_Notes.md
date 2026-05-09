# CS 1102 — Unit 5: Objects and Classes
## Comprehensive Learning Notes
### Source: Eck (2022), Chapter 5, Sections 5.1–5.4, 5.6

---

## Part 1: Objects, Instance Methods, and Instance Variables (Section 5.1)

### 1.1 What is Object-Oriented Programming?

Object-oriented programming (OOP) represents an attempt to make programs more closely model the way people think about and deal with the world. In older programming styles, a programmer identifies a computing task and finds a sequence of instructions to accomplish it. But at the heart of OOP, instead of tasks we find **objects** — entities that have behaviors, hold information, and can interact with one another (Eck, 2022, Section 5.1).

Programming in OOP consists of designing a set of objects that model the problem at hand. Software objects can represent real or abstract entities in the problem domain.

### 1.2 Classes vs. Objects

A **class** is a blueprint or factory for creating objects. The non-static parts of a class specify what variables and methods the objects will contain (Eck, 2022, Section 5.1.1).

An **object** (also called an **instance**) is created from a class using the `new` operator. There can be many objects created from the same class, each with its own copy of the instance variables.

**Key distinction** — static vs. non-static:

```java
class PlayerData {
    static int playerCount;  // ONE copy — belongs to the class
    String name;             // EACH object gets its own copy
    int age;                 // EACH object gets its own copy
}
```

- `PlayerData.playerCount` — one variable, shared by all instances
- `player1.name`, `player2.name` — separate variables for each object

### 1.3 Variables Hold References, Not Objects

**Critical point from Eck (2022, Section 5.1.2):**

> In Java, no variable can ever hold an object. A variable can only hold a **reference** to an object.

Objects live in a special area of memory called the **heap**. A variable of object type holds the memory address (reference/pointer) of where the object is stored.

```java
Student std;              // declares a variable — NO object created yet
std = new Student();      // creates an object on the heap, stores reference in std
Student std2 = std;       // std2 and std now point to the SAME object
```

### 1.4 The Student Class Example (Eck, 2022, Section 5.1.2)

```java
public class Student {
    public String name;
    public double test1, test2, test3;

    public double getAverage() {
        return (test1 + test2 + test3) / 3;
    }
}
```

Usage:
```java
Student std = new Student();
std.name = "Alice";
std.test1 = 90;
std.test2 = 85;
std.test3 = 92;
System.out.println(std.getAverage());  // prints 89.0
```

Each `Student` object has its own `name`, `test1`, `test2`, `test3`. The method `getAverage()` uses the instance variables of the specific object it is called on.

---

## Part 2: Access Modifiers, Getters, and Setters (Section 5.1.3)

### 2.1 Access Modifiers

| Modifier | Accessible from |
|----------|----------------|
| `public` | Anywhere — any class in any package |
| `private` | Only within the class where it is defined |
| `protected` | Within the class, subclasses, and same package |
| (none) | Within the same package only |

Eck (2022) states that in the opinion of many programmers, **almost all member variables should be declared private**. This gives complete control over what can be done with the variable (Section 5.1.3).

### 2.2 Getter Methods (Accessor Methods)

A **getter** provides read access to a private variable. By convention, the name is `get` + capitalized variable name:

```java
public class Book {
    private String title;
    private String author;
    private int year;

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Getter for author
    public String getAuthor() {
        return author;
    }

    // For boolean variables, use "is" prefix
    private boolean available;
    public boolean isAvailable() {
        return available;
    }
}
```

### 2.3 Setter Methods (Mutator Methods)

A **setter** provides write access to a private variable. By convention, the name is `set` + capitalized variable name. Setters can validate input before assigning:

```java
public void setTitle(String newTitle) {
    if (newTitle == null)
        title = "(Untitled)";   // reject null, use default
    else
        title = newTitle;
}

public void setYear(int newYear) {
    if (newYear > 0)
        year = newYear;         // only accept positive years
}
```

**Why use getters/setters instead of public variables?**
Eck (2022) explains: getters and setters are not restricted to simply reading and writing the variable's value — they can take any action, including validation, logging, or triggering other updates. If you use public variables and later need to add validation, you must change every piece of code that accesses the variable. With getters/setters, you only change the method (Section 5.1.3).

### 2.4 Encapsulation

**Encapsulation** is the OOP principle of bundling data (instance variables) and the methods that operate on that data together within a class, and restricting direct access to the data from outside the class.

Encapsulation achieves:
- **Data hiding**: private variables cannot be accessed or corrupted from outside the class
- **Controlled access**: only through public getter/setter methods
- **Modularity**: the internal implementation can change without affecting code that uses the class
- **Data integrity**: setters can enforce validation rules

---

## Part 3: Constructors and Object Initialization (Section 5.2)

### 3.1 Default Initialization

When an object is created, instance variables are automatically initialized to default values if no explicit value is provided (Eck, 2022, Section 5.2.1):

| Type | Default value |
|------|--------------|
| `int`, `double`, etc. | `0` |
| `boolean` | `false` |
| `char` | Unicode character 0 |
| Object types (String, etc.) | `null` |

### 3.2 What is a Constructor?

A **constructor** is a special subroutine that is called automatically when an object is created with `new`. It initializes the object's instance variables (Eck, 2022, Section 5.2.2).

**Three rules for constructors:**
1. No return type (not even `void`)
2. Name must be exactly the same as the class name
3. Only access modifiers (`public`, `private`, `protected`) are allowed — cannot be `static`

```java
public class PairOfDice {
    public int die1;
    public int die2;

    // Constructor with parameters
    public PairOfDice(int val1, int val2) {
        die1 = val1;
        die2 = val2;
    }

    public void roll() {
        die1 = (int)(Math.random() * 6) + 1;
        die2 = (int)(Math.random() * 6) + 1;
    }
}

// Usage
PairOfDice dice = new PairOfDice(3, 4);  // die1=3, die2=4
dice.roll();                              // randomize both dice
```

### 3.3 Default Constructor

If the programmer does not write any constructor, Java provides a **default constructor** that takes no parameters and does nothing beyond basic initialization. Once you write any constructor, the default constructor is no longer provided automatically (Eck, 2022, Section 5.2.2).

### 3.4 Constructor Overloading

A class can have multiple constructors with different parameter lists:

```java
public class Student {
    private String name;
    private int id;
    private double gpa;

    // No-argument constructor
    public Student() {
        name = "Unknown";
        id = 0;
        gpa = 0.0;
    }

    // Constructor with name and id
    public Student(String name, int id) {
        this.name = name;   // 'this' distinguishes instance variable from parameter
        this.id = id;
        this.gpa = 0.0;
    }

    // Constructor with all fields
    public Student(String name, int id, double gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }
}
```

---

## Part 4: The `this` and `super` Keywords (Section 5.6)

### 4.1 The `this` Keyword (Section 5.6.1)

Inside an instance method or constructor, `this` is a reference to the object that the method was called on — the "current object."

**Primary use — disambiguating parameter names from instance variables:**

```java
public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;  // 'this.radius' = instance variable
                               // 'radius' alone = the parameter
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
```

Without `this`, the assignment `radius = radius` would assign the parameter to itself — the instance variable would never be set.

**Secondary use — calling another constructor from within a constructor:**

```java
public Student(String name, int id) {
    this(name, id, 0.0);  // calls the 3-argument constructor
}
```

### 4.2 The `super` Keyword (Section 5.6.2)

`super` refers to the superclass of the current class. It is used in subclasses to access methods and variables that have been overridden or hidden.

```java
public class Animal {
    public void speak() {
        System.out.println("...");
    }
}

public class Dog extends Animal {
    @Override
    public void speak() {
        super.speak();              // calls Animal's speak()
        System.out.println("Woof!");
    }
}
```

`super` is also used to call a superclass constructor:
```java
public Dog(String name) {
    super(name);  // calls Animal's constructor
}
```

---

## Part 5: Programming with Objects (Section 5.3)

### 5.1 Object-Oriented Design Principles

OOP encourages programmers to produce **generalized software components** that can be used in a wide variety of programming projects (Eck, 2022, Section 5.3).

Key design principles:
- **Encapsulation**: bundle data and behavior, hide implementation details
- **Abstraction**: expose only what is necessary through a clean public interface
- **Modularity**: each class has a single, well-defined responsibility
- **Reusability**: well-designed classes can be used in multiple programs

### 5.2 Complete Class Example — BankAccount

```java
public class BankAccount {
    private String owner;       // private — encapsulated
    private double balance;     // private — encapsulated
    private static int totalAccounts = 0;  // static — shared across all instances

    // Constructor
    public BankAccount(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
        totalAccounts++;        // increment class-level counter
    }

    // Getter methods
    public String getOwner()  { return owner; }
    public double getBalance() { return balance; }

    // Instance methods — manipulate object state
    public void deposit(double amount) {
        if (amount > 0)
            balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // Static method — class-level information
    public static int getTotalAccounts() {
        return totalAccounts;
    }
}
```

---

## Key Terms Summary

| Term | Definition |
|------|-----------|
| Object | An instance of a class — has its own copy of instance variables |
| Class | Blueprint/factory for creating objects |
| Instance variable | Non-static variable — each object has its own copy |
| Instance method | Non-static method — operates on a specific object's data |
| Static variable | One copy shared by all instances of the class |
| Encapsulation | Bundling data and methods, hiding implementation details |
| Access modifier | `public`, `private`, `protected` — controls visibility |
| Getter | Public method that returns the value of a private variable |
| Setter | Public method that sets the value of a private variable (with optional validation) |
| Constructor | Special method called when an object is created with `new` |
| `this` | Reference to the current object inside an instance method |
| `super` | Reference to the superclass — used to call overridden methods |
| Heap | Memory area where objects are stored |
| Reference | Memory address pointing to an object |

---

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, Swing ed.). Creative Commons CC 4.0. https://math.hws.edu/javanotes/
