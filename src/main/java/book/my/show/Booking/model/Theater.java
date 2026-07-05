package book.my.show.Booking.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Theater extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theater_id")
    private long theaterId;
    private String name;
    private String address;


    //many theater belong to 1 city
    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "theater")
    private List<Auditorium> auditoriums;

}
