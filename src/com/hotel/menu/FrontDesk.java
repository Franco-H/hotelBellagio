package com.hotel.menu;

import com.hotel.model.Customer;
import com.hotel.model.IRoom;
import com.hotel.model.RoomType;
import com.hotel.resource.Admin;

import java.util.Collection;
import java.util.Scanner;

public class FrontDesk {
    private static final Admin ADMIN = Admin.getInstance();

    public static void frontDesk() {
        showAdminMenu();

        // Ask user to enter a choice
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (line.matches("[1-5]")) {
            switch (line) {
                case "1":
                    displayAllCustomers();
                    break;
                case "2":
                    displayAllRooms();
                    break;
                case "3":
                    ADMIN.displayAllReservations();
                    break;
                case "4":
                    addRoom();
                    break;
                case "5":
                    Menu.showMenu();
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
            showAdminMenu();
            line = scanner.nextLine();
        }
    }

    private static void displayAllCustomers() {
        Collection<Customer> customers = ADMIN.getAllCustomers();
        System.out.println("All customers: ");
        // Iterate through the collection and print each customer. If empty, print "No customers"
        if (customers.isEmpty()) {
            System.out.println("No customers.");
        } else {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    private static void displayAllRooms() {
        Collection<IRoom> rooms = ADMIN.getAllRooms();

        // Iterate through the collection and print each room. If empty, print "No rooms"
        if (rooms.isEmpty()) {
            System.out.println("No rooms.");
        } else {
            for (IRoom room : rooms) {
                System.out.println(room);
            }
        }
    }

    private static void addRoom() {
        // Ask user to enter room number
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter room number: ");
        String roomNumber = scanner.nextLine();

        // Ask user to enter room price
        System.out.println("Enter room price: ");
        Double roomPrice = setRoomPrice(scanner);

        // Ask user to enter room type
        System.out.println("Enter room type: ");
        RoomType roomType = setRoomType(scanner);
    }

    private static RoomType setRoomType(Scanner scanner) {
        // Ask user to enter room type. If it is not one of the RoomType enum values, ask again
        try {
            return RoomType.valueOf(scanner.nextLine().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid room type. Please enter a valid room type.");
            return setRoomType(scanner);
        }
    }

    private static Double setRoomPrice(Scanner scanner) {
        // Check if the input is a valid number. If not, throw an exception and ask for input again
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return setRoomPrice(scanner);
        }
    }

    private static void showAdminMenu() {
        System.out.println("Front Desk Services\n" +
                "----------------------\n" +
                "1. View all customers\n" +
                "2. View all rooms\n" +
                "3. View all reservations\n" +
                "4. Add room\n" +
                "5. Back to main menu\n");
    }
}
