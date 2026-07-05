package book.my.show.Booking.repositories;

import book.my.show.Booking.model.Movie;
import book.my.show.Booking.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long>{}