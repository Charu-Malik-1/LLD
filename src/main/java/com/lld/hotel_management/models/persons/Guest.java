package com.lld.hotel_management.models.persons;

import com.lld.hotel_management.enums.RoomType;
import com.lld.hotel_management.models.rooms.Room;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
public class Guest extends Person {

    int id;
    String name;

    public Guest(int id,String name){
        this.id=id;
        this.name=name;
    }

}
