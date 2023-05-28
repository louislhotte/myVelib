package fr.cs.GroupNN.myVelib;

public class MechanicalBicycle extends Bicycle {
    private double hourlyRate;
    public MechanicalBicycle(int bicycleId, double[] bicycleLocation, String bicycleType) {
        super(bicycleId, bicycleLocation, "Mechanical");
        this.hourlyRate = 1.0;
    }

    @Override
    public void accept(BicycleVisitor visitor) {

        visitor.visit(this);
    }

    public double getHourlyRate() {
        return hourlyRate;
    }
}
