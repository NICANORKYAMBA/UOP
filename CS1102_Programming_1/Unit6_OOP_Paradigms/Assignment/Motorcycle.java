/**
 * Motorcycle.java
 * Concrete class implementing both Vehicle and MotorVehicle interfaces.
 * Represents a motorcycle with make, model, year, number of wheels,
 * and motorcycle type.
 *
 * @author Nicanor Kyamba
 * @course CS 1102 — Programming 1, Unit 6
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

    // ─── MotorVehicle Interface Methods ──────────────────────────────────────

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
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    @Override
    public void setMotorcycleType(String type) {
        if (type != null &&
            (type.equalsIgnoreCase("Sport") ||
             type.equalsIgnoreCase("Cruiser") ||
             type.equalsIgnoreCase("Off-Road"))) {
            // Normalize capitalization
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
    public String getMotorcycleType() {
        return motorcycleType;
    }

    // ─── Display Method ──────────────────────────────────────────────────────

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
