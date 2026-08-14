package bms.demo.lld.models;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Show extends BaseModel {
    private String id;
    private Date startTime;
    private Date endTime;
    private Map<String, ShowSeat> showSeatMap;
    private Movie movie;

    public Show(String showId, Movie movie, Date startTime, Date endTime) {
        this.id = showId;
        this.startTime = startTime;
        this.endTime = endTime;
        showSeatMap = new HashMap<>();
        this.movie = movie;
    }

    public void addShowSeat(Seat seatMetrix[][]) {
        int r = seatMetrix.length;
        int c = seatMetrix[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                Seat s = seatMetrix[i][j];
                if (s == null) {
                    System.out.print(" ");
                } else {
                    ShowSeat showSeat1 = new ShowSeat(this, s, 200);
                    showSeatMap.put(showSeat1.getShowSeatId(), showSeat1);
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }
}
