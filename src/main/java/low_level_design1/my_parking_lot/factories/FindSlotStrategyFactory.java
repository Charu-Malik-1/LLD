package low_level_design1.my_parking_lot.factories;

import low_level_design1.my_parking_lot.models.parking_spots.FindSlotStrategy;
import low_level_design1.my_parking_lot.models.parking_spots.LinearSearchFindingStrategy;

public class FindSlotStrategyFactory {
    public static FindSlotStrategy createLinearSearchFindSlotStrategy(){
        return new LinearSearchFindingStrategy();
    }
}
