package low_level_design1.my_parking_lot.models.ticket_and_price.prices;

import low_level_design1.my_parking_lot.enums.PricingStrategyType;

public class HourlyPriceStrategy implements PricingStrategy {
    private final int pricePerHour;
    private long numOfHours;

    public HourlyPriceStrategy(int pricePerHour, Long totalTime) {
        this.pricePerHour = pricePerHour;
        numOfHours = totalTime;
    }

    @Override
    public long calculatePrice(long entryTime, long exitTime) {
        return pricePerHour * this.numOfHours;
    }

//    public void setNumOfHours(int n) {
//        this.numOfHours = n;
//    }

    @Override
    public PricingStrategyType getType() {
        return PricingStrategyType.HOURLY;
    }
}
