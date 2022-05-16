package com.hotel.model;

import java.util.Objects;

 class Room {
     public static final Room instance = new Room();
     private int roomNumber;
    private double price;

    private Room() {
    }
    public Room getInstance(){
        return instance;
    }
     public int getRoomNumber() {
         return roomNumber;
     }

     public void setRoomNumber(int roomNumber) {
         this.roomNumber = roomNumber;
     }

     public double getPrice() {
         return price;
     }

     public void setPrice(double price) {
         this.price = price;
     }

     @Override
    public boolean equals(Object obj) {
        if (obj instanceof Room) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Room) obj;
        return this.roomNumber == that.roomNumber &&
                Double.doubleToLongBits(this.price) == Double.doubleToLongBits(that.price);

    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, price);
    }

    @Override
    public String toString() {
        return "Room[" +
                "roomNumber=" + roomNumber + ", " +
                "price=" + price + ']';
    }
}