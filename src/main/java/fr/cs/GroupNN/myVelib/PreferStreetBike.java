package fr.cs.GroupNN.myVelib;

public class PreferStreetBike implements PlanningPolicy{
    @Override
    public DockingStation[] optimalItinerary(double[] startLocation,double[] endLocation, String bicycleType){
        ArrayList<DockingStation> dockingStations = DockingStation.getDockingStations();
        ArrayList<Bicycle> streetBicycles = Bicycle.getStreetBicycles();

        Bicycle nearestToStart = streetBicycles.get(0);
        DockingStation nearestToEnd = dockingStations.get(0);

        double[] nearestToStartLocation = nearestToStart.getBicycleLocation();
        double[] nearestToEndLocation = nearestToEnd.getDockingStationLocation();

        for (Bicycle bicycle: streetBicycles) {
            if (distance(bicycle.getBicycleLocation(), startLocation) < distance(nearestToStartLocation, startLocation) && bicycle.getBicycleType() == bicycleType){
                nearestToStart = bicycle;
                nearestToStartLocation = nearestToStart.getBicycleLocation();
            }
        }

        for(DockingStation dockingStation: dockingStations){
            if (!dockingStation.isOnService())
                continue;
            if (dockingStation.oneFree() && distance(dockingStation.getDockingStationLocation(), endLocation) < distance(nearestToEndLocation, endLocation)){
                nearestToEnd = dockingStation;
                nearestToEndLocation = nearestToEnd.getDockingStationLocation();
            }
        }
        return {nearestToStart, nearestToEnd};
    }
}