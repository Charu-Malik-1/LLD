package com.cricbuzz.push_based.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class Team {
    private String name;
    private String teamId;
    private List<Player> players;
}
