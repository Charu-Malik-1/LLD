package low_level_design1.my_parking_lot.models.parking_spots;


import low_level_design1.my_parking_lot.models.vehicles.Vehicle;

import java.util.Optional;

public interface FindSlotStrategy {
    // from complete parking lot it will give the available parking slot for given vehicle
    Optional<ParkingSlot> findSlot(ParkingLot parkingLot, Vehicle vehicle);
}
