package fr.cs.Group07.myVelib;

import java.util.ArrayList;
/**
 * The SortingPolicy interface defines the contract for a sorting policy used to sort docking stations.
 */
public interface SortingPolicy {

    /**
     * Sorts the docking stations according to the specified sorting policy.
     */
    void sortDockingStations();
}