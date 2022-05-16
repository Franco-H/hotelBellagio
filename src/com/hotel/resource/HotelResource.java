package com.hotel.resource;

public interface HotelResource {

    private static final HotelResource SINGLETON = new HotelResource();

    public Customer getCUstomer(String email) {
        return CustomerService.getCustomer(email);
    }

    public void createACustomer(String email, String firstName, String lastName) {
        CustomerService.addCustomer(email, firstName, lastName);
    }

    public IRoom getRoom(String roomNumber) {
        return ReservationService.getRoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate,
                                 Date CheckOutDate) {
        return ReservationService.reserveARoom(getCUstomer(customerEmail), room, checkInDate, CheckOutDate);
    }

    public Collection<Reservation> getCustomersReservations(String customerEmail) {
        return ReservationService.getCustomersReservations(getCUstomer(customerEmail));
    }

    public Collection<IRoom> findARoom(Date checkIn, Date checkOut) {
        return ReservationService.findARoom(checkIn, checkOut);
    }
}
