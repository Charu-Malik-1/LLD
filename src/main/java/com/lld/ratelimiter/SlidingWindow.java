package com.lld.ratelimiter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


public class SlidingWindow {
    final int maxCounter;
    final long slidingWindowSizeInSeconds;
    ConcurrentHashMap<String, List<LocalDateTime>> map;
    int globalRequestCounterInWindow;

    public SlidingWindow(int maxCounter, int slidingWindowSize) {
        this.maxCounter = maxCounter;
        this.slidingWindowSizeInSeconds = slidingWindowSize;
        map = new ConcurrentHashMap<String, List<LocalDateTime>>();
        globalRequestCounterInWindow=0;
    }

    public boolean isAllowed(String id) {
        if (!map.containsKey(id)) {
            List<LocalDateTime> l=new ArrayList<>();
            l.add(LocalDateTime.now());
            map.put(id,l);
            return true;
        }
        List<LocalDateTime> l=map.get(id);
        Duration duration = Duration.between(LocalDateTime.now(),l.getFirst());
        while(l.size()>=1 && duration.toSeconds()>=slidingWindowSizeInSeconds){
            l.removeFirst();
            duration = Duration.between(LocalDateTime.now(),l.getFirst());
        }
        if(l.size()>globalRequestCounterInWindow){
            return false;
        }
        l.add(LocalDateTime.now());
        map.put(id,l);
        return true;
    }
}
