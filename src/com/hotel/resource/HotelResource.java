package com.hotel.resource;

import com.hotel.model.Customer;
import com.hotel.model.IRoom;
import com.hotel.model.Reservation;

import java.util.Collection;
import java.util.Date;

public interface HotelResource {

    Customer getCustomer(String email);
    void createACustomer(String email, String firstName, String lastName);
    IRoom getRoom(String roomNumber);
    Reservation bookARoom(String email, IRoom room, Date checkInDate, Date CheckOutDate);
    Collection<Reservation> getCustomersReservations(String customerEmail);
    Collection<IRoom> findARoom(Date checkIn, Date checkOut);
}
