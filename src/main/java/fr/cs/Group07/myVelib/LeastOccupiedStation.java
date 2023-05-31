package fr.cs.Group07.myVelib;

import java.util.Collections;
import java.util.List;

public class LeastOccupiedStation implements SortingPolicy{
    // fields
    private List<DockingStation> dockingStations = DockingStation.getDockingStations();

    @Override
    public void sortDockingStations() {
        LeastOccupiedComparator leastOccupiedComparator = new LeastOccupiedComparator();
        Collections.sort(dockingStations, leastOccupiedComparator);
        return;
    }
}
