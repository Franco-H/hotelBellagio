package com.hotel.menu;

import com.hotel.model.Reservation;
import com.hotel.resource.HotelResource;
import com.hotel.resource.ReservationService;

import java.text.ParseException;
import java.util.Collection;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;

public class Menu {
    // static field for default MM/dd/yyyy format
    private static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
    private static final HotelResource hotelResource = HotelResource.getInstance();


    public static void execute() {
        String line = "";
        Scanner scanner = new Scanner(System.in);
        showMenu();

        try {
            line = scanner.nextLine();
            // while the input is between 1 and 5
            while (line.matches("[1-5]")) {
                switch (line) {
                    case "1":
                        findAndReserveRoom();
                        break;
                    case "2":
                        viewMyReservation();
                        break;
                    case "3":
                        createAccount();
                        break;
                    case "4":
                        FrontDesk.frontDesk();
                        break;
                    case "5":
                        System.out.println("Thank you for visiting Bellagio Las Vegas!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
            }
        } catch (Exception StringIndexOutOfBoundsException) {
            System.out.println("Please select a valid option.");
        }
    }

    private static void findAndReserveRoom() throws ParseException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter check in date (mm/dd/yyyy): ");
        String checkInDate = getDate(scanner);

        System.out.println("Enter check out date (mm/dd/yyyy): ");
        String checkOutDate = getDate(scanner);

        // With the check in and out dates, iterate through the room collection at ReservationService
        Collection<IRoom> availableRooms = HotelResource.findARoom(checkInDate, checkOutDate);

        // If there is at least one available room, display the available rooms
        if (availableRooms.size() > 0) {
            System.out.println("Available rooms:");
            for (IRoom room : availableRooms) {
                System.out.println(room.toString());
                reserve(checkInDate, checkOutDate);
            }
        } else {
            System.out.println("No available rooms.");
            Collection<IRoom> rooms = HotelResource.customerService.findAlternativeRooms(checkInDate, checkOutDate);
            // If there is
        }
    }

    private static void reserve(String checkInDate, String checkOutDate) {
        // Ask if the customer wants to reserve the room
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to reserve a room? (y/n)");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("y")) {
            // Ask if the customer has a registered email with us
            System.out.println("Do you have your email registered with us ? (y/n)");
            answer = scanner.nextLine();
            // If yes, ask for the email
            if (answer.equalsIgnoreCase("y")) {
                System.out.println("Enter your email: ");
                String email = scanner.nextLine();
                // if the email is not registered, print an error message and return to the menu
                if (!ReservationService.getCustomer(email)) {
                    System.out.println("Email is not registered. Please create an account at menu.");
                    showMenu();
                } else {
                    System.out.println("Enter the room number you would like to reserve: ");
                    String roomNumber = scanner.nextLine();
                    // If the room number match the room number in the collection, reserve the room
                    IRoom room = hotelResource.getRoom(roomNumber);
                    Reservation reservation  hotelResource.bookARoom(room, checkInDate, checkOutDate);
                    System.out.println("Room reserved. We are looking forward to your stay!");
                    System.out.println(reservation.toString());
                }
            } else {
                System.out.println("Please register your email with us prior to room reservation.");
                showMenu();
            }
        } else {
            System.out.println("Thank you for visiting Bellagio Las Vegas!");
            showMenu();
        }
    }

    private static void viewMyReservation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your email: ");
        String email = scanner.nextLine();

        hotelResource.getCustomersReservations(email);
    }

    private static void createAccount() {
        Scanner scanner = new Scanner(System.in);
            // Ask customer to enter email, first name, last name.
        System.out.println("Enter your email: ");
        String email = scanner.nextLine();
        System.out.println("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter your last name: ");
        String lastName = scanner.nextLine();

        // Create a new customer object with the email, first name, last name.
        try {
            HotelResource.createCustomer(email, firstName, lastName);
            System.out.println("Thank you for joining us!");
            showMenu();
        } catch (IllegalArgumentException e) {
            System.out.println("Email already exists.");
            createAccount();
        }

    }

    private static String getDate(Scanner scanner) throws ParseException {
        // Check if the date is in the DEFAULT_DATE_FORMAT format and not empty. If not, throw an exception with message.
        String date = scanner.nextLine();
        if (Pattern.matches("^\\d{2}/\\d{2}/\\d{4}$", date) && !date.isEmpty()) {
            // Check if the checkInDate is before the checkOutDate. If not, throw an exception with message.
            if (DEFAULT_DATE_FORMAT.parse(date).before(DEFAULT_DATE_FORMAT.parse(scanner.nextLine()))) {
                return DEFAULT_DATE_FORMAT.parse(date).toString();
            } else {
                throw new ParseException("Check in date must be before check out date.", 0);
            }
        } else {
            // throw an exception with message, and re-prompt for the date with findAndReserveRoom()
            throw new ParseException("Invalid date format.", 0);
        }
    }

    public static void showMenu() {
        // Display the menu
        System.out.println("Welcome to Bellagio Las Vegas! \n" +
                "------------------------------------------\n" +
                "1. Find and reserve a room\n" +
                "2. View my reservation\n" +
                "3. Create an account\n" +
                "4. Front Desk (admin only)\n" +
                "5. Exit");
    }
}
