package com.lld.hotel_management.models.rooms;

import com.lld.hotel_management.enums.RoomState;
import com.lld.hotel_management.enums.RoomType;
import com.lld.hotel_management.state.room_states.AvailableState;
import com.lld.hotel_management.state.room_states.IRoomStates;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Room {
    int roomId;
//    RoomState roomState;
    IRoomStates roomStates;
    RoomType roomType;
//    boolean isAvailable;

    public Room(int roomId, RoomType roomType) {
        this.roomId = roomId;
//        roomState = RoomState.AVAILABLE;
        this.roomType = roomType;
//        isAvailable = true;
        roomStates=new AvailableState();
    }

}
