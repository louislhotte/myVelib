package fr.cs.GroupNN.myVelib;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static fr.cs.GroupNN.myVelib.Data.getAllDockingStations;

public class Terminal {
    private int duration;
    private Bicycle bicycle;
    private User user;
    private boolean wasParkedInDockStation;

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


    public double calculateCost() {
        double cost = 0;

        if (isParkedInDockStation()) {
            if (user.getRegistrationCard().getRegistrationType() == null) {
                if (bicycle.getBicycleType().equals("mechanical")) {
                    cost = duration / 60.0 * 1;
                } else if (bicycle.getBicycleType().equals("electrical")) {
                    cost = duration / 60.0 * 2;
                }
            } else if (user.getRegistrationCard().getRegistrationType().equals("VLIBRE")) {
                int freeHour = 60;
                if (duration <= freeHour) {
                    cost = 0;
                } else {
                    int timeCredit = user.getTimeCreditEarned();
                    int durationExcess = Math.max(duration - freeHour - timeCredit, 0);
                    double hourlyRate;
                    if (bicycle.getBicycleType().equals("mechanical")) {
                        hourlyRate = 1;
                    } else  {
                        hourlyRate = 2;
                    }

                    cost = (durationExcess / 60.0 * hourlyRate);
                    timeCredit = Math.max(timeCredit - (duration - freeHour), 0);
                    user.setUserTimeCreditBalance(timeCredit);
                }
            } else if (user.getRegistrationCard().getRegistrationType().equals("VMAX")) {
                int freeHour = 60;
                if (duration > freeHour) {
                    int durationExcess = duration - freeHour;
                    double hourlyRate = 1;
                    cost = (durationExcess / 60.0 * hourlyRate);
                }
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
