package com.hotel.model;

import java.util.Objects;

public class Customer {
    public static final Customer instance = new Customer();
    private String firstName;
    private String lastName;
    private String email;
    private int phoneNumber;
//    private Email email;
//    private Phone phoneNumber;

    public Customer() {
    }

    public Customer(String email, String firstName, String lastName) {
    }

    public static Customer getInstance(){
        return instance;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String checkEmail(){
        return getEmail();
    }

    @Override //verify if == is best practice here. Records created Class
    public boolean equals(Object obj) {
        if (obj instanceof Customer) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Customer) obj;
        return this.firstName.equals(that.firstName) &&
                this.lastName.equals(that.lastName) &&
                this.email.equals(that.email) &&
                this.phoneNumber == that.phoneNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, phoneNumber);
    }

    @Override
    public String toString() {
        return "Customer[" +
                "firstName=" + firstName + ", " +
                "lastName=" + lastName + ", " +
                "email=" + email + ", " +
                "phoneNumber=" + phoneNumber + ']';
    }
}