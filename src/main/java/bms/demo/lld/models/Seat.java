package bms.demo.lld.models;

import bms.demo.lld.enums.SeatType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat extends BaseModel {
    private String id;
    private int rowNo;
    private int columnNo;
    private SeatType seatType;

    public Seat(String aid, int rowNo, int columnNo) {
        this.id = aid + "-" + rowNo + "-" + columnNo;
        this.rowNo = rowNo;
        this.columnNo = columnNo;
        this.seatType = SeatType.NORMAL;
    }
}
