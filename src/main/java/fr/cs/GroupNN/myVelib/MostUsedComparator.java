package fr.cs.GroupNN.myVelib;

import java.util.Comparator;

public class MostUsedComparator implements Comparator<DockingStation> {

    @Override
    public int compare(DockingStation o1, DockingStation o2) {
        int final1 = o1.getDropping() + o1.getRenting();
        int final2 = o2.getDropping() + o2.getRenting();
        return (final1 - final2);
    }
}
