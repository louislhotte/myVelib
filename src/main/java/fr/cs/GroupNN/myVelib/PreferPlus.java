package fr.cs.GroupNN.myVelib;

import java.util.*;

public class PreferPlus extends Normal {
    @Override
    public double[][] optimalItinerary(double[] startLocation,double[] endLocation, String bicycleType){
        ArrayList<DockingStation> dockingStations = DockingStation.getDockingStations();

        double[][] normalOptimal = super.optimalItinerary(startLocation, endLocation, bicycleType);
        double[] nearestToStartLocation = normalOptimal[0] ;
        double[] nearestToEndLocation = normalOptimal[1];

        DockingStation nearestToStart = DockingStation.getDockingStationFromLocation(nearestToStartLocation);
        DockingStation nearestToEnd = DockingStation.getDockingStationFromLocation(nearestToEndLocation);

        double distanceToNearestToEndStation = distance(endLocation, nearestToEndLocation);

        final double RATE = 10.0;

        if (nearestToEnd.getStationType().toLowerCase().equals("plus"))
            return new double[][]{nearestToStartLocation, nearestToEndLocation};

        for(DockingStation dockingStation: dockingStations){
            double[] currentDockingStationLocation = dockingStation.getDockingStationLocation();
            if (dockingStation.getStationType().toLowerCase().equals("plus") && dockingStation.oneFree() && distance(currentDockingStationLocation, endLocation) < distanceToNearestToEndStation * (double)(1 + (RATE/100.0)) ){
                System.out.println("yes");
                nearestToEndLocation = currentDockingStationLocation;
                nearestToEnd = dockingStation;
            }
        }

        return new double[][]{nearestToStartLocation, nearestToEndLocation};
    }
}