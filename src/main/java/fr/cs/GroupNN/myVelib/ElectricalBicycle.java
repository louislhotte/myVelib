package fr.cs.GroupNN.myVelib;

public class ElectricalBicycle extends Bicycle {
    private double hourlyRate;

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
