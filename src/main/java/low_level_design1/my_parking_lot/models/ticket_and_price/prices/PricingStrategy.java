package low_level_design1.my_parking_lot.models.ticket_and_price.prices;

import low_level_design1.my_parking_lot.enums.PricingStrategyType;

public interface PricingStrategy {
    long calculatePrice(long entryTime,long exitTime);
    PricingStrategyType getType();
}
