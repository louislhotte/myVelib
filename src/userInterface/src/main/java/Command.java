package main.java;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;

import fr.cs.GroupNN.myVelib.*;

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
                        + "rentBike <userID, stationID>: Allow the specified user to rent a bike from the specified station. If no bikes are available, appropriate action is taken.\n\n"
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
                    setup(10, 10, 4000.0, 75);
                    return "Successfully set up the default myVelib network.";
                }
                else if (arguments.size() == 4) {
                    int nStations = Integer.parseInt(arguments.get(0));
                    int nSlots = Integer.parseInt(arguments.get(1));
                    double s =Double.parseDouble(arguments.get(2));
                    double nBikes = Double.parseDouble(arguments.get(3));

                    setup(nStations, nSlots, s, nBikes);
                    return "Successfully set up the velibNetwork with " + nStations + " Stations " + nSlots + "Slots" + "of squared area with side length " + s + "and initially populated with" + nBikes + "bikes";
                }
            case "exit":
                return "Exiting the network.";

            default:
                return "Unknown command entered. Type help to display help.";
        }
    }


//    addUser <userName,cardType, velibNetworkName> : to add a user with name
//    userName and card cardType (i.e. ``none'' if the user has no card) to a myVelib network
//    velibNetworkName

    public void addUser(String userName, String cardType, String velibNetworkName){
        double first14Digits = (double) (Math.random() * 100_000_000_000_000D);
        double creditCardNumber = 5200000000000000D + first14Digits;
        String stringCreditCardNumber = Double.toString(creditCardNumber);
        double[] location = {0.0, 0.0};

        if (cardType.toLowerCase() == "none"){
            User user = new User(userName, location, stringCreditCardNumber);
        }
        else if (cardType.toLowerCase() == "vlibre" || cardType.toLowerCase() == "vmax"){
            User user = new User(userName, location, stringCreditCardNumber);
        }
    }

    public void setup(int nStations, int nSlots, double s, double nBikes) {
        ArrayList<ParkingSlot> parkingSlots= new ArrayList<>();

        for (int i = 0; i < nStations; i++) {
            double[] location = {Math.random() * s, Math.random() * s};
            ParkingSlot[] slots = {};
            DockingStation station = new DockingStation(location, "Standard", slots, new Terminal());

            for (int j = 0; j < nSlots; j++) {
                ParkingSlot parkingSlot = new ParkingSlot(null, true, false);
            }
        }

    }
}
