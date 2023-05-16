package fr.cs.GroupNN.myVelib;

import java.util.List;

public class Bicycle {
    private int bicycleId;
    private double[] bicycleLocation;
    private String bicycleType;

    public Bicycle(int bicycleId, double[] bicycleLocation, String bicycleType) {
        this.bicycleId = bicycleId;
        this.bicycleLocation = bicycleLocation;
        this.bicycleType = bicycleType;
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
}
