package bms.demo.lld.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Booking {
    private String id;
    private Theater theater;
    private Auditorium auditorium;
    private LocalDateTime creationTime;
    private User1 user;
    private Show show;
    private List<String> showSeats;
    private double amount;

    public Booking(String id, Theater theater, Auditorium auditorium, User1 user, Show show, List<String> showSeats, double amount) {
        this.id = id;
        this.theater = theater;
        this.auditorium = auditorium;
        creationTime = LocalDateTime.now();
        this.user = user;
        this.show = show;
        this.showSeats = showSeats;
        this.amount = amount;
    }
}
