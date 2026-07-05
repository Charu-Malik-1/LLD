package book.my.show.Booking.repositories;

import book.my.show.Booking.model.Show;
import book.my.show.Booking.model.ShowSeat;
import book.my.show.Booking.model.Ticket;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {

    List<ShowSeat> findAllByShowSeatId(Long showId);
    List<ShowSeat> findAllByShowShowIdAndSeatSeatIdIn(Long showId,List<Long> seatIds);

    @Modifying
    @Query("UPDATE ShowSeat s SET s.status=1 , s.ticket= :ticket where s.seat.seatId in :ids")
    int bookShowSeatsBulk(@Param("ids") List<Long> ids, @Param("ticket") Ticket ticket);
}
