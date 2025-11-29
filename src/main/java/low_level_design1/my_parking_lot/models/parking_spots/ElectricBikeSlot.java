package low_level_design1.my_parking_lot.models.parking_spots;

import low_level_design1.my_parking_lot.enums.VehicleType;

import java.util.List;

public class ElectricBikeSlot extends ParkingSlot implements ElectricSlot , BikeSlot{

    public ElectricBikeSlot(int slotNum, ParkingFloor pf) {
        super(slotNum,List.of(VehicleType.ELECTRIC_BIKE), pf);
    }
}
