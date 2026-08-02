package com.lld.hotel_management.models.rooms;

import com.lld.hotel_management.enums.RoomType;

public class SuiteRoom extends Room{

    public SuiteRoom(int id) {
        super(id,RoomType.SUITE);
    }

}
