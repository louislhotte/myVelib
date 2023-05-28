package fr.cs.GroupNN.myVelib;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        User user = new User("Louis Lhotte", new double[]{0.0, 0.0}, new Cards("VLIBRE"), "");

        // Bicycles
        double[] bicycleLocation1 = { 1.0, 2.0 };
        double[] bicycleLocation2 = { 3.0, 4.0 };
        Bicycle bicycle1 = new MechanicalBicycle(bicycleLocation1, "electrical");
        Bicycle bicycle2 = new ElectricalBicycle(bicycleLocation2, "mechanical");

        // Create parking slots
        ParkingSlot parkingSlot1 = new ParkingSlot(bicycle1, false, false);
        ParkingSlot parkingSlot2 = new ParkingSlot(bicycle2, false, false);
        ParkingSlot parkingSlot3 = new ParkingSlot(null, true, false);
        ParkingSlot parkingSlot4 = new ParkingSlot(null, true, false);

        // Create terminals
        Terminal terminal = new Terminal();

        // Create docking stations
        DockingStation dockingStation1 = new DockingStation(new double[]{1.0, 2.0}, "Type1", new ParkingSlot[]{parkingSlot1, parkingSlot2}, terminal);
        DockingStation dockingStation2 = new DockingStation(new double[]{3.0, 4.0}, "Type2", new ParkingSlot[]{parkingSlot3, parkingSlot4}, terminal);

        ArrayList<DockingStation> dockingStations = DockingStation.getDockingStations();

        // Set start and end locations
        double[] startLocation = { 0.0, 0.0 };
        double[] endLocation = { 5.0, 5.0 };

        // Create a planner
        Planner planner = new Planner(startLocation, endLocation, new Normal());

        // Use the planner as needed
        double[][] itinerary = planner.optimalItinerary();

        // Access the itinerary
        if (itinerary != null) {
            for (int i = 0; i < itinerary.length; i++) {
                System.out.println("Waypoint " + (i + 1) + ": " + Arrays.toString(itinerary[i]));
            }
        } else {
            System.out.println("No optimal itinerary found.");
        }

        DockingStation dockingStationStart = getDockingStationFromLocation


    }
}
