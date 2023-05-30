package fr.cs.GroupNN.myVelib;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class PlannerTest {

    @Test
    public void testOptimalItinerary_normal() {
        double[] startLocation = {0.0, 0.0};
        double[] endLocation = {10.0, 10.0};

        // Bicycles
        double[] bicycleLocation1 = { 1.0, 1.0 };
        double[] bicycleLocation2 = { 9.0, 9.0 };
        Bicycle bicycle1 = new MechanicalBicycle(bicycleLocation1);
        Bicycle bicycle2 = new ElectricalBicycle(bicycleLocation1);
        Bicycle bicycle3 = new MechanicalBicycle(bicycleLocation2);
        Bicycle bicycle4 = new ElectricalBicycle(bicycleLocation2);

        // Create parking slots
        ParkingSlot parkingSlot1 = new ParkingSlot(bicycle1, false, false);
        ParkingSlot parkingSlot2 = new ParkingSlot(bicycle2, false, false);
        ParkingSlot parkingSlot3 = new ParkingSlot(null, true, false);
        ParkingSlot parkingSlot4 = new ParkingSlot(null, true, false);

        // Create parking slots
        ParkingSlot parkingSlot5 =  new ParkingSlot(bicycle1, false, false);
        ParkingSlot parkingSlot6 = new ParkingSlot(bicycle2, false, false);
        ParkingSlot parkingSlot7 = new ParkingSlot(null, true, false);
        ParkingSlot parkingSlot8 = new ParkingSlot(null, true, false);

        ParkingSlot parkingSlot9 = new ParkingSlot(null, true, false);
        ParkingSlot parkingSlot10 = new ParkingSlot(null, true, false);

        // Create terminals
        Terminal terminal = new Terminal();

        // Create docking stations
        DockingStation dockingStation1 = new DockingStation(new double[]{1.0, 1.0}, "Standard", new ParkingSlot[]{parkingSlot1, parkingSlot2, parkingSlot3, parkingSlot4}, terminal);
        DockingStation dockingStation2 = new DockingStation(new double[]{9.0, 9.0}, "Standard", new ParkingSlot[]{parkingSlot5, parkingSlot6, parkingSlot7, parkingSlot8}, terminal);
        DockingStation dockingStation3 = new DockingStation(new double[]{0.0, 0.0}, "Standard", new ParkingSlot[]{parkingSlot9, parkingSlot10}, terminal);


        String bicycleType = "electrical";
        PlanningPolicy policy = new Normal();

        Planner planner = new Planner(startLocation, endLocation, bicycleType, policy);
        double[][] itinerary = planner.optimalItinerary();
        // Perform assertions to test the functionality of the optimalItinerary() method
        assertNotNull(itinerary);
        assertEquals(1.0, itinerary[0][0], 0.01);
        assertEquals(1.0, itinerary[0][1], 0.01);
        assertEquals(9.0, itinerary[1][0], 0.01);
        assertEquals(9.0, itinerary[1][1], 0.01);
    }

    @Test
    public void testOptimalItinerary_preferplus() {
        double[] startLocation = {0.0, 0.0};
        double[] endLocation = {10.0, 10.0};

        // Bicycles
        double[] bicycleLocation1 = { 1.0, 1.0 };
        double[] bicycleLocation2 = { 9.0, 9.0 };
        double[] bicycleLocation3 = { 11.01, 11.01 };
        Bicycle bicycle1 = new MechanicalBicycle(bicycleLocation1);
        Bicycle bicycle2 = new ElectricalBicycle(bicycleLocation1);
        Bicycle bicycle3 = new MechanicalBicycle(bicycleLocation2);
        Bicycle bicycle4 = new ElectricalBicycle(bicycleLocation2);

        // Create parking slots
        ParkingSlot parkingSlot1 = new ParkingSlot(bicycle1, false, false);
        ParkingSlot parkingSlot2 = new ParkingSlot(bicycle2, false, false);
        ParkingSlot parkingSlot3 = new ParkingSlot(null, true, false);
        ParkingSlot parkingSlot4 = new ParkingSlot(null, true, false);

        // Create parking slots
        ParkingSlot parkingSlot5 =  new ParkingSlot(bicycle1, false, false);
        ParkingSlot parkingSlot6 = new ParkingSlot(bicycle2, false, false);
        ParkingSlot parkingSlot7 = new ParkingSlot(null, true, false);
        ParkingSlot parkingSlot8 = new ParkingSlot(null, true, false);

        ParkingSlot parkingSlot9 = new ParkingSlot(null, true, false);
        ParkingSlot parkingSlot10 = new ParkingSlot(null, true, false);
        ParkingSlot parkingSlot11 = new ParkingSlot(null, true, false);
        ParkingSlot parkingSlot12 = new ParkingSlot(null, true, false);

        // Create terminals
        Terminal terminal = new Terminal();

        // Create docking stations
        DockingStation dockingStation1 = new DockingStation(new double[]{1.0, 1.0}, "Standard", new ParkingSlot[]{parkingSlot1, parkingSlot2, parkingSlot3, parkingSlot4}, terminal);
        DockingStation dockingStation2 = new DockingStation(new double[]{9.0, 9.0}, "Standard", new ParkingSlot[]{parkingSlot5, parkingSlot6, parkingSlot7, parkingSlot8}, terminal);
        DockingStation dockingStation3 = new DockingStation(new double[]{0.0, 0.0}, "Standard", new ParkingSlot[]{parkingSlot9, parkingSlot10}, terminal);
        DockingStation dockingStation4 = new DockingStation(new double[]{11.01, 11.01}, "Plus", new ParkingSlot[]{parkingSlot11, parkingSlot12}, terminal);


        String bicycleType = "electrical";
        PlanningPolicy policy = new PreferPlus();

        Planner planner = new Planner(startLocation, endLocation, bicycleType, policy);
        double[][] itinerary = planner.optimalItinerary();
        // Perform assertions to test the functionality of the optimalItinerary() method
        assertNotNull(itinerary);
        assertEquals(1.0, itinerary[0][0], 0.01);
        assertEquals(1.0, itinerary[0][1], 0.01);
        assertEquals(11.01, itinerary[1][0], 0.01);
        assertEquals(11.01, itinerary[1][1], 0.01);

    }


    // For some reasons, the following test only works when it is launched alone

    @Test
    public void testOptimalItinerary_preferstreetbike() {
        double[] startLocation = {0.0, 0.0};
        double[] endLocation = {10.0, 10.0};

        ParkingSlot[] parkingSlots1 = {};
        ParkingSlot[] parkingSlots2 = {};
        ParkingSlot[] parkingSlots3 = {};
        ParkingSlot[] parkingSlots4 = {};



        // Create terminals
        Terminal terminal = new Terminal();


        // Create docking stations
        DockingStation dockingStation1 = new DockingStation(new double[]{1.0, 1.0}, "Standard", parkingSlots1, terminal);
        DockingStation dockingStation2 = new DockingStation(new double[]{9.0, 9.0}, "Standard", parkingSlots2, terminal);
        DockingStation dockingStation3 = new DockingStation(new double[]{0.0, 0.0}, "Standard", parkingSlots3, terminal);
        DockingStation dockingStation4 = new DockingStation(new double[]{11.01, 11.01}, "Plus", parkingSlots4, terminal);


        // Bicycles
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
        // Perform assertions to test the functionality of the optimalItinerary() method
        assertNotNull(itinerary);
        assertEquals(-1.1, itinerary[0][0], 0.01);
        assertEquals(-1.1, itinerary[0][1], 0.01);
        assertEquals(9.0, itinerary[1][0], 0.01);
        assertEquals(9.0, itinerary[1][1], 0.01);

    }
}
