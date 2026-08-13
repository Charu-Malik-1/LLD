package bms.demo.lld.services;

import bms.demo.lld.models.Booking;
import bms.demo.lld.strategy.IPaymentStrategy;

public class PaymentService {

    private IPaymentStrategy paymentStrategy;
    public boolean isPymentSuccessful(IPaymentStrategy paymentStrategy,Booking booking){
       return paymentStrategy.makePayment();
    }
    public boolean refund(IPaymentStrategy paymentStrategy, Booking booking) {
        System.out.println("Refunding booking " + booking.getBookingId() + " amount " + booking.getAmount());
        return paymentStrategy.refund();
    }
}
