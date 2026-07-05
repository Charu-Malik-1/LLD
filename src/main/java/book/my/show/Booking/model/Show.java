package book.my.show.Booking.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Show extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_id")
    private long showId;
    // many shows belongs to 1 movie
    @ManyToOne
    private Movie movie;

    private Date startTime;
    private Date endTime;

    // many show belong to 1 auditorium

    @ManyToOne
    private Auditorium auditorium;

    @OneToMany(mappedBy = "show")
    private List<ShowSeat> showSeats;




}
