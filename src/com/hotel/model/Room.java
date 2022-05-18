package com.hotel.model;

import java.util.Objects;

class Room implements IRoom {

    private int roomNumber;
    private double price;
    private String description;
    private RoomType roomType;
    private static final double freeRoom = .01;

    public Room(int roomNumber, double price, RoomType roomType, String description) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.roomType = roomType;
        this.description = description;
    }
//    private Room() {
//    }
//
//    public Room getInstance() {
//        return instance;
//    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public Double getRoomPrice() {
        return price;
    }

    @Override
    public RoomType getRoomType() {
        return roomType;
    }

    @Override //Identify condition
    public boolean isFree() {
        return price < freeRoom;
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