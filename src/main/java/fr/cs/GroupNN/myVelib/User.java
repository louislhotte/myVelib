package fr.cs.GroupNN.myVelib;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class User {
    private static int counter;
    private String name;
    private int userId;
    private double[] userLocation;
    private int userTimeCreditBalance;
    private double totalCharges;
    private Cards registrationCard;
    private String creditCardNumber;
    private int numberOfRides;
    private int totalRentTime;
    private int timeCreditEarned;
    private Bicycle rentedBicycle;
    private LocalDateTime rentDateTime;
    private LocalDateTime parkDateTime;
    private ArrayList<Integer> listOfUsedBicycleIds;

    public User(String name, double[] userLocation, String creditCardNumber) {
        super();
        this.name = name;
        counter++;
        userId = counter;
        this.userLocation = userLocation;
        userTimeCreditBalance = 0;
        this.totalCharges = 0;
        this.registrationCard = null;
        this.creditCardNumber = creditCardNumber;
        this.numberOfRides = 0;
        this.totalRentTime = 0;
        this.timeCreditEarned = 0;
        this.rentedBicycle = null;
        this.rentDateTime = null;
        this.listOfUsedBicycleIds = null;
        this.parkDateTime = null;
    }

    public User(String name, double[] userLocation, Cards registrationCard, String creditCardNumber) {
        super();
        this.name = name;
        counter++;
        userId = counter;
        this.userLocation = userLocation;
        userTimeCreditBalance = 0;
        this.totalCharges = 0;
        this.registrationCard = registrationCard;
        this.creditCardNumber = creditCardNumber;
        this.numberOfRides = 0;
        this.totalRentTime = 0;
        this.timeCreditEarned = 0;
        this.rentedBicycle = null;
        this.rentDateTime = null;
        this.listOfUsedBicycleIds = null;
        this.parkDateTime = null;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double[] getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(double[] userLocation) {
        this.userLocation = userLocation;
    }

    public int getUserTimeCreditBalance() {
        return userTimeCreditBalance;
    }

    public void setUserTimeCreditBalance(int userTimeCreditBalance) {
        this.userTimeCreditBalance = userTimeCreditBalance;
    }

    public double getTotalCharges() {
        return totalCharges;
    }

    public void setTotalCharges(double totalCharges) {
        this.totalCharges = totalCharges;
    }

    public Cards getRegistrationCard() {
        return registrationCard;
    }

    public void setRegistrationCard(Cards registrationCard) {
        this.registrationCard = registrationCard;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public int getNumberOfRides() {
        return numberOfRides;
    }

    public void setNumberOfRides(int numberOfRides) {
        this.numberOfRides = numberOfRides;
    }

    public int getTotalRentTime() {
        return totalRentTime;
    }

    public void setTotalRentTime(int totalRentTime) {
        this.totalRentTime = totalRentTime;
    }

    public int getTimeCreditEarned() {
        return timeCreditEarned;
    }

    public void setTimeCreditEarned(int timeCreditEarned) {
        this.timeCreditEarned = timeCreditEarned;
    }

    public Bicycle getRentedBicycle() {
        return rentedBicycle;
    }

    public void setRentedBicycle(Bicycle rentedBicycle) {
        this.rentedBicycle = rentedBicycle;
    }

    public LocalDateTime getRentDateTime() {
        return rentDateTime;
    }

    public void setRentDateTime(LocalDateTime rentDateTime) {
        this.rentDateTime = rentDateTime;
    }

    public LocalDateTime getParkDateTime() {
        return parkDateTime;
    }

    public void setParkDateTime(LocalDateTime parkDateTime) {
        this.parkDateTime = parkDateTime;
    }

    public ArrayList<Integer> getListOfUsedBicycleIds() {
        return listOfUsedBicycleIds;
    }

    public void setListOfUsedBicycleIds(ArrayList<Integer> listOfUsedBicycleIds) {
        this.listOfUsedBicycleIds = listOfUsedBicycleIds;
    }


    /**
     * Adds the specified charges to the total charges of the user.
     *
     * @param charges The charges to be added to the total charges.
     */

    public void addToTotalCharges(double charges){
        double currentTotalCharges = this.getTotalCharges();
        double newTotalCharges = currentTotalCharges + charges;
        this.setTotalCharges(newTotalCharges);
    }



    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", userLocation=" + Arrays.toString(userLocation) +
                ", userTimeCreditBalance=" + userTimeCreditBalance +
                ", totalCharges=" + totalCharges +
                ", registrationCard=" + registrationCard +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", numberOfRides=" + numberOfRides +
                ", totalRentTime=" + totalRentTime +
                ", timeCreditEarned=" + timeCreditEarned +
                ", rentedBicycle=" + rentedBicycle +
                ", rentDateTime=" + rentDateTime +
                ", parkDateTime=" + parkDateTime +
                ", listOfUsedBicycleIds=" + listOfUsedBicycleIds +
                '}';
    }


}
