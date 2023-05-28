package fr.cs.GroupNN.myVelib;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TerminalTest {
    private Terminal terminal;
    private User user;
    private MechanicalBicycle mechanicalBicycle;
    private ElectricalBicycle electricalBicycle;

    @BeforeEach
    void setUp() {
        mechanicalBicycle = new MechanicalBicycle(1, new double[]{0.0, 0.0}, "mechanical");
        electricalBicycle = new ElectricalBicycle(1, new double[]{0.0, 0.0}, "electrical");
        user = new User("Louis Lhotte", 1, new double[]{0.0, 0.0}, 20, 0, new Cards("VLIBRE"), "", 0, 0, 20, null, null, new ArrayList<>());
        terminal = new Terminal(0, mechanicalBicycle, user);
    }

    @Test
    void calculateCost_ShouldReturnZero_WhenDurationIsLessThanOrEqualToFreeHour() {
        terminal = new Terminal(30, mechanicalBicycle, user);
        double expectedCost = 0.0;

        double result = terminal.calculateCost();

        assertEquals(expectedCost, result);
    }

    @Test
    void calculateCost_ShouldReturnCostForMechanicalBicycle_WhenDurationExceedsFreeHour() {
        terminal = new Terminal(75, mechanicalBicycle, user);
        double expectedCost = 0;

        double result = terminal.calculateCost();
        int expectedTimeBalance = 5;

        assertEquals(expectedCost, result);
        assertEquals(expectedTimeBalance, user.getUserTimeCreditBalance());
    }

    @Test
    void calculateCost_ShouldReturnCostForElectricalBicycle_WhenDurationExceedsFreeHour() {
        terminal = new Terminal(135, electricalBicycle, user);
        double expectedCost = 1.8333333333333333;

        double result = terminal.calculateCost();

        assertEquals(expectedCost, result);
        assertEquals(0, user.getUserTimeCreditBalance());
    }
}
