package book.my.show.Booking.repositories;

import book.my.show.Booking.model.Ticket;
import book.my.show.Booking.model.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
