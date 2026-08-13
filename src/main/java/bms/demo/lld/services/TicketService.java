package bms.demo.lld.services;

import bms.demo.lld.enums.TicketStatus;
import bms.demo.lld.models.*;

import java.util.ArrayList;
import java.util.List;

public class TicketService {

    public Ticket generateTicket(Booking booking,  User1 user,  List<Integer> showSeats) {
        return new Ticket(booking, user, showSeats);
    }

    public void print(Ticket ticket) {
        System.out.println(ticket.getTicketId() + " " + ticket.getAmount() + " " + ticket.getShowSeats() + " ");
    }
}
