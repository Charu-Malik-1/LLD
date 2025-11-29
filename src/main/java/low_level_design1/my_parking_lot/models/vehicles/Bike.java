package low_level_design1.my_parking_lot.models.vehicles;

import low_level_design1.my_parking_lot.enums.VehicleType;

public class Bike extends Vehicle {
    public Bike(String regNum, String color) {
        super(regNum, color, VehicleType.BIKE);
    }

    @Override
    public void park(int slotNum) {

    }
}
