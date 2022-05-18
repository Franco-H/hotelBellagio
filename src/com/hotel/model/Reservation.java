package com.hotel.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Reservation {
//    public static final Reservation instance = new Reservation();
    private Customer customer;
    private Room room;
    private Date checkIn;
    private Date checkOut;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Reservation(Customer customer, Room room, Date checkIn, Date checkOut) {
        setCustomer(customer);
        setRoom(room);
        setCheckIn(checkIn);
        setCheckOut(checkOut);
    }

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
    }

    //    private Reservation() {
//    }
//    public static Reservation getInstance(){
//        return instance;
//    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
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
        return "Reservation[" +
                "checkIn=" + checkIn + ", " +
                "checkOut=" + checkOut + ']';
    }
}