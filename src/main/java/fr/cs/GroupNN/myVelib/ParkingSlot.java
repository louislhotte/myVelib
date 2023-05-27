package fr.cs.GroupNN.myVelib;

public class ParkingSlot {
    private int ParkingSlotId;
    private Bicycle bicycle;
    private boolean free;
    private boolean outOfOrder;
    private boolean occupied;

    public ParkingSlot(int parkingSlotId, Bicycle bicycle, boolean free, boolean outOfOrder, boolean occupied) {
        ParkingSlotId = parkingSlotId;
        this.bicycle = bicycle;
        this.free = free;
        this.outOfOrder = outOfOrder;
        this.occupied = occupied;
    }


    //Getters and Setters

    public int getParkingSlotId() {
        return ParkingSlotId;
    }

    public void setParkingSlotId(int parkingSlotId) {
        ParkingSlotId = parkingSlotId;
    }

    public Bicycle getBicycle() {
        return bicycle;
    }

    public void setBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    public boolean isFree() {
        return free;
    };

    public void setFree(boolean free) {
        this.free = free;
    }

    public boolean isOutOfOrder() {
        return outOfOrder;
    }

    public void setOutOfOrder(boolean outOfOrder) {
        this.outOfOrder = outOfOrder;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}
