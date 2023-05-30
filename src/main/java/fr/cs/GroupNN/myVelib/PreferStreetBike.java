package fr.cs.GroupNN.myVelib;

import java.util.*;

public class PreferStreetBike extends Normal {
    @Override
    public double[][] optimalItinerary(double[] startLocation,double[] endLocation, String bicycleType){
        ArrayList<DockingStation> dockingStations = DockingStation.getDockingStations();
        ArrayList<Bicycle> streetBicycles = Bicycle.getStreetBicycles();
        streetBicycles.trimToSize();

        double[][] normalOptimal = super.optimalItinerary(startLocation, endLocation, bicycleType);
        double[] nearestToStartLocation = normalOptimal[0] ;
        double[] nearestToEndLocation = normalOptimal[1];

        if (streetBicycles.size() == 0){
            return new double[][]{nearestToStartLocation, nearestToEndLocation};
        }

        Bicycle nearestToStart = streetBicycles.get(0);

        nearestToStartLocation = nearestToStart.getBicycleLocation();

        for (Bicycle bicycle: streetBicycles) {
            if (distance(bicycle.getBicycleLocation(), startLocation) < distance(nearestToStartLocation, startLocation) && bicycle.getBicycleType().equals(bicycleType)){
                nearestToStart = bicycle;
                nearestToStartLocation = nearestToStart.getBicycleLocation();
            }
        }

        return new double[][]{nearestToStartLocation, nearestToEndLocation};
    }
}