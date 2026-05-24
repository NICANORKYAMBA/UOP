/**
 * MotorVehicle.java
 * Interface defining motorcycle-specific behavior.
 * Specifies methods for setting and retrieving the number of wheels
 * and the type of motorcycle (sport, cruiser, or off-road).
 *
 * @author Nicanor Kyamba
 * @course CS 1102 — Programming 1, Unit 6
 */
public interface MotorVehicle {

    /**
     * Sets the number of wheels on the motorcycle.
     * @param wheels the number of wheels (must be between 2 and 3)
     */
    void setNumberOfWheels(int wheels);

    /**
     * Returns the number of wheels on the motorcycle.
     * @return the number of wheels
     */
    int getNumberOfWheels();

    /**
     * Sets the type of motorcycle.
     * @param type the motorcycle type — must be "Sport", "Cruiser", or "Off-Road"
     */
    void setMotorcycleType(String type);

    /**
     * Returns the type of motorcycle.
     * @return the motorcycle type (Sport, Cruiser, or Off-Road)
     */
    String getMotorcycleType();
}
