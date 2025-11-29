package low_level_design1.my_parking_lot.models.parking_spots;

import low_level_design1.my_parking_lot.enums.VehicleType;

import java.util.List;

public class CarParkingSlot extends ParkingSlot implements CarSlot{

    public CarParkingSlot(int slotNum, ParkingFloor pf) {
        super(slotNum, List.of(VehicleType.CAR,VehicleType.BIKE), pf);
    }
}
