package bms.demo.lld.services;

import bms.demo.lld.enums.ShowSeatsStatus;
import bms.demo.lld.models.ShowSeat;
import lombok.Getter;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
/*** It use the concurrent hash map that will delete **/
public class InMemoryCacheService {

    private final Map<ShowSeat, ShowSeatsStatus> cache = new ConcurrentHashMap<>();

    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1);

    public String getLockWithScheduler(ShowSeat seat) {
        String token = UUID.randomUUID().toString();
        if (!seat.lockShowSeat(token)) {
            return null;
        }
        scheduler.schedule(() -> seat.expireHold(token), 10, TimeUnit.SECONDS);
        return token;
    }

//    public boolean tryLock1(ShowSeat key, ShowSeatsStatus value) {
//        if (cache.putIfAbsent(key, value) != null) {
//            return false;
//        }
//        scheduler.schedule(() -> {
//            cache.remove(key);
//            System.out.println("Removed from cache: " + key);
//        }, 10, TimeUnit.SECONDS);
//        return true;
//    }
//    public void put(ShowSeat key, ShowSeatsStatus value) {
//
//        cache.put(key, value);
//
//        scheduler.schedule(
//                () -> {
//                    cache.remove(key);
//                    System.out.println("Removed from cache: " + key);
//                },
//                10, TimeUnit.SECONDS
//        );
//    }

    public ShowSeatsStatus get(ShowSeat key) {
        return cache.get(key);
    }

    public void delete(ShowSeat key) {
        cache.remove(key);
    }

    public void shutdown() {
        scheduler.shutdown();
    }

    void printCache(String msg) {
        System.out.println(msg);
        Map<ShowSeat, ShowSeatsStatus> m = cache;
        for (Map.Entry<ShowSeat, ShowSeatsStatus> e : m.entrySet()) {
            System.out.println(e.getKey().getShowSeatId() + " " + e.getValue());
        }
    }
}
