package low_level_design1.my_parking_lot.models.vehicles;

import low_level_design1.my_parking_lot.enums.VehicleType;

public class ElectricCar extends Vehicle implements ElectricVehicle{
    public ElectricCar(String regNum, String color) {
        super(regNum, color, VehicleType.ELECTRIC_CAR);
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
