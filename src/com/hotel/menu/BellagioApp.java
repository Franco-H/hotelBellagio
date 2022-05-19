package com.hotel.menu;

import com.hotel.model.Room;
import com.hotel.model.RoomLoader;
import com.hotel.model.RoomType;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

class BellagioApp {
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        try{
            Menu.execute();
        }catch (ParseException e){
            e.printStackTrace();
        }
    }
}
