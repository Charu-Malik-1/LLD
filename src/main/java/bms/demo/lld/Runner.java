package bms.demo.lld;

import bms.demo.lld.models.*;
import bms.demo.lld.services.*;
import bms.demo.lld.strategy.CardPaymentStrategy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Runner {
    MovieService movieService;
    BookingService bookingService;
    PaymentService paymentService;
    InMemorySchedulerService inMemoryCacheService;
    ShowAuditoriumManager showAuditoriumManager;

    public Runner() {
        movieService = new MovieService();
        paymentService = new PaymentService();
        inMemoryCacheService = new InMemorySchedulerService();
        bookingService = new BookingService(inMemoryCacheService, paymentService);
        showAuditoriumManager = new ShowAuditoriumManager();
    }

    private Date getDate(int dd, int mm, int h, int min) {
        SimpleDateFormat sdf =
                new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

        try {
            String s = dd + "-" + mm + "-2026 " + h + ":" + min + ":00";
            Date date = sdf.parse(s);
            return date;
        } catch (ParseException p) {
        }
        return null;
    }

//    private Map<String, Seat> initialiseSeats(Auditorium auditorium, int row, int col) {
//        Map<String, Seat> map = new HashMap<>();
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                Seat seat = new Seat(auditorium.getAuditoriumId(), i, j);
//                map.put(seat.getSeatId(), seat);
//            }
//        }
//        return map;
//    }

    public void runner() {
        City city = new City("city1", "delhi");

        Theater theater1 = new Theater("theater1", "gachibowli", "gachibowli");
        Theater theater2 = new Theater("theater2", "gachibowli", "gachibowli");

        city.addTheater(theater1);
        city.addTheater(theater2);

        Auditorium auditorium1 = new Auditorium("auditorium1", "a1", 5, 10);
        Auditorium auditorium2 = new Auditorium("auditorium2", "a2", 6, 10);
        Auditorium auditorium3 = new Auditorium("auditorium3", "a3", 7, 10);
        Auditorium auditorium4 = new Auditorium("auditorium4", "a4", 8, 10);

        theater1.addAuditorium(auditorium1);
        theater1.addAuditorium(auditorium2);
        theater2.addAuditorium(auditorium3);
        theater2.addAuditorium(auditorium4);

        Movie movie1 = new Movie("movie1", "ravan1");
        Movie movie2 = new Movie("movie2", "ravan2");
        Movie movie3 = new Movie("movie3", "ravan3");
        Movie movie4 = new Movie("movie4", "ravan4");

        Show show1 = new Show("show1", movie1, getDate(11, 8, 3, 0), getDate(11, 8, 5, 0));
        Show show2 = new Show("show2", movie1, getDate(11, 8, 6, 0), getDate(11, 8, 8, 0));
        Show show3 = new Show("show3", movie1, getDate(11, 8, 9, 0), getDate(11, 8, 11, 0));

        Show show4 = new Show("show4", movie1, getDate(11, 8, 3, 0), getDate(11, 8, 5, 0));
        Show show5 = new Show("show5", movie1, getDate(11, 8, 6, 0), getDate(11, 8, 8, 0));
        Show show6 = new Show("show6", movie1, getDate(11, 8, 9, 0), getDate(11, 8, 11, 0));

        Show show7 = new Show("show7", movie2, getDate(11, 8, 3, 0), getDate(11, 8, 5, 0));
        Show show8 = new Show("show8", movie2, getDate(11, 8, 6, 0), getDate(11, 8, 8, 0));
        Show show9 = new Show("show9", movie2, getDate(11, 8, 9, 0), getDate(11, 8, 11, 0));

        Show show10 = new Show("show10", movie2, getDate(11, 8, 3, 0), getDate(11, 8, 5, 0));
        Show show11 = new Show("show11", movie2, getDate(11, 8, 6, 0), getDate(11, 8, 8, 0));
        Show show12 = new Show("show12", movie2, getDate(11, 8, 9, 0), getDate(11, 8, 11, 0));

        showAuditoriumManager.mapAuditoriumToShow(auditorium1, show1);
        showAuditoriumManager.mapAuditoriumToShow(auditorium1, show2);
        showAuditoriumManager.mapAuditoriumToShow(auditorium1, show3);
        showAuditoriumManager.mapAuditoriumToShow(auditorium2, show4);
        showAuditoriumManager.mapAuditoriumToShow(auditorium2, show5);
        showAuditoriumManager.mapAuditoriumToShow(auditorium2, show6);
        showAuditoriumManager.mapAuditoriumToShow(auditorium3, show7);
        showAuditoriumManager.mapAuditoriumToShow(auditorium3, show8);
        showAuditoriumManager.mapAuditoriumToShow(auditorium3, show9);
        showAuditoriumManager.mapAuditoriumToShow(auditorium4, show10);
        showAuditoriumManager.mapAuditoriumToShow(auditorium4, show11);
        showAuditoriumManager.mapAuditoriumToShow(auditorium4, show12);

        movieService.addMovie(movie1);
        movieService.addMovie(movie2);
        movieService.addMovie(movie3);
        movieService.addMovie(movie4);

//        showAuditoriumManager.printAllShowsInAuditorium(theater1,"auditorium1");

        // operations
        // 1. search movie by name
//        Movie m = movieService.searchMovieByName("ravan");
//        if (m != null)
//            System.out.println("movie " + m);
//        else {
//            System.out.println("no movie");
//        }

        // 2. createBooking

        Thread thread1 = new Thread(() -> {
            System.out.println("-----------------------------------------");
            System.out.println("Thread 1 started");
            List<String> seatIdsForBooking = new ArrayList<>();
            seatIdsForBooking.add("show1-auditorium1-0-8");
            seatIdsForBooking.add("show1-auditorium1-1-8");
            Booking b = bookingService.createBooking3(theater1, "auditorium1", seatIdsForBooking, "show1",
                    new User1(1, "chry"), new CardPaymentStrategy());
            if (b != null)
                System.out.println("Booking created for thread 1: " + b.getBookingId());
            else System.out.println("No booking created for thread 1");
            System.out.println("-----------------------------------------");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("-----------------------------------------");
            System.out.println("Thread 2 started");
            List<String> seatIdsForBooking = new ArrayList<>();
            seatIdsForBooking.add("show1-auditorium1-0-8");
            seatIdsForBooking.add("show1-auditorium1-1-8");
            Booking b1 = bookingService.createBooking3(theater1, "auditorium1", seatIdsForBooking, "show1",
                    new User1(1, "chry"), new CardPaymentStrategy());
            if (b1 != null)
                System.out.println("Booking created for thread 2: " + b1.getBookingId());
            else System.out.println("No booking created for thread 2");
            System.out.println("-----------------------------------------");
        });

        thread1.start();
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        thread2.start();


// TODO add multithreading
    }
}
