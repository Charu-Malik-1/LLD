package com.cricbuzz.push_based.subscribers;

import com.cricbuzz.push_based.producers.Producer;

import java.util.ArrayList;
import java.util.List;

public class CommentarySubscriber implements Subscriber{
    private List<String> commentaries;

    public CommentarySubscriber(){
        commentaries=new ArrayList<>();
    }

    @Override
    public void update(Producer producer) {
        this.commentaries.add(producer.getMatchData().getCommentary().get(
                producer.getMatchData().getCommentary().size()-1)
        );
    }
}
