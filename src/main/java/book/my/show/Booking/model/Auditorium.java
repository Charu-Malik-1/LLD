package book.my.show.Booking.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Auditorium extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auditorium_id")
    private long auditoriumId;
    private String name;
    private int capacity;
    @ManyToOne
    private Theater theater;

    @OneToMany(mappedBy = "auditorium")
    private List<Seat> seats;

    @OneToMany(mappedBy = "auditorium")
    private List<Show> shows;

}
