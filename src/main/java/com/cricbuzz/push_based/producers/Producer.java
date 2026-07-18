package com.cricbuzz.push_based.producers;

import com.cricbuzz.push_based.model.Match;
import com.cricbuzz.push_based.subscribers.Subscriber;

public interface Producer {
    Match getMatchData();
     void subscribe(Subscriber subscriber);

     void unsubscribe(Subscriber subscriber);

     void notifySubscriber(Subscriber subscriber);
}
