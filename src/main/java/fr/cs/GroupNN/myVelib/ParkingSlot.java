package fr.cs.GroupNN.myVelib;

public class ParkingSlot {
    private static int counter;
    private int ParkingSlotId;
    private Bicycle bicycle;
    private boolean free;
    private boolean outOfOrder;

    public ParkingSlot(Bicycle bicycle, boolean free, boolean outOfOrder) {
        super();
        counter++;
        ParkingSlotId = counter;
        this.free = free;
        this.setBicycle(bicycle);
        this.outOfOrder = outOfOrder;
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
        if (bicycle == null)
            this.free = true;
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
}
