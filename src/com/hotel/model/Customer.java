package com.hotel.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.regex.Pattern;


public class Customer {
//    public static final Customer instance = new Customer();
    private static final String nameRegexPattern = "^[a-zA-Z0-9]+S";
    public static Customer instance;

    private String firstName;
    private String lastName;
    private final String email;

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Use regex to validate email
//    public void isValidEmail(String email) {
//        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
//                            "[a-zA-Z0-9_+&*-]+)*@" +
//                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
//                            "A-Z]{2,7}$";
//
//        Pattern pat = Pattern.compile(emailRegex);
//        // if email is valid, return email. Else throw illegal argument exception
//        if (Objects.isNull(email) || !pat.matcher(email).matches()) {
//            throw new IllegalArgumentException("Invalid email");
//        }
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws Exception {
       if (!firstName.matches(nameRegexPattern)){
           throw new Exception("First name has to be alpha numeric");
       }else{
           this.firstName = firstName;
       }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws Exception {
        if (!lastName.matches(nameRegexPattern)){
            throw new Exception("First name has to be alpha numeric");
        }else{
            this.lastName = lastName;
        }
    }

    public String getEmail() {
        return this.email;
    }

//    public void setEmail(String email) {
//        this.email = email;
//    }

//    public int getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(int phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }

    @Override //verify if == is best practice here. Records created Class
    public boolean equals(Object obj) {
        if (obj instanceof Customer) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Customer) obj;
        return this.firstName.equals(that.firstName) &&
                this.lastName.equals(that.lastName) &&
                this.email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email);
    }

    @Override
    public String toString() {
        return "Customer[" +
                "firstName=" + firstName + ", " +
                "lastName=" + lastName + ", " +
                "email=" + email + ']';
    }
}