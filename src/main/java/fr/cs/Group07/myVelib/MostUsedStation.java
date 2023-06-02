package fr.cs.Group07.myVelib;

import java.util.Collections;
import java.util.List;

/**
 * The MostUsedStation class implements the SortingPolicy interface to sort docking stations based on their usage.
 */
public class MostUsedStation implements SortingPolicy {
    // fields
    private List<DockingStation> dockingStations = DockingStation.getDockingStations();

    /**
     * Sorts the docking stations based on their usage, i.e., the total number of bikes rented and returned.
     */
    @Override
    public void sortDockingStations() {
        MostUsedComparator mostUsedComparator = new MostUsedComparator();
        Collections.sort(dockingStations, mostUsedComparator);
    }
}
