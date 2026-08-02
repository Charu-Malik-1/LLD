package com.lld.hotel_management.state.room_states;

import com.lld.hotel_management.models.rooms.Room;

public interface IRoomStates {
    void reserve(Room room);
    void checkIn(Room room);
    void checkOut(Room room);
    void cancel(Room room);
}
