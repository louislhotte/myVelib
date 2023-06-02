package main.java;

import java.util.ArrayList;
import java.util.HashMap;

import fr.cs.Group07.myVelib.*;

public class Command {
    private String commandOrder;
    private ArrayList<String> arguments;

    public Command(String commandOrder, ArrayList<String> arguments) {
        this.commandOrder = commandOrder;
        this.arguments = arguments;
    }

    public Command() {
        this.commandOrder = null;
        this.arguments = null;
    }

    public boolean exit() {
        return commandOrder.equals("exit");
    }

    /**
     * Takes the command, and complete the evaluation and action of it
     *
     * @return the result string
     * @throws Exception the exception
     */
    // executes the given command and returns a STATUS message
    public String eval() throws Exception {
        switch (commandOrder.toLowerCase()) {
            case "help":
                return "[Command Syntax]" + "\n" +
                        "Command Syntax: command-name <arg1> <arg2> ... <argN>\n\n"
                        + "[Available Commands]\n\n"
                        + "setup <velibnetworkName>: Create a myVelib network with the given name. The network consists of 10 stations, each with 10 parking slots. Stations are arranged on a square grid of side 4km. Initially, 75% of bikes are randomly distributed across the stations.\n\n"
                        + "setup <name> <nstations> <nslots> <s> <nbikes>: Create a myVelib network with the given name, consisting of nstations stations, each with nslots parking slots. Stations are distributed as uniformly as possible over either a circular area of radius s or a square area of side s. The network is initially populated with nbikes bikes randomly distributed across the stations.\n\n"
                        + "addUser <userName, cardType, velibnetworkName>: Add a user with the specified name and card type ('none' if the user has no card) to the myVelib network.\n\n"
                        + "offline <velibnetworkName, stationID>: Put the specified station offline in the myVelib network.\n\n"
                        + "online <velibnetworkName, stationID>: Put the specified station online in the myVelib network.\n\n"
                        + "rentBike <userID, stationID, bicycleType>: Allow the specified user to rent a bike from the specified station. If no bikes are available, appropriate action is taken.\n\n"
                        + "rentBike <userID, GPS_Position>: Allow the specified user to rent a bike from a given GPS position.\n\n"
                        + "returnBike <userID, stationID, duration>: Allow the specified user to return a bike to the specified station after the given duration. If no parking bay is available, appropriate action is taken. The command also displays the cost of the rent.\n\n"
                        + "displayStation <velibnetworkName, stationID>: Display the statistics of the specified station in the myVelib network.\n\n"
                        + "displayUser <velibnetworkName, userID>: Display the statistics of the specified user in the myVelib network.\n\n"
                        + "sortStation <velibnetworkName, sortpolicy>: Display the stations in increasing order based on the specified sorting policy of the user.\n\n"
                        + "display <velibnetworkName>: Display the entire status of the myVelib network, including stations, parking bays, and users.\n\n"
                        + "exit: Exit the myVelib network.\n\n"
                        + "[End of Available Commands]";

            case "":
                return "";
            case "setup":
                if (arguments.size() == 0){
                    setup("defaultName" ,10, 10, 4000.0, 75);
                    return "Successfully set up the default myVelib network.";
                }
                else if (arguments.size() == 4) {
                    String name = arguments.get(0);
                    int nStations = Integer.parseInt(arguments.get(1));
                    int nSlots = Integer.parseInt(arguments.get(2));
                    double s =Double.parseDouble(arguments.get(3));
                    double nBikes = Double.parseDouble(arguments.get(4));

                    setup(name, nStations, nSlots, s, nBikes);
                    return "Successfully set up the velibNetwork with " + nStations + " Stations " + nSlots + "Slots" + "of squared area with side length " + s + "and initially populated with" + nBikes + "bikes";
                }
                break;
            case "addUser":
                if (arguments.size() == 3){
                    String name = arguments.get(0);
                    String cardType = arguments.get(1);
                    String velibNetwork = arguments.get(2);

                    addUser(name, cardType, velibNetwork);

                    return "Successfully added a user";
                }
                else {
                    return "3 arguments expected";
                }
            case "offline":
                if (arguments.size() == 2){
                    String velibNetworkName = arguments.get(0);
                    int stationID = Integer.parseInt(arguments.get(1));

                    int value = offline(velibNetworkName, stationID);
                    if (value == -1){
                        return "No current MyVelib network with the given name.";
                    }
                    else if (value == 0){
                        return "Station shut down successfully";
                    }
                    else{
                        return "The given Station ID does not match any of the existing docking stations";
                    }
                }
                else{
                    return "2 arguments expected";
                }
            case "online":
                if (arguments.size() == 2){
                    String velibNetworkName = arguments.get(0);
                    int stationID = Integer.parseInt(arguments.get(1));

                    int value = online(velibNetworkName, stationID);
                    if (value == -1){
                        return "No current MyVelib network with the given name.";
                    }
                    else if (value == 0){
                        return "Station switched on successfully";
                    }
                    else{
                        return "The given Station ID does not match any of the existing docking stations";
                    }
                }
                else{
                    return "2 arguments expected";
                }
            case "exit":
                return "Exiting the network.";


            case "rentbike":
                if (arguments.size() == 4) {
                    int userID = Integer.parseInt(arguments.get(0));
                    int stationID = Integer.parseInt(arguments.get(1));
                    String name = arguments.get(2);
                    String bicycleType = arguments.get(3);
                    rentBike(userID, stationID, name, bicycleType);
                    return "Bike successfully rented.";
                }
                else {
                    return "4 arguments expected";
                }
            case "displayStation":
                if (arguments.size() == 2) {
                    String name = arguments.get(0);
                    int stationID = Integer.parseInt(arguments.get(1));
                    displayStation(name, stationID);
                }
                else {
                    return "2 arguments expected.";
                }

            case "displayUser":
                if (arguments.size() == 2) {
                    String name = arguments.get(0);
                    int userID = Integer.parseInt(arguments.get(1));
                    displayUser(name, userID);
                }
                else {
                    return "2 arguments expected.";
                }

            case "returnBike":
                if (arguments.size() == 4) {
                    int userID = Integer.parseInt(arguments.get(0));
                    int stationID = Integer.parseInt(arguments.get(1));
                    double duration = Double.parseDouble(arguments.get(2));
                    String name = arguments.get(4);
                    returnBike(userID, stationID, duration, name);
                    return "Bike successfully returned to docking station " + stationID;
                }
                else {
                    return "4 arguments expected.";
                }

            default:
                return "Unknown command entered. Type help to display help.";
        }
        return "";
    }

    public void returnBike(int userID, int stationID, double duration, String name) {
        MyVelib myvelib = MyVelib.inMyVelibNetworks(name);
        User user = myvelib.getUserByID(userID);
        DockingStation dockingStation = DockingStation.getDockingStationByID(stationID);
        if (dockingStation.oneFree()) {
            dockingStation.getTerminal().parkBicycle(dockingStation, user);
        }
        else {
            System.out.println("Park not successfully parked due to no free spots.");
            return;
        }
    }

    public String displayUser(String name, int userID) {
        MyVelib myvelib = MyVelib.inMyVelibNetworks(name);
        User user = myvelib.getUserByID(userID);
        return user.toString();
    }


    public String displayStation(String name, int stationID) {
        MyVelib myvelib = MyVelib.inMyVelibNetworks(name);
        DockingStation dockingStation = DockingStation.getDockingStationByID(stationID);
        return dockingStation.toString();
    }



    public void rentBike(int userID,int stationID, String name, String bicycleType) {
        MyVelib myvelib = MyVelib.inMyVelibNetworks(name);
        User user = myvelib.getUserByID(userID);
        DockingStation dockingStation = DockingStation.getDockingStationByID(stationID);
        if (dockingStation.oneBike(bicycleType)) {
            dockingStation.getTerminal().rentBicycle(dockingStation, user, bicycleType);
            System.out.println("User " + user.getName() + " picked a " + bicycleType + "at the the docking Station " + stationID);
        }
    }
//    addUser <userName,cardType, velibNetworkName> : to add a user with name
//    userName and card cardType (i.e. ``none'' if the user has no card) to a myVelib network
//    velibNetworkName

    public void addUser(String userName, String cardType, String velibNetworkName){
        long first14Digits = (long) (Math.random() * 100_000_000_000_000D);
        long creditCardNumber = 5200000000000000L + first14Digits;
        String stringCreditCardNumber = Long.toString(creditCardNumber);
        double[] location = {0.0, 0.0};
        User user = null;

        if (cardType.toLowerCase() == "vlibre" || cardType.toLowerCase() == "vmax"){
            Cards card = new Cards(cardType.toUpperCase());
            user = new User(userName, location, card, stringCreditCardNumber);
        }

        else{
            user = new User(userName, location, stringCreditCardNumber);
        }

        MyVelib velibNetwork = MyVelib.inMyVelibNetworks(velibNetworkName);

        if (velibNetwork != null){
            velibNetwork.addUser(user);
        }
        else{
            System.out.println("No current MyVelib network with the given name.");
        }
    }

    public void setup(String velibNetworkName, int nStations, int nSlots, double s, double nBikes) {
        MyVelib myvelib = new MyVelib(velibNetworkName);
        MyVelib.addMyVelib(myvelib);
        ArrayList<double[]> locations = new ArrayList<double[]>();

        ParkingSlot[] slots;
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        hashMap.put(0, "Standard");
        hashMap.put(1, "Plus");

        for (int i = 0; i < nStations; i++) {
            slots = new ParkingSlot[nSlots];
            // square map of size s
            double[] location = {Math.random() * s, Math.random() * s};
            locations.add(location);

            int type = (int) (Math.random()*2);
            DockingStation station = null;

            // creating the parking slots
            for (int j = 0; j < nSlots; j++) {
                ParkingSlot parkingSlot = new ParkingSlot(null, true, false);
                slots[j] = parkingSlot;
            }
            station = new DockingStation(location, hashMap.get(type), slots, new Terminal());
            myvelib.addDockingStation(station);
        }

        int counter = 0;
        while (counter < nBikes){
            int index = (int) (Math.random()*(nBikes - counter));
            double[] location = locations.get(index);

            int isElectrical = (int) (Math.random() * 2);
            Bicycle bicycle = null;
            if (isElectrical == 1) {
                bicycle = new ElectricalBicycle(location);
            } else {
                bicycle = new MechanicalBicycle(location);
            }

            ArrayList<DockingStation> dockingStations = myvelib.getDockingStationsList();

            DockingStation locatedDockingStation = null;
            for (DockingStation dockingStation: dockingStations){
                double[] currentDockingStationLocation = dockingStation.getDockingStationLocation();
                if(DockingStation.equalLocation(currentDockingStationLocation, location)) {
                    locatedDockingStation = dockingStation;
                    break;
                }
            }
            ParkingSlot[] parkingSlots = locatedDockingStation.getSlots();
            for (ParkingSlot parkingSlot: parkingSlots) {
                if (!parkingSlot.isOutOfOrder()){
                    if (parkingSlot.isFree()){
                        parkingSlot.setBicycle(bicycle);
                        parkingSlot.setFree(false);
                        locations.remove(index);
                        counter++;
                        break;
                    }
                }
            }

        }

    }

    public int offline(String velibNetworkName, int stationID){
        MyVelib velibNetwork = MyVelib.inMyVelibNetworks(velibNetworkName);

        if (velibNetwork == null) {
            return -1;
        }

        else{
            boolean stationIDExists = false;
            for (DockingStation dockingStation: DockingStation.getDockingStations()) {
                if (dockingStation.getId() == stationID){
                    stationIDExists = true;
                    dockingStation.setOnService(false);
                    break;
                }
            }
            if (!stationIDExists){
                return 1;
            }
            return 0;
        }
    }

    public String getCommandOrder() {
        return commandOrder;
    }

    public void setCommandOrder(String commandOrder) {
        this.commandOrder = commandOrder;
    }

    public ArrayList<String> getArguments() {
        return arguments;
    }

    public void setArguments(ArrayList<String> arguments) {
        this.arguments = arguments;
    }

    public int online(String velibNetworkName, int stationID){
        MyVelib velibNetwork = MyVelib.inMyVelibNetworks(velibNetworkName);

        if (velibNetwork == null) {
            return -1;
        }

        else{
            boolean stationIDExists = false;
            for (DockingStation dockingStation: DockingStation.getDockingStations()) {
                if (dockingStation.getId() == stationID){
                    stationIDExists = true;
                    dockingStation.setOnService(true);
                    break;
                }
            }
            if (!stationIDExists){
                return 1;
            }
            return 0;
        }

    }
}
