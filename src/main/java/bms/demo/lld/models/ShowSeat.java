package bms.demo.lld.models;

import bms.demo.lld.enums.ShowSeatsStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowSeat extends BaseModel {
    private String showSeatId;
    // 1 show has many seats
    private Show show;
    private Seat seat;
//    private volatile ShowSeatsStatus showSeatsStatus;
    private int cost;
    @Setter(AccessLevel.NONE)
    private volatile ShowSeatsStatus showSeatsStatus;
    // who currently holds the reservation on this seat -- null means nobody
    @Setter(AccessLevel.NONE)
    private volatile String holdToken;

    public ShowSeat(Show show, Seat seat, int cost) {
        showSeatId = show.getId() + "-" + seat.getId();
        this.show = show;
        this.seat = seat;
        showSeatsStatus = ShowSeatsStatus.AVAILABLE;
        this.cost = cost;
    }
    /** Try to reserve this seat under a fresh token. Fails if booked or already held. */
    public synchronized boolean tryHold(String token) {
        if (showSeatsStatus == ShowSeatsStatus.BOOKED) return false;
        if (holdToken != null) return false;
        holdToken = token;
        showSeatsStatus = ShowSeatsStatus.LOCKED;
        return true;
    }

    /** TTL expiry callback -- only clears the hold if it's STILL this token's (not a newer one's). */
    public synchronized void expireHold(String token) {
        if (token.equals(holdToken)) {
            holdToken = null;
            if (showSeatsStatus == ShowSeatsStatus.LOCKED) {
                showSeatsStatus = ShowSeatsStatus.AVAILABLE;
            }
        }
    }

    /** Voluntary release (payment failed, or another seat in the same booking failed). */
    public synchronized void release(String token) {
        expireHold(token); // identical rule: only release if it's still your hold
    }

    /** Final commit. Only succeeds if this token's hold is STILL the current one. */
    public synchronized boolean tryMarkBooked(String token) {
        if (showSeatsStatus == ShowSeatsStatus.BOOKED) return false;
        if (!token.equals(holdToken)) return false; // your reservation isn't current anymore
        showSeatsStatus = ShowSeatsStatus.BOOKED;
        holdToken = null;
        return true;
    }

    public synchronized boolean tryMarkBooked() {
        if (showSeatsStatus == ShowSeatsStatus.BOOKED) {
            return false;
        }
        showSeatsStatus = ShowSeatsStatus.BOOKED;
        return true;
    }

    public synchronized void release() {
        showSeatsStatus = ShowSeatsStatus.AVAILABLE;
    }
}