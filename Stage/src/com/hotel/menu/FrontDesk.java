package com.hotel.menu;

import com.apps.util.Prompter;
import com.hotel.model.Customer;
import com.hotel.model.IRoom;
import com.hotel.model.Room;
import com.hotel.model.RoomType;
import com.hotel.resource.Admin;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class FrontDesk {
    private static final Admin ADMIN = Admin.getInstance();

    private static final Prompter prompter = new Prompter(new Scanner(System.in));
    private static final Scanner scanner = new Scanner(System.in);

    public static void frontDesk() throws ParseException {
        showAdminMenu();

        // Ask user to enter a choice
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a choice: ");
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
                    Menu menu = new Menu();
                    menu.execute();
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
        int type;
        String addRoom = null;

        do {
            RoomType roomType = null;
            scanner.nextLine();
            String roomNumber = prompter.prompt("Enter room number: ");
            // Parse double into integer **
            String roomPrice = prompter.prompt("Enter price per night: ");
            do {
                // TODO: Add enum for room type
                System.out.println("Enter room type: ");
                type = scanner.nextInt();
                if (type == 1) {
                    // TODO: Change room type
                    roomType = RoomType.OVER_LOOKING_WATER_FALL_KING;
                } else if (type == 2) {
                    roomType = RoomType.PINT_HOUSE_KING;
                } else if (type == 3) {
                    roomType = RoomType.ELITE_KING;
                } else if (type == 4) {
                    roomType = RoomType.KING;
                } else if (type == 5) {
                    roomType = RoomType.OVER_LOOKING_WATER_FALL_QUEEN;
                } else if (type == 6) {
                    roomType = RoomType.PINT_HOUSE_QUEEN;
                } else if (type == 7) {
                    roomType = RoomType.QUEEN;
                } else {
                    System.out.println("Invalid input");
                }
            } while (type != 1 && type != 2 && type != 3 && type != 4 && type != 5 && type != 6 && type != 7);
            IRoom room = new Room(roomNumber, roomPrice, roomType, true);
            List<IRoom> rooms = new ArrayList<>();
            rooms.add(room);
            ADMIN.addRoom(rooms);
            do {
                System.out.println("Would you like to add another room? y/n");
                addRoom = scanner.next().toLowerCase().trim();
            } while (!addRoom.equals("y") && !addRoom.equals("n"));
        } while (addRoom.equals("y"));
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
