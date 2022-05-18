package com.hotel.menu;

import com.apps.util.SplashApp;
import java.text.ParseException;

class BellagioApp implements SplashApp {
    @Override
    public void start() {
        Menu menu = new Menu();
        try {
            menu.execute();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void welcome(String... strings) throws IllegalArgumentException {
        SplashApp.super.welcome(strings);
    }

    @Override
    public void welcome(long l, String... strings) throws IllegalArgumentException {
        SplashApp.super.welcome(l, strings);
    }

    public static void main(String[] args) {
        BellagioApp app = new BellagioApp();
        app.welcome("images/credits.jpg", "images/bellagio.png");
        app.start();
    }
}
