package fr.cs.Group07.myVelib;

/**
 * The UserBalance class represents the balance of a user,
 * including the number of rides, total rent time, total charges, and time-credit earned.
 */
public class UserBalance {
    private User user;

    /**
     * Constructs a UserBalance object for the specified user.
     *
     * @param user the user
     */
    public UserBalance(User user) {
        super();
        this.setUser(user);
    }

    /**
     * Returns the user associated with this user balance.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user for this user balance.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Returns the number of rides for the user.
     *
     * @return the number of rides
     */
    public int getNumberOfRides() {
        return user.getNumberOfRides();
    }

    /**
     * Returns the total rent time for the user.
     *
     * @return the total rent time
     */
    public int getTotalRentTime() {
        return user.getTotalRentTime();
    }

    /**
     * Returns the total charges for the user.
     *
     * @return the total charges
     */
    public double getTotalCharges() {
        return user.getTotalCharges();
    }

    /**
     * Returns the time-credit earned by the user.
     *
     * @return the time-credit earned
     */
    public int getTimeCreditEarned() {
        return user.getTimeCreditEarned();
    }

    /**
     * Returns a string representation of the user balance.
     *
     * @return a string representing the user's statistics
     */
    @Override
    public String toString() {
        String s = "Number of rides=" + this.getNumberOfRides() + "; Total time spent on a bike=" + this.getTotalRentTime() +
                "; Total amount of charges=" + this.getTotalCharges() + "; Time-credit earned=" + this.getTimeCreditEarned();
        return s;
    }
}
