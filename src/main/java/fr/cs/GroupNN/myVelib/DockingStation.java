package fr.cs.GroupNN.myVelib;

import java.util.*;

public class DockingStation {
    private int id;
    private double[] dockingStationLocation;
    private String stationType;
    private ParkingSlot[] slots;
    private Terminal terminal;
    private boolean onService;
    private static ArrayList<DockingStation> dockingStations = new ArrayList<DockingStation>();

    public DockingStation(int id, double[] dockingStationLocation, String stationType, ParkingSlot[] slots, Terminal terminal) {
        this.id = id;
        this.dockingStationLocation = dockingStationLocation;
        this.stationType = stationType;
        this.slots = slots;
        this.terminal = terminal;
        this.onService = false;
        dockingStations.add(this);
    }

    public void earnCredit() {
        // Implement the functionality to earn credit for the docking station here
    }

    // Getters and setters for private fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double[] getDockingStationLocation() {
        return dockingStationLocation;
    }

    public void setDockingStationLocation(double[] dockingStationLocation) {
        this.dockingStationLocation = dockingStationLocation;
    }

    public String getStationType() {
        return stationType;
    }

    public void setStationType(String stationType) {
        this.stationType = stationType;
    }

    public ParkingSlot[] getSlots() {
        return slots;
    }

    public void setSlots(ParkingSlot[] slots) {
        this.slots = slots;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public boolean isOnService() {
        return onService;
    }

    public void setOnService(boolean onService) {
        this.onService = onService;
    }

    public Bicycle rentBike(DockingStation dockingStation) {
        if (dockingStation.getSlots()) {
            System.out.println("No available bikes at the docking station.");
            return null;
        }

        // Check if there is a free and on-duty parking slot
        ParkingSlot freeParkingSlot = findFreeParkingSlot();
        if (freeParkingSlot == null) {
            System.out.println("No free parking slot available at the docking station.");
            return null;
        }

        // Remove the bike from the slots
        Bicycle rentedBicycle = slots.remove(0);

        // Occupy the parking slot with the rented bike
        freeParkingSlot.setOccupied(true);
        freeParkingSlot.setBicycle(rentedBicycle);

        System.out.println("Bike rented successfully.");

        return rentedBicycle;
    }

    private ParkingSlot findFreeParkingSlot() {
        for (ParkingSlot parkingSlot : parkingSlot[]) {
            if (parkingSlot.isFree() && parkingSlot.isOnDuty()) {
                return parkingSlot;
            }
        }
        return null;
    }

    public boolean oneFree() {
        boolean atLeastOneFree = false;
        for(ParkingSlot parkingSlot: slots){
            if (parkingSlot.isOutOfOrder())
                continue;
            if (parkingSlot.isFree()){
                atLeastOneFree = true;
                break;
            }
        }
        return atLeastOneFree;
    }

    public boolean oneBike(String bicycleType){
        boolean atLeastOneBike = false;
        for(ParkingSlot parkingSlot: slots){
            if (parkingSlot.isOutOfOrder())
                continue;
            if (!parkingSlot.isFree() && parkingSlot.getBicycle().getBicycleType() == bicycleType){
                atLeastOneBike = true;
                break;
            }
        }
        return atLeastOneBike;
    }

    public int getBikesNumber(String bicycleType){
        int bikesNumber = 0;
        for(ParkingSlot parkingSlot: slots){
            if (parkingSlot.isOutOfOrder())
                continue;
            if (!parkingSlot.isFree() && parkingSlot.getBicycle().getBicycleType() == bicycleType){
                bikesNumber++;
            }
        }
        return bikesNumber;
    }

    public int getFreeSlotsNumber(){
        int freeSlotsNumber = 0;
        for(ParkingSlot parkingSlot: slots){
            if (parkingSlot.isOutOfOrder())
                continue;
            if (parkingSlot.isFree()){
                freeSlotsNumber++;
            }
        }
        return freeSlotsNumber;
    }

    private static boolean equalLocation(double[] point1, double[] point2){
        if(point1[0] == point2[0] && point1[1] == point2[1])
            return true;
        return false;
    }

    public static DockingStation getDockingStationFromLocation(double[] location){
        DockingStation locatedDockingStation = null;
        for (DockingStation dockingStation: dockingStations){
            double[] currentDockingStationLocation = dockingStation.getDockingStationLocation();
            if(equalLocation(currentDockingStationLocation, location)) {
                locatedDockingStation = dockingStation;
                break;
            }
        }
        return locatedDockingStation;
    }

    public static ArrayList<DockingStation> getDockingStations(){
        return dockingStations;
    }
}