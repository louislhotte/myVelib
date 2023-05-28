package fr.cs.GroupNN.myVelib;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TerminalTest {
    private Terminal terminal;
    private User user;
    private DockingStation dockingStation;
    private MechanicalBicycle mechanicalBicycle;
    private ElectricalBicycle electricalBicycle;

    @BeforeEach
    void setUp() {
        terminal = new Terminal();

        double[] userLocation = {45, 80};
        Cards registrationCard = new Cards("VLIBRE");
        String creditCardNumber = "4268 8465 2564 4566";
        user = new User("Louis Lhotte", userLocation, registrationCard, creditCardNumber);

        mechanicalBicycle = new MechanicalBicycle(new double[] {0.0, 0.0}, "Mechanical");
        electricalBicycle = new ElectricalBicycle(new double[] {0.0, 0.0}, "Electrical");

        ParkingSlot parkingSlot1 = new ParkingSlot(null, true, false);
        ParkingSlot parkingSlot2 = new ParkingSlot(null, true, false);
        ParkingSlot parkingSlot3 = new ParkingSlot(mechanicalBicycle, false, false);
        ParkingSlot parkingSlot4 = new ParkingSlot(electricalBicycle, false, false);

        // Create terminals
        Terminal terminal = new Terminal();

        // Create docking stations
        DockingStation dockingStation = new DockingStation(new double[]{0.0, 0.0}, "Standard", new ParkingSlot[]{parkingSlot1, parkingSlot2, parkingSlot3, parkingSlot4}, terminal);


    }

    @Test
    void testCalculateCostWithVLIBRECardAndMechanicalBicycle() {
        user.setRegistrationCard(new Cards("VLIBRE"));
        user.setTimeCreditEarned(20);

        user.setRentedBicycle(mechanicalBicycle);
        double cost = terminal.calculateCost(user, 90);

        assertEquals(0.16, cost, 0.01);
    }

    @Test
    void testCalculateCostWithVLIBRECardAndElectricalBicycle() {
        user.setRegistrationCard(new Cards("VLIBRE"));
        user.setTimeCreditEarned(20);

        user.setRentedBicycle(electricalBicycle);
        double cost = terminal.calculateCost(user, 135);

        assertEquals(0.91, cost, 0.01);
    }

    @Test
    void testCalculateCostWithVMAXCardAndMechanicalBicycle() {
        user.setRegistrationCard(new Cards("VMAX"));
        user.setTimeCreditEarned(0);

        user.setRentedBicycle(mechanicalBicycle);
        double cost = terminal.calculateCost(user, 90);

        assertEquals(0.16, cost, 0.01);
    }

    @Test
    void testCalculateCostWithVMAXCardAndElectricalBicycle() {
        user.setRegistrationCard(new Cards("VMAX"));
        user.setTimeCreditEarned(0);

        user.setRentedBicycle(electricalBicycle);
        double cost = terminal.calculateCost(user, 135);

        assertEquals(0.83, cost, 0.01);
    }

    @Test
    void testCalculateCostWithOtherCardAndMechanicalBicycle() {
        user.setRegistrationCard(new Cards("OTHER"));

        user.setRentedBicycle(mechanicalBicycle);
        double cost = terminal.calculateCost(user, 90);

        assertEquals(1.5, cost, 0.01);
    }

    @Test
    void testCalculateCostWithOtherCardAndElectricalBicycle() {
        user.setRegistrationCard(new Cards("OTHER"));

        user.setRentedBicycle(electricalBicycle);
        double cost = terminal.calculateCost(user, 135);

        assertEquals(4.5, cost, 0.01);
    }



    @Test
    void testParkBicycle() {
        terminal.rentBicycle(dockingStation, user, "Mechanical");
        terminal.parkBicycle(dockingStation, user);

        Bicycle rentedBicycle = user.getRentedBicycle();

        assertEquals(null, rentedBicycle);
        assertEquals(dockingStation.getDockingStationLocation(), user.getUserLocation());
        assertEquals(1, user.getNumberOfRides());
    }
}
