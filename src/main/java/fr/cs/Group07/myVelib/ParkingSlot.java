package fr.cs.Group07.myVelib;


/**
 * The ParkingSlot class represents a parking slot for bicycles.
 */
public class ParkingSlot {
    private static int counter;
    private int ParkingSlotId;
    private Bicycle bicycle;
    private boolean free;
    private boolean outOfOrder;


    /**
     * Constructs a ParkingSlot object with the specified bicycle, availability, and out-of-order status.
     *
     * @param bicycle     the bicycle parked in the slot (null if empty)
     * @param free        true if the slot is free, false otherwise
     * @param outOfOrder  true if the slot is out of order, false otherwise
     */
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
    /**
     * Checks if the slot is free.
     *
     * @return true if the slot is free, false otherwise
     */
    public boolean isFree() {
        return free;
    };


    /**
     * Sets the availability of the slot.
     *
     * @param free true if the slot is free, false otherwise
     */
    public void setFree(boolean free) {
        this.free = free;
    }


    /**
     * Checks if the slot is out of order.
     *
     * @return true if the slot is out of order, false otherwise
     */
    public boolean isOutOfOrder() {
        return outOfOrder;
    }


    /**
     * Sets the out-of-order status of the slot.
     *
     * @param outOfOrder true if the slot is out of order, false otherwise
     */
    public void setOutOfOrder(boolean outOfOrder) {
        this.outOfOrder = outOfOrder;
    }
}
