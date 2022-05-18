package com.hotel.service;

import com.hotel.model.Customer;
import com.hotel.model.IRoom;
import com.hotel.model.Reservation;

import java.util.*;


public class ReservationService {
    Map<String, IRoom> rooms = new HashMap<>();
    Map<String, Collection<Reservation>> customerReservations = new HashMap<>();

    public static final ReservationService RESERVATION_SERVICE = new ReservationService();
    
    public ReservationService() {
    }
    
    public static ReservationService getInstance() {
        return RESERVATION_SERVICE;
    }

    public void addRoom(IRoom room) {
        rooms.put(room.getRoomNumber(), room);
    }

    public IRoom getRoom(String roomNumber) {
        return rooms.get(roomNumber);
    }

    public Reservation reserveRoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {

        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);

        Collection<Reservation> customerReservations = getReservation(customer);

        // if (customerReservations.size() == 0), make a new list of reservations
        customerReservations.add(reservation);
        return reservation;
    }

    public Collection<Reservation> getReservation(Customer customer) {
        return customerReservations.get(customer.getEmail());
    }

    public Collection<IRoom> findRooms(Date checkIn, Date checkOut) {
        return findRoomsList(checkIn, checkOut);
    }

    public Collection<IRoom> findOtherRooms(Date checkIn, Date checkOut) {
        return findRoomsList(checkIn, checkOut);
    }

    private Collection<IRoom> findAllAvailable(Date checkIn, Date checkOut) {
        Collection<Reservation> allReserved = getAllReservedRooms();
        Collection<IRoom> areReserved = new LinkedList<>();
        // for each room in allReserved, if it is not reserved, add it to areReserved
        for (Reservation reservation : allReserved) {
            if (!reservation.isReserved(checkIn, checkOut)) {
                areReserved.add(reservation.getRoom());
            }
        }
        return areReserved;
    }

    private boolean isReserved(Reservation reservation, Date checkIn, Date checkOut) {
        return checkIn.before(reservation.getCheckOut()) && checkOut.after(reservation.getCheckIn());
    }

    private Collection<IRoom> getAllReservedRooms() {
        Collection<IRoom> allReserved = new ArrayList<>();
        for (Collection<Reservation> reservations : customerReservations.values()) {
            allReserved.addAll(customerReservations);
        }
        return allReserved;
    }

    public Collection<Reservation> getCustomersReservation(Customer customer) {
        Collection<Reservation> filteredReservations = new LinkedList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getCustomer().equals(customer)) {
                filteredReservations.add(reservation);
            }
        }
        return filteredReservations;
    }

    public void printAllReservations() {
        System.out.println("This are the available reservations: ");
        Collection<IRoom> allReserved = getAllReservedRooms();
        for (IRoom room : allReserved) {
            System.out.println(room);
        }
    }

    public Collection<IRoom> getAllRooms() {
        return rooms.values();
    }

    public Collection<IRoom> getRoom() {
        for (IRoom room : room) {
            if (room.equals(room.getRoomNumber())) {
            }
        }
        return room;
    }

    @Override
    public String toString() {
        return "ReservationService{" +
                "room=" + room +
                '}';
    }
}


