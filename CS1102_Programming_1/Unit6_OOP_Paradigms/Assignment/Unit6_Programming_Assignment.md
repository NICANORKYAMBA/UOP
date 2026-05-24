# CS 1102 — Unit 6 Programming Assignment

## Vehicle Information System: Implementing Interfaces for a Car Rental Agency

**Student**: Nicanor Kyamba  
**Course**: CS 1102 — Programming 1  
**Unit**: 6 — OOP Paradigms  
**Date**: May 2026

---

## 1. Introduction

This assignment implements a Vehicle Information System for a car rental agency using Java interfaces to define contracts and enforce common behavior across multiple vehicle types. The system handles three categories of vehicles — cars, motorcycles, and trucks — each with shared and type-specific attributes. Eck (2022) defines an interface as a reference type that specifies a set of abstract method signatures that any implementing class must provide, effectively creating a contract that guarantees consistent structure across different classes (Section 5.7). This design ensures that all vehicle types conform to a predictable structure while allowing each class to provide its own implementation details.

The system demonstrates the following object-oriented principles:

- **Interfaces as contracts** — each interface defines what methods a class must provide without dictating how (Eck, 2022, Section 5.7)
- **Multiple interface implementation** — each class implements two interfaces simultaneously, achieving Java's form of multiple inheritance of type
- **Polymorphism** — all vehicles are stored in an `ArrayList<Vehicle>` and processed uniformly through the `Vehicle` interface
- **Encapsulation** — all instance variables are `private` with controlled access through getter/setter methods (Eck, 2022, Section 5.1.3)
- **Error handling** — `try-catch` blocks and input validation handle invalid user inputs gracefully

---

## 2. Interface Design

### 2.1 Vehicle Interface — Base Contract

The `Vehicle` interface defines the minimum contract that all vehicle types must fulfill. Any class that implements `Vehicle` guarantees it can provide its make, model, and year of manufacture. Eck (2022) explains that an interface specifies *what* a class must do without specifying *how* — the implementing class provides the actual logic (Section 5.7). This interface enables polymorphism: code that works with `Vehicle` references can operate on any implementing class without knowing the specific type.

```java
/**
 * Vehicle.java
 * Base interface for the Vehicle Information System.
 * Defines the contract for retrieving basic vehicle information
 * that all vehicle types must implement.
 */
public interface Vehicle {
    /** Returns the manufacturer/make of the vehicle. */
    String getMake();

    /** Returns the model name of the vehicle. */
    String getModel();

    /** Returns the year the vehicle was manufactured. */
    int getYearOfManufacture();
}
```

### 2.2 CarVehicle Interface — Car-Specific Contract

The `CarVehicle` interface adds car-specific behavior: managing the number of doors (2–6) and fuel type (Petrol, Diesel, or Electric). The setter methods enforce validation constraints to ensure data integrity.

```java
/**
 * CarVehicle.java
 * Interface defining car-specific behavior.
 * Specifies methods for setting and retrieving the number of doors
 * and the fuel type (petrol, diesel, or electric).
 */
public interface CarVehicle {
    void setNumberOfDoors(int doors);
    int getNumberOfDoors();
    void setFuelType(String fuelType);
    String getFuelType();
}
```

### 2.3 MotorVehicle Interface — Motorcycle-Specific Contract

The `MotorVehicle` interface defines motorcycle-specific behavior: managing the number of wheels (2–3) and motorcycle type (Sport, Cruiser, or Off-Road).

```java
/**
 * MotorVehicle.java
 * Interface defining motorcycle-specific behavior.
 * Specifies methods for setting and retrieving the number of wheels
 * and the type of motorcycle (sport, cruiser, or off-road).
 */
public interface MotorVehicle {
    void setNumberOfWheels(int wheels);
    int getNumberOfWheels();
    void setMotorcycleType(String type);
    String getMotorcycleType();
}
```

### 2.4 TruckVehicle Interface — Truck-Specific Contract

The `TruckVehicle` interface defines truck-specific behavior: managing cargo capacity in tons and transmission type (Manual or Automatic).

```java
/**
 * TruckVehicle.java
 * Interface defining truck-specific behavior.
 * Specifies methods for setting and retrieving the cargo capacity
 * (in tons) and the transmission type (manual or automatic).
 */
public interface TruckVehicle {
    void setCargoCapacity(double capacity);
    double getCargoCapacity();
    void setTransmissionType(String transmission);
    String getTransmissionType();
}
```

---

## 3. Class Implementation

### 3.1 Car Class

The `Car` class implements both `Vehicle` and `CarVehicle`, fulfilling both contracts simultaneously. This is Java's mechanism for multiple inheritance of type — a single class can be treated as both a `Vehicle` and a `CarVehicle` depending on context (Eck, 2022, Section 5.7). The constructor delegates to setter methods rather than assigning directly, ensuring validation runs even during object construction so the object can never exist in an invalid state (Eck, 2022, Section 5.1.3).

```java
/**
 * Car.java
 * Concrete class implementing both Vehicle and CarVehicle interfaces.
 * Represents a car with make, model, year, number of doors, and fuel type.
 */
public class Car implements Vehicle, CarVehicle {

    private String make;
    private String model;
    private int yearOfManufacture;
    private int numberOfDoors;
    private String fuelType;

    /**
     * Constructs a Car with the specified attributes.
     * @param make the manufacturer name
     * @param model the model name
     * @param yearOfManufacture the year of manufacture
     * @param numberOfDoors the number of doors (2-6)
     * @param fuelType the fuel type (Petrol, Diesel, or Electric)
     */
    public Car(String make, String model, int yearOfManufacture,
               int numberOfDoors, String fuelType) {
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        setNumberOfDoors(numberOfDoors);
        setFuelType(fuelType);
    }

    // ─── Vehicle Interface Methods ───────────────────────────────────────

    @Override
    public String getMake() { return make; }

    @Override
    public String getModel() { return model; }

    @Override
    public int getYearOfManufacture() { return yearOfManufacture; }

    // ─── CarVehicle Interface Methods ────────────────────────────────────

    @Override
    public void setNumberOfDoors(int doors) {
        if (doors >= 2 && doors <= 6) {
            this.numberOfDoors = doors;
        } else {
            throw new IllegalArgumentException(
                "Number of doors must be between 2 and 6. Received: " + doors);
        }
    }

    @Override
    public int getNumberOfDoors() { return numberOfDoors; }

    @Override
    public void setFuelType(String fuelType) {
        if (fuelType != null &&
            (fuelType.equalsIgnoreCase("Petrol") ||
             fuelType.equalsIgnoreCase("Diesel") ||
             fuelType.equalsIgnoreCase("Electric"))) {
            this.fuelType = fuelType.substring(0, 1).toUpperCase()
                          + fuelType.substring(1).toLowerCase();
        } else {
            throw new IllegalArgumentException(
                "Fuel type must be Petrol, Diesel, or Electric. Received: " + fuelType);
        }
    }

    @Override
    public String getFuelType() { return fuelType; }

    @Override
    public String toString() {
        return String.format(
            "Car Details:%n" +
            "  Make:            %s%n" +
            "  Model:           %s%n" +
            "  Year:            %d%n" +
            "  Number of Doors: %d%n" +
            "  Fuel Type:       %s",
            make, model, yearOfManufacture, numberOfDoors, fuelType);
    }
}
```

### 3.2 Motorcycle Class

The `Motorcycle` class implements both `Vehicle` and `MotorVehicle` interfaces. It stores motorcycle-specific attributes (number of wheels and motorcycle type) and validates inputs through setter methods. The `setMotorcycleType()` method normalizes capitalization to ensure consistent data storage regardless of how the user enters the value.

```java
/**
 * Motorcycle.java
 * Concrete class implementing both Vehicle and MotorVehicle interfaces.
 * Represents a motorcycle with make, model, year, number of wheels,
 * and motorcycle type.
 */
public class Motorcycle implements Vehicle, MotorVehicle {

    private String make;
    private String model;
    private int yearOfManufacture;
    private int numberOfWheels;
    private String motorcycleType;

    /**
     * Constructs a Motorcycle with the specified attributes.
     * @param make the manufacturer name
     * @param model the model name
     * @param yearOfManufacture the year of manufacture
     * @param numberOfWheels the number of wheels (2-3)
     * @param motorcycleType the type (Sport, Cruiser, or Off-Road)
     */
    public Motorcycle(String make, String model, int yearOfManufacture,
                      int numberOfWheels, String motorcycleType) {
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        setNumberOfWheels(numberOfWheels);
        setMotorcycleType(motorcycleType);
    }

    // ─── Vehicle Interface Methods ───────────────────────────────────────

    @Override
    public String getMake() { return make; }

    @Override
    public String getModel() { return model; }

    @Override
    public int getYearOfManufacture() { return yearOfManufacture; }

    // ─── MotorVehicle Interface Methods ──────────────────────────────────

    @Override
    public void setNumberOfWheels(int wheels) {
        if (wheels >= 2 && wheels <= 3) {
            this.numberOfWheels = wheels;
        } else {
            throw new IllegalArgumentException(
                "Number of wheels must be 2 or 3. Received: " + wheels);
        }
    }

    @Override
    public int getNumberOfWheels() { return numberOfWheels; }

    @Override
    public void setMotorcycleType(String type) {
        if (type != null &&
            (type.equalsIgnoreCase("Sport") ||
             type.equalsIgnoreCase("Cruiser") ||
             type.equalsIgnoreCase("Off-Road"))) {
            if (type.equalsIgnoreCase("Off-Road")) {
                this.motorcycleType = "Off-Road";
            } else {
                this.motorcycleType = type.substring(0, 1).toUpperCase()
                                    + type.substring(1).toLowerCase();
            }
        } else {
            throw new IllegalArgumentException(
                "Motorcycle type must be Sport, Cruiser, or Off-Road. Received: " + type);
        }
    }

    @Override
    public String getMotorcycleType() { return motorcycleType; }

    @Override
    public String toString() {
        return String.format(
            "Motorcycle Details:%n" +
            "  Make:            %s%n" +
            "  Model:           %s%n" +
            "  Year:            %d%n" +
            "  Number of Wheels:%d%n" +
            "  Type:            %s",
            make, model, yearOfManufacture, numberOfWheels, motorcycleType);
    }
}
```

### 3.3 Truck Class

The `Truck` class implements both `Vehicle` and `TruckVehicle` interfaces. It manages truck-specific attributes including cargo capacity (validated to be positive) and transmission type (validated to be either Manual or Automatic). Liang (2020) notes that setter validation is essential for maintaining object integrity, as it prevents the object from entering an inconsistent state (p. 380).

```java
/**
 * Truck.java
 * Concrete class implementing both Vehicle and TruckVehicle interfaces.
 * Represents a truck with make, model, year, cargo capacity,
 * and transmission type.
 */
public class Truck implements Vehicle, TruckVehicle {

    private String make;
    private String model;
    private int yearOfManufacture;
    private double cargoCapacity;
    private String transmissionType;

    /**
     * Constructs a Truck with the specified attributes.
     * @param make the manufacturer name
     * @param model the model name
     * @param yearOfManufacture the year of manufacture
     * @param cargoCapacity the cargo capacity in tons (must be positive)
     * @param transmissionType the transmission type (Manual or Automatic)
     */
    public Truck(String make, String model, int yearOfManufacture,
                 double cargoCapacity, String transmissionType) {
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        setCargoCapacity(cargoCapacity);
        setTransmissionType(transmissionType);
    }

    // ─── Vehicle Interface Methods ───────────────────────────────────────

    @Override
    public String getMake() { return make; }

    @Override
    public String getModel() { return model; }

    @Override
    public int getYearOfManufacture() { return yearOfManufacture; }

    // ─── TruckVehicle Interface Methods ──────────────────────────────────

    @Override
    public void setCargoCapacity(double capacity) {
        if (capacity > 0) {
            this.cargoCapacity = capacity;
        } else {
            throw new IllegalArgumentException(
                "Cargo capacity must be positive. Received: " + capacity);
        }
    }

    @Override
    public double getCargoCapacity() { return cargoCapacity; }

    @Override
    public void setTransmissionType(String transmission) {
        if (transmission != null &&
            (transmission.equalsIgnoreCase("Manual") ||
             transmission.equalsIgnoreCase("Automatic"))) {
            this.transmissionType = transmission.substring(0, 1).toUpperCase()
                                  + transmission.substring(1).toLowerCase();
        } else {
            throw new IllegalArgumentException(
                "Transmission type must be Manual or Automatic. Received: "
                + transmission);
        }
    }

    @Override
    public String getTransmissionType() { return transmissionType; }

    @Override
    public String toString() {
        return String.format(
            "Truck Details:%n" +
            "  Make:            %s%n" +
            "  Model:           %s%n" +
            "  Year:            %d%n" +
            "  Cargo Capacity:  %.1f tons%n" +
            "  Transmission:    %s",
            make, model, yearOfManufacture, cargoCapacity, transmissionType);
    }
}
```

---

## 4. Main Program — VehicleInformationSystem

The main program integrates all classes into an interactive system. It stores vehicles in an `ArrayList<Vehicle>` — using the interface type as the element type. This is polymorphism in action: the list holds `Car`, `Motorcycle`, and `Truck` objects, but the code interacts with them through the common `Vehicle` interface (Eck, 2022, Section 5.7). The `displayAllVehicles()` method iterates over the list and calls `toString()` on each element — dynamic binding ensures the correct overridden version is called for each vehicle type at runtime.

```java
import java.util.ArrayList;
import java.util.Scanner;

/**
 * VehicleInformationSystem.java
 * Main program for the Vehicle Information System.
 * Provides an interactive menu that allows users to create Car, Motorcycle,
 * and Truck objects, input their details, and display all vehicle information.
 * Demonstrates interfaces, polymorphism, and error handling.
 */
public class VehicleInformationSystem {

    // Store all vehicles using the Vehicle interface type — polymorphism
    private static ArrayList<Vehicle> vehicles = new ArrayList<>();

    /**
     * Creates a Car object by collecting input from the user.
     * Validates all inputs and handles errors gracefully.
     */
    private static void addCar(Scanner sc) {
        System.out.println("\n--- Add a New Car ---");
        try {
            System.out.print("Enter make: ");
            String make = sc.nextLine().trim();
            if (make.isEmpty()) {
                System.out.println("Error: Make cannot be empty.");
                return;
            }

            System.out.print("Enter model: ");
            String model = sc.nextLine().trim();
            if (model.isEmpty()) {
                System.out.println("Error: Model cannot be empty.");
                return;
            }

            System.out.print("Enter year of manufacture: ");
            int year = Integer.parseInt(sc.nextLine().trim());
            if (year < 1886 || year > 2026) {
                System.out.println("Error: Year must be between 1886 and 2026.");
                return;
            }

            System.out.print("Enter number of doors (2-6): ");
            int doors = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Enter fuel type (Petrol/Diesel/Electric): ");
            String fuel = sc.nextLine().trim();

            Car car = new Car(make, model, year, doors, fuel);
            vehicles.add(car);
            System.out.println("\nCar added successfully!");
            System.out.println(car);

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format. Please enter a valid integer.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Creates a Motorcycle object by collecting input from the user.
     * Validates all inputs and handles errors gracefully.
     */
    private static void addMotorcycle(Scanner sc) {
        System.out.println("\n--- Add a New Motorcycle ---");
        try {
            System.out.print("Enter make: ");
            String make = sc.nextLine().trim();
            if (make.isEmpty()) {
                System.out.println("Error: Make cannot be empty.");
                return;
            }

            System.out.print("Enter model: ");
            String model = sc.nextLine().trim();
            if (model.isEmpty()) {
                System.out.println("Error: Model cannot be empty.");
                return;
            }

            System.out.print("Enter year of manufacture: ");
            int year = Integer.parseInt(sc.nextLine().trim());
            if (year < 1886 || year > 2026) {
                System.out.println("Error: Year must be between 1886 and 2026.");
                return;
            }

            System.out.print("Enter number of wheels (2-3): ");
            int wheels = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Enter motorcycle type (Sport/Cruiser/Off-Road): ");
            String type = sc.nextLine().trim();

            Motorcycle motorcycle = new Motorcycle(make, model, year, wheels, type);
            vehicles.add(motorcycle);
            System.out.println("\nMotorcycle added successfully!");
            System.out.println(motorcycle);

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format. Please enter a valid integer.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Creates a Truck object by collecting input from the user.
     * Validates all inputs and handles errors gracefully.
     */
    private static void addTruck(Scanner sc) {
        System.out.println("\n--- Add a New Truck ---");
        try {
            System.out.print("Enter make: ");
            String make = sc.nextLine().trim();
            if (make.isEmpty()) {
                System.out.println("Error: Make cannot be empty.");
                return;
            }

            System.out.print("Enter model: ");
            String model = sc.nextLine().trim();
            if (model.isEmpty()) {
                System.out.println("Error: Model cannot be empty.");
                return;
            }

            System.out.print("Enter year of manufacture: ");
            int year = Integer.parseInt(sc.nextLine().trim());
            if (year < 1886 || year > 2026) {
                System.out.println("Error: Year must be between 1886 and 2026.");
                return;
            }

            System.out.print("Enter cargo capacity in tons: ");
            double capacity = Double.parseDouble(sc.nextLine().trim());

            System.out.print("Enter transmission type (Manual/Automatic): ");
            String transmission = sc.nextLine().trim();

            Truck truck = new Truck(make, model, year, capacity, transmission);
            vehicles.add(truck);
            System.out.println("\nTruck added successfully!");
            System.out.println(truck);

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format. Please enter a valid number.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Displays all vehicles stored in the system.
     * Uses polymorphism — each vehicle's toString() is called dynamically.
     */
    private static void displayAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("\nNo vehicles in the system.");
            return;
        }
        System.out.println("\n========================================");
        System.out.println("  All Vehicles in the System (" + vehicles.size() + " total)");
        System.out.println("========================================");
        int count = 1;
        for (Vehicle v : vehicles) {
            System.out.println("\n[Vehicle #" + count + "]");
            System.out.println(v);  // polymorphic call to toString()
            count++;
        }
        System.out.println("\n========================================");
    }

    /**
     * Displays a summary count of each vehicle type.
     */
    private static void displaySummary() {
        int cars = 0, motorcycles = 0, trucks = 0;
        for (Vehicle v : vehicles) {
            if (v instanceof Car) cars++;
            else if (v instanceof Motorcycle) motorcycles++;
            else if (v instanceof Truck) trucks++;
        }
        System.out.println("\n--- Vehicle Summary ---");
        System.out.println("  Cars:        " + cars);
        System.out.println("  Motorcycles: " + motorcycles);
        System.out.println("  Trucks:      " + trucks);
        System.out.println("  Total:       " + vehicles.size());
    }

    /**
     * Main method — entry point for the Vehicle Information System.
     * Displays an interactive menu and processes user choices.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("==============================================");
        System.out.println("       Vehicle Information System");
        System.out.println("       Car Rental Agency Management");
        System.out.println("==============================================");

        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add a Car");
            System.out.println("2. Add a Motorcycle");
            System.out.println("3. Add a Truck");
            System.out.println("4. Display All Vehicles");
            System.out.println("5. Display Vehicle Summary");
            System.out.println("6. Exit");
            System.out.print("Enter choice (1-6): ");

            String input = sc.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                continue;
            }

            switch (choice) {
                case 1: addCar(sc);        break;
                case 2: addMotorcycle(sc); break;
                case 3: addTruck(sc);      break;
                case 4: displayAllVehicles(); break;
                case 5: displaySummary();  break;
                case 6:
                    System.out.println("\nExiting Vehicle Information System. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
        sc.close();
    }
}
```

---

## 5. Error Handling

The system implements a two-level error handling strategy to ensure robust and stable operation:

**Level 1 — Class-Level Validation (IllegalArgumentException):**

Each setter method in the implementing classes validates its input before assignment. If the input violates business rules, the method throws an `IllegalArgumentException` with a descriptive error message. This ensures that objects can never exist in an invalid state — a principle Eck (2022) emphasizes as critical for maintaining data integrity in object-oriented systems (Section 5.1.3).

| Class | Setter | Validation Rule |
|-------|--------|-----------------|
| `Car` | `setNumberOfDoors(int)` | Must be between 2 and 6 |
| `Car` | `setFuelType(String)` | Must be "Petrol", "Diesel", or "Electric" |
| `Motorcycle` | `setNumberOfWheels(int)` | Must be 2 or 3 |
| `Motorcycle` | `setMotorcycleType(String)` | Must be "Sport", "Cruiser", or "Off-Road" |
| `Truck` | `setCargoCapacity(double)` | Must be positive (> 0) |
| `Truck` | `setTransmissionType(String)` | Must be "Manual" or "Automatic" |

**Level 2 — Main Program Input Handling (try-catch):**

The main program wraps all user input processing in `try-catch` blocks that catch:

- `NumberFormatException` — when the user enters non-numeric text where a number is expected (e.g., typing "abc" for year)
- `IllegalArgumentException` — when the user enters a value that passes type checking but fails business validation (e.g., entering 8 for number of doors)

This two-level approach ensures that the program never crashes regardless of what the user enters, and always provides a clear, informative error message explaining what went wrong and what is expected.

---

## 6. Output Screenshots

### Screenshot 1 — IntelliJ IDEA Project Structure

*[INSERT SCREENSHOT: IntelliJ IDEA showing the project panel with all 7 Java files (Vehicle.java, CarVehicle.java, MotorVehicle.java, TruckVehicle.java, Car.java, Motorcycle.java, Truck.java, VehicleInformationSystem.java) and the editor open on VehicleInformationSystem.java]*

### Screenshot 2 — Adding a Car

*[INSERT SCREENSHOT: IntelliJ console showing the menu, user entering Car details (Toyota, Camry, 2023, 4 doors, Petrol), and the successful output displaying all car details]*

### Screenshot 3 — Adding a Motorcycle

*[INSERT SCREENSHOT: IntelliJ console showing user entering Motorcycle details (Honda, CBR600, 2022, 2 wheels, Sport), and the successful output displaying all motorcycle details]*

### Screenshot 4 — Adding a Truck

*[INSERT SCREENSHOT: IntelliJ console showing user entering Truck details (Ford, F-150, 2024, 5.0 tons, Automatic), and the successful output displaying all truck details]*

### Screenshot 5 — Displaying All Vehicles

*[INSERT SCREENSHOT: IntelliJ console showing the "Display All Vehicles" output with all three vehicles listed with their complete details]*

### Screenshot 6 — Error Handling Demonstration

*[INSERT SCREENSHOT: IntelliJ console showing error handling in action — e.g., entering an invalid number of doors (8), invalid fuel type, or non-numeric input for year]*

---

## 7. Explanation and Documentation Summary

### 7.1 Interface Design Summary

The system uses four interfaces to define contracts:

| Interface | Purpose | Methods |
|-----------|---------|---------|
| `Vehicle` | Base contract for all vehicles | `getMake()`, `getModel()`, `getYearOfManufacture()` |
| `CarVehicle` | Car-specific contract | `setNumberOfDoors()`, `getNumberOfDoors()`, `setFuelType()`, `getFuelType()` |
| `MotorVehicle` | Motorcycle-specific contract | `setNumberOfWheels()`, `getNumberOfWheels()`, `setMotorcycleType()`, `getMotorcycleType()` |
| `TruckVehicle` | Truck-specific contract | `setCargoCapacity()`, `getCargoCapacity()`, `setTransmissionType()`, `getTransmissionType()` |

Each interface defines a contract that specifies the methods for retrieving and setting vehicle details, ensuring a consistent structure for different vehicle types. The `Vehicle` interface provides the common base that enables polymorphic processing of all vehicle types through a single reference type (Eck, 2022, Section 5.7).

### 7.2 Class Implementation Summary

| Class | Implements | Attributes |
|-------|-----------|------------|
| `Car` | `Vehicle`, `CarVehicle` | make, model, year, numberOfDoors, fuelType |
| `Motorcycle` | `Vehicle`, `MotorVehicle` | make, model, year, numberOfWheels, motorcycleType |
| `Truck` | `Vehicle`, `TruckVehicle` | make, model, year, cargoCapacity, transmissionType |

Each class translates the interface specifications into concrete implementations, enabling the storage and retrieval of specific attributes and behaviors. All instance variables are declared `private` with access controlled through public getter and setter methods — following the encapsulation principle that Eck (2022) describes as giving the programmer "complete control over what can be done with the variable" (Section 5.1.3).

### 7.3 Main Program Summary

The `VehicleInformationSystem` class provides a comprehensive interactive interface that:

1. **Prompts the user** for all relevant information for each vehicle type (make, model, year of manufacture, number of doors, fuel type, number of wheels, motorcycle type, cargo capacity, and transmission type)
2. **Creates objects** of the appropriate vehicle type using the collected input
3. **Stores all vehicles** in a polymorphic `ArrayList<Vehicle>` collection
4. **Displays complete details** of each vehicle including all user-provided information
5. **Provides a summary** showing the count of each vehicle type in the system

### 7.4 Code Quality

The codebase follows Java coding best practices:

- **Meaningful variable names**: `numberOfDoors`, `cargoCapacity`, `motorcycleType` clearly communicate purpose
- **Consistent indentation**: 4-space indentation throughout all files
- **Comprehensive Javadoc comments**: Every class, constructor, and method is documented with purpose, parameters, and behavior
- **Section dividers**: Visual separators (`// ─── Section ───`) organize code within classes
- **Single Responsibility**: Each class has one well-defined purpose
- **DRY Principle**: Validation logic is centralized in setter methods, not duplicated

---

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, JavaFX ed.). Creative Commons CC 4.0. [https://math.hws.edu/javanotes/](https://math.hws.edu/javanotes/)

Liang, Y. D. (2020). *Introduction to Java programming and data structures* (12th ed.). Pearson.
