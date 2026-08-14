package bms.demo.lld.observer;

import bms.demo.lld.models.Booking;
import bms.demo.lld.models.User1;

public interface BookingObserver {

    void onBookingConfirmed(Booking booking, User1 user);
}
