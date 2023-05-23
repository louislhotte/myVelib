package fr.cs.GroupNN.myVelib;

public class UniformDistributionBikes extends Normal{
    @Override
    public DockingStation[] optimalItinerary(double[] startLocation,double[] endLocation, String bicycleType){
        DockingStation[] subOptimalItinerary = super.optimalItinerary(startLocation, endLocation, String bicycleType);
        DockingStation subNearestToStart = subOptimalItinerary[0];
        DockingStation subNearestToEnd = subOptimalItinerary[1];
        double[] subNearestToStartLocation = subNearestToStart.getDockingStationLocation();
        double[] subNearestToEndLocation = subNearestToEnd.getDockingStationLocation();

        double subNearestDistanceToStart = distance(subNearestToStartLocation, startLocation);
        double subNearestDistanceToEnd = distance(subNearestToEndLocation, endLocation);

        DockingStation nearestToStart = subNearestToStart;
        DockingStation nearestToEnd = subNearestToEnd;

        double final RATE = 5;

        double maximumDistanceToStart = subNearestDistanceToStart * (1.0 + RATE/100.0);
        double maximumDistanceToEnd = subNearestDistanceToEnd * (1.0 + RATE/100.0);

        int subStartBikeNumber = subNearestToStart.getBikesNumber(bicycleType);
        int subEndFreeSlotsNumber = subNearestToEnd.getFreeSlotsNumber();

        for(DockingStation dockingStation: dockingStations) {
            currentDockingStationLocation = dockingStation.getDockingStationLocation();
            if (!dockingStation.isOnService())
                continue;
            if (distance(currentDockingStationLocation, startLocation) < maximumDistanceToStart && dockingStation.getBikesNumber(bicycleType) > subStartBikeNumber){
                subStartBikeNumber = dockingStation.getBikesNumber(bicycleType);
                nearestToStart = dockingStation;
            }
            if (distance(currentDockingStationLocation, endLocation) < maximumDistanceToEnd && dockingStation.getFreeSlotsNumber() > subEndFreeSlotsNumber){
                subEndFreeSlotsNumber = dockingStation.getFreeSlotsNumber();
                nearestToEnd = dockingStation;
            }
        }
        return {nearestToStart, nearestToEnd}
    }
}