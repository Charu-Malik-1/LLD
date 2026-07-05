package book.my.show.Booking.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Movie extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private long movieId;
    private String name;
    private String poster;
//one movie has many shows
    @OneToMany(mappedBy = "movie")
    private List<Show> shows;
}
