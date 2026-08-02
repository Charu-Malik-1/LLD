package com.lld.hotel_management;

import com.lld.hotel_management.enums.RoomType;
import com.lld.hotel_management.models.Booking;
import com.lld.hotel_management.models.persons.Admin;
import com.lld.hotel_management.models.persons.Guest;
import com.lld.hotel_management.models.persons.Person;
import com.lld.hotel_management.models.rooms.DeluxRoom;
import com.lld.hotel_management.models.rooms.Room;
import com.lld.hotel_management.models.rooms.SingleRoom;
import com.lld.hotel_management.models.rooms.SuiteRoom;
import com.lld.hotel_management.services.BookingService;
import com.lld.hotel_management.services.RoomService;
import com.lld.hotel_management.services.UserService;
import com.lld.hotel_management.strategy.CardPaymentStrategy;
import com.lld.hotel_management.strategy.CashPaymentStrategy;
import com.lld.hotel_management.strategy.PaymentStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HotelManagementSystem {


    BookingService bookingService;
    private static HotelManagementSystem instance;
    RoomService roomService;

    UserService userService;

    public static HotelManagementSystem getInstance() {
        if (instance == null) {
            synchronized (HotelManagementSystem.class) {
                instance = new HotelManagementSystem();
            }
        }
        return instance;
    }

    private HotelManagementSystem() {
        roomService = new RoomService();
        bookingService = new BookingService(roomService);
//        userService = new UserService();
    }


    public void runner() {
        // case 1 : user search for room on given checking and checkout date with roomtype
        Guest guest1 = new Guest(1, "charu");
        Booking b = bookingService.bookRoom(guest1, "01-Aug-2026", "04-Aug-2026",
                RoomType.SINGLE, 1, new CardPaymentStrategy(), 100);
        bookingService.printBooking(b);

        // case 2 : user search for room on given checking and checkout date with roomtype
        Booking b1 = bookingService.bookRoom(guest1, "01-Aug-2026", "04-Aug-2026",
                RoomType.SINGLE, 2, new CardPaymentStrategy(), 100);
        bookingService.printBooking(b1);

        // case 3 : user search for room on given checking and checkout date with roomtype -> it should not create any booking , as no single room avaialbale on given dates
        Booking b2 = bookingService.bookRoom(guest1, "01-Aug-2026", "04-Aug-2026",
                RoomType.SINGLE, 3, new CardPaymentStrategy(), 100);
        bookingService.printBooking(b2);

        // case 4 : user search for room on given checking and checkout date with roomtype
        Booking b3 = bookingService.bookRoom(guest1, "05-Aug-2026", "06-Aug-2026",
                RoomType.SINGLE, 4, new CashPaymentStrategy(), 100);
        bookingService.printBooking(b3);


        // now user came for check-in, now room states will be change
        roomService.checkIn(b3);
        roomService.checkOut(b3);


    }



    public static void initaliseStaff() {

    }


}
