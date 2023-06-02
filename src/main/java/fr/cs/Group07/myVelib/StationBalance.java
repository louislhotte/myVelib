package fr.cs.Group07.myVelib;

/**
 * The StationBalance class represents the balance of a docking station,
 * including the total number of rents and returns.
 */
public class StationBalance {
    private DockingStation dockingStation;

    /**
     * Constructs a StationBalance object for the specified docking station.
     *
     * @param dockingStation the docking station
     */
    public StationBalance(DockingStation dockingStation) {
        super();
        this.setDockingStation(dockingStation);
    }

    /**
     * Returns the docking station associated with this station balance.
     *
     * @return the docking station
     */
    public DockingStation getDockingStation() {
        return dockingStation;
    }

    /**
     * Sets the docking station for this station balance.
     *
     * @param dockingStation the docking station
     */
    public void setDockingStation(DockingStation dockingStation) {
        this.dockingStation = dockingStation;
    }

    /**
     * Returns the total number of rents at the docking station.
     *
     * @return the total number of rents
     */
    public int getTotalNumberOfRents() {
        return dockingStation.getRenting();
    }

    /**
     * Returns the total number of returns at the docking station.
     *
     * @return the total number of returns
     */
    public int getTotalNumberOfReturns() {
        return dockingStation.getDropping();
    }

    /**
     * Returns a string representation of the station balance.
     *
     * @return a string representing the total number of rents and returns
     */
    @Override
    public String toString() {
        String s = "Total number of rents=" + this.getTotalNumberOfRents() + "; Total number of returns=" + this.getTotalNumberOfReturns();
        return s;
    }
}
