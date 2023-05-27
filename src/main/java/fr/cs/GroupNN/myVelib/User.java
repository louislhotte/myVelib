package fr.cs.GroupNN.myVelib;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class User {
    private String name;
    private int UserId;
    private double[] userLocation;
    private int UserTimeCreditBalance;
    private double totalCharges;
    private Cards registrationCard;
    private String creditCardNumber;
    private int numberOfRides;
    private int totalRentTime;
    private int timeCreditEarned;
    private Bicycle rentedBicycle;
    private LocalDateTime rentDateTime;
    private ArrayList<Integer> listOfUsedBicycleIds;

    public User(String name, int userId, double[] userLocation, int userTimeCreditBalance, double totalCharges, Cards registrationCard, String creditCardNumber, int numberOfRides, int totalRentTime, int timeCreditEarned, Bicycle rentedBicycle, LocalDateTime rentDateTime, ArrayList<Integer> listOfUsedBicycleIds) {
        this.name = name;
        UserId = userId;
        this.userLocation = userLocation;
        UserTimeCreditBalance = userTimeCreditBalance;
        this.totalCharges = totalCharges;
        this.registrationCard = registrationCard;
        this.creditCardNumber = creditCardNumber;
        this.numberOfRides = numberOfRides;
        this.totalRentTime = totalRentTime;
        this.timeCreditEarned = timeCreditEarned;
        this.rentedBicycle = rentedBicycle;
        this.rentDateTime = rentDateTime;
        this.listOfUsedBicycleIds = listOfUsedBicycleIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public double[] getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(double[] userLocation) {
        this.userLocation = userLocation;
    }

    public int getUserTimeCreditBalance() {
        return UserTimeCreditBalance;
    }

    public void setUserTimeCreditBalance(int userTimeCreditBalance) {
        UserTimeCreditBalance = userTimeCreditBalance;
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

    public ArrayList<Integer> getListOfUsedBicycleIds() {
        return listOfUsedBicycleIds;
    }

    public void setListOfUsedBicycleIds(ArrayList<Integer> listOfUsedBicycleIds) {
        this.listOfUsedBicycleIds = listOfUsedBicycleIds;
    }

    public void addToTotalCharges(double charges){
        double currentTotalCharges = this.getTotalCharges();
        double newTotalCharges = currentTotalCharges + charges;
        this.setTotalCharges(newTotalCharges);
    }
}
