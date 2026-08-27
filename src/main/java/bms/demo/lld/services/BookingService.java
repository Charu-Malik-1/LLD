package bms.demo.lld.services;

import bms.demo.lld.models.*;
import bms.demo.lld.strategy.IPaymentStrategy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BookingService {
    private InMemorySchedulerService inMemorySchedulerService;
    private PaymentService paymentService;
    private TicketService ticketService;
    private NotificationService notoficationService;

    public BookingService(InMemorySchedulerService inMemoryCacheService, PaymentService paymentService
            , TicketService ticketService, NotificationService ns) {
        this.inMemorySchedulerService = inMemoryCacheService;
        this.paymentService = paymentService;
        this.ticketService = ticketService;
        this.notoficationService=ns;
    }


    /**
     * here we are achieving more accuracy as for each showseat , we are generatuing the token and storing in map
     * that tocken shuld be same at the time of making the payment and updating in db
     */
    public Ticket createBooking3(Theater theater, String auditoriumId, List<String> seatIds,
                                 String showId, User1 user, IPaymentStrategy paymentStrategy) {
        Auditorium auditorium = theater.getAuditoriumMap().get(auditoriumId);
        Show show = auditorium.getShowMap().get(showId);

        // ---- Phase 1: hold seats, remembering MY token for each ----
        Map<ShowSeat, String> finalShowSeatTokenMap = new LinkedHashMap<>();
        int amount = 0;

        for (String seatId : seatIds) {
            ShowSeat ss = show.getShowSeatMap().get(seatId);
            /** if user give 5 seats to book and all 4 seats are valid and booked, but 1 seat is invalid, so
             no seat will be allocated to user **/
            if (ss == null) {
                releaseAllShowSeats(finalShowSeatTokenMap);
                return null;
            }
            // generate token for seat to lock , it will return null if seat is booked or locked by other user
            String token = inMemorySchedulerService.getLockWithScheduler(ss);
            if (token == null) {
                System.out.println("Could not hold seat: " + seatId);
                releaseAllShowSeats(finalShowSeatTokenMap);
                return null;
            }
            finalShowSeatTokenMap.put(ss, token);
            amount += ss.getCost();
        }

        // ---- Phase 2: payment -- nothing held/blocked while this runs ----
        Booking booking = generateNewBooking(theater,auditorium,user,show,seatIds, amount);
        // if payment is not suucess for this booking then also it will release
        if (!paymentService.isPymentSuccessful(paymentStrategy, booking)) {
            releaseAllShowSeats(finalShowSeatTokenMap);
            return null;
        }

        // ---- Phase 3: confirm -- each seat checked against MY token, not just "is it free" ----
        if (!confirmBooking(finalShowSeatTokenMap)) {
            System.out.println("Lost a seat at confirmation time (stale hold), refunding payment");
            paymentService.refund(paymentStrategy, booking);
            releaseAllShowSeats(finalShowSeatTokenMap);
            return null;
        }
        // phase 4 : create ticket (this doest need any lock)
        Ticket ticket = ticketService.generateTicket(booking);

        // phase 5 : we can notify obserever on success booking
        notoficationService.notifyAllObserevre(ticket.getBooking(),user);
        return ticket;
    }

    private boolean confirmBooking(Map<ShowSeat, String> finalShowSeatTokenMap) {
        List<ShowSeat> confirmedShowSeat = new ArrayList<>();
        for (Map.Entry<ShowSeat, String> entry : finalShowSeatTokenMap.entrySet()) {
            ShowSeat ss = entry.getKey();
            String token = entry.getValue();
            if (!ss.bookSeatInDB(token)) {
                for (int i = 0; i < confirmedShowSeat.size(); i++) {
                    ShowSeat prevBookedSeat = confirmedShowSeat.get(i);
                    prevBookedSeat.release(finalShowSeatTokenMap.get(prevBookedSeat));
                }
                return false;
            }
            confirmedShowSeat.add(ss);
        }
        return true;
    }

    private void releaseAllShowSeats(Map<ShowSeat, String> showSeatTokenMap) {
        for (Map.Entry<ShowSeat, String> e : showSeatTokenMap.entrySet()) {
            ShowSeat showSeat = e.getKey();
            String token = e.getValue();
            showSeat.release(token);
        }
    }

    private String buildBookingId(Theater theater, Auditorium auditorium, Show show, List<String> seatIds) {
        return theater.getId() + "-" + auditorium.getId() + "-" + show.getId() + "-" + String.join(",", seatIds);
    }

    Booking generateNewBooking(Theater theater, Auditorium auditorium, User1 user, Show show, List<String> showSeats,
                               double amount) {
        String bookingId = buildBookingId(theater, auditorium, show, showSeats);
        Booking b = new Booking(bookingId, theater,auditorium,user,show,showSeats,amount);
        return b;
    }
}
