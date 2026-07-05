package book.my.show.Booking.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class City extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private long cityId;
    private String name;

    @OneToMany(mappedBy="city")
    private List<Theater> theater;
}
