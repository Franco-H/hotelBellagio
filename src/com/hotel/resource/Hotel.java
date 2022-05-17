package com.hotel.resource;

import com.hotel.model.Customer;
import com.hotel.model.IRoom;
import com.hotel.model.Reservation;

import java.util.Collection;
import java.util.Date;

public class Hotel implements HotelResource {

    private static final Hotel HOTEL = new Hotel();
    private static final CustomerService CUSTOMER_SERVICE = CustomerService.getInstance();
    private static final ReservationService RESERVATION_SERVICE = ReservationService.getInstance();

    private Hotel() {
    }

    public static Hotel getInstance() {
        return HOTEL;
    }
    @Override
    public Customer getCustomer(String email) {
        return CUSTOMER_SERVICE.getCustomer(email);
    }

    @Override
    public void createACustomer(String email, String firstName, String lastName) {
        CUSTOMER_SERVICE.addCustomer(email, firstName, lastName);
    }

    @Override
    public IRoom getRoom(String roomNumber) {
        return RESERVATION_SERVICE.getRoom(roomNumber);
    }

    @Override
    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        return RESERVATION_SERVICE.bookARoom(customerEmail, room, checkInDate, checkOutDate);
    }

    @Override
    public Collection<Reservation> getCustomersReservations(String customerEmail) {
        return RESERVATION_SERVICE.getCustomersReservations(customerEmail);
    }

    @Override
    public Collection<IRoom> findARoom(Date checkIn, Date checkOut) {
        return RESERVATION_SERVICE.findARoom(checkIn, checkOut);
    }

    public Collection<IRoom> findOtherRooms(final Date checkIn, final Date checkOut) {
        return RESERVATION_SERVICE.findAlternativeRooms(checkIn, checkOut);
    }
}