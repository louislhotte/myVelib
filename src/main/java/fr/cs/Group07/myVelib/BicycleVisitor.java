package fr.cs.Group07.myVelib;

public interface BicycleVisitor {
    void visit(MechanicalBicycle bicycle);
    void visit(ElectricalBicycle bicycle);
}
