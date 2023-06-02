package fr.cs.Group07.myVelib;
/**
 * The PlanningPolicy interface defines the contract for a planning policy used to determine the optimal itinerary
 * for a given start location, end location, and bicycle type.
 */


public interface PlanningPolicy {

    /**
     * Computes the optimal itinerary for a given start location, end location, and bicycle type.
     *
     * @param startLocation the coordinates representing the start location
     * @param endLocation   the coordinates representing the end location
     * @param bicycleType   the type of bicycle
     * @return a 2D array of doubles representing the optimal itinerary with intermediate locations
     */
    double[][] optimalItinerary(double[] startLocation, double[] endLocation, String bicycleType);

    /**
     * Computes the Euclidean distance between two points in 2D space.
     *
     * @param point1 the coordinates of the first point
     * @param point2 the coordinates of the second point
     * @return the Euclidean distance between the two points
     */
    default double distance(double[] point1, double[] point2) {
        double[] differenceVector = {point2[0] - point1[0], point2[1] - point1[1]};
        double dist = Math.abs(differenceVector[0]) + Math.abs(differenceVector[1]);
        return dist;
    }
}