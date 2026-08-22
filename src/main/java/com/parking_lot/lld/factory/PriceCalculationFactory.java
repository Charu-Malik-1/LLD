package com.parking_lot.lld.factory;

import com.parking_lot.lld.enums.PriceCalculationStrategyType;
import com.parking_lot.lld.strategy.price_calculation_strategy.FixedPriceCalculationStrategy;
import com.parking_lot.lld.strategy.price_calculation_strategy.HourlyPriceCalculationStrategy;
import com.parking_lot.lld.strategy.price_calculation_strategy.IPriceCalculationStrategy;

public class PriceCalculationFactory {

    public static IPriceCalculationStrategy getPriceCalculationStrategy(PriceCalculationStrategyType pt) {
        IPriceCalculationStrategy ps = null;
        switch (pt) {
            case FIXED:
                ps = new FixedPriceCalculationStrategy();
                break;
            case HOURLY:
                ps = new HourlyPriceCalculationStrategy();
        }
        return ps;
    }
}
