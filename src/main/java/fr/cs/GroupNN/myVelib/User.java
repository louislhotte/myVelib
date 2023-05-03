package fr.cs.GroupNN.myVelib;

public class User {
    private String name;
    private int UserId;
    private int UserLatitude;
    private int UserLongitude;
    private int UserTimeCreditBalance;
    private double totalCharges;
    private Cards registrationCard;

    public User(String name, int userId, int userLatitude, int userLongitude, int userTimeCreditBalance, double totalCharges, Cards registrationCard) {
        this.name = name;
        UserId = userId;
        UserLatitude = userLatitude;
        UserLongitude = userLongitude;
        UserTimeCreditBalance = userTimeCreditBalance;
        this.totalCharges = totalCharges;
        this.registrationCard = registrationCard;
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

    public int getUserLatitude() {
        return UserLatitude;
    }

    public void setUserLatitude(int userLatitude) {
        UserLatitude = userLatitude;
    }

    public int getUserLongitude() {
        return UserLongitude;
    }

    public void setUserLongitude(int userLongitude) {
        UserLongitude = userLongitude;
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
}
