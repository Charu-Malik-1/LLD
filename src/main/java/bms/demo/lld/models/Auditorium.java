package bms.demo.lld.models;

//import jakarta.persistence.*;

import bms.demo.lld.enums.SeatType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Auditorium extends BaseModel {
    private String id;
    private String name;
    private int capacity;
    private int row;
    private int column;
    private Seat seatMetrix[][];
    private Map<String, Show> showMap;
//    private Map<Movie,Show> movieShowMap; // use for search service that is not completed

    public Auditorium(String auditoriumId, String name, int r, int c) {
        this.id = auditoriumId;
        this.name = name;
        this.row = r;
        this.column = c;
        showMap = new HashMap<>();
//        movieShowMap=new HashMap<>();
        seatMetrix = new Seat[r][c];
        initialiseSeats();
    }

    private void initialiseSeats() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                Seat seat = new Seat(id, i, j);
                seatMetrix[i][j] = seat;
            }
        }
        // add empty row and column
        for (int r = 0; r < row; r++) {
            seatMetrix[r][0] = null;
            seatMetrix[r][column - 1] = null;
        }
        for (int c = 0; c < column; c++) {
            seatMetrix[row / 2][c] = null;
        }
    }

    public void addShow( Show show) {
        getShowMap().put(show.getId(),show);
        show.addShowSeat(seatMetrix);
//        movieShowMap.put(show.getMovie(),show);
    }
}
