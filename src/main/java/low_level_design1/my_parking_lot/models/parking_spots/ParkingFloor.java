package low_level_design1.my_parking_lot.models.parking_spots;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ParkingFloor {
    private final int floorNum;
    private List<ParkingSlot> parkingSlots;

    public ParkingFloor(int floorNum,List<ParkingSlot> parkingSlots) {
        this.floorNum = floorNum;
        this.parkingSlots=parkingSlots;
    }

    public void addParkingSlot(ParkingSlot parkingSlot) {
        parkingSlots.add(parkingSlot);
    }

    public void removeParkingSlot(ParkingSlot parkingSlot) {
        parkingSlots.remove(parkingSlot);
    }
}
