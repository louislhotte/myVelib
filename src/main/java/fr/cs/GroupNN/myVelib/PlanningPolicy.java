package fr.cs.GroupNN.myVelib;

public interface PlanningPolicy{
    DockingStation[] optimalItinerary(double[] startLocation,double[] endLocation, String bicycleType);

    default distance(double[] point1, double[] point2){
        double[] differenceVector = {point2[0] - point1[0], point2[1] - point1[1]};
        double dist = Math.abs(differenceVector[0]) + Math.abs(differenceVector[1]);
        return dist;
    }
}