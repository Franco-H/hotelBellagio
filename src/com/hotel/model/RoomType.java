package com.hotel.model;

public enum RoomType {
  
    OVER_LOOKING_WATER_FALL_KING(10_000.0),
    PINT_HOUSE_KING(8_500.0),
    ELITE_KING(7_000.0),
    KING(6_000.0),
    OVER_LOOKING_WATER_FALL_QUEEN(4_500.0),
    PINT_HOUSE_QUEEN(3_000.0),
    QUEEN(2_000.0);

    private double price;

    RoomType(double price){
        this.price = price;
    }

    public double RoomType(){
        return price;
    }
}