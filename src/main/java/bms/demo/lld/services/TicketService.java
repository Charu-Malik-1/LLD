package bms.demo.lld.services;

import bms.demo.lld.enums.TicketStatus;
import bms.demo.lld.models.*;

import java.util.ArrayList;
import java.util.List;

public class TicketService {

    public Ticket generateTicket(Booking booking) {
        return new Ticket(booking);
    }

//    public void print(Ticket ticket) {
//        System.out.println(ticket.getTicketId() + " " + ticket.getAmount() + " " + ticket.getShowSeats() + " ");
//    }
}
