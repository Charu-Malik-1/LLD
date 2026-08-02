package com.lld.hotel_management.models.rooms;

import com.lld.hotel_management.enums.RoomType;

public class DeluxRoom extends Room{

    public DeluxRoom(int id) {
        super(id, RoomType.DELUXE);
    }
}
