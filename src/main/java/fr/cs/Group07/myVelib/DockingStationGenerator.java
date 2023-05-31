package fr.cs.Group07.myVelib;

import java.util.ArrayList;
import java.util.List;

public class DockingStationGenerator {
    public static void main(String[] args) {
        List<DockingStation> dockingStations = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            double[] location = generateRandomLocation();
            ParkingSlot[] parkingSlots = generateParkingSlots();

            DockingStation dockingStation = new DockingStation(location, "Type" + (i + 1), parkingSlots, new Terminal());
            dockingStations.add(dockingStation);
        }

        // Print the generated docking stations
        for (DockingStation dockingStation : dockingStations) {
            System.out.println("Docking Station Location: " + dockingStation.getDockingStationLocation()[0] + ", " + dockingStation.getDockingStationLocation()[1]);
            System.out.println("Docking Station Type: " + dockingStation.getStationType());
            System.out.println("Number of Parking Slots: " + dockingStation.getSlots().length);
            System.out.println("---------------------");
        }
    }

    private static double[] generateRandomLocation() {
        double x = Math.random() * 100;
        double y = Math.random() * 100;
        return new double[]{x, y};
    }

    private static ParkingSlot[] generateParkingSlots() {
        ParkingSlot[] parkingSlots = new ParkingSlot[5];

        for (int i = 0; i < parkingSlots.length; i++) {
            Bicycle bicycle = null;
            boolean outOfOrder = Math.random() < 0.2;  // 20% chance of being out of order
            boolean free = Math.random() < 0.5;  // 50% chance of being free

            if (!outOfOrder && !free) {
                double[] bicycleLocation = generateRandomLocation();
                if (Math.random() < 0.5) {
                    bicycle = new MechanicalBicycle(bicycleLocation);
                } else {
                    bicycle = new ElectricalBicycle(bicycleLocation);
                }
            }

            parkingSlots[i] = new ParkingSlot(bicycle, outOfOrder, !free);
        }

        return parkingSlots;
    }
}
