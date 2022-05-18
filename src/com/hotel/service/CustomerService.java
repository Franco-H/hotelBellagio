package com.hotel.service;

import com.hotel.model.Customer;
import com.hotel.resource.HotelResource;

import java.util.*;

public class CustomerService {
    public static final Map<String, Customer> customers = new HashMap<>();
    private static final CustomerService CUSTOMER_SERVICE = new CustomerService();

    public CustomerService() {
    }

    public static CustomerService getInstance() {
        return CUSTOMER_SERVICE;
    }

    public void addCustomer(String email, String firstName, String lastName) {
        Customer customer = new Customer(email, firstName, lastName);
        customers.put(email, customer);
    }

    public Customer getCustomer(String customerEmail) {
        // return customer email
        return customers.get(customerEmail);
    }


    public Collection<Customer> getAllCustomers() {
        return customers.values();
    }

}
