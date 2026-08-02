package com.lld.hotel_management.services;

import com.lld.hotel_management.enums.RoomState;
import com.lld.hotel_management.enums.RoomType;
import com.lld.hotel_management.models.Booking;
import com.lld.hotel_management.models.Payment;
import com.lld.hotel_management.models.persons.Guest;
import com.lld.hotel_management.models.rooms.Room;
import com.lld.hotel_management.strategy.PaymentStrategy;
import lombok.Getter;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Getter
@Setter
public class BookingService {

    RoomService roomService;
    List<Booking> upcomingBookings;
    List<Booking> pastBookings;
//    Map<RoomType, List<Room>> roomAndTypeMapping;


    public BookingService(
                          RoomService roomService) {
        upcomingBookings = new ArrayList<>();
        pastBookings = new ArrayList<>();
//        this.roomAndTypeMapping = roomAndTypeMapping;

        this.roomService = roomService;
    }

    void cancelBooking() {
    }

    public void printBooking(Booking b) {
        if (b == null) {
            System.out.println("enter valid booking id");
            System.out.println("------------------------------------------");
            return;
        }
        System.out.println(" booking id = " + b.getId() + "\n room-id = " + b.getRoom().getRoomId() +
                "\n check-in-date = " + b.getCheckInDate() +
                "\n check-out-date = " + b.getCheckOutDate() + "\n room-type = " + b.getRoom().getRoomType()
                + "\n guest-id = " + b.getGuest().getName());
        System.out.println("------------------------------------------");
    }

    public Booking createBooking(int bookingId, Guest guest, Room room, Date checkInDate,
                                 Date checkOutDate, PaymentStrategy paymentStrategy, int amount) {
        Booking b = new Booking(bookingId, checkInDate, checkOutDate, guest, room);

        b.getRoom().getRoomStates().reserve(room);

        //  payment
        Payment p = paymentStrategy.makePayment(amount);
        if (p == null) {
            System.out.println("Payment failure");
            b.getRoom().getRoomStates().cancel(b.getRoom());
        return null;
        }
        upcomingBookings.add(b);
        b.getRoom().setRoomState(RoomState.OCCUPIED);
        return b;
    }

    public List<Room> search(RoomType style, Date checkInDate, Date checkOutDate) {
        Map<String, Room> availableRooms = new HashMap<>();

        // get all the rooms of type style
        List<Room> totalRooms = roomService.roomAndTypeMapping.get(style);
        // first add all rooms to available rooms
        for (int i = 0; i < totalRooms.size(); i++) {
            Room r = totalRooms.get(i);
            availableRooms.put(style.toString() + r.getRoomId(), r);
        }

        // search if same room type is avaialble on given dates, remove that room from avaialble rooms
        for (int i = 0; i < upcomingBookings.size(); i++) {
            Booking b = upcomingBookings.get(i);
            String s = style.toString() + b.getRoom().getRoomId();

            if (b.getRoom().getRoomType().equals(style)) {
                // check check-in date in range, then remove the room from available rooms
                if ((checkInDate.compareTo(b.getCheckInDate()) >= 0 &&
                        checkInDate.compareTo(b.getCheckOutDate()) <= 0)
                        || (checkOutDate.compareTo(b.getCheckInDate()) >= 0 &&
                        checkOutDate.compareTo(b.getCheckOutDate()) <= 0)
                ) {
                    availableRooms.remove(s);
                }
            }
        }
        List<Room> availableRoomList = new ArrayList<>();
        for (Map.Entry<String, Room> entry : availableRooms.entrySet()) {
            availableRoomList.add(entry.getValue());
        }
        return availableRoomList;
    }

    public Booking bookRoom(Guest guest, String date1, String date2, RoomType roomType,
                            int bookingId, PaymentStrategy paymentStrategy, int amount) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        Date checkInDate, checkOutDate;
        List<Room> availableRooms = null;
        try {
            checkInDate = sdf.parse(date1);
            checkOutDate = sdf.parse(date2);
            availableRooms = search(roomType, checkInDate, checkOutDate);

            if (availableRooms == null || availableRooms.isEmpty()) {
                System.out.println("No rooms available at this point");
                return null;
            }
            return createBooking(bookingId, guest, availableRooms.get(0), checkInDate,
                    checkOutDate, paymentStrategy, amount);
        } catch (ParseException e) {
            return null;
        }
    }

}
