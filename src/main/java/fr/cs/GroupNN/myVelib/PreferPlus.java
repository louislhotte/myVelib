package fr.cs.GroupNN.myVelib;

import java.util.*;

public class PreferPlus extends Normal implements PlanningPolicy{
    @Override
    public double[][] optimalItinerary(double[] startLocation,double[] endLocation, String bicycleType){
        ArrayList<DockingStation> dockingStations = DockingStation.getDockingStations();

        DockingStation nearestToStart = null;
        DockingStation nearestToEnd = null;

        double[][] normalOptimal = super.optimalItinerary(startLocation, endLocation, bicycleType);
        double[] nearestToStartLocation = normalOptimal[0] ;
        double[] nearestToEndLocation = normalOptimal[1];

        double distanceToNearestToEndStation = distance(endLocation, nearestToEndLocation);

        final double RATE = 10.0;

        if (nearestToEnd.getStationType() == "plus")
            return new double[][]{nearestToStartLocation, nearestToEndLocation};

        for(DockingStation dockingStation: dockingStations){
            double[] currentDockingStationLocation = dockingStation.getDockingStationLocation();
            if (dockingStation.getStationType() == "plus" && dockingStation.oneBike(bicycleType) && distance(currentDockingStationLocation, endLocation) < distanceToNearestToEndStation * (1 + RATE/100)){
                nearestToEndLocation = currentDockingStationLocation;
                nearestToEnd = dockingStation;
            }
        }

        return new double[][]{nearestToStartLocation, nearestToEndLocation};
    }
}