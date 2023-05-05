package fr.cs.GroupNN.myVelib;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class User {
    private String name;
    private int UserId;
    private int UserLatitude;
    private int UserLongitude;
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


    public User(String name, int userId, int userLatitude, int userLongitude, int userTimeCreditBalance, double totalCharges, Cards registrationCard, String creditCardNumber, int numberOfRides, int totalRentTime, int timeCreditEarned, Bicycle rentedBicycle, LocalDateTime rentDateTime, ArrayList<Integer> listOfUsedBicycleIds) {
        /*
        @param

         */
        this.name = name;
        UserId = userId;
        UserLatitude = userLatitude;
        UserLongitude = userLongitude;
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
}
