package com.hotel.menu;

//import com.apps.util.SplashApp;
import com.hotel.model.Room;
import com.hotel.model.RoomLoader;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

class BellagioApp {
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        RoomLoader roomLoader = new RoomLoader();
        try{
            Menu.execute();
        }catch (ParseException e){
            e.printStackTrace();
        }
    }
//    @Override
//    public void start() {
//        Menu menu = new Menu();
//        try {
//            menu.execute();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }

//    @Override
//    public void welcome(String... strings) throws IllegalArgumentException {
//        SplashApp.super.welcome(strings);
//    }
//
//    @Override
//    public void welcome(long l, String... strings) throws IllegalArgumentException {
//        SplashApp.super.welcome(l, strings);
//    }

//    public static void main(String[] args) {
//        BellagioApp app = new BellagioApp();
////        app.welcome("images/credits.jpg", "images/bellagio.png");
////        app.start();
//    }
}
