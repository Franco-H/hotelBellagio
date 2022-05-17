package com.hotel.service;

import com.hotel.model.Customer;
import com.hotel.model.IRoom;
import com.hotel.model.Reservation;
import com.hotel.resource.AdminResource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

class ReservationService {
    Collection<IRoom> room = new ArrayList<>();

    public ReservationService(Collection<IRoom> room) {
        this.room = room;
    }

    public void addRoom(IRoom room) {
    }

    public IRoom getARoom(String roomId) {
        return null;
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        return null;
    }

    public Collection<IRoom> findRoom(Date checkIn, Date checkOut) {
        return null;
    }

    public Collection<Reservation> getCustomersReservation(Customer customer) {
        return null;
    }

    public void printAllReservation() {

    }

    public Collection<IRoom> getRoom() {
        return room;
    }

    public void setRoom(Collection<IRoom> room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "ReservationService{" +
                "room=" + room +
                '}';
    }

}