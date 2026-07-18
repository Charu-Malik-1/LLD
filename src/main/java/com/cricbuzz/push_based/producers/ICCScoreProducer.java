package com.cricbuzz.push_based.producers;

import com.cricbuzz.push_based.model.Match;
import com.cricbuzz.push_based.subscribers.ScoreBoardSubscriber;
import com.cricbuzz.push_based.subscribers.Subscriber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// this class will produce the data
public class ICCScoreProducer implements Producer{
    private Match match;
    private ScoreBoardSubscriber scoreBoardSubscriber;
    private Set<Subscriber> subscribers;

    public ICCScoreProducer(Match match,ScoreBoardSubscriber scoreBoardSubscriber){
        this.scoreBoardSubscriber=scoreBoardSubscriber;
        subscribers=new HashSet<>();
    }

    public void scoreUpdate(String runs,String over,String ball,String wickets, boolean isFirstInnings){
       // this has api that fetch data from ICC server and publish to our subscriber
        this.scoreBoardSubscriber.update(this);
    }

    public void subscribe(Subscriber subscriber){
        this.subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber){
        this.subscribers.remove(subscriber);
    }

    public void notifySubscriber(Subscriber subscriber){
        this.subscribers.add(subscriber);
    }

    @Override
    public Match getMatchData() {
        return this.match;
    }
}
