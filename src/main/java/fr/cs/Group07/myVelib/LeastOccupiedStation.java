package fr.cs.Group07.myVelib;

import java.util.Collections;
import java.util.List;

/**
 * The LeastOccupiedStation class implements the SortingPolicy interface and defines a sorting policy
 * based on the occupancy level of docking stations.
 */
public class LeastOccupiedStation implements SortingPolicy {
    private List<DockingStation> dockingStations = DockingStation.getDockingStations();

    /**
     * Sorts the docking stations based on their occupancy level using the LeastOccupiedComparator.
     */
    @Override
    public void sortDockingStations() {
        LeastOccupiedComparator leastOccupiedComparator = new LeastOccupiedComparator();
        Collections.sort(dockingStations, leastOccupiedComparator);
    }
}
