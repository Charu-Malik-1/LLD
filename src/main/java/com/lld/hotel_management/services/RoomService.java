package com.lld.hotel_management.services;

import com.lld.hotel_management.enums.RoomType;
import com.lld.hotel_management.models.Booking;
import com.lld.hotel_management.models.rooms.DeluxRoom;
import com.lld.hotel_management.models.rooms.Room;
import com.lld.hotel_management.models.rooms.SingleRoom;
import com.lld.hotel_management.models.rooms.SuiteRoom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomService {
     Map<RoomType, List<Room>> roomAndTypeMapping;
     public RoomService(){
         roomAndTypeMapping = new HashMap<>();
         initialiseRoom();
     }
    public void initialiseRoom() {
        List<Room> singleRoom = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            singleRoom.add(new SingleRoom(i));
        }
        roomAndTypeMapping.put(RoomType.SINGLE, singleRoom);

        List<Room> deluxe = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            deluxe.add(new DeluxRoom(i));
        }
        roomAndTypeMapping.put(RoomType.DELUXE, deluxe);

        List<Room> suites = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            suites.add(new SuiteRoom(i));
        }
        roomAndTypeMapping.put(RoomType.SUITE, suites);
    }

    public void checkIn(Booking booking){
        booking.getRoom().getRoomStates().checkIn();
    }
    public void checkOut(Booking booking){
        booking.getRoom().getRoomStates().checkOut();
    }
}
