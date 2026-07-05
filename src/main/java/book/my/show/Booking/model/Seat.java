package book.my.show.Booking.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private long seatId;
    private String seatNumber;
    private int rowNo;
    private int columnNo;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
//    private boolean isBooked;

    @ManyToOne
    private Auditorium auditorium;
}
