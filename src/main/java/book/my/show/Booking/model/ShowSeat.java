package book.my.show.Booking.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Entity
@Getter
@Setter
public class ShowSeat extends BaseModel{
    @Id
    @Column(name = "show_seat_id")
    private long showSeatId;
    // 1 show has many seats
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;

    @Enumerated(EnumType.ORDINAL)
    private ShowSeatsStatus status;

    @ManyToOne
    private Ticket ticket;
}
