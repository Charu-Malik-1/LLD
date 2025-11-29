package low_level_design1.my_parking_lot.models.vehicles;

import lombok.Getter;
import low_level_design1.my_parking_lot.enums.VehicleType;

@Getter
public abstract class Vehicle {
    private final String regNum;
    private final String color;
    private final VehicleType vehicleType;

    public Vehicle(String regNum, String color, VehicleType vehicleType) {
        this.regNum = regNum;
        this.color = color;
        this.vehicleType = vehicleType;
    }

    public abstract void park(int slotNum);
}
