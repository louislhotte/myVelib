package fr.cs.GroupNN.myVelib;

import java.util.*;

public class AvoidPlus implements PlanningPolicy{
    @Override
    public double[][] optimalItinerary(double[] startLocation,double[] endLocation, String bicycleType){
        ArrayList<DockingStation> dockingStations = DockingStation.getDockingStations();

        DockingStation nearestToStart = dockingStations.get(0);
        DockingStation nearestToEnd = null;

        double[] nearestToStartLocation = nearestToStart.getDockingStationLocation();
        double[] nearestToEndLocation = dockingStations.get(0).getDockingStationLocation();

        for(DockingStation dockingStation: dockingStations){
            if (!dockingStation.isOnService())
                continue;
            if (dockingStation.oneBike(bicycleType) && distance(dockingStation.getDockingStationLocation(), startLocation) < distance(nearestToStartLocation, startLocation)){
                nearestToStart = dockingStation;
                nearestToStartLocation = nearestToStart.getDockingStationLocation();
            }
            if (dockingStation.getStationType().toLowerCase() != "plus" && dockingStation.oneFree() && distance(dockingStation.getDockingStationLocation(), endLocation) < distance(nearestToEndLocation, endLocation)){
                nearestToEnd = dockingStation;
                nearestToEndLocation = nearestToEnd.getDockingStationLocation();
            }
        }

        if (nearestToEnd == null){
            nearestToEndLocation = endLocation;
        }

        return new double[][]{nearestToStartLocation, nearestToEndLocation};
    }
}