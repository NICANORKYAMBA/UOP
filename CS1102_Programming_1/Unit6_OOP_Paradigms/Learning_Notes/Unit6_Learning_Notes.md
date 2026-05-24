# CS 1102 — Unit 6: OOP Paradigms
## Comprehensive Learning Notes
### Source: Eck (2022), Chapter 5, Sections 5.5 (Inheritance and Polymorphism), 5.7 (Interfaces)

---

## Part 1: Inheritance (Section 5.5)

### 1.1 What is Inheritance?

Inheritance is the mechanism by which a new class can be defined as a modified or extended version of an existing class. The existing class is called the **superclass** (or parent class), and the new class is called the **subclass** (or child class). The subclass inherits all the non-private instance variables and methods of the superclass, and can add new variables and methods or override existing ones (Eck, 2022, Section 5.5).

In Java, inheritance is declared using the `extends` keyword:

```java
public class Vehicle {
    private String make;
    private String model;
    private int year;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake()  { return make; }
    public String getModel() { return model; }
    public int getYear()     { return year; }

    public String getInfo() {
        return year + " " + make + " " + model;
    }
}

public class Car extends Vehicle {
    private int numberOfDoors;
    private String fuelType;

    public Car(String make, String model, int year, int numberOfDoors, String fuelType) {
        super(make, model, year);  // call superclass constructor
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
    }

    public int getNumberOfDoors() { return numberOfDoors; }
    public String getFuelType()   { return fuelType; }
}
```

Here, `Car` inherits `getMake()`, `getModel()`, `getYear()`, and `getInfo()` from `Vehicle` without rewriting them. It adds its own fields (`numberOfDoors`, `fuelType`) and methods.

### 1.2 The Class Hierarchy

Java has a single-inheritance model — every class extends exactly one superclass. If no `extends` clause is specified, the class implicitly extends `Object`, which is the root of the entire Java class hierarchy (Eck, 2022, Section 5.5.1).

```
Object
  └── Vehicle
        ├── Car
        ├── Motorcycle
        └── Truck
```

Every class inherits methods from `Object`, including `toString()`, `equals()`, and `hashCode()`.

### 1.3 The `super` Keyword in Inheritance

The `super` keyword serves two purposes in subclasses:

**1. Calling the superclass constructor:**
```java
public Car(String make, String model, int year, int doors, String fuel) {
    super(make, model, year);  // MUST be the first statement in the constructor
    this.numberOfDoors = doors;
    this.fuelType = fuel;
}
```

If the superclass does not have a no-argument constructor, the subclass **must** explicitly call `super(...)` with appropriate arguments. This call must be the first statement in the subclass constructor (Eck, 2022, Section 5.6.2).

**2. Calling an overridden superclass method:**
```java
@Override
public String getInfo() {
    return super.getInfo() + " | Doors: " + numberOfDoors + " | Fuel: " + fuelType;
}
```

### 1.4 Benefits of Inheritance

| Benefit | Explanation |
|---------|-------------|
| Code reuse | Subclasses inherit existing methods and variables — no duplication |
| Extensibility | New functionality can be added without modifying the superclass |
| Hierarchical organization | Models real-world "is-a" relationships naturally |
| Polymorphism | Enables treating different subclass objects uniformly (see Part 2) |
| Maintainability | Bug fixes in the superclass automatically propagate to all subclasses |

### 1.5 What is NOT Inherited

- **Private members**: Private instance variables and methods are not directly accessible in subclasses (though they exist in memory — accessed through inherited public/protected methods)
- **Constructors**: Constructors are never inherited — each class must define its own (Eck, 2022, Section 5.5.2)
- **Static members**: Static methods belong to the class, not to objects — they are not overridden (they can be hidden)

### 1.6 Protected Access

The `protected` modifier allows access from within the class, its subclasses, and classes in the same package. It is the middle ground between `private` (too restrictive for subclasses) and `public` (too open):

```java
public class Vehicle {
    protected String make;   // accessible in Car, Motorcycle, Truck
    private String vin;      // NOT accessible in subclasses
    public int year;         // accessible everywhere
}
```

Eck (2022) notes that `protected` is useful when you want subclasses to have direct access to a variable but still want to hide it from unrelated classes (Section 5.5).

---

## Part 2: Polymorphism (Section 5.5.3)

### 2.1 What is Polymorphism?

Polymorphism (from Greek: "many forms") is the ability of a variable of a superclass type to refer to objects of different subclass types, and for method calls on that variable to execute the appropriate subclass version of the method. Eck (2022) describes this as one of the most powerful features of object-oriented programming (Section 5.5.3).

```java
Vehicle v1 = new Car("Toyota", "Camry", 2023, 4, "Petrol");
Vehicle v2 = new Motorcycle("Honda", "CBR", 2022, 2, "Sport");
Vehicle v3 = new Truck("Ford", "F-150", 2024, 5.0, "Automatic");

// All three are treated as Vehicle — polymorphism
Vehicle[] fleet = { v1, v2, v3 };
for (Vehicle v : fleet) {
    System.out.println(v.getInfo());  // calls the correct overridden version
}
```

The variable type is `Vehicle`, but the actual objects are `Car`, `Motorcycle`, and `Truck`. When `getInfo()` is called, Java executes the version defined in the actual object's class — not the variable's declared type.

### 2.2 Method Overriding

**Method overriding** occurs when a subclass provides its own implementation of a method that is already defined in its superclass. The overriding method must have the same name, return type, and parameter list as the superclass method (Eck, 2022, Section 5.5.3).

```java
public class Vehicle {
    public String getInfo() {
        return year + " " + make + " " + model;
    }
}

public class Car extends Vehicle {
    @Override
    public String getInfo() {
        return super.getInfo() + " | " + numberOfDoors + "-door " + fuelType;
    }
}

public class Motorcycle extends Vehicle {
    @Override
    public String getInfo() {
        return super.getInfo() + " | " + numberOfWheels + "-wheel " + motorcycleType;
    }
}
```

The `@Override` annotation is optional but strongly recommended — it tells the compiler to verify that the method actually overrides a superclass method, catching typos and signature mismatches at compile time.

### 2.3 Dynamic Binding (Late Binding)

**Dynamic binding** means that the decision about which version of an overridden method to call is made at **runtime**, not at compile time. The JVM looks at the actual type of the object (not the declared type of the variable) to determine which method to execute (Eck, 2022, Section 5.5.3).

```java
Vehicle v = new Car("Toyota", "Camry", 2023, 4, "Petrol");
System.out.println(v.getInfo());
// At compile time: compiler sees Vehicle.getInfo()
// At runtime: JVM sees the object is actually a Car → calls Car.getInfo()
```

This is the mechanism that makes polymorphism work. Without dynamic binding, `v.getInfo()` would always call `Vehicle.getInfo()` regardless of the actual object type.

### 2.4 Method Overloading vs. Method Overriding

| Feature | Overloading | Overriding |
|---------|-------------|------------|
| Definition | Same method name, different parameters | Same method name, same parameters, different class |
| Where | Within the same class (or inherited) | In a subclass |
| Binding | Compile-time (static) | Runtime (dynamic) |
| Return type | Can differ | Must be the same (or covariant) |
| Parameters | Must differ | Must be identical |
| `@Override` | Not applicable | Recommended |
| Also called | Compile-time polymorphism | Runtime polymorphism |

**Overloading example** (same class, different parameters):
```java
public class Calculator {
    public int add(int a, int b)          { return a + b; }
    public double add(double a, double b) { return a + b; }
    public int add(int a, int b, int c)   { return a + b + c; }
}
```

**Overriding example** (subclass, same signature):
```java
public class Animal {
    public void speak() { System.out.println("..."); }
}
public class Dog extends Animal {
    @Override
    public void speak() { System.out.println("Woof!"); }
}
```

### 2.5 Compile-Time vs. Runtime Polymorphism

**Compile-time polymorphism** (static polymorphism): Achieved through method overloading. The compiler determines which method to call based on the argument types at compile time.

**Runtime polymorphism** (dynamic polymorphism): Achieved through method overriding and dynamic binding. The JVM determines which method to call based on the actual object type at runtime.

```java
// Compile-time: compiler picks add(int, int) vs add(double, double)
Calculator calc = new Calculator();
calc.add(3, 4);       // calls add(int, int)
calc.add(3.0, 4.0);   // calls add(double, double)

// Runtime: JVM picks Dog.speak() vs Cat.speak() based on actual object
Animal a = new Dog();
a.speak();  // "Woof!" — decided at runtime
```

### 2.6 The `instanceof` Operator

The `instanceof` operator checks whether an object is an instance of a particular class or implements a particular interface:

```java
Vehicle v = new Car("Toyota", "Camry", 2023, 4, "Petrol");

if (v instanceof Car) {
    Car c = (Car) v;  // safe downcast
    System.out.println("Doors: " + c.getNumberOfDoors());
}
```

This is useful when you need to access subclass-specific methods that are not defined in the superclass.

---

## Part 3: Interfaces (Section 5.7)

### 3.1 What is an Interface?

An interface in Java is a reference type that defines a **contract** — a set of abstract method signatures that any implementing class must provide. An interface specifies *what* a class must do, but not *how* it does it (Eck, 2022, Section 5.7).

```java
public interface Drawable {
    void draw();                    // abstract — no body
    double getArea();               // abstract — no body
    default String getColor() {     // default method — has a body (Java 8+)
        return "black";
    }
}
```

### 3.2 Declaring and Implementing Interfaces

A class implements an interface using the `implements` keyword. The class **must** provide concrete implementations of all abstract methods declared in the interface:

```java
public interface Vehicle {
    String getMake();
    String getModel();
    int getYearOfManufacture();
}

public class Car implements Vehicle {
    private String make;
    private String model;
    private int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    @Override
    public String getMake()  { return make; }

    @Override
    public String getModel() { return model; }

    @Override
    public int getYearOfManufacture() { return year; }
}
```

If a class declares that it `implements` an interface but fails to provide implementations for all abstract methods, the compiler will produce an error.

### 3.3 Multiple Interface Implementation

Unlike inheritance (where a class can extend only one superclass), a class can implement **multiple interfaces**. This is Java's solution to the multiple inheritance problem:

```java
public interface Vehicle {
    String getMake();
    String getModel();
    int getYearOfManufacture();
}

public interface CarVehicle {
    void setNumberOfDoors(int doors);
    int getNumberOfDoors();
    void setFuelType(String fuelType);
    String getFuelType();
}

public class Car implements Vehicle, CarVehicle {
    private String make, model, fuelType;
    private int year, numberOfDoors;

    // Must implement ALL methods from BOTH interfaces
    @Override public String getMake()  { return make; }
    @Override public String getModel() { return model; }
    @Override public int getYearOfManufacture() { return year; }
    @Override public void setNumberOfDoors(int doors) { this.numberOfDoors = doors; }
    @Override public int getNumberOfDoors() { return numberOfDoors; }
    @Override public void setFuelType(String fuelType) { this.fuelType = fuelType; }
    @Override public String getFuelType() { return fuelType; }
}
```

### 3.4 Interfaces as Types (Polymorphism with Interfaces)

An interface can be used as a variable type. Any object whose class implements the interface can be assigned to that variable — this is polymorphism through interfaces:

```java
Vehicle v1 = new Car("Toyota", "Camry", 2023);
Vehicle v2 = new Motorcycle("Honda", "CBR", 2022);
Vehicle v3 = new Truck("Ford", "F-150", 2024);

Vehicle[] fleet = { v1, v2, v3 };
for (Vehicle v : fleet) {
    System.out.println(v.getMake() + " " + v.getModel() + " (" + v.getYearOfManufacture() + ")");
}
```

This is one of the most powerful uses of interfaces — it allows you to write code that works with any object that fulfills the contract, regardless of its actual class.

### 3.5 Interface vs. Abstract Class

| Feature | Interface | Abstract Class |
|---------|-----------|---------------|
| Methods | All abstract (pre-Java 8); can have `default` and `static` methods (Java 8+) | Can have both abstract and concrete methods |
| Variables | Only `public static final` constants | Can have instance variables of any type |
| Constructors | Cannot have constructors | Can have constructors |
| Multiple inheritance | A class can implement multiple interfaces | A class can extend only one abstract class |
| Access modifiers | Methods are implicitly `public` | Methods can have any access modifier |
| Use when | Defining a contract/capability across unrelated classes | Sharing code among closely related classes |

### 3.6 Why Use Interfaces?

Eck (2022) identifies several key benefits of interfaces (Section 5.7):

1. **Defining contracts**: Interfaces guarantee that implementing classes provide specific methods, enabling reliable interaction between components
2. **Loose coupling**: Code that depends on an interface rather than a concrete class can work with any implementation — making the system flexible and testable
3. **Multiple inheritance of type**: A class can be treated as multiple types simultaneously by implementing multiple interfaces
4. **Design by contract**: Interfaces define what a class promises to do, separating specification from implementation
5. **Polymorphism**: Interface types enable polymorphic behavior across unrelated class hierarchies

### 3.7 Default Methods (Java 8+)

Starting with Java 8, interfaces can contain `default` methods — methods with a body that provide a default implementation. Classes that implement the interface can use the default implementation or override it:

```java
public interface Vehicle {
    String getMake();
    String getModel();
    int getYearOfManufacture();

    default String getDescription() {
        return getYearOfManufacture() + " " + getMake() + " " + getModel();
    }
}
```

Default methods were introduced to allow interfaces to evolve without breaking existing implementations. If a new method is added to an interface as a `default` method, existing classes that implement the interface do not need to be modified.

---

## Part 4: Putting It All Together — Inheritance, Polymorphism, and Interfaces

### 4.1 Combined Design Pattern

A common design pattern combines interfaces (for contracts) with inheritance (for code reuse) and polymorphism (for flexibility):

```java
// Interface — defines the contract
public interface Vehicle {
    String getMake();
    String getModel();
    int getYearOfManufacture();
}

// Abstract base class — provides shared implementation
public abstract class AbstractVehicle implements Vehicle {
    private String make;
    private String model;
    private int year;

    public AbstractVehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    @Override public String getMake()  { return make; }
    @Override public String getModel() { return model; }
    @Override public int getYearOfManufacture() { return year; }

    // Abstract method — subclasses must implement
    public abstract String getVehicleType();
}

// Concrete subclass
public class Car extends AbstractVehicle implements CarVehicle {
    private int numberOfDoors;
    private String fuelType;

    public Car(String make, String model, int year, int doors, String fuel) {
        super(make, model, year);
        this.numberOfDoors = doors;
        this.fuelType = fuel;
    }

    @Override public String getVehicleType() { return "Car"; }
    @Override public int getNumberOfDoors()  { return numberOfDoors; }
    @Override public String getFuelType()    { return fuelType; }
    // ... setters
}
```

### 4.2 Real-World Applications

| Domain | Superclass/Interface | Subclasses |
|--------|---------------------|------------|
| Banking | `Account` | `SavingsAccount`, `CheckingAccount`, `CreditAccount` |
| E-commerce | `Product` | `Electronics`, `Clothing`, `Food` |
| Gaming | `Character` | `Warrior`, `Mage`, `Archer` |
| Transport | `Vehicle` | `Car`, `Motorcycle`, `Truck` |
| GUI | `Component` | `Button`, `TextField`, `Label` |

---

## Key Terms Summary

| Term | Definition |
|------|-----------|
| Inheritance | Mechanism where a subclass acquires properties and methods of a superclass |
| Superclass | The parent class being extended |
| Subclass | The child class that extends the superclass |
| `extends` | Keyword used to declare inheritance |
| `implements` | Keyword used to declare interface implementation |
| Polymorphism | Ability of objects to take multiple forms — superclass variable holding subclass objects |
| Method overriding | Subclass provides its own implementation of a superclass method |
| Method overloading | Multiple methods with the same name but different parameter lists |
| Dynamic binding | Runtime decision about which overridden method to call |
| Static binding | Compile-time decision about which overloaded method to call |
| Interface | Contract specifying methods a class must implement |
| Abstract class | Class that cannot be instantiated; may contain abstract methods |
| `@Override` | Annotation indicating a method overrides a superclass method |
| `super` | Reference to the superclass — used to call superclass constructors and methods |
| `instanceof` | Operator that checks if an object is an instance of a class/interface |
| Default method | Interface method with a body (Java 8+) |
| Loose coupling | Design principle where components depend on abstractions, not concrete implementations |

---

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, JavaFX ed.). Creative Commons CC 4.0. https://math.hws.edu/javanotes/

Coding with John. (2021, April 18). *Java polymorphism fully explained in 7 minutes* [Video]. YouTube. https://youtu.be/jhDUxynEQRI

Lee, A. (2019, August 30). *Inheritance in Java tutorial* [Video]. YouTube. https://youtu.be/zbfMHMGT5mE

Pragada, S. (2020, March 10). *Compile-time polymorphism vs. runtime polymorphism* [Video]. YouTube. https://youtu.be/tEXQROOlX0s

Programming with Mosh. (2022, February 15). *Java interfaces tutorial* [Video]. YouTube. https://youtu.be/kTpp5n_CppQ

Simple Snippets. (2018, May 7). *Java polymorphism — method overloading vs method overriding* [Video]. YouTube. https://youtu.be/tNgZpcebbWo

