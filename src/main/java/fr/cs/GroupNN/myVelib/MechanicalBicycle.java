package fr.cs.GroupNN.myVelib;

public class MechanicalBicycle extends Bicycle {
    public MechanicalBicycle(int bicycleId, double[] bicycleLocation, String bicycleType) {
        super(bicycleId, bicycleLocation, "Mechanical");
    }

    @Override
    public void accept(BicycleVisitor visitor) {

        visitor.visit(this);
    }
}
