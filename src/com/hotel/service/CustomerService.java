package com.hotel.service;

import com.hotel.resource.HotelResource;

class CustomerService implements HotelResource {

    @Override
    public Customer getCustomer(String email) {
        return null;
    }

    @Override
    public void createACustomer(String email, String firstName, String lastName) {

    }

    @Override
    public IRoom getRoom(String roomNumber) {
        return null;
    }

    @Override
    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date CheckOutDate) {
        return null;
    }

    @Override
    public Collection<Reservation> getCustomersReservations(String customerEmail) {
        return null;
    }

    @Override
    public Collection<IRoom> findARoom(Date checkIn, Date checkOut) {
        return null;
    }
}