package com.cricbuzz.push_based.model;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Match {
    private String matchId;
    private Team team1;
    private Team team2;
    private String venue;
    private String date;
    private String time;
    private String status;
    private Innings innings1;
    private Innings innings2;
    private List<String> commentary;
    private boolean isFirstInnings;

    public Match(String matchId, Team team1, Team team2, String venue, String date, String time, String status,
                 Innings innings1, Innings innings2) {
        this.matchId = matchId;
        this.team1 = team1;
        this.team2 = team2;
        this.venue = venue;
        this.date = date;
        this.time = time;
        this.status = status;
        this.innings1 = innings1;
        this.innings2 = innings2;
        this.commentary = new ArrayList<>();
        this.isFirstInnings = true;
    }
}
