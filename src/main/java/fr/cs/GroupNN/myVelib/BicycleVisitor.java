package fr.cs.GroupNN.myVelib;

public interface BicycleVisitor {
    void visit(MechanicalBicycle bicycle);
    void visit(ElectricalBicycle bicycle);
}
