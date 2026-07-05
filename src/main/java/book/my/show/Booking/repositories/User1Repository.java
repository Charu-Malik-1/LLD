package book.my.show.Booking.repositories;

import book.my.show.Booking.model.Show;
import book.my.show.Booking.model.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User1Repository extends JpaRepository<User1,Long> {
}
