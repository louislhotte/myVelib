package fr.cs.GroupNN.myVelib;

import java.util.Comparator;

public class LeastOccupiedComparator implements Comparator<DockingStation> {
    @Override
    public int compare(DockingStation o1, DockingStation o2) {
        int comp1 = o1.getRenting() - o1.getDropping();
        int comp2 = o2.getRenting() - o2.getDropping();
        return comp1 - comp2;
    }
}
