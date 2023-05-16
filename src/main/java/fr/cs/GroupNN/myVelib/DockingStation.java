package fr.cs.GroupNN.myVelib;

public class DockingStation {
    private int id;
    private double[] dockingStationLocation;
    private String stationType;
    private ParkingSlot[] slots;
    private Terminal terminal;
    private boolean onService;

    public DockingStation(int id, double[] dockingStationLocation, String stationType, ParkingSlot[] slots, Terminal terminal) {
        this.id = id;
        this.dockingStationLocation = dockingStationLocation;
        this.stationType = stationType;
        this.slots = slots;
        this.terminal = terminal;
        this.onService = false;
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

    public Bicycle rentBike() {
        // method to rent a Bike and reserve a parking Slot
        return null;
    }
}
