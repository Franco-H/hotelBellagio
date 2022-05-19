package com.hotel.resource;

import com.hotel.model.*;
import com.hotel.service.CustomerService;
import com.hotel.service.ReservationService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel implements HotelResource{

    private static final Hotel HOTEL = new Hotel();
    private CustomerService CUSTOMER_SERVICE = CustomerService.getInstance();
    private ReservationService RESERVATION_SERVICE = ReservationService.getInstance();
    private RoomLoader roomLoader = new RoomLoader();

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
    public void createCustomer(String email, String firstName, String lastName) {
        CUSTOMER_SERVICE.addCustomer(email, firstName, lastName);
    }

    @Override
    public IRoom getRoom(String roomNumber) {
        try {
            roomLoader.getRooms().forEach(e -> System.out.println(e.getRoomType()));
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return RESERVATION_SERVICE.getRoom(roomNumber);
    }

    @Override
    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        Customer customer = CUSTOMER_SERVICE.getCustomer(customerEmail);
        return RESERVATION_SERVICE.reserveRoom(customer, room, checkInDate, checkOutDate);
    }

    @Override
    public Collection<Reservation> getCustomersReservations(String customerEmail) {
        Customer customer = CUSTOMER_SERVICE.getCustomer(customerEmail);
        return RESERVATION_SERVICE.getCustomersReservation(customer);
    }

    @Override
    public Collection<IRoom> findARoom(Date checkIn, Date checkOut)  {
        return RESERVATION_SERVICE.findRooms(checkIn, checkOut);
    }

}
