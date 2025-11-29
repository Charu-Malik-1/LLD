package low_level_design1.my_parking_lot.models.vehicles;

import low_level_design1.my_parking_lot.enums.VehicleType;

public class Car extends Vehicle {
    public Car(String regNum, String color) {
        super(regNum, color, VehicleType.CAR);
    }

    @Override
    public void park(int slotNum) {

    }
}
