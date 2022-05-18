package com.hotel.resource;

import com.hotel.model.Customer;
import com.hotel.model.IRoom;
import com.hotel.model.Reservation;
import com.hotel.service.CustomerService;
import com.hotel.service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class Hotel {

    private static Hotel HOTEL = null;
    static CustomerService CUSTOMER_SERVICE = CustomerService.getInstance();
    static ReservationService RESERVATION_SERVICE = ReservationService.getInstance();

    private Hotel() {
    }

    public static Hotel getInstance() {
        return HOTEL == null ? HOTEL = new Hotel() : HOTEL;
    }

    public Customer getCustomer(String email) {
        return CUSTOMER_SERVICE.getCustomer(email);
    }

    public void createCustomer(String email, String firstName, String lastName) {
        CUSTOMER_SERVICE.addCustomer(email, firstName, lastName);
    }

    public IRoom getRoom(String roomNumber) {
        return RESERVATION_SERVICE.getRoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        Customer customer = CUSTOMER_SERVICE.getCustomer(customerEmail);
        return RESERVATION_SERVICE.reserveRoom(customer, room, checkInDate, checkOutDate);
    }

    public Collection<Reservation> getCustomersReservations(String customerEmail) {
        Customer customer = CUSTOMER_SERVICE.getCustomer(customerEmail);
        return RESERVATION_SERVICE.getCustomersReservation(customer);
    }

    public Collection<IRoom> findARoom(Date checkIn, Date checkOut) {
        return RESERVATION_SERVICE.findRooms(checkIn, checkOut);
    }
}
