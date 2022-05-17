package com.hotel.model;

public final class FreeRoom {
    /*
    * Cannot extend Room class due to Room class being a singleton
    * Review with team.
    * */
    FreeRoom() {
    }

    @Override
    public boolean equals(Object obj) {
        return obj.equals(this) || obj.getClass() == this.getClass();
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString(){
        return "FreeRoom[]";
    }
}