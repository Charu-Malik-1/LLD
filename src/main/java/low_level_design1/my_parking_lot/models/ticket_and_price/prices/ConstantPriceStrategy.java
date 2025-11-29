package low_level_design1.my_parking_lot.models.ticket_and_price.prices;

import low_level_design1.my_parking_lot.enums.PricingStrategyType;

import java.time.LocalDateTime;

public class ConstantPriceStrategy implements PricingStrategy {
    private final long price;

    public ConstantPriceStrategy(int price){
        this.price=price;
    }

    @Override
    public long calculatePrice(long entryTime, long exitTime) {
        return price;
    }
    @Override
    public PricingStrategyType getType() {
        return PricingStrategyType.CONSTANT;
    }
}
