package fr.cs.GroupNN.myVelib;

public class PreferPlus implements PlanningPolicy{
    @Override
    public DockingStation[] optimalItinerary(double[] startLocation,double[] endLocation, String bicycleType){
        ArrayList<DockingStation> dockingStations = DockingStation.getDockingStations();

        DockingStation nearestToStart = dockingStations.get(0);
        DockingStation nearestToEnd = dockingStations.get(0);

        double[] nearestToStartLocation = nearestToStart.getDockingStationLocation();
        double[] nearestToEndLocation = nearestToEnd.getDockingStationLocation();

        double distanceToNearestToEndStation = distance(endLocation, nearestToEndLocation);

        for(DockingStation dockingStation: dockingStations){
            currentDockingStationLocation = dockingStation.getDockingStationLocation();
            if (!dockingStation.isOnService())
                continue;
            if (dockingStation.oneBike(bicycleType) && distance(currentDockingStationLocation, startLocation) < distance(nearestToStartLocation, startLocation)){
                nearestToStart = dockingStation;
                nearestToStartLocation = nearestToStart.getDockingStationLocation();
            }
            if (dockingStation.oneFree() && distance(currentDockingStationLocation, endLocation) < distanceToNearestToEndStation) {
                nearestToEnd = dockingStation;
                nearestToEndLocation = nearestToEnd.getDockingStationLocation();
                distanceToNearestToEndStation = distance(endLocation, nearestToEndLocation);
            }
        }

        if (nearestToEnd.getStationType() == "plus")
            return {nearestToStart, nearestToEnd};

        for(DockingStation dockingStation: dockingStations){
            currentDockingStationLocation = dockingStation.getDockingStationLocation();
            if (dockingStation.getStationType() == "plus" && distance(currentDockingStationLocation, endLocation) < distanceToNearestToEndStation * 1.1){
                nearestToEndLocation = currentDockingStationLocation;
                nearestToEnd = currentDockingStationLocation;
            }
        }

        return {nearestToStart, nearestToEnd};
    }
}