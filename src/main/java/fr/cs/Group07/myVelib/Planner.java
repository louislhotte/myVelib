package fr.cs.Group07.myVelib;


/**
 * Represents a planner for finding an optimal itinerary.
 */

public class Planner{
    // fields
    private double[] startLocation;
    private double[] endLocation;
    private String bicycleType;
    private PlanningPolicy policy;

    /**
     * Constructs a new Planner object.
     *
     * @param startLocation The starting location for the itinerary.
     * @param endLocation   The ending location for the itinerary.
     * @param bicycleType   The type of bicycle to use for the itinerary.
     * @param policy        The planning policy to use for the itinerary.
     */
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


    /**
     * Retrieves the optimal itinerary based on the start and end locations, and bicycle type.
     *
     * @return The optimal itinerary as a two-dimensional array of coordinates.
     */
    // other methods
    public double[][] optimalItinerary(){
        return policy.optimalItinerary(startLocation, endLocation, bicycleType);
    }
}