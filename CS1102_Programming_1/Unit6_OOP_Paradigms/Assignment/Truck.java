/**
 * Truck.java
 * Concrete class implementing both Vehicle and TruckVehicle interfaces.
 * Represents a truck with make, model, year, cargo capacity,
 * and transmission type.
 *
 * @author Nicanor Kyamba
 * @course CS 1102 — Programming 1, Unit 6
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

    // ─── TruckVehicle Interface Methods ──────────────────────────────────────

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
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public void setTransmissionType(String transmission) {
        if (transmission != null &&
            (transmission.equalsIgnoreCase("Manual") ||
             transmission.equalsIgnoreCase("Automatic"))) {
            this.transmissionType = transmission.substring(0, 1).toUpperCase()
                                  + transmission.substring(1).toLowerCase();
        } else {
            throw new IllegalArgumentException(
                "Transmission type must be Manual or Automatic. Received: " + transmission);
        }
    }

    @Override
    public String getTransmissionType() {
        return transmissionType;
    }

    // ─── Display Method ──────────────────────────────────────────────────────

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
