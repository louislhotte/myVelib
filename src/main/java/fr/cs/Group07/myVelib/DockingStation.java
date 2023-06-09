package fr.cs.Group07.myVelib;

import java.util.*;
/**
 * Represents a docking station for bicycles.
 */
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

    /**
     * Constructs a new DockingStation object.
     *
     * @param dockingStationLocation The location of the docking station.
     * @param stationType            The type of the docking station.
     * @param slots                  The parking slots in the docking station.
     * @param terminal               The terminal associated with the docking station.
     */

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
    /**
     * Retrieves a docking station with the specified ID.
     *
     * @param stationID The ID of the docking station to retrieve.
     * @return The DockingStation object with the specified ID, or null if not found.
     */
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

    /**
     * Retrieves the location of the docking station.
     *
     * @return The location of the docking station.
     */
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
    /**
     * Rents a bike from the docking station.
     *
     * @return The rented bicycle, or null if no bikes are available.
     */
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
    /**
     * Parks a bicycle in the docking station.
     *
     * @param bicycle The bicycle to be parked.
     */
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
    /**
     * Finds an occupied parking slot in the docking station.
     *
     * @return The occupied parking slot, or null if none are found.
     */
    private ParkingSlot findOccupiedParkingSlot() {
        for (ParkingSlot parkingSlot : slots) {
            if (parkingSlot.isFree() && !parkingSlot.isOutOfOrder()) {
                return parkingSlot;
            }
        }
        return null;
    }
    /**
     * Checks if there is at least one free parking slot in the docking station.
     *
     * @return true if there is at least one free parking slot, false otherwise.
     */
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
    /**
     * Checks if there is at least one bike of the specified type in the docking station.
     *
     * @param bicycleType The type of the bicycle to check.
     * @return true if there is at least one bike of the specified type, false otherwise.
     */
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
    /**
     * Retrieves the number of bikes of the specified type in the docking station.
     *
     * @param bicycleType The type of the bicycle to count.
     * @return The number of bikes of the specified type.
     */
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
    /**
     * Retrieves the number of free parking slots in the docking station.
     *
     * @return The number of free parking slots.
     */
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

    /**
     * Checks if two locations are equal.
     *
     * @param point1 The first location to compare.
     * @param point2 The second location to compare.
     * @return true if the two locations are equal, false otherwise.
     */
    public static boolean equalLocation(double[] point1, double[] point2){
        if(point1[0] == point2[0] && point1[1] == point2[1])
            return true;
        return false;
    }


    /**
     * Retrieves a docking station based on its location.
     *
     * @param location The location of the docking station to retrieve.
     * @return The DockingStation object with the specified location, or null if not found.
     */
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


    /**
     * Retrieves the list of all docking stations.
     *
     * @return The list of all docking stations.
     */
    public static ArrayList<DockingStation> getDockingStations(){
        return dockingStations;
    }


    /**
     * Generates a string representation of the DockingStation object.
     *
     * @return A string representation of the DockingStation object.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Docking Station ID: ").append(id).append("\n");
        sb.append("Location: ").append(Arrays.toString(dockingStationLocation)).append("\n");
        sb.append("Station Type: ").append(stationType).append("\n");
        sb.append("Number of Slots: ").append(slots.length).append("\n");
        sb.append("Terminal: ").append(terminal).append("\n");
        sb.append("On Service: ").append(onService).append("\n");
        sb.append("Renting Count: ").append(renting).append("\n");
        sb.append("Dropping Count: ").append(dropping).append("\n");

        return sb.toString();
    }

}