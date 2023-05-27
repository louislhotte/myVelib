package fr.cs.GroupNN.myVelib;

public class UserBalance {
    // fields
    private User user;

    // constructor
    public UserBalance(User user){
        super();
        this.setUser(user);
    }

    // getters and setters
    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    // methods
    public int getNumberOfRides(){
        return user.getNumberOfRides();
    }

    public int getTotalRentTime(){
        return user.getTotalRentTime();
    }

    public double getTotalCharges(){
        return user.getTotalCharges();
    }

    public int getTimeCreditEarned(){
        return user.getTimeCreditEarned();
    }

    // toString method
    @Override
    public String toString(){
        String s = "Number of rides=" + this.getNumberOfRides() + "; Total time spent on a bike=" + this.getTotalRentTime() +
                "; Total amount of charges=" + this.getTotalCharges() + "; Time-credit earned=" + this.getTimeCreditEarned();
        return s;
    }
}