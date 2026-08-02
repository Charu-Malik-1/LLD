package com.lld.hotel_management.state.room_states;

import com.lld.hotel_management.models.rooms.Room;
import com.lld.hotel_management.services.RoomService;

public class AvailableState implements IRoomStates {

    @Override
    public void reserve(Room room) {
        room.setRoomStates(new ReserveState());
    }

    @Override
    public void checkIn(Room room) {
        System.out.println("First reserver the room");
    }

    @Override
    public void checkOut(Room room) {
        System.out.println("First reserver the room");
    }

    @Override
    public void cancel(Room room) {
        room.setRoomStates(new AvailableState());
    }

}
