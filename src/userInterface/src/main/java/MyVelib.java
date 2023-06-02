package main.java;

import fr.cs.Group07.myVelib.DockingStation;
import fr.cs.Group07.myVelib.User;

import java.util.ArrayList;

public class MyVelib {
    // fields
    private String name;
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<DockingStation> dockingStationsList = new ArrayList<DockingStation>();

    // static field
    private static ArrayList<MyVelib> myVelibNetworks = new ArrayList<MyVelib>();

    // constructor
    public MyVelib(String name){
        super();
        this.setName(name);
    }

    public User getUserByID(int userID) {
        for (User user: users) {
            if (user.getUserId() == userID) {
                return user;
            }
            else {
                return null;
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
    public void addUser(User user){
        users.add(user);
    }

    public void addDockingStation(DockingStation dockingStation){
        dockingStationsList.add(dockingStation);
    }

    public static void addMyVelib(MyVelib myVelib){
        myVelibNetworks.add(myVelib);
    }

    public static MyVelib inMyVelibNetworks(String velibNetworkName) {
        MyVelib velibNetwork = null;

        for (MyVelib myVelib: myVelibNetworks) {
            String currentNetworkName = myVelib.getName();
            if (velibNetworkName.equals(currentNetworkName)){
                velibNetwork = myVelib;
                break;
            }
        }

        return velibNetwork;
    }
}
