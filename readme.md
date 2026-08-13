City

    - id,name
    - city(is,name) -> initialise theater mao
    - Theaters: map
    - addTheater()
    - deleteTheater()
    - getTheater()

Theater

    - id,name
    - theater(id,name) -> initilise map
    - auditoriums: map
    - addAuditorium()
    - getAuditorium()
    - deleteAuditorium()

Auditorium
    
    - id,name
    - auditrium(id,name,row,col) -> initialise seats
    - shows: map
    - physical-seats: map
    - addshow()
    - deleteshow()
    - getshow()
    - getSeatLayout()

Show

    - id,name,date and time, movie
    - show(is,name,date, time,movie) -> 
    - showSeat: map : populate it with auditorium seats

Seat 

    - id
    - seatType : enum : normal, premium
    - getSeatType()

ShowSeat

    - id,show,seat, auditoriumid,
    - seatStatus : enum : available, booked, locked 

showSeatManager:
 
    -

User
    
    - id,name

Movie

    - id,name

Ticket

    - 

Booking
    
    - id,

PaymentStrategy
    
    - cashpayment
    - creditCardPayment
searchservice
    
    - List<Show> searchMovieByName(movieName,city,theater,)
    -         SearchService
                -- -
                cityId, text-- > List < Movies >
                Filter < CityID, MovieId > --Show + Theater
    
Operations
    
    - serachMovie
    - bookShow
    