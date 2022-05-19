package com.hotel.menu;

import com.hotel.model.Customer;
import com.hotel.model.IRoom;
import com.hotel.model.Reservation;
import com.hotel.resource.Hotel;
import com.apps.util.Prompter;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Menu {

    private static final Hotel HOTEL = Hotel.getInstance();

    private static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
    private static final Prompter prompter = new Prompter(new Scanner(System.in));
    private static final Scanner scanner = new Scanner(System.in);

    public static void execute() throws ParseException {

        boolean exit = false;

        while (!exit) {
            showMenu();
            String line = prompter.prompt("Enter a choice: ");
            do {
                switch (line) {
                    case "1":
                        findAndReserve();
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
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option");
                }
            } while (!line.matches("[1-5]") && !exit);
        }
    }

    private static void findAndReserve() throws ParseException {
        System.out.println("Enter check in date (MM/dd/yyyy): ");
        // If user enters the check in date before today's date,
        // the system will prompt the user to enter a valid date.
        Date checkIn = validateDate(scanner);

        System.out.println("Enter check out date (MM/dd/yyyy): ");
        Date checkOut = validateDate(scanner);

//        String checkInDate = prompter.prompt("Enter check in date (MM/dd/yyyy): ");
//        String checkOutDate = prompter.prompt("Enter check out date (MM/dd/yyyy): ");
//
//        Date checkIn = DEFAULT_DATE_FORMAT.parse(checkInDate);
//        Date checkOut = DEFAULT_DATE_FORMAT.parse(checkOutDate);
        Date today = DEFAULT_DATE_FORMAT.parse(DEFAULT_DATE_FORMAT.format(Calendar.getInstance().getTime()));

        if (!checkIn.before(today) && !checkOut.before(checkIn)) {
            Collection<IRoom> rooms = HOTEL.findARoom(checkIn, checkOut);
            if (!rooms.isEmpty()) {
                String book;
                do {
                    book = prompter.prompt("Would you like to book a room? (y/n)");
                    if (book.equalsIgnoreCase("y")) {
                        String account;
                        do {
                            account = prompter.prompt("Do you have an account with us? (y/n)");
                            if (account.equalsIgnoreCase("y")) {
                                String email = prompter.prompt("Enter Email format: ");
                                Customer customer = HOTEL.getCustomer(email);
                                // print out the rooms
                                for (IRoom room : rooms) {
                                    System.out.println(room);
                                }
                                String roomNumber = prompter.prompt("Enter room number: ");
                                IRoom room = HOTEL.getRoom(roomNumber);
                                HOTEL.bookARoom(customer.getEmail(), room, checkIn, checkOut);
                            } else if (account.equals("n")) {
                                System.out.println("Please create an account");
                                createAccount();
                            } else {
                                System.out.println("Invalid option");
                            }
                        } while (!account.equalsIgnoreCase("y") && !account.equalsIgnoreCase("n"));
                    } else if (book.equals("n")) {
                        execute();
                    } else {
                        System.out.println("Invalid option");
                    }
                } while (!book.equalsIgnoreCase("y") && !book.equalsIgnoreCase("n"));
            } else {
                System.out.println("No rooms available");
                String exit;
                do {
                    exit = prompter.prompt("Would you like to exit? (y/n)");
                    if (exit.equalsIgnoreCase("y")) {
                        System.exit(0);
                    } else if (exit.equalsIgnoreCase("n")) {
                        execute();
                    } else {
                        System.out.println("Invalid option");
                    }
                } while (!exit.equalsIgnoreCase("y") && !exit.equalsIgnoreCase("n"));
            }
        } else {
            System.out.println("Invalid date");
        }
    }

    private static Date validateDate(Scanner scanner) throws ParseException {
        // If input is not in the correct format, keep asking for input
        while (true) {
            String date = scanner.nextLine();
            try {
                return DEFAULT_DATE_FORMAT.parse(date);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter a date in the format MM/dd/yyyy");
            }
        }
    }

    private static void viewMyReservation() {
        String email = prompter.prompt("Enter your email: ");
        Collection<Reservation> reservations = HOTEL.getCustomersReservations(email);
        if (reservations.isEmpty()) {
            System.out.println("You have no reservations.");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
        }
    }

    private static void createAccount() {
        String email = prompter.prompt("Enter your email: ");
        String firstName = prompter.prompt("Enter your first name: ");
        String lastName = prompter.prompt("Enter your last name: ");

        HOTEL.createCustomer(email, firstName, lastName);
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
