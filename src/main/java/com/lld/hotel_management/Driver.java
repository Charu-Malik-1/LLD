package com.lld.hotel_management;

public class Driver {
    public static void runner(){
//        HotelManagementSystem.initialiseRoom();
//        HotelManagementSystem.initaliseStaff();
        HotelManagementSystem hms=HotelManagementSystem.getInstance();
        hms.runner();
    }
}
