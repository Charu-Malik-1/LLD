package com.lld.hotel_management.state.room_states;

import com.lld.hotel_management.models.rooms.Room;

public class ReserveState implements IRoomStates {

    @Override
    public void reserve(Room room) {
        System.out.println("First reserver the room");
    }

    @Override
    public void checkIn(Room room) {
        room.setRoomStates(new OccupiedState());
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
