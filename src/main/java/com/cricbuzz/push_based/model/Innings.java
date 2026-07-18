package com.cricbuzz.push_based.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Innings {
    private String currentOver;
    private String currentBall;
    private String currentRunRate;
    private String currentScore;
    private String wickets;
}
