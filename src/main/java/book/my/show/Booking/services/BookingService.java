package book.my.show.Booking.services;

import book.my.show.Booking.model.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookingService {
    void getSeats();

    // Boolean fun that tell if able to block the seat or not.
    boolean blockSeats(long showId, List<Long> seatIds, long userId);

    // This will be transactional
    Optional<Ticket> bookTicket(long showId, List<Long> showSeatIds, long userId);

    void clearAllSeatLocks();
}



