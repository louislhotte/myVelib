package fr.cs.GroupNN.myVelib;

import java.util.Arrays;

/**
 * This class represents the main entry point of the MyVelib application. It demonstrates a user case scenario
 * by setting up the initial state of the application, including docking stations, bicycles, parking slots, and a planner.
 * It then executes the planner's optimal itinerary calculation and displays the resulting itinerary.
 */
public class Main {
    /**
     * The main method is the entry point of the MyVelib application.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        // Set up the starting and ending locations for the itinerary
        double[] startLocation = {0.0, 0.0};
        double[] endLocation = {10.0, 10.0};

        // Create parking slots for the docking stations
        ParkingSlot[] parkingSlots1 = {};
        ParkingSlot[] parkingSlots2 = {};
        ParkingSlot[] parkingSlots3 = {};
        ParkingSlot[] parkingSlots4 = {};

        // Create a terminal
        Terminal terminal = new Terminal();

        // Create docking stations at different locations
        DockingStation dockingStation1 = new DockingStation(new double[]{1.0, 1.0}, "Standard", parkingSlots1, terminal);
        DockingStation dockingStation2 = new DockingStation(new double[]{9.0, 9.0}, "Standard", parkingSlots2, terminal);
        DockingStation dockingStation3 = new DockingStation(new double[]{0.0, 0.0}, "Standard", parkingSlots3, terminal);
        DockingStation dockingStation4 = new DockingStation(new double[]{11.01, 11.01}, "Plus", parkingSlots4, terminal);

        // Create bicycles at different locations
        double[] bicycleLocation1 = { 1.0, 1.0 };
        double[] bicycleLocation2 = { 9.0, 9.0 };
        double[] bicycleLocation3 = { -1.1, -1.1 };
        Bicycle b1 = new MechanicalBicycle(bicycleLocation1);
        Bicycle b2 = new ElectricalBicycle(bicycleLocation1);
        Bicycle b3 = new MechanicalBicycle(bicycleLocation2);
        Bicycle b4 = new ElectricalBicycle(bicycleLocation2);
        Bicycle b5 = new ElectricalBicycle(bicycleLocation3);

        // Create parking slots
        ParkingSlot parkingSlot1 = new ParkingSlot(b1, false, false);
        ParkingSlot parkingSlot2 = new ParkingSlot(b2, false, false);
        ParkingSlot parkingSlot3 = new ParkingSlot(null, true, false);
        ParkingSlot parkingSlot4 = new ParkingSlot(null, true, false);
        dockingStation1.setSlots(new ParkingSlot[] {parkingSlot1, parkingSlot2, parkingSlot3, parkingSlot4});


        // Create parking slots
        ParkingSlot parkingSlot5 =  new ParkingSlot(b3, false, false);
        ParkingSlot parkingSlot6 = new ParkingSlot(b4, false, false);
        ParkingSlot parkingSlot7 = new ParkingSlot(null, true, false);
        ParkingSlot parkingSlot8 = new ParkingSlot(null, true, false);
        dockingStation2.setSlots(new ParkingSlot[] {parkingSlot5, parkingSlot6, parkingSlot7, parkingSlot8});

        ParkingSlot parkingSlot9 = new ParkingSlot(null, true, false);
        ParkingSlot parkingSlot10 = new ParkingSlot(null, true, false);
        dockingStation3.setSlots(new ParkingSlot[] {parkingSlot9, parkingSlot10});

        ParkingSlot parkingSlot11 = new ParkingSlot(null, true, false);
        ParkingSlot parkingSlot12 = new ParkingSlot(null, true, false);
        dockingStation4.setSlots(new ParkingSlot[] {parkingSlot11, parkingSlot12});


        String bicycleType = "electrical";
        PlanningPolicy policy = new PreferStreetBike();
        Bicycle.getStreetBicycles().trimToSize();
        System.out.println((Bicycle.getStreetBicycles().size()));

        Planner planner = new Planner(startLocation, endLocation, bicycleType, policy);
        double[][] itinerary = planner.optimalItinerary();
        System.out.println(Arrays.deepToString(itinerary));
    }
}
