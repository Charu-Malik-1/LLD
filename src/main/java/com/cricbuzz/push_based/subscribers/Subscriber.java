package com.cricbuzz.push_based.subscribers;

import com.cricbuzz.push_based.producers.Producer;

public interface Subscriber {
    void update(Producer producer);
}
