package fr.cs.GroupNN.myVelib;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Terminal implements BicycleVisitor {
    private Planner planner;

    public Terminal() {
        super();
    }

    @Override
    public void visit(MechanicalBicycle bicycle) {
        double hourlyRate = bicycle.getHourlyRate();
    }

    @Override
    public void visit(ElectricalBicycle bicycle) {
        double hourlyRate = bicycle.getHourlyRate();
    }


    public double calculateCost(User user, int duration) {
        Bicycle bicycle = user.getRentedBicycle();
        double cost = 0;
        if (user != null && user.getRegistrationCard() != null) {
            String registrationType = user.getRegistrationCard().getRegistrationType();
            int timeCredit = user.getTimeCreditEarned();
            int freeHour = 60;

            double hourlyRate;
            if (bicycle instanceof MechanicalBicycle) {
                hourlyRate = ((MechanicalBicycle) bicycle).getHourlyRate();
            } else if (bicycle instanceof ElectricalBicycle) {
                hourlyRate = ((ElectricalBicycle) bicycle).getHourlyRate();
            } else {
                return cost; // Return 0 if the bicycle type is unknown
            }

            if (registrationType.equals("VLIBRE")) {
                int durationExcess = Math.max(duration - freeHour, 0);
                int effectiveDuration = Math.max(durationExcess - timeCredit, 0);

                cost = (effectiveDuration / 60.0) * hourlyRate;

                timeCredit = Math.max(timeCredit - durationExcess, 0);
                user.setUserTimeCreditBalance(timeCredit);
            } else if (registrationType.equals("VMAX")) {
                int durationExcess = Math.max(duration - freeHour, 0);

                if (duration >= 60) {
                    cost = 1 + (durationExcess / 60.0) * hourlyRate;
                } else if (duration < 60) {
                    cost = (duration * hourlyRate) / 60.0;
                }

                timeCredit = Math.max(timeCredit - durationExcess, 0);
                user.setUserTimeCreditBalance(timeCredit);
            } else {
                cost = (duration * hourlyRate) / 60.0;
            }
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