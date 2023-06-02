package fr.cs.Group07.myVelib;

import java.util.Comparator;

/**
 * The LeastOccupiedComparator class is a comparator for sorting docking stations based on their occupancy level.
 * It compares docking stations based on the difference between the number of rentals and the number of returns.
 */
public class LeastOccupiedComparator implements Comparator<DockingStation> {

    /**
     * Compares two docking stations based on their occupancy level.
     *
     * @param o1 The first docking station to compare.
     * @param o2 The second docking station to compare.
     * @return A negative integer, zero, or a positive integer as the first docking station is less occupied,
     *         equal to, or more occupied than the second docking station.
     */
    @Override
    public int compare(DockingStation o1, DockingStation o2) {
        int comp1 = o1.getRenting() - o1.getDropping();
        int comp2 = o2.getRenting() - o2.getDropping();
        return comp1 - comp2;
    }
}
