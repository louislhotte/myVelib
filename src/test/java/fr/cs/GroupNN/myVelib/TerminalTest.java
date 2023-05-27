package fr.cs.GroupNN.myVelib;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TerminalTest {
    private Terminal terminal;
    private User user;

    @BeforeEach
    void setUp() {
        Bicycle bicycle = new Bicycle(1, new double[]{0.0, 0.0}, "mechanical");
        user = new User("Louis Lhotte", 1, new double[]{0.0, 0.0}, 0, 0, new Cards("VLIBRE"), "", 0, 0, 20, null, null, new ArrayList<>());
        terminal = new Terminal(0, bicycle, user);
    }

    @Test
    void calculateCost_ShouldReturnZero_WhenDurationIsLessThanOrEqualToFreeHour() {
        terminal = new Terminal(30, new Bicycle(1, new double[]{0.0, 0.0}, "mechanical"), user);
        double expectedCost = 0.0;

        double result = terminal.calculateCost();

        assertEquals(expectedCost, result);
        assertEquals(20, user.getTimeCreditEarned());
    }

    @Test
    void calculateCost_ShouldReturnCostForMechanicalBicycle_WhenDurationExceedsFreeHour() {
        terminal = new Terminal(75, new Bicycle(1, new double[]{0.0, 0.0}, "mechanical"), user);
        double expectedCost = 1.0;

        double result = terminal.calculateCost();

        assertEquals(expectedCost, result);
        assertEquals(5, user.getTimeCreditEarned());
    }

    @Test
    void calculateCost_ShouldReturnCostForElectricalBicycle_WhenDurationExceedsFreeHour() {
        terminal = new Terminal(135, new Bicycle(1, new double[]{0.0, 0.0}, "electrical"), user);
        double expectedCost = 115.0;

        double result = terminal.calculateCost();

        assertEquals(expectedCost, result);
        assertEquals(0, user.getTimeCreditEarned());
    }
}
