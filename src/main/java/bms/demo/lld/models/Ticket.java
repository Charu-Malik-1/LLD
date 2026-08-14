package bms.demo.lld.models;

import bms.demo.lld.enums.TicketStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Ticket extends BaseModel{
    private TicketStatus status;
    private Booking booking;

    public Ticket(Booking booking){
        status=TicketStatus.PENDING;
        this.booking=booking;
    }
}
