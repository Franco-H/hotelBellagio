package com.hotel.menu;

import com.hotel.model.IRoom;
import com.hotel.model.Reservation;
import com.hotel.resource.Hotel;
import com.apps.util.Prompter;
import com.hotel.service.ReservationService;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;

public class Menu {

    private static final Hotel HOTEL = Hotel.getInstance();

    private static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
    private static final Prompter prompter = new Prompter(new Scanner(System.in));
    private static final Scanner scanner = new Scanner(System.in);

    public void execute() throws ParseException {

        showMenu();
        String line = prompter.prompt("Enter a choice: ");

        while (line.matches("[1-5]")) {
            switch (line) {
                case "1":
                    findRoom();
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
    }

    private static void findRoom() throws ParseException {
        // Prompt for check in and check out dates, and parse them to DEFAULT_DATE_FORMAT
        String checkInDate = prompter.prompt("Enter check in date (MM/dd/yyyy): ");
        String checkOutDate = prompter.prompt("Enter check out date (MM/dd/yyyy): ");

        Date checkIn = DEFAULT_DATE_FORMAT.parse(checkInDate);
        Date checkOut = DEFAULT_DATE_FORMAT.parse(checkOutDate);

        // Pass check in and check out dates to validateDates()
        if (validateDates(checkIn, checkOut)) {
            // Pass check in and check out dates to findARoom()
            Collection<IRoom> rooms = HOTEL.findARoom(checkIn, checkOut);
            if (rooms.isEmpty()) {
                // Get the next seven days from check in date
                Date alternativeCheckIn = getNextSevenDays(checkIn);
                Date alternativeCheckOut = getNextSevenDays(checkOut);
                Collection<IRoom> alternativeRooms = HOTEL.findARoom(alternativeCheckIn, alternativeCheckOut);
//                if (alternativeRooms.isEmpty()){
//                    System.out.println("Sorry, there no rooms available for the next seven days.");
//                } else {
//                    System.out.println("We have rooms available for the next seven days.");
//                    //print out the rooms and ask if they want to book
//                    for (IRoom room : alternativeRooms) {
//                        System.out.println(room.getRoomNumber());
//                    }
//                    // call reserveRoom()
//                    String roomNumber = prompter.prompt("Enter room number: ");
//                    Reservation reservation = HOTEL.bookARoom(prompter.prompt("Enter email: "), HOTEL.getRoom(roomNumber), checkIn, checkOut);
            } else {
                // show the rooms and ask if they want to book
                for (IRoom room : rooms) {
                    System.out.println(room.getRoomNumber());
                }
                // Bring the user to reserveRoom()
                reserveRoom(checkIn, checkOut);
            }
        }
    }

    private static Date getNextSevenDays(Date date) {
        // Return the next seven calendar days from the given date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 7);
        return calendar.getTime();
    }

    private static boolean validateDates(Date checkIn, Date checkOut) {
        if (checkIn.after(checkOut)) {
            System.out.println("Check out date must be after check in date");
            return false;
        } else if (checkIn.equals(checkOut)) {
            System.out.println("Check in and check out dates cannot be the same");
            return false;
            // If check in date is before system date, return false
        } else if (checkIn.before(new Date())) {
            System.out.println("Check in date cannot be before today.");
            return false;
            }
        return true;
        }

    private static void reserveRoom(Date checkInDate, Date checkOutDate) {
        // Ask if the customer wants to reserve the room
        String answer = prompter.prompt("Would you like to reserve a room? (y/n): ");
//        System.out.println("Would you like to reserve a room? (y/n)");
//        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("y")) {
            // Ask if the customer has a registered email with us
            String askEmail = prompter.prompt("Do you have your email registered with us ? (y/n)");
            // If yes, ask for the email
            if (askEmail.equalsIgnoreCase("y")) {
                String email = prompter.prompt("Enter your email: ");
                // if the email collection is empty, print an error message and return to the menu
                if (HOTEL.getCustomer(email) == null) {
                    System.out.println("Email is not registered. Please create an account at menu.");
                    showMenu();
                } else {
                    String roomNumber = prompter.prompt("Enter the room number you would like to reserve: ");

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

        HOTEL.getCustomersReservations(email);
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
            HOTEL.createACustomer(email, firstName, lastName);
            System.out.println("Thank you for joining us!");
            showMenu();
        } catch (IllegalArgumentException e) {
            System.out.println("Email already exists.");
            createAccount();
        }

    }

//    private static String getDate() throws ParseException {
//        // Check if the date is in the DEFAULT_DATE_FORMAT format and not empty. If not, throw an exception with message.
//        String date = Menu.scanner.nextLine();
//        if (Pattern.matches("^\\d{2}/\\d{2}/\\d{4}$", date) && !date.isEmpty()) {
//            // Check if the checkInDate is before the checkOutDate. If not, throw an exception with message.
//            if (DEFAULT_DATE_FORMAT.parse(date).before(DEFAULT_DATE_FORMAT.parse(Menu.scanner.nextLine()))) {
//                return DEFAULT_DATE_FORMAT.parse(date).toString();
//            } else {
//                throw new ParseException("Check in date must be before check out date.", 0);
//            }
//        } else {
//            // throw an exception with message, and re-prompt for the date with findAndReserveRoom()
//            throw new ParseException("Invalid date format.", 0);
//        }
//    }

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
