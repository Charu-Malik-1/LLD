package book.my.show.Booking.repositories;

import book.my.show.Booking.model.Auditorium;
import book.my.show.Booking.model.ShowSeat;
import book.my.show.Booking.model.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium,Long> {
}
