package bms.demo.lld.services;

import bms.demo.lld.enums.ShowSeatsStatus;
import bms.demo.lld.models.*;
import bms.demo.lld.strategy.IPaymentStrategy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class BookingService {
    private InMemoryCacheService inMemoryCacheService;
    private PaymentService paymentService;

    public BookingService(InMemoryCacheService inMemoryCacheService, PaymentService paymentService) {
        this.inMemoryCacheService = inMemoryCacheService;
        this.paymentService = paymentService;
    }

    public Booking createBooking3(Theater theater, String auditoriumId, List<String> seatIds,
                                 String showId, User1 user, IPaymentStrategy paymentStrategy) {
        Auditorium auditorium = theater.getAuditoriumMap().get(auditoriumId);
        Show show = auditorium.getShowMap().get(showId);

        // ---- Phase 1: hold seats, remembering MY token for each ----
        Map<ShowSeat, String> held = new LinkedHashMap<>();
        int amount = 0;

        for (String seatId : seatIds) {
            ShowSeat ss = show.getShowSeatMap().get(seatId);
            if (ss == null) {
                releaseAll(held);
                return null;
            }
            String token = inMemoryCacheService.tryLock(ss);
            if (token == null) {
                System.out.println("Could not hold seat: " + seatId);
                releaseAll(held);
                return null;
            }
            held.put(ss, token);
            amount += ss.getCost();
        }

        // ---- Phase 2: payment -- nothing held/blocked while this runs ----
        String bookingId = buildBookingId(theater, auditorium, show, seatIds);
        Booking booking = generateNewBooking(bookingId, amount);

        if (!paymentService.isPymentSuccessful(paymentStrategy, booking)) {
            releaseAll(held);
            return null;
        }

        // ---- Phase 3: confirm -- each seat checked against MY token, not just "is it free" ----
        if (!confirmBooking(held)) {
            System.out.println("Lost a seat at confirmation time (stale hold), refunding payment");
            paymentService.refund(paymentStrategy, booking);
            releaseAll(held);
            return null;
        }

        return booking;
    }

    private boolean confirmBooking(Map<ShowSeat, String> held) {
        List<ShowSeat> confirmed = new ArrayList<>();
        for (Map.Entry<ShowSeat, String> entry : held.entrySet()) {
            ShowSeat ss = entry.getKey();
            String token = entry.getValue();
            if (!ss.tryMarkBooked(token)) {
                confirmed.forEach(c -> c.release(held.get(c)));
                return false;
            }
            confirmed.add(ss);
        }
        return true;
    }

    private void releaseAll(Map<ShowSeat, String> held) {
        held.forEach((seat, token) -> seat.release(token));
    }
    private String buildBookingId(Theater theater, Auditorium auditorium, Show show, List<String> seatIds) {
        return theater.getId() + "-" + auditorium.getId() + "-" + show.getId() + "-" + String.join(",", seatIds);
    }

    //------------------------------------------
//    public Booking createBooking1(Theater theater, String auditoriumId, List<String> seatIds,
//                                 String showId, User1 user, IPaymentStrategy paymentStrategy) {
//        Auditorium auditorium = theater.getAuditoriumMap().get(auditoriumId);
//        Show show = auditorium.getShowMap().get(showId);
//
//        // ---- Phase 1: claim seats -- fast, atomic, fail-fast, no I/O ----
//        List<ShowSeat> claimed = new ArrayList<>();
//        int amount = 0;
//
//        for (String seatId : seatIds) {
//            ShowSeat ss = show.getShowSeatMap().get(seatId);
//
//            if (ss == null) {
//                System.out.println("Invalid seat: " + seatId);
//                release(claimed);
//                return null;
//            }
//            if (ss.getShowSeatsStatus() == ShowSeatsStatus.BOOKED) {
//                System.out.println("Seat already booked: " + seatId);
//                release(claimed);
//                return null;
//            }
//            if (!inMemoryCacheService.tryLock(ss, ShowSeatsStatus.LOCKED)) {
//                System.out.println("Seat locked by someone else: " + seatId);
//                release(claimed);
//                return null;
//            }
//            claimed.add(ss);
//            amount += ss.getCost();
//        }
//
//        // ---- Phase 2: payment -- slow, external, nothing locked while this runs ----
//        String bookingId = buildBookingId(theater, auditorium, show, seatIds);
//        Booking booking = generateNewBooking(bookingId, amount);
//
//        if (!paymentService.isPymentSuccessful(paymentStrategy, booking)) {
//            System.out.println("Payment failed, releasing seats");
//            release(claimed);
//            return null;
//        }
//
//        // ---- Phase 3: confirm -- atomic per-seat commit, the real guard ----
//        if (!saveToDb1(seatIds, show)) {
//            System.out.println("Lost the seat at confirmation time, refunding payment");
//            paymentService.refund(paymentStrategy, booking);
//            release(claimed);
//            return null;
//        }
//
//        release(claimed); // DB now holds the real BOOKED status; cache entries are redundant
//        return booking;
//    }
//
//    private void release(List<ShowSeat> seats) {
//        for (ShowSeat ss : seats) {
//            inMemoryCacheService.delete(ss);
//        }
//    }
//
//    private String buildBookingId(Theater theater, Auditorium auditorium, Show show, List<String> seatIds) {
//        return theater.getId() + "-" + auditorium.getId() + "-" + show.getId() + "-" + String.join(",", seatIds);
//    }
//
//    boolean saveToDb1(List<String> seatIds, Show show) {
//        List<ShowSeat> confirmed = new ArrayList<>();
//        for (String seatId : seatIds) {
//            ShowSeat ss = show.getShowSeatMap().get(seatId);
//            if (!ss.tryMarkBooked()) {
//                confirmed.forEach(ShowSeat::release);
//                return false;
//            }
//            confirmed.add(ss);
//        }
//        return true;
//    }

    /// i/p should be theater, showtime, user, movie name
//    public Booking createBooking(Theater theater, String auditoriumId, List<String> seatIds,
//                                 String showId, User1 user, IPaymentStrategy paymentStrategy) {
//        Auditorium auditorium = theater.getAuditoriumMap().get(auditoriumId);
//        Show show = auditorium.getShowMap().get(showId);
//
//        // take lock on show
//        ReentrantLock lock = show.getShowLock();
//        lock.lock();
//        int amount = 0;
//        String seatsIdsString = "";
//        try {
//            for (int i = 0; i < seatIds.size(); i++) {
//                ShowSeat ss = show.getShowSeatMap().get(seatIds.get(i));
//                if (ss == null) {
//                    System.out.println("Invalid seat");
//                    return null;
//                }
//                seatsIdsString += ss.getShowSeatId();
//                amount += ss.getCost();
//                // check showSeat availability
//                if (ss.getShowSeatsStatus().equals(ShowSeatsStatus.BOOKED)) {
//                    System.out.println("show seat is booked : not available " + Thread.currentThread().getName());
//                    return null;
//                }
//                if (inMemoryCacheService.getCache().containsKey(ss) && inMemoryCacheService.getCache().get(ss).equals(ShowSeatsStatus.LOCKED)) {
//                    System.out.println("show seat is locked : not available " + Thread.currentThread().getName());
//                    return null;
//                }
//            }
//
//
//            // if all the seats neither booked nor locked
//            // step 1: by the time user make payment, add seats to cache as locked
//            // step 2 : get payment success
//            // step 3: update status to booked in db
//            inMemoryCacheService.printCache("print before lock " + Thread.currentThread().getName());
//            //step 1
//            for (int i = 0; i < seatIds.size(); i++) {
//                ShowSeat ss = show.getShowSeatMap().get(seatIds.get(i));
//                System.out.println("Locked the seats in cache by " + Thread.currentThread().getName());
//                inMemoryCacheService.put(ss, ShowSeatsStatus.LOCKED);
//            }
//
////            if (Thread.currentThread().getName().equals("Thread-1")) {
////                try {
////                    Thread.sleep(5_000);
////                } catch (InterruptedException e) {
////                    Thread.currentThread().interrupt();
////                }
////            }
//            inMemoryCacheService.printCache("print after lock " + Thread.currentThread().getName());
//            //step 2
//            String id = theater.getId() + "-" + auditorium.getId() + "-" + show.getId() + "-" + seatsIdsString;
//            Booking booking = generateNewBooking(id, amount);
//            if (paymentService.isPymentSuccessful(paymentStrategy, booking)) {
//                // step 3 : update status to booked in db
//                if (saveToDb(seatIds, show))
//                    return booking;
//            }
//        } finally {
//            lock.unlock();
//        }
//        return null;
//    }


//    boolean saveToDb(List<String> seatIds,
//                     Show show) {
//        try {
//            for (int i = 0; i < seatIds.size(); i++) {
//                ShowSeat ss = show.getShowSeatMap().get(seatIds.get(i));
//                // update showSeat availability in db/map
//                ss.setShowSeatsStatus(ShowSeatsStatus.BOOKED);
//            }
//        } catch (Exception e) {
//            System.out.println("saving to db failed " + Thread.currentThread().getName());
//            return false;
//        }
//        return true;
//    }

    Booking generateNewBooking(String bookingId, int amount) {
        Booking b = new Booking(bookingId, amount);
        return b;
    }
}
