package com.hotel.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Reservation {

    private Customer customer;
    private Date checkIn;
    private Date checkOut;
    private IRoom room;

    public Reservation(Customer customer,IRoom room, Date checkIn, Date checkOut) {
        this.customer = customer;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.room = room;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setRoom(IRoom room) {
        this.room = room;
    }

    public IRoom getRoom() {
        return room;
    }

    public Date getCheckIn() {
        return this.checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Reservation) return true;
        if (obj.equals(null) || !obj.getClass().equals(this.getClass())) return false;
        var that = (Reservation) obj;
        return this.checkIn.equals(that.checkIn) &&
               this.checkOut.equals(that.checkOut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkIn, checkOut);
    }

    @Override
    public String toString() {
        return "Reservation:  " +
                "Customer- " + getCustomer().getFirstName() + " " + getCustomer().getLastName() + "\n" +
                ", Rooom number - " + room.getRoomNumber() + ", " +
                ", Room type - " + room.getRoomType() + ", " + "\n" +
                ", Check In Date - " + checkIn + ", " +
                " Check In Date - " + checkOut + ']';
    }
}
