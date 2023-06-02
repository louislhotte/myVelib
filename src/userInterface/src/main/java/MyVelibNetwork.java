package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.configuration2.INIConfiguration;
import org.apache.commons.configuration2.SubnodeConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

/**
 * The MyVelibNetwork class represents the main entry point for the MyVelib network program.
 */
public class MyVelibNetwork {
    public static void main(String[] args) throws Exception {
        // Initialization of the Velib Network
        readMyVelibIni();

        // Read Command
        readCommand();

        // Exit
        exit();
    }

    /**
     * Reads the my_velib.ini configuration file and prints the parsed information.
     */
    private static void readMyVelibIni() {
        try {
            Configurations configs = new Configurations();
            INIConfiguration iniConfig = configs.ini("main/java/my_velib.ini");

            // Parse Users section
            SubnodeConfiguration usersSection = iniConfig.getSection("Users");
            List<String> names = Arrays.asList(usersSection.getStringArray("names"));
            List<String> creditCardNumbers = Arrays.asList(usersSection.getStringArray("creditCardNumbers"));

            // Parse userLocations
            List<String> userLocations = Arrays.asList(usersSection.getStringArray("userLocations"));

            // Parse DockingStations section
            SubnodeConfiguration dockingStationsSection = iniConfig.getSection("DockingStations");
            int nStations = dockingStationsSection.getInt("nStations");
            int nSlots = dockingStationsSection.getInt("nSlots");
            int nBikes = dockingStationsSection.getInt("nBikes");

            // Print the parsed information
            System.out.println("[Users]");
            System.out.println("Names: " + names);
            System.out.println("User Locations: " + userLocations);
            System.out.println("Credit Card Numbers: " + creditCardNumbers);
            System.out.println();
            System.out.println("[Docking Stations]");
            System.out.println("nStations: " + nStations);
            System.out.println("nSlots: " + nSlots);
            System.out.println("nBikes: " + nBikes);
            System.out.println("You have successfully initiated a myVelib network from the my_velib.ini file");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads and executes commands entered by the user.
     *
     * @throws Exception If an error occurs while reading commands.
     */
    private static void readCommand() throws Exception {
        Command command;

        do {
            // Read a command
            command = readFromConsole();

            String STATUS = command.eval();

            // If error statement, print it
            if (!STATUS.isEmpty()) {
                System.out.println(STATUS);
            }

        } while (command != null && !command.getCommandOrder().equalsIgnoreCase("exit"));
    }

    /**
     * Reads a command from the console input.
     *
     * @return The parsed Command object.
     */
    private static Command readFromConsole() {
        try {
            System.out.print("Enter a command: ");
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();

            // Check if the user wants to exit
            if (line.equalsIgnoreCase("exit")) {
                scanner.close();
                return new Command("exit", new ArrayList<>());
            }

            // Parsing
            String[] parts = line.split(" ");
            ArrayList<String> arguments = new ArrayList<>(Arrays.asList(parts).subList(1, parts.length));

            Command command = new Command(parts[0], arguments);
            return command;
        } catch (IllegalStateException e) {
            // System.in has been closed
            System.out.println("Error: System input was closed; exiting");
        }

        return null;
    }

    /**
     * Prints an exit message when the program exits.
     */
    private static void exit() {
        System.out.println("You have successfully exited the Velib Network.");
    }
}
