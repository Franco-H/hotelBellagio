package com.hotel.service;

import com.hotel.model.Customer;
import com.hotel.resource.HotelResource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

class CustomerService {
    public static final Collection<Customer> customers = new ArrayList<>();

    public void addCustomer(String email, String firstName, String lastName) {
        Customer customer= new Customer(email, firstName,lastName);
        customers.add(customer);

    }

    public Customer getCustomers(String customerEmail) {
        for (Customer customer : customers){
            if (customer.getEmail().equals(customerEmail)){
                return customer;
            }
        }
        return null;
    }


    public Collection<Customer> getAllCustomers() {
        for (Customer customer : customers){
            System.out.println(customer);
        }
        return customers;
    }



}

}