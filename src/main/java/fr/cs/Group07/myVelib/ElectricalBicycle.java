package fr.cs.Group07.myVelib;


/**
 * The ElectricalBicycle class represents an electrical bicycle.
 * It extends the Bicycle class.
 */
public class ElectricalBicycle extends Bicycle {
    private double hourlyRate;
    /**
     * Constructs an ElectricalBicycle object with the specified bicycle location.
     *
     * @param bicycleLocation the coordinates representing the bicycle location
     */
    public ElectricalBicycle(double[] bicycleLocation) {
        super(bicycleLocation, "Electrical");
        this.hourlyRate = 2.0;
    }

    @Override
    public void accept(BicycleVisitor visitor) {

        visitor.visit(this);
    }

    public double getHourlyRate() {
        return hourlyRate;
    }
}
