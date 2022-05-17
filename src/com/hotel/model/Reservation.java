package com.hotel.model;

import java.time.LocalDate;
import java.util.Objects;

public class Reservation {
    public static final Reservation instance = new Reservation();
    private Customer customer;
//    private Room room;
    private LocalDate checkIn;
    private LocalDate checkOut;

    private Reservation() {
    }
    public static Reservation getInstance(){
        return instance;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
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