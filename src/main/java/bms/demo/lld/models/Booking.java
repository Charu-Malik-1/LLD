package bms.demo.lld.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Booking {
    private String bookingId;
    private int amount;

    public Booking(String bookingId,int a) {
        this.bookingId = bookingId;
        this.amount=a;
    }
}
