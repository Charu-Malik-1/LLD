package bms.demo.lld.observer;

import bms.demo.lld.models.Booking;
import bms.demo.lld.models.User1;

public class MessageObserver implements IObserver {

    @Override
    public void onBookingConfirmed(Booking booking, User1 user) {
        System.out.println("Notifying " + user.getName() + " (" + user.getEmail() + "): "
                + "booking " + booking.getId() + " confirmed, amount " + booking.getAmount());
    }
}
