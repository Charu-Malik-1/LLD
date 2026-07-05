package book.my.show.Booking.repositories;

import book.my.show.Booking.model.Theater;
import book.my.show.Booking.model.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theater,Long> {
}
