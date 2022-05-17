package com.hotel.resource;

import com.hotel.model.Customer;
import com.hotel.model.IRoom;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public interface AdminResource {
    Customer getCustomer(String email);
    void addRoom(List<IRoom> rooms);
    Collection<IRoom> getAllRooms();
    Collection<Customer> getAllCustomers();
    void displayAllReservations();
}
