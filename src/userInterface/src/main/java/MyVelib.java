package main.java;

import fr.cs.GroupNN.myVelib.*;

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
        myVelibNetworks.add(this);
    }

    public static ArrayList<MyVelib> getMyVelibNetworks() {
        return myVelibNetworks;
    }



    // adding methods
    public void addUser(User user){
        users.add(user);
    }

    public void addDockingStation(DockingStation dockingStation){
        dockingStationsList.add(dockingStation);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<DockingStation> getDockingStationsList() {
        return dockingStationsList;
    }

    public void setDockingStationsList(ArrayList<DockingStation> dockingStationsList) {
        this.dockingStationsList = dockingStationsList;
    }
}
