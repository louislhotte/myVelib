package main.java;

import fr.cs.Group07.myVelib.DockingStation;
import fr.cs.Group07.myVelib.User;

import java.util.ArrayList;

/**
 * The MyVelib class represents a Velib network and manages its users and docking stations.
 */
public class MyVelib {
    // fields
    private String name;
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<DockingStation> dockingStationsList = new ArrayList<>();

    // static field
    private static ArrayList<MyVelib> myVelibNetworks = new ArrayList<>();

    /**
     * Constructs a MyVelib object with the specified name.
     *
     * @param name The name of the MyVelib network.
     */
    public MyVelib(String name) {
        this.name = name;
    }

    /**
     * Retrieves a user from the MyVelib network based on the user ID.
     *
     * @param userID The ID of the user to retrieve.
     * @return The User object with the specified ID, or null if no such user exists.
     */
    public User getUserByID(int userID) {
        for (User user : users) {
            if (user.getUserId() == userID) {
                return user;
            }
        }
        return null;
    }

    // getters
    public String getName() {
        return name;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<DockingStation> getDockingStationsList() {
        return dockingStationsList;
    }

    public static ArrayList<MyVelib> getMyVelibNetworks() {
        return myVelibNetworks;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    // adding methods
    public void addUser(User user) {
        users.add(user);
    }

    public void addDockingStation(DockingStation dockingStation) {
        dockingStationsList.add(dockingStation);
    }

    public static void addMyVelib(MyVelib myVelib) {
        myVelibNetworks.add(myVelib);
    }

    /**
     * Retrieves a MyVelib network from the list of networks based on its name.
     *
     * @param velibNetworkName The name of the MyVelib network to retrieve.
     * @return The MyVelib object with the specified name, or null if no such network exists.
     */
    public static MyVelib inMyVelibNetworks(String velibNetworkName) {
        for (MyVelib myVelib : myVelibNetworks) {
            if (velibNetworkName.equals(myVelib.getName())) {
                return myVelib;
            }
        }
        return null;
    }
}
