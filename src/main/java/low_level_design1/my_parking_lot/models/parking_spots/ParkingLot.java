package low_level_design1.my_parking_lot.models.parking_spots;

import lombok.Getter;
import low_level_design1.my_parking_lot.models.ticket_and_price.prices.PricingStrategy;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ParkingLot {
    private List<ParkingFloor> parkingFloors;
    // parking lot will support these pricing strategies like constant, dynamic
    private List<PricingStrategy> pricingStrategies;

    public ParkingLot(int totalFloors, List<PricingStrategy> ps) {
        parkingFloors = new ArrayList<>(totalFloors);
        pricingStrategies = ps;
    }

    public void addParkingFloor(ParkingFloor parkingFloor) {
        parkingFloors.add(parkingFloor);
    }

    public void removeParkingFloor(ParkingFloor parkingFloor) {
        parkingFloors.remove(parkingFloor);
    }
}

