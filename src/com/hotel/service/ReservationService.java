package com.hotel.service;

import com.hotel.model.Customer;
import com.hotel.model.IRoom;
import com.hotel.model.Reservation;
import com.hotel.resource.AdminResource;

import java.time.LocalDate;
import java.util.*;

class ReservationService {
    Collection<IRoom> room = new LinkedList<>();
    Collection<Reservation> reservations = new LinkedList<>();

    public static final ReservationService reservationService = new ReservationService();

    public void addRoom(IRoom room) {
        addRoom(room);
    }

    public IRoom getARoom(String roomId) {
        for (IRoom room : room){
            if (room.getRoomNumber().equals(roomId)){
                return room;
            }
        }
        return null;
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(reservation);
        return reservation;
    }

    public Collection<IRoom> findRooms(Date checkIn, Date checkOut) {
        Collection<IRoom> rooms = new LinkedList<>();
        Date today = new Date();
        if (today.after(checkOut)) {
            System.out.println("Date is invalid. Add future date");
            return room;
        }
        for (IRoom room : rooms) {
            boolean reserved = false;
            for (Reservation reservation : reservations) {
                if (reservation.getRoom() ( reservation.getCheckOut().isAfter(){
                    reserved = true;
                    break;

                }
            }
            if (!reserved) {
                addRoom(room);
            }
        }
        return rooms;
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

    public void printAllReservations(){
        System.out.println("This are the available reservations: ");

        if (reservations.isEmpty()){
            System.out.println("No Rooms available. Check back later");
        }

        for (Reservation reservation: reservations){
            System.out.println(reservation);
        }

    }

    public Collection<IRoom> getRoom() {
        for (IRoom room : room){
            if (room.equals(room.getRoomNumber())){
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