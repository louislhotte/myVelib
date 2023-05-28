package fr.cs.GroupNN.myVelib;

import java.util.ArrayList;

public class Planner{
    // fields
    private double[] startLocation;
    private double[] endLocation;
    private String bicycleType;
    private PlanningPolicy policy;

    // constructor
    public Planner(double[] startLocation, double[] endLocation, String bicycleType, PlanningPolicy policy){
        super();
        this.setStartLocation(startLocation);
        this.setEndLocation(endLocation);
        this.bicycleType = bicycleType;
        this.policy = policy;
    }

    // getters and setters
    public double[] getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(double[] startLocation) {
        this.startLocation = startLocation;
    }

    public double[] getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(double[] endLocation) {
        this.endLocation = endLocation;
    }

    // other methods
    public double[][] optimalItinerary(){
        return policy.optimalItinerary(startLocation, endLocation, bicycleType);
    }
}