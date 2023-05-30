package fr.cs.GroupNN.myVelib;

import java.util.*;

public class DockingStation {
    private static int counter;
    private int id;
    private double[] dockingStationLocation;
    private String stationType; // "Standard" or "Plus"
    private ParkingSlot[] slots;
    private Terminal terminal;
    private boolean onService;
    private static ArrayList<DockingStation> dockingStations = new ArrayList<DockingStation>();
    private int renting;
    private int dropping;

    public DockingStation(double[] dockingStationLocation, String stationType, ParkingSlot[] slots, Terminal terminal) {
        super();
        counter++;
        this.id = counter;
        this.dockingStationLocation = dockingStationLocation;
        this.stationType = stationType;
        this.slots = slots;
        this.terminal = terminal;
        this.onService = true;
        this.renting = 0;
        this.dropping = 0;
        dockingStations.add(this);
    }

    public static DockingStation getDockingStationByID(int stationID) {
        for (DockingStation dockingStation: dockingStations) {
            if (dockingStation.getId() == stationID) {
                return dockingStation;
            }
            else {
                return null;
            }
        }
        return null;
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

    public int getRenting() {
        return renting;
    }

    public void setRenting(int renting) {
        this.renting = renting;
    }

    public int getDropping() {
        return dropping;
    }

    public void setDropping(int dropping) {
        this.dropping = dropping;
    }

    public Bicycle rentBike() {
        boolean bikeInDockingStation = false;
        ParkingSlot selectedParkingSlot = null;

        for(ParkingSlot parkingSlot: slots){
            if (!parkingSlot.isOutOfOrder()){
                if (!parkingSlot.isFree()){
                    bikeInDockingStation = true;
                    selectedParkingSlot = parkingSlot;
                    break;
                }
            }
        }

        if (!bikeInDockingStation) {
            System.out.println("No available bikes for rent at this docking station.");
            return null;
        }

        // Remove the bike from the slots
        Bicycle rentedBicycle = selectedParkingSlot.getBicycle();
        selectedParkingSlot.setBicycle(null);

        // Occupy the parking slot with the rented bike
        selectedParkingSlot.setFree(true);

//        freeParkingSlot.setBicycle(rentedBicycle);

        System.out.println("Bike rented successfully.");
        renting++;

        return rentedBicycle;
    }

    public void parkBike(Bicycle bicycle){
        boolean freeParkInDockingStation = false;
        ParkingSlot selectedParkingSlot = null;

        for(ParkingSlot parkingSlot: slots){
            if (parkingSlot.isOutOfOrder())
                continue;
            if (parkingSlot.isFree()){
                freeParkInDockingStation = true;
                selectedParkingSlot = parkingSlot;
                break;
            }
        }

        if (!freeParkInDockingStation) {
            System.out.println("No available slots to park in this docking station.");
            return;
        }

        // Remove the bike from the slots
        selectedParkingSlot.setBicycle(bicycle);

        // Occupy the parking slot with the rented bike
        selectedParkingSlot.setFree(false);

        System.out.println("Bike parked successfully.");

        dropping++;
    }

    private ParkingSlot findOccupiedParkingSlot() {
        for (ParkingSlot parkingSlot : slots) {
            if (parkingSlot.isFree() && !parkingSlot.isOutOfOrder()) {
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