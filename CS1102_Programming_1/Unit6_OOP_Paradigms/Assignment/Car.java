/**
 * Car.java
 * Concrete class implementing both Vehicle and CarVehicle interfaces.
 * Represents a car with make, model, year, number of doors, and fuel type.
 * Demonstrates multiple interface implementation and encapsulation.
 *
 * @author Nicanor Kyamba
 * @course CS 1102 — Programming 1, Unit 6
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

    // ─── Vehicle Interface Methods ───────────────────────────────────────────

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    // ─── CarVehicle Interface Methods ────────────────────────────────────────

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
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

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
    public String getFuelType() {
        return fuelType;
    }

    // ─── Display Method ──────────────────────────────────────────────────────

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
