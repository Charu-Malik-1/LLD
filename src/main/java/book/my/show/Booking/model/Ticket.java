package book.my.show.Booking.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Ticket extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private long ticketId;
    private int amount;

    @ManyToOne
    private User1 user;

    @ManyToOne
    private Show show;

    @OneToMany(mappedBy = "ticket")
    private List<ShowSeat> showSeats;

    @Enumerated(EnumType.ORDINAL)
    private TicketStatus status;


}
