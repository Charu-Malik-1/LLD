package bms.demo.lld.services;

import bms.demo.lld.models.ShowSeat;
import lombok.Getter;

import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
/*** It use the concurrent hash map that will delete **/
public class InMemorySchedulerService {

    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1);

    public String getLockWithScheduler(ShowSeat seat) {
        String token = UUID.randomUUID().toString();
        if (!seat.lockShowSeat(token)) {
            return null;
        }
        scheduler.schedule(() -> seat.release(token), 10, TimeUnit.SECONDS);
        return token;
    }
}
