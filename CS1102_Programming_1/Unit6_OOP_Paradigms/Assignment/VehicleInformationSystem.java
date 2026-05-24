import java.util.ArrayList;
import java.util.Scanner;

/**
 * VehicleInformationSystem.java
 * Main program for the Vehicle Information System.
 * Provides an interactive menu that allows users to create Car, Motorcycle,
 * and Truck objects, input their details, and display all vehicle information.
 * Demonstrates interfaces, polymorphism, and error handling.
 *
 * @author Nicanor Kyamba
 * @course CS 1102 — Programming 1, Unit 6
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
            if (make.isEmpty()) { System.out.println("Error: Make cannot be empty."); return; }

            System.out.print("Enter model: ");
            String model = sc.nextLine().trim();
            if (model.isEmpty()) { System.out.println("Error: Model cannot be empty."); return; }

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
            if (make.isEmpty()) { System.out.println("Error: Make cannot be empty."); return; }

            System.out.print("Enter model: ");
            String model = sc.nextLine().trim();
            if (model.isEmpty()) { System.out.println("Error: Model cannot be empty."); return; }

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
            if (make.isEmpty()) { System.out.println("Error: Make cannot be empty."); return; }

            System.out.print("Enter model: ");
            String model = sc.nextLine().trim();
            if (model.isEmpty()) { System.out.println("Error: Model cannot be empty."); return; }

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
