package fr.cs.Group07.myVelib;

import java.util.*;


/**
 * The abstract base class for different types of bicycles in the MyVelib system.
 */
public abstract class Bicycle {
    private static int counter;
    private int bicycleId;
    private double[] bicycleLocation;
    private String bicycleType;
    private static ArrayList<Bicycle> streetBicycles = new ArrayList<Bicycle>();


    /**
     * Constructs a new Bicycle object.
     *
     * @param bicycleLocation The location of the bicycle.
     * @param bicycleType     The type of the bicycle.
     */
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
    /**
     * Compares two locations for equality.
     *
     * @param x The first location to compare.
     * @param y The second location to compare.
     * @return true if the locations are equal, false otherwise.
     */
    public static boolean equalsLocations(double[] x, double[] y) {
        if (x[0] == y[0] && x[1] == y[1]) {
            return true;
        }
        return false;
    }


    /**
     * Retrieves the list of street bicycles.
     *
     * @return The list of street bicycles.
     */
    public static ArrayList<Bicycle> getStreetBicycles() {
        return streetBicycles;
    }


    /**
     * Accepts a visitor for the Bicycle.
     *
     * @param visitor The BicycleVisitor to accept.
     */
    public abstract void accept(BicycleVisitor visitor);
}


