package fr.cs.GroupNN.myVelib;

import javax.print.Doc;
import java.util.*;

public abstract class Bicycle {
    private static int counter;
    private int bicycleId;
    private double[] bicycleLocation;
    private String bicycleType;
    private static ArrayList<Bicycle> streetBicycles = new ArrayList<Bicycle>();

    public Bicycle(double[] bicycleLocation, String bicycleType) {
        super();
        counter++;
        this.bicycleId = counter;
        this.bicycleLocation = bicycleLocation;
        this.bicycleType = bicycleType;
        boolean inDockingStation = false;
        List<DockingStation> dockingStations = DockingStation.getDockingStations();
        System.out.println("BICYCLE");
        for(DockingStation dockingStation: dockingStations){
            if (Bicycle.equalsLocations(bicycleLocation,dockingStation.getDockingStationLocation())) {
                inDockingStation = true;
            }
        }
        if (!inDockingStation)
            streetBicycles.add(this);
    }

    public int getBicycleId() {
        return bicycleId;
    }

    public void setBicycleId(int bicycleId) {
        this.bicycleId = bicycleId;
    }

    public double[] getBicycleLocation() {
        return bicycleLocation;
    }

    public void setBicycleLocation(double[] bicycleLocation) {
        this.bicycleLocation = bicycleLocation;
    }

    public String getBicycleType() {
        return bicycleType;
    }

    public void setBicycleType(String bicycleType) {
        this.bicycleType = bicycleType;
    }

    public static boolean equalsLocations(double[] x, double[] y) {
        if (x[0] == y[0] && x[1] == y[1]) {
            return true;
        }
        return false;
    }

    public static ArrayList<Bicycle> getStreetBicycles() {
        return streetBicycles;
    }

    public abstract void accept(BicycleVisitor visitor);
}


