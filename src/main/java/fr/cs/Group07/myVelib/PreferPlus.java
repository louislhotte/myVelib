package fr.cs.Group07.myVelib;

import java.util.ArrayList;

/**
 * The PreferPlus class represents a sorting policy that prefers docking stations with plus type
 * when determining the optimal itinerary for a user's trip.
 */
public class PreferPlus extends Normal {

    /**
     * Retrieves the optimal itinerary based on the start and end locations, and bicycle type.
     *
     * @param startLocation The start location of the trip.
     * @param endLocation   The end location of the trip.
     * @param bicycleType   The type of bicycle.
     * @return The optimal itinerary as a two-dimensional array of coordinates.
     */
    @Override
    public double[][] optimalItinerary(double[] startLocation, double[] endLocation, String bicycleType) {
        ArrayList<DockingStation> dockingStations = DockingStation.getDockingStations();

        double[][] normalOptimal = super.optimalItinerary(startLocation, endLocation, bicycleType);
        double[] nearestToStartLocation = normalOptimal[0];
        double[] nearestToEndLocation = normalOptimal[1];

        DockingStation nearestToStart = DockingStation.getDockingStationFromLocation(nearestToStartLocation);
        DockingStation nearestToEnd = DockingStation.getDockingStationFromLocation(nearestToEndLocation);

        double distanceToNearestToEndStation = distance(endLocation, nearestToEndLocation);

        final double RATE = 10.0;

        if (nearestToEnd.getStationType().equalsIgnoreCase("plus")) {
            return new double[][]{nearestToStartLocation, nearestToEndLocation};
        }

        for (DockingStation dockingStation : dockingStations) {
            double[] currentDockingStationLocation = dockingStation.getDockingStationLocation();
            if (dockingStation.getStationType().equalsIgnoreCase("plus") && dockingStation.oneFree() && distance(currentDockingStationLocation, endLocation) < distanceToNearestToEndStation * (1 + (RATE / 100.0))) {
                nearestToEndLocation = currentDockingStationLocation;
                nearestToEnd = dockingStation;
            }
        }

        return new double[][]{nearestToStartLocation, nearestToEndLocation};
    }
}
