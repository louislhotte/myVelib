package fr.cs.GroupNN.myVelib;

public class Planner{
    // fields
    private double[] startLocation;
    private double[] endLocation;

    // connstructor
    public Planner(double[] startLocation, double[ endLocation]){
        super();
        this.setStartLocation(startLocation);
        this.setEndLocation(endLocation);
    }

    // getters and setters
    public double[] getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(double[] startLocation) {
        this.startLocation = startLocation;
    }

    public double[] getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(double[] endLocation) {
        this.endLocation = endLocation;
    }

    // other methods
    public double[][] optimalItinerary(){
        ArrayList<DockingStation> dockingStations = DockingStation.getDockingStations();

        DockingStation nearestToStart = dockingStations.get(0);
        DockingStation nearestToEnd = dockingStations.get(0);

        double[] nearestToStartLocation = nearestToStart.getDockingStationLocation();
        double[] nearestToEndLocation = nearestToEnd.getDockingStationLocation();

        for(DockingStation dockingStation: dockingStations){
            if (!dockingStation.isOnService())
                continue;
            if (dockingStation.oneBike() && distance(dockingStation.getDockingStationLocation(), startLocation) < distance(nearestToStartLocation, startLocation)){
                nearestToStart = dockingStation;
                nearestToStartLocation = nearestToStart.getDockingStationLocation();
            }
            if (dockingStation.oneFree() && distance(dockingStation.getDockingStationLocation(), endLocation) < distance(nearestToEndLocation, endLocation)){
                nearestToEnd = dockingStation;
                nearestToEndLocation = nearestToEnd.getDockingStationLocation();
            }
        }
    }
}