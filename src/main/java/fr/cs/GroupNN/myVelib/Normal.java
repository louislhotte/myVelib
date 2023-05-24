package fr.cs.GroupNN.myVelib;

import java.util.*;

public class Normal implements PlanningPolicy{
    @Override
    public double[][] optimalItinerary(double[] startLocation,double[] endLocation, String bicycleType){
        ArrayList<DockingStation> dockingStations = DockingStation.getDockingStations();

        DockingStation nearestToStart = dockingStations.get(0);
        DockingStation nearestToEnd = dockingStations.get(0);

        double[] nearestToStartLocation = nearestToStart.getDockingStationLocation();
        double[] nearestToEndLocation = nearestToEnd.getDockingStationLocation();

        for(DockingStation dockingStation: dockingStations){
            if (!dockingStation.isOnService())
                continue;
            if (dockingStation.oneBike(bicycleType) && distance(dockingStation.getDockingStationLocation(), startLocation) < distance(nearestToStartLocation, startLocation)){
                nearestToStart = dockingStation;
                nearestToStartLocation = nearestToStart.getDockingStationLocation();
            }
            if (dockingStation.oneFree() && distance(dockingStation.getDockingStationLocation(), endLocation) < distance(nearestToEndLocation, endLocation)){
                nearestToEnd = dockingStation;
                nearestToEndLocation = nearestToEnd.getDockingStationLocation();
            }
        }
        return new double[][]{nearestToStartLocation, nearestToEndLocation};
    }
}