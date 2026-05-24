/**
 * CarVehicle.java
 * Interface defining car-specific behavior.
 * Specifies methods for setting and retrieving the number of doors
 * and the fuel type (petrol, diesel, or electric).
 *
 * @author Nicanor Kyamba
 * @course CS 1102 — Programming 1, Unit 6
 */
public interface CarVehicle {

    /**
     * Sets the number of doors on the car.
     * @param doors the number of doors (must be between 2 and 6)
     */
    void setNumberOfDoors(int doors);

    /**
     * Returns the number of doors on the car.
     * @return the number of doors
     */
    int getNumberOfDoors();

    /**
     * Sets the fuel type of the car.
     * @param fuelType the fuel type — must be "Petrol", "Diesel", or "Electric"
     */
    void setFuelType(String fuelType);

    /**
     * Returns the fuel type of the car.
     * @return the fuel type (Petrol, Diesel, or Electric)
     */
    String getFuelType();
}
