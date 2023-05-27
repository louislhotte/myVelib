package fr.cs.GroupNN.myVelib;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static fr.cs.GroupNN.myVelib.Data.getAllDockingStations;

public class Terminal implements BicycleVisitor {
    private int duration;
    private Bicycle bicycle;
    private User user;
    private boolean wasParkedInDockStation;
    private double cost;

    public Terminal(int duration, Bicycle bicycle, User user) {
        this.duration = duration;
        this.bicycle = bicycle;
        this.user = user;
        this.wasParkedInDockStation = true; //Regarder comment implémenter avec data...
    }



    public boolean isParkedInDockStation() {
        double[] bicycleLocation = bicycle.getBicycleLocation();
        List<DockingStation> dockingStations = getAllDockingStations();

        for (DockingStation dockingStation : dockingStations) {
            double[] dockingStationLocation = dockingStation.getDockingStationLocation();
            if (Arrays.equals(bicycleLocation, dockingStationLocation)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void visit(MechanicalBicycle bicycle) {
        double hourlyRate = 1;
        cost = duration / 60.0 * hourlyRate;
    }

    @Override
    public void visit(ElectricalBicycle bicycle) {
        double hourlyRate = 2;
        cost = duration / 60.0 * hourlyRate;
    }



    public double calculateCost() {
        double cost = 0;

        if (isParkedInDockStation()) {
            if (user.getRegistrationCard().getRegistrationType() == null) {
                bicycle.accept(this);
            } else if (user.getRegistrationCard().getRegistrationType().equals("VLIBRE")) {
                // Existing code
            } else if (user.getRegistrationCard().getRegistrationType().equals("VMAX")) {
                // Existing code
            }
        }

        if (!wasParkedInDockStation && isParkedInDockStation()) {
            return cost * 0.9;
        } else if (!isParkedInDockStation()) {
            return cost * 1.1;
        }

        return cost;
    }

    public void rentBicycle(DockingStation dockingStation, User user) {
        if (user.getRentedBicycle() != null) {
            System.out.println("User already has a rented bicycle. Cannot rent another one.");
            return;
        }

        if (!dockingStation.isOnService()) {
            System.out.println("The docking station is currently off-duty. Cannot rent a bicycle.");
            return;
        }

        if (dockingStation.getSlots() == null) {
            System.out.println("No available bikes at the docking station. Cannot rent a bicycle.");
            return;
        }


        // Rent the first available bike from the docking station
        Bicycle rentedBicycle = dockingStation.rentBike();

        // Update user's information
        user.setRentedBicycle(rentedBicycle);
        user.setRentDateTime(LocalDateTime.now());
        user.getListOfUsedBicycleIds().add(rentedBicycle.getBicycleId());

        System.out.println("Bicycle rented successfully.");
    }




}

