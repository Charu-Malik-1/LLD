package book.my.show.Booking.controller;

import book.my.show.Booking.dto.BlockSeatsRequestDto;
import book.my.show.Booking.dto.BookSeatRequestDTO;
import book.my.show.Booking.model.Ticket;
import book.my.show.Booking.services.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

    private BookingService bookingService;
    public BookingController(BookingService bookingService){
        this.bookingService=bookingService;
    }

    @PostMapping("/block")
    public boolean blockSeats(@RequestBody BlockSeatsRequestDto blockSeatsRequestDto){
        return bookingService.blockSeats(blockSeatsRequestDto.getShowId(),
                blockSeatsRequestDto.getSeatsId(),blockSeatsRequestDto.getUserId());
    }

    // temp api, not required in actual code, it basically delete everything from cache
    @DeleteMapping
    public void cleaAllSeatLocks(){
        bookingService.clearAllSeatLocks();
    }

    @PostMapping("/confirm")
    public void confirmBooking(@RequestBody BookSeatRequestDTO bookSeatRequestDTO){
         bookingService.bookTicket(bookSeatRequestDTO.getShowId(),bookSeatRequestDTO.getSeatsId(),
                bookSeatRequestDTO.getUserId());
    }


}
