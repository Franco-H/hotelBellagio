package com.hotel.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Reservation {
//    public static final Reservation instance = new Reservation();
    private Customer customer;
//    private Room room;
    private Date checkIn;
    private Date checkOut;

    public Reservation(Customer customer, Date checkIn, Date checkOut) {
        this.customer = customer;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
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