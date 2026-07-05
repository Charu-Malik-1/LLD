package book.my.show.Booking.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User1 extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;

    private String name;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Ticket> tickets;
}
