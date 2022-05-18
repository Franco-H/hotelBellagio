package com.hotel.model;

import java.util.Objects;

public class Room implements IRoom {

    private String roomNumber;
    private String price;
    private String description;
    private RoomType roomType;
    private boolean isFree;

    public Room(String roomNumber, String price, RoomType roomType, Boolean isFree) {
        this.roomNumber = roomNumber;
        this.price = price;
//        this.description = description
        this.roomType = roomType;
        this.isFree = isFree;
//        this.description = description;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public String getRoomPrice() {
        return price;
    }

    @Override
    public RoomType getRoomType() {
        return roomType;
    }

    @Override //Identify condition
    public boolean isFree() {
        return isFree;
    }

public boolean equals(Object obj) {
    if (obj instanceof Room) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    var that = (Room) obj;
    return this.roomNumber == that.roomNumber &&
            this.price == that.price &&
            this.roomType.equals(that.roomType);
}
    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, price, roomType);
    }

    @Override
    public String toString() {
        return "Room[" +
                "roomNumber=" + roomNumber + ", " +
                "price=" + price + ']';
    }
}
