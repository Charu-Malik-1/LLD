package book.my.show.Booking.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class BlockSeatsRequestDto {
    private long showId;
    private long userId;
    private List<Long> seatsId;
}
