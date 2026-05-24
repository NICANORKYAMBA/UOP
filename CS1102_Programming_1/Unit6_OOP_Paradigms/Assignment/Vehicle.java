
/**
 * Vehicle.java
 * Base interface for the Vehicle Information System.
 * Defines the contract for retrieving basic vehicle information
 * that all vehicle types must implement.
 *
 * @author Nicanor Kyamba
 * @course CS 1102 — Programming 1, Unit 6
 */
public interface Vehicle {

    /**
     * Returns the manufacturer/make of the vehicle.
     *
     * @return the vehicle's make (e.g., "Toyota", "Honda", "Ford")
     */
    String getMake();

    /**
     * Returns the model name of the vehicle.
     *
     * @return the vehicle's model (e.g., "Camry", "CBR600", "F-150")
     */
    String getModel();

    /**
     * Returns the year the vehicle was manufactured.
     *
     * @return the year of manufacture (e.g., 2023)
     */
    int getYearOfManufacture();
}
