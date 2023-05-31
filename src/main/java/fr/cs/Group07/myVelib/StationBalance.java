package fr.cs.Group07.myVelib;

public class StationBalance {
    // fields
    private DockingStation dockingStation;

    // constructor
    public StationBalance(DockingStation dockingStation){
        super();
        this.setDockingStation(dockingStation);
    }

    // getters and setters
    public DockingStation getDockingStation() {
        return dockingStation;
    }

    public void setDockingStation(DockingStation dockingStation) {
        this.dockingStation = dockingStation;
    }

    // methods
    public int getTotalNumberOfRents(){
        return dockingStation.getRenting();
    }

    public int getTotalNumberOfReturn(){
        return dockingStation.getDropping();
    }

    // toString method
    @Override
    public String toString(){
        String s = "Total number of rents=" + this.getTotalNumberOfRents() + "; Total number of return=" + this.getTotalNumberOfReturn();
        return s;
    }
}