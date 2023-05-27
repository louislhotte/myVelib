package fr.cs.GroupNN.myVelib;

public class ElectricalBicycle extends Bicycle {
    public ElectricalBicycle(int bicycleId, double[] bicycleLocation, String bicycleType) {
        super(bicycleId, bicycleLocation, "Electrical");
    }

    @Override
    public void accept(BicycleVisitor visitor) {

        visitor.visit(this);
    }
}
