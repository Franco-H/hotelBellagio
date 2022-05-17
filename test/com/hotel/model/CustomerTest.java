package com.hotel.model;

import org.junit.Test;

import static org.junit.Assert.*;
class CustomerTest {
    Customer customer;
    void setUp() {
    }

    @Test(expected = Exception.class)
    public void testFirstName() {
        customer = Customer.instance;
        try {
            customer.setFirstName("**");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            customer.setLastName("Willink");
        } catch (Exception e) {
            e.printStackTrace();
        }
        customer.setPhoneNumber(1112223333);
        customer.setEmail("test@mail.com");
    }
}