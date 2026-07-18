package com.cricbuzz.push_based.subscribers;

import com.cricbuzz.push_based.model.Innings;
import com.cricbuzz.push_based.model.Match;
import com.cricbuzz.push_based.producers.Producer;

public class ScoreBoardSubscriber implements Subscriber {
    private Match match;

    public ScoreBoardSubscriber(Match match) {
        this.match = match;
    }

    public void update(Producer producer) {
        Match producerMatchData = producer.getMatchData();
        boolean isFirstInnings = producerMatchData.isFirstInnings();
        Innings inningsProducer = (isFirstInnings) ? producerMatchData.getInnings1() :
                producerMatchData.getInnings2();
        Innings inningsSubscriber = (isFirstInnings) ? this.match.getInnings1() : this.match.getInnings2();
        inningsSubscriber.setCurrentBall(inningsProducer.getCurrentBall());
        inningsSubscriber.setCurrentScore(inningsProducer.getCurrentScore());
        inningsSubscriber.setWickets(inningsProducer.getWickets());
        inningsSubscriber.setCurrentOver(inningsProducer.getCurrentOver());
    }
}
