package com.hotel.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RoomLoader {

    private  Path roomsFilePath;
    public static  List<Room> result = new ArrayList<>();

    public List<Room> getRooms() throws IOException {

        Files.lines(roomsFilePath).forEach(line -> {

            String[] tokens = line.split(",");
            if(tokens.length == 5){
                String roomNumber = tokens[0];
                String price = tokens[1];
                RoomType roomType = RoomType.valueOf(tokens[2]);
                boolean isFree = Boolean.parseBoolean(tokens[4]);
                result.add(new Room(roomNumber, price, roomType, true));
            }
        });
        return result;
    }

}

