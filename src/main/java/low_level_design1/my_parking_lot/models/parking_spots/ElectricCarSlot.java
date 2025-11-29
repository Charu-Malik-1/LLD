package low_level_design1.my_parking_lot.models.parking_spots;

import low_level_design1.my_parking_lot.enums.VehicleType;

import java.util.List;

public class ElectricCarSlot extends ParkingSlot implements ElectricSlot, CarSlot {
    public ElectricCarSlot(int slotNum, ParkingFloor pf) {
        super(slotNum, List.of(VehicleType.ELECTRIC_BIKE,VehicleType.ELECTRIC_CAR), pf);
    }
}
