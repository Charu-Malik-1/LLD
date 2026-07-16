package com.cricbuzz.pull_based.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Match {
    private String matchId;
    private String venue;
    private String date;
    private String time;
    private String status;
    private Innings inning1;
    private Innings inning2;
    private Team team1;
    private Team team2;
    private List<String> commentry;

    public Match(String matchId,
     String venue,
     String date,
     String time,
     String status,
     Innings inning1,
     Innings inning2,
     Team team1,
     Team team2
    ){
        this.venue=venue;
         this.date=date;
         this.time=time;
         this.status=status;
         this.inning1=inning1;
         this.inning2=inning2;
         this.team1=team1;
         this.team2=team2;
         commentry=new ArrayList<>();
    }


}
