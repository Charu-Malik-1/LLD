package bms.demo.lld.models;

import bms.demo.lld.enums.TicketStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Ticket extends BaseModel{
    private double ticketId;
    private int amount;
    private User1 user;
    private Show show;
    private List<Integer> showSeats;
    private TicketStatus status;
    private Booking booking;

    public Ticket(Booking booking,User1 user,List<Integer> showSeats){
        this.user=user;
        this.showSeats=showSeats;
        status=TicketStatus.PENDING;
        this.booking=booking;
    }
}
