package fr.cs.Group07.myVelib;
/**
 * The MechanicalBicycle class represents a mechanical bicycle.
 * It extends the Bicycle class.
 */
public class MechanicalBicycle extends Bicycle {
    private double hourlyRate;

    /**
     * Constructs a MechanicalBicycle object with the specified bicycle location.
     *
     * @param bicycleLocation the coordinates representing the bicycle location
     */

    public MechanicalBicycle(double[] bicycleLocation) {
        super(bicycleLocation, "Mechanical");
        this.hourlyRate = 1.0;
    }
    /**
     * Accepts a visitor for the mechanical bicycle.
     *
     * @param visitor the visitor object to accept
     */
    @Override
    public void accept(BicycleVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * Returns the hourly rate for renting the mechanical bicycle.
     *
     * @return the hourly rate for renting the mechanical bicycle
     */
    public double getHourlyRate() {
        return hourlyRate;
    }
}

