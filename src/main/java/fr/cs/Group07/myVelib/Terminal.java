package fr.cs.Group07.myVelib;

import java.time.Duration;
import java.time.LocalDateTime;

public class Terminal implements BicycleVisitor {

    public Terminal() {
        super();
    }


    /**
     * Visits a MechanicalBicycle and retrieves its hourly rate.
     *
     * @param bicycle The MechanicalBicycle to visit.
     */
    @Override
    public void visit(MechanicalBicycle bicycle) {
        double hourlyRate = bicycle.getHourlyRate();
    }


    /**
     * Visits an ElectricalBicycle and retrieves its hourly rate.
     *
     * @param bicycle The ElectricalBicycle to visit.
     */
    @Override
    public void visit(ElectricalBicycle bicycle) {
        double hourlyRate = bicycle.getHourlyRate();
    }

    /**
     * Calculates the cost of a bicycle rental for a given user and duration.
     *
     * @param user     The user renting the bicycle.
     * @param duration The duration of the rental in minutes.
     * @return The calculated cost of the rental.
     */
    public double calculateCost(User user, int duration) {
        Bicycle bicycle = user.getRentedBicycle();
        double cost = 0;
        if (user != null && user.getRegistrationCard() != null) {
            String registrationType = user.getRegistrationCard().getRegistrationType();
            int timeCredit = user.getUserTimeCreditBalance();
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
            }
            else if (registrationType.equals("VMAX")) {
                int durationExcess = Math.max(duration - freeHour, 0);
                int effectiveDuration = Math.max(durationExcess - timeCredit, 0);

                cost = (effectiveDuration / 60.0) * 1;

                timeCredit = Math.max(timeCredit - durationExcess, 0);
                user.setUserTimeCreditBalance(timeCredit);
            }

            else {
                cost = (duration * hourlyRate) / 60.0;
            }
        }
        return cost;
    }


    /**
     * Rents a bicycle for a user from a docking station.
     *
     * @param dockingStation The docking station from which to rent the bicycle.
     * @param user           The user renting the bicycle.
     * @param bicycleType    The type of bicycle to rent.
     */
    public void rentBicycle(DockingStation dockingStation, User user, String bicycleType) {
        if (user.getRentedBicycle() != null) {
            System.out.println("User already has a rented bicycle. Cannot rent another one.");
            return;
        }

        if (!dockingStation.isOnService()) {
            System.out.println("The docking station is currently off-duty. Cannot rent a bicycle.");
            return;
        }

        if (!dockingStation.oneBike(bicycleType)) {
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


    /**
     * Parks a bicycle for a user at a docking station.
     *
     * @param dockingStation The docking station at which to park the bicycle.
     * @param user           The user parking the bicycle.
     */
    public void parkBicycle(DockingStation dockingStation, User user) {
        Bicycle bicycle = user.getRentedBicycle();

        if (bicycle == null){
            System.out.println("User does not have a bicycle to park.");
            return;
        }

        if (!dockingStation.isOnService()) {
            System.out.println("The docking station is currently off-duty. Cannot park a bicycle.");
            return;
        }

        // park the bike (if there exists a free slot (the condition is handled in parkBike))
        dockingStation.parkBike(bicycle);

        // Update user's information
        user.setParkDateTime(LocalDateTime.now());

        int rentTime = calculateDuration(user);
        double costOfTheRide = this.calculateCost(user, rentTime);

        user.setRentedBicycle(null);
        user.setUserLocation(dockingStation.getDockingStationLocation());
        if (dockingStation.getStationType() == "plus"){
            user.setTimeCreditEarned(user.getTimeCreditEarned() + 5);
            user.setUserTimeCreditBalance(user.getUserTimeCreditBalance() + 5);
        }
        user.addToTotalCharges(costOfTheRide);
        user.setNumberOfRides(user.getNumberOfRides() + 1);
        user.setTotalRentTime(user.getTotalRentTime() + rentTime);
        user.getListOfUsedBicycleIds().add(bicycle.getBicycleId());
        user.setRentDateTime(null);
        user.setParkDateTime(null);

        System.out.println("Bicycle parked successfully.");
    }



    /**
     * Calculates the duration of a user's rental.
     *
     * @param user The user who rented the bicycle.
     * @return The duration of the rental in minutes.
     */
    private int calculateDuration(User user) {
        Duration duration = Duration.between(user.getRentDateTime(), user.getParkDateTime());
        int minutes = (int) (duration.toMinutes() % 60 * 100_000_000);
        return minutes;
    }
}