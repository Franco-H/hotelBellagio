package com.hotel.service;


import com.hotel.model.Customer;
import com.hotel.resource.HotelResource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class CustomerService {
    private String email;
    private String firstName;
    private String lastName;

    Collection<Customer> customers = new ArrayList<>();

    public CustomerService(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addCustomer(String email, String firstName, String lastName) {

    }

    public Customer getCustomer(String customerEmail) {
        return null;
    }


    public Collection<Customer> getAllCustomer() {
        return null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "CustomerService{" +
                "email='" + email +
                ", firstName='" + firstName +
                ", lastName='" + lastName +
                ", customers=" + customers +
                '}';
    }

}