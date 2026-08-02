package com.lld.hotel_management.models;

import com.lld.hotel_management.enums.RoomType;
import com.lld.hotel_management.models.persons.Guest;
import com.lld.hotel_management.models.rooms.Room;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Booking {
    int id;
    Date checkInDate;
    Date checkOutDate;
    Guest guest;
    Room room;

    public Booking(int id, Date checkInDate, Date checkOutDate, Guest guest, Room room) {
        this.id = id;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.guest = guest;
        this.room = room;
    }
}
