package low_level_design1.my_parking_lot.models.parking_spots;

import low_level_design1.my_parking_lot.models.vehicles.Vehicle;

import java.util.Optional;

public class LinearSearchFindingStrategy implements FindSlotStrategy{
    // linearly search for all floors and slots which are supported the vehicle
    // and are available
    @Override
    public Optional<ParkingSlot> findSlot(ParkingLot parkingLot, Vehicle vehicle) {
        for(ParkingFloor floor: parkingLot.getParkingFloors()){
            for(ParkingSlot slot: floor.getParkingSlots()){
                if(!slot.isSlotAvailable() && slot.isVehicleSupported(vehicle)){
                    slot.display();
                    return Optional.of(slot);
                }
            }
        }
        System.out.println("No slot available");
        return Optional.empty();
    }
}
