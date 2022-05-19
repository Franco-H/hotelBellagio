package com.hotel.service;

import com.hotel.model.*;

import java.util.*;


public class ReservationService {
    Set<IRoom> rooms = new HashSet<>();
    Set<Reservation> reservations = new HashSet<>();

    public static ReservationService RESERVATION_SERVICE = new ReservationService();

    public ReservationService() {
    }

    public static ReservationService getInstance() {
        return RESERVATION_SERVICE;
    }

    public void addRoom(IRoom room) {
        rooms.add(room);
    }

    public IRoom getRoom(String roomNumber) {
        for (IRoom room : rooms) {
            System.out.println("ROOM: " + room);
            if (!room.getRoomNumber().equals(roomNumber)) {
                continue;
            }
            return room;
        }
        return null;
    }

    public Reservation reserveRoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {

        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(reservation);
        return reservation;
    }

    public Collection<IRoom> findRooms(Date checkIn, Date checkOut) {
        if (reservations.isEmpty()) {
            return rooms;
        } else {
            return findAvailableRooms(checkIn, checkOut);
        }
    }

    private Collection<IRoom> findAvailableRooms(Date checkIn, Date checkOut) {
        List<IRoom> availableRooms = new ArrayList<>();

        for (Reservation reservation : reservations) {
            if (!reservation.getCheckIn().after(checkIn) && !reservation.getCheckOut().before(checkOut)) {
                for (IRoom room : rooms) {
                    if (!reservation.getRoom().equals(room)) {
                        availableRooms.add(room);
                    }
                }
            }
        }
        return availableRooms;
    }

    public static Collection<IRoom> getAllRooms() {
        return RESERVATION_SERVICE.rooms;
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

    public void displayAllReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
        }
    }
}




