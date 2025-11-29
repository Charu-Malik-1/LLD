package low_level_design1.my_parking_lot.models.parking_spots;

import lombok.Getter;
import lombok.Setter;
import low_level_design1.my_parking_lot.enums.ParkingSlotStatus;
import low_level_design1.my_parking_lot.enums.VehicleType;
import low_level_design1.my_parking_lot.models.vehicles.Vehicle;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Setter
@Getter
public abstract class ParkingSlot {
    private final int slotNum;
    private ParkingSlotStatus parkingSlotStatus;
    private Optional<Vehicle> parkedVehicle;
    private final List<VehicleType> supportedVehicleType;
    private final ParkingFloor parkingFloor;

    public ParkingSlot(int slotNum, List<VehicleType> supportedVehicleType, ParkingFloor pf) {
        this.slotNum = slotNum;
        parkingSlotStatus = ParkingSlotStatus.EMPTY;
        parkedVehicle = Optional.empty();
        this.supportedVehicleType = supportedVehicleType;
        this.parkingFloor = pf;
    }

    public void removeVehicle(Vehicle vehicle) {
        parkingSlotStatus = ParkingSlotStatus.EMPTY;
        this.parkedVehicle= Optional.empty();
    }

    public boolean isSlotAvailable() {
        return parkingSlotStatus == ParkingSlotStatus.EMPTY;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (supportedVehicleType.contains(vehicle.getVehicleType())) {
            parkingSlotStatus = ParkingSlotStatus.OCCUPIED;
            parkedVehicle = Optional.of(vehicle);
            return true;
        }else{
            System.out.println("vehicle not supported");
            return false;
        }
    }

    public void display(){
        System.out.println("Slot num "+slotNum);
        System.out.println("Slot status "+parkingSlotStatus);
        System.out.println("Supported vehicle types "+ Arrays.toString(supportedVehicleType.toArray()));
        if(parkedVehicle.isPresent()){
            System.out.println("Parked vehicle "+ parkedVehicle.get().getRegNum());
        }
    }

    public boolean isVehicleSupported(Vehicle vehicle){
        if(supportedVehicleType.contains(vehicle.getVehicleType()))
            return true;
        return false;
    }
}
