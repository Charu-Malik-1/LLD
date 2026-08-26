package com.lld.ratelimiter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

// 2 requ allow in 5min
class WindowCounter {
    LocalDateTime startTime;
    int counter;

    public WindowCounter(LocalDateTime s, int c) {
        this.startTime = s;
        this.counter = c;
    }
}
//TODO concurrency
public class FixedWindow {
    int maxRequest;
    int windowSizeInSecond;

    ConcurrentHashMap<String, WindowCounter> map;

    public FixedWindow(int maxRequest, int windowSizeInSecond) {
        map = new ConcurrentHashMap<String, WindowCounter>();
        this.maxRequest = maxRequest;
        this.windowSizeInSecond = windowSizeInSecond;
    }

    public boolean checkLimit(String id) {
        if (!map.containsKey(id)) {
            WindowCounter wc = new WindowCounter(LocalDateTime.now(), 1);
            map.put(id, wc);
            return true;
        }
        WindowCounter wc = map.get(id);
        Duration duration = Duration.between(wc.startTime, LocalDateTime.now());
        long diffSeconds = duration.toSeconds();
        if (diffSeconds < windowSizeInSecond) {
            if (wc.counter > maxRequest)
                return false;
            else {
                wc.counter++;
                map.put(id, wc);
                return true;
            }
        } else {
            wc.counter = 1;
            wc.startTime = LocalDateTime.now();
            map.put(id, wc);
            return true;
        }
    }
}

