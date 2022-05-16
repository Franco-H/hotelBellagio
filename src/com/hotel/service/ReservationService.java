package com.hotel.service;

import com.hotel.resource.AdminResource;

class ReservationService implements AdminResource {
    @Override
    public Customer getCustomer(String email) {
        return null;
    }

    @Override
    public void addRoom(List<IRoom> rooms) {

    }

    @Override
    public Collection<IRoom> getAllRooms() {
        return null;
    }

    @Override
    public Collection<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public void displayAllReservations() {

    }
}

}