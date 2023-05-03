package fr.cs.GroupNN.myVelib;

public class Bicycle {
    private int BicycleId;
    private double BicycleLatitude;
    private double BicycleLongitude;
    private String BicycleType;

    public Bicycle(int bicycleId, double bicycleLatitude, double bicycleLongitude, String bicycleType) {
        BicycleId = bicycleId;
        BicycleLatitude = bicycleLatitude;
        BicycleLongitude = bicycleLongitude;
        BicycleType = bicycleType;
    }

    public int getBicycleId() {
        return BicycleId;
    }

    public void setBicycleId(int bicycleId) {
        BicycleId = bicycleId;
    }

    public double getBicycleLatitude() {
        return BicycleLatitude;
    }

    public void setBicycleLatitude(double bicycleLatitude) {
        BicycleLatitude = bicycleLatitude;
    }

    public double getBicycleLongitude() {
        return BicycleLongitude;
    }

    public void setBicycleLongitude(double bicycleLongitude) {
        BicycleLongitude = bicycleLongitude;
    }

    public String getBicycleType() {
        return BicycleType;
    }

    public void setBicycleType(String bicycleType) {
        BicycleType = bicycleType;
    }
}
