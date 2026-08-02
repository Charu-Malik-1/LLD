package book.my.show.Booking.services;

import book.my.show.Booking.model.*;
import book.my.show.Booking.repositories.ShowRepository;
import book.my.show.Booking.repositories.ShowSeatRepository;
import book.my.show.Booking.repositories.TicketRepository;

import book.my.show.Booking.repositories.User1Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RedisBookingService implements BookingService {
    private final CacheService cacheService;
    private final ShowSeatRepository showSeatRepository;
    private final TicketRepository ticketRepository;
    private final ShowRepository showRepository;
    private final User1Repository user1Repository;

    public RedisBookingService(RedisService redisService, ShowSeatRepository showSeatRepository,
                               TicketRepository tr, ShowRepository showRepository, User1Repository user1Repository) {
        cacheService = redisService;
        this.showSeatRepository = showSeatRepository;
        ticketRepository = tr;
        this.showRepository = showRepository;
        this.user1Repository = user1Repository;
    }

    @Override
    public boolean blockSeats(long showId, List<Long> seatIds, long userId) {
        // 1. fisrt check if seats are avaialble or not
        // a. check if seats are not booked already

        List<ShowSeat> showSeats = showSeatRepository.findAllByShowShowIdAndSeatSeatIdIn(showId, seatIds);
        System.out.println("printing db before logic");
        showSeats.forEach(showSeat -> {
            System.out.println(showSeat.getShowSeatId() + " " + showSeat.getStatus());
        });

        System.out.println("printing cache before logic");
        cacheService.getAllKeysAndValues();

        //check in db if any of seat is booked then false
        for (ShowSeat seat : showSeats) {
            if (seat.getStatus().equals(ShowSeatsStatus.BOOKED))
                return false;
        }

        // b. if in db seats are not booked , then check in cache if seats are not locked already
        for (ShowSeat seat : showSeats) {
            String status = (String) cacheService.get("seatId-" + seat.getShowSeatId() + "-userId-" + userId);
            if (status != null)
                return false;
        }

        // 2. if all the seats are available then we will block the seats in redis - seatId - userId
        for (ShowSeat seat : showSeats) {
            cacheService.set("seatId-" + seat.getShowSeatId() + "-userId-" + userId, "LOCKED");
        }

        System.out.println("printing cache after logic");
        cacheService.getAllKeysAndValues();

        return true;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Optional<Ticket> bookTicket(long showId, List<Long> showSeatIds, long userId) {
        // 1. in redis check if user has locked the seat
        for (Long seatId : showSeatIds) {
            String key="seatId-" + seatId + "-userId-" + userId;
            String status = (String) cacheService.get(key);
            System.out.println("key="+key+" status=" + status);
            // no seats locked for this user
            if (status == null)
                return Optional.empty();
        }
        System.out.println("All seats available");
        // create ticket
        User1 user = user1Repository.findById(userId).get();
        Show show = showRepository.findById(showId).get();


        // 2. if user has lock for all the seats then we will book the seat
        // for this go to all the rows of show_seat and update the status to booked in one query
        // go to all the rows of show_seats and update the status to booked in one query

        Ticket t = createTicketAndBookSeats(show, showSeatIds, user);
        System.out.println("ticket created");
        return Optional.of(t);
    }


    @Transactional(isolation =Isolation.SERIALIZABLE)
    protected Ticket createTicketAndBookSeats(Show show, List<Long> showSeatIds, User1 user) {
        // 1. create new ticket
        Ticket ticket = new Ticket();
        ticket.setAmount(100);// should be calculated based on show and seat price
        ticket.setShow(show);
        ticket.setUser(user);
        ticket.setStatus(TicketStatus.BOOKED);

        ticket = ticketRepository.save(ticket);
        showSeatRepository.bookShowSeatsBulk(showSeatIds, ticket);
        return ticket;
    }

    @Override
    public void clearAllSeatLocks() {
        cacheService.deleteAll();
    }
}
















