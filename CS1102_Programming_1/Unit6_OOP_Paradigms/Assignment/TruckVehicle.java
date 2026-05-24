/**
 * TruckVehicle.java
 * Interface defining truck-specific behavior.
 * Specifies methods for setting and retrieving the cargo capacity
 * (in tons) and the transmission type (manual or automatic).
 *
 * @author Nicanor Kyamba
 * @course CS 1102 — Programming 1, Unit 6
 */
public interface TruckVehicle {

    /**
     * Sets the cargo capacity of the truck in tons.
     * @param capacity the cargo capacity (must be positive)
     */
    void setCargoCapacity(double capacity);

    /**
     * Returns the cargo capacity of the truck in tons.
     * @return the cargo capacity in tons
     */
    double getCargoCapacity();

    /**
     * Sets the transmission type of the truck.
     * @param transmission the transmission type — must be "Manual" or "Automatic"
     */
    void setTransmissionType(String transmission);

    /**
     * Returns the transmission type of the truck.
     * @return the transmission type (Manual or Automatic)
     */
    String getTransmissionType();
}
