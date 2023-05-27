package fr.cs.GroupNN.myVelib;

import java.util.*;

public class MostUsedStation implements SortingPolicy{
    // fields
    private List<DockingStation> dockingStations = DockingStation.getDockingStations();

    @Override
    public void sortDockingStations() {
        MostUsedComparator mostUsedComparator = new MostUsedComparator();
        Collections.sort(dockingStations, mostUsedComparator);
        return;
    }
}
