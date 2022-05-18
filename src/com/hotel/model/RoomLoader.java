package com.hotel.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RoomLoader {

// <<<<<<< main_V2
//    private final Path roomsFilePath;
//
//    public RoomLoader(String roomsFilePath) {
//        this.roomsFilePath = Path.of(roomsFilePath);
//    }
//
//    public List<Room> getRooms() throws IOException{
//        List<Room> result = new ArrayList<>();
//
//        Files.lines(roomsFilePath).forEach(line -> {
//            String[] tokens = line.split(",");
//
//            int roomNumber = Integer.parseInt(tokens[0]);
//            double price = Double.parseDouble(tokens[1]);
//            RoomType roomType = RoomType.valueOf(tokens[2]);
//            String description = tokens[3];
//
//            result.add(new Room(roomNumber, price, roomType, description));
//        });
//        return result;
//    }
// }
// =======
//     private final Path roomsFilePath;

//     public RoomLoader() {
//         this.roomsFilePath = Path.of("data/room-data.csv");
//     }

//     public List<Room> getRooms() throws IOException {
//         List<Room> result = new ArrayList<>();

//         Files.lines(roomsFilePath).forEach(line -> {
//             String[] tokens = line.split(",");

//             String roomNumber = tokens[0];
//             String price = tokens[1];
//             RoomType roomType = RoomType.valueOf(tokens[2]);
// //            String description = tokens[3];
//             boolean isFree = Boolean.parseBoolean(tokens[4]);
//             result.add(new Room(roomNumber, price, roomType, true));
//         });
//         return result;
//     }
// }
// >>>>>>> main
