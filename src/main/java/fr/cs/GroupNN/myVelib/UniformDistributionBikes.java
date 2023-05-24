package fr.cs.GroupNN.myVelib;

import java.util.ArrayList;

public class UniformDistributionBikes extends Normal{
    @Override
    public double[][] optimalItinerary(double[] startLocation, double[] endLocation, String bicycleType){
        ArrayList<DockingStation> dockingStations = DockingStation.getDockingStations();

        double[][] subOptimalItinerary = super.optimalItinerary(startLocation, endLocation, bicycleType);


        DockingStation subNearestToStart = DockingStation.getDockingStationFromLocation(subOptimalItinerary[0]);
        DockingStation subNearestToEnd = DockingStation.getDockingStationFromLocation(subOptimalItinerary[1]);

        double[] subNearestToStartLocation = subNearestToStart.getDockingStationLocation();
        double[] subNearestToEndLocation = subNearestToEnd.getDockingStationLocation();

        DockingStation nearestToStart = subNearestToStart;
        DockingStation nearestToEnd = subNearestToEnd;

        double[] nearestToStartLocation = subNearestToStartLocation;
        double[] nearestToEndLocation = subNearestToEndLocation;

        double subNearestDistanceToStart = distance(subNearestToStartLocation, startLocation);
        double subNearestDistanceToEnd = distance(subNearestToEndLocation, endLocation);

        final double RATE = 5;

        double maximumDistanceToStart = subNearestDistanceToStart * (1.0 + RATE/100.0);
        double maximumDistanceToEnd = subNearestDistanceToEnd * (1.0 + RATE/100.0);

        int subStartBikeNumber = subNearestToStart.getBikesNumber(bicycleType);
        int subEndFreeSlotsNumber = subNearestToEnd.getFreeSlotsNumber();

        for(DockingStation dockingStation: dockingStations) {
            double[] currentDockingStationLocation = dockingStation.getDockingStationLocation();
            if (!dockingStation.isOnService())
                continue;
            if (distance(currentDockingStationLocation, startLocation) < maximumDistanceToStart && dockingStation.getBikesNumber(bicycleType) > subStartBikeNumber){
                subStartBikeNumber = dockingStation.getBikesNumber(bicycleType);
                nearestToStart = dockingStation;
                nearestToStartLocation = nearestToStart.getDockingStationLocation();
            }
            if (distance(currentDockingStationLocation, endLocation) < maximumDistanceToEnd && dockingStation.getFreeSlotsNumber() > subEndFreeSlotsNumber){
                subEndFreeSlotsNumber = dockingStation.getFreeSlotsNumber();
                nearestToEnd = dockingStation;
                nearestToEndLocation = nearestToEnd.getDockingStationLocation();
            }
        }
        return new double[][]{nearestToStartLocation, nearestToEndLocation};
    }
}