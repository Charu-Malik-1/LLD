package com.cricbuzz.pull_based;

import lombok.Getter;


@Getter
public class IccApiServices {
    private int runs;
    private int wickets;
    private int overs;

    public IccApiServices(int runs, int wickets, int overs) {
        this.runs = runs;
        this.wickets = wickets;
        this.overs = overs;
    }

    public void updateScore(int runs, int wickets, int overs) {
        // This service will talk to ICC server and get the latest data
        this.runs = runs;
        this.wickets = wickets;
        this.overs = overs;
    }

}
