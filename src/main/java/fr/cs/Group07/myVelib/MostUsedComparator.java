package fr.cs.Group07.myVelib;

import java.util.Comparator;

/**
 * The MostUsedComparator class implements the Comparator interface to compare docking stations based on their usage.
 */
public class MostUsedComparator implements Comparator<DockingStation> {

    /**
     * Compares two docking stations based on their usage, i.e., the total number of bikes rented and returned.
     *
     * @param o1 The first docking station to compare.
     * @param o2 The second docking station to compare.
     * @return A negative integer if o1 has lower usage than o2, zero if they have equal usage, or a positive integer if o1 has higher usage than o2.
     */
    @Override
    public int compare(DockingStation o1, DockingStation o2) {
        int final1 = o1.getDropping() + o1.getRenting();
        int final2 = o2.getDropping() + o2.getRenting();
        return final1 - final2;
    }
}
