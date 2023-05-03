package fr.cs.GroupNN.myVelib;

import java.util.List;

public class DockingStation {
    private double DockingStationLatitude;
    private double DockingStationLongitude;
    private String DockingStationStatus;
    private String StationType;
    private int DockingStationId;
    private List<ParkingSlot> parkingSlots;
    private Terminal terminal;

    public DockingStation(double dockingStationLatitude, double dockingStationLongitude, String dockingStationStatus, String StationType, int dockingStationId, List<ParkingSlot> parkingSlots) {
        DockingStationLatitude = dockingStationLatitude;
        DockingStationLongitude = dockingStationLongitude;
        DockingStationStatus = dockingStationStatus;
        this.StationType = StationType;
        DockingStationId = dockingStationId;
        this.parkingSlots = parkingSlots;
    }

    public double getDockingStationLatitude() {
        return DockingStationLatitude;
    }

    public void setDockingStationLatitude(double dockingStationLatitude) {
        DockingStationLatitude = dockingStationLatitude;
    }

    public double getDockingStationLongitude() {
        return DockingStationLongitude;
    }

    public void setDockingStationLongitude(double dockingStationLongitude) {
        DockingStationLongitude = dockingStationLongitude;
    }

    public String getDockingStationStatus() {
        return DockingStationStatus;
    }

    public void setDockingStationStatus(String dockingStationStatus) {
        DockingStationStatus = dockingStationStatus;
    }

    public String getStationType() {
        return StationType;
    }

    public void setStationType(String stationType) {
        this.StationType = stationType;
    }

    public int getDockingStationId() {
        return DockingStationId;
    }

    public void setDockingStationId(int dockingStationId) {
        DockingStationId = dockingStationId;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }


    public class Terminal {
        public void rentBicycle() {
            // code to rent a bicycle
        }

        public void dropBicycle() {
            // code to drop a bicycle
        }

        public void displayStatus() {
            // code to display the status of the docking station
        }
    }

}
