package com.hotel.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RoomLoader {

    private final Path roomsFilePath;

    public RoomLoader(String roomsFilePath) {
        this.roomsFilePath = Path.of(roomsFilePath);
    }

    public List<Room> getRooms() throws IOException{
        List<Room> result = new ArrayList<>();

        Files.lines(roomsFilePath).forEach(line -> {
            String[] tokens = line.split(",");

            int roomNumber = Integer.parseInt(tokens[0]);
            double price = Double.parseDouble(tokens[1]);
            RoomType roomType = RoomType.valueOf(tokens[2]);
            String description = tokens[3];

            result.add(new Room(roomNumber, price, roomType, description));
        });
        return result;
    }
}