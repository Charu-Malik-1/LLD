package com.lld.hotel_management.models.rooms;

import com.lld.hotel_management.enums.RoomType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SingleRoom extends Room {

    public SingleRoom(int id) {
        super(id,RoomType.SINGLE);
    }

}
