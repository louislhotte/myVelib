package fr.cs.Group07.myVelib;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The User class represents a user in the myVelib system.
 */
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

    /**
     * Constructs a User object with the specified name, user location, and credit card number.
     *
     * @param name            the name of the user
     * @param userLocation    the coordinates representing the user's location
     * @param creditCardNumber the credit card number of the user
     */
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

    /**
     * Constructs a User object with the specified name, user location, registration card, and credit card number.
     *
     * @param name              the name of the user
     * @param userLocation      the coordinates representing the user's location
     * @param registrationCard  the registration card of the user
     * @param creditCardNumber  the credit card number of the user
     */
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

    /**
     * Returns the name of the user.
     *
     * @return the name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     *
     * @param name the name of the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the ID of the user.
     *
     * @return the ID of the user
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the ID of the user.
     *
     * @param userId the ID of the user
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Returns the location of the user.
     *
     * @return the location of the user
     */
    public double[] getUserLocation() {
        return userLocation;
    }

    /**
     * Sets the location of the user.
     *
     * @param userLocation the location of the user
     */
    public void setUserLocation(double[] userLocation) {
        this.userLocation = userLocation;
    }

    /**
     * Returns the time credit balance of the user.
     *
     * @return the time credit balance of the user
     */
    public int getUserTimeCreditBalance() {
        return userTimeCreditBalance;
    }

    /**
     * Sets the time credit balance of the user.
     *
     * @param userTimeCreditBalance the time credit balance of the user
     */
    public void setUserTimeCreditBalance(int userTimeCreditBalance) {
        this.userTimeCreditBalance = userTimeCreditBalance;
    }

    /**
     * Returns the total charges of the user.
     *
     * @return the total charges of the user
     */
    public double getTotalCharges() {
        return totalCharges;
    }

    /**
     * Sets the total charges of the user.
     *
     * @param totalCharges the total charges of the user
     */
    public void setTotalCharges(double totalCharges) {
        this.totalCharges = totalCharges;
    }

    /**
     * Returns the registration card of the user.
     *
     * @return the registration card of the user
     */
    public Cards getRegistrationCard() {
        return registrationCard;
    }

    /**
     * Sets the registration card of the user.
     *
     * @param registrationCard the registration card of the user
     */
    public void setRegistrationCard(Cards registrationCard) {
        this.registrationCard = registrationCard;
    }

    /**
     * Returns the credit card number of the user.
     *
     * @return the credit card number of the user
     */
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    /**
     * Sets the credit card number of the user.
     *
     * @param creditCardNumber the credit card number of the user
     */
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    /**
     * Returns the number of rides for the user.
     *
     * @return the number of rides for the user
     */
    public int getNumberOfRides() {
        return numberOfRides;
    }

    /**
     * Sets the number of rides for the user.
     *
     * @param numberOfRides the number of rides for the user
     */
    public void setNumberOfRides(int numberOfRides) {
        this.numberOfRides = numberOfRides;
    }

    /**
     * Returns the total rent time for the user.
     *
     * @return the total rent time for the user
     */
    public int getTotalRentTime() {
        return totalRentTime;
    }

    /**
     * Sets the total rent time for the user.
     *
     * @param totalRentTime the total rent time for the user
     */
    public void setTotalRentTime(int totalRentTime) {
        this.totalRentTime = totalRentTime;
    }

    /**
     * Returns the time credit earned by the user.
     *
     * @return the time credit earned by the user
     */
    public int getTimeCreditEarned() {
        return timeCreditEarned;
    }

    /**
     * Sets the time credit earned by the user.
     *
     * @param timeCreditEarned the time credit earned by the user
     */
    public void setTimeCreditEarned(int timeCreditEarned) {
        this.timeCreditEarned = timeCreditEarned;
    }

    /**
     * Returns the rented bicycle by the user.
     *
     * @return the rented bicycle by the user
     */
    public Bicycle getRentedBicycle() {
        return rentedBicycle;
    }

    /**
     * Sets the rented bicycle by the user.
     *
     * @param rentedBicycle the rented bicycle by the user
     */
    public void setRentedBicycle(Bicycle rentedBicycle) {
        this.rentedBicycle = rentedBicycle;
    }

    /**
     * Returns the rent date and time for the user.
     *
     * @return the rent date and time for the user
     */
    public LocalDateTime getRentDateTime() {
        return rentDateTime;
    }

    /**
     * Sets the rent date and time for the user.
     *
     * @param rentDateTime the rent date and time for the user
     */
    public void setRentDateTime(LocalDateTime rentDateTime) {
        this.rentDateTime = rentDateTime;
    }

    /**
     * Returns the park date and time for the user.
     *
     * @return the park date and time for the user
     */
    public LocalDateTime getParkDateTime() {
        return parkDateTime;
    }

    /**
     * Sets the park date and time for the user.
     *
     * @param parkDateTime the park date and time for the user
     */
    public void setParkDateTime(LocalDateTime parkDateTime) {
        this.parkDateTime = parkDateTime;
    }

    /**
     * Returns the list of used bicycle IDs for the user.
     *
     * @return the list of used bicycle IDs for the user
     */
    public ArrayList<Integer> getListOfUsedBicycleIds() {
        return listOfUsedBicycleIds;
    }

    /**
     * Sets the list of used bicycle IDs for the user.
     *
     * @param listOfUsedBicycleIds the list of used bicycle IDs for the user
     */
    public void setListOfUsedBicycleIds(ArrayList<Integer> listOfUsedBicycleIds) {
        this.listOfUsedBicycleIds = listOfUsedBicycleIds;
    }

    /**
     * Adds the specified charges to the total charges of the user.
     *
     * @param charges the charges to be added to the total charges
     */
    public void addToTotalCharges(double charges) {
        double currentTotalCharges = this.getTotalCharges();
        double newTotalCharges = currentTotalCharges + charges;
        this.setTotalCharges(newTotalCharges);
    }

    /**
     * Returns a string representation of the user.
     *
     * @return a string representation of the user
     */
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
