package low_level_design1.my_parking_lot.models.vehicles;

import low_level_design1.my_parking_lot.enums.VehicleType;

public class ElectricBike extends Vehicle  implements ElectricVehicle{
    public ElectricBike(String regNum, String color) {
        super(regNum, color, VehicleType.ELECTRIC_BIKE);
    }

    @Override
    public void chargeVehicle() {

    }

    @Override
    public int getBatteryPercentage() {
        return 0;
    }

    @Override
    public void park(int slotNum) {

    }
}
