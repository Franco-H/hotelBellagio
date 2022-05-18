package com.hotel.service;

import com.hotel.model.Customer;
import com.hotel.resource.HotelResource;

import java.util.*;

public class CustomerService {
    private static final CustomerService CUSTOMER_SERVICE = new CustomerService();
    private static Collection<Customer> customers;

    public CustomerService() {
        customers = new ArrayList<>();
    }

    public static CustomerService getInstance() {
        return CUSTOMER_SERVICE;
    }

    public static void addCustomer(String email, String firstName, String lastName) throws IllegalArgumentException{
        customers.add(new Customer(firstName, lastName, email));
    }

    public Customer getCustomer(String customerEmail) {
        for (Customer customer : customers) {
            if (customer.getEmail().equals(customerEmail)) {
                return customer;
            }
        }
        return null;
    }

    public Collection<Customer> getAllCustomers() {
        return customers;
    }
}
