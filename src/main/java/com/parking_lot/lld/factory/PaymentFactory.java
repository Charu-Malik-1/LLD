package com.parking_lot.lld.factory;

import com.parking_lot.lld.enums.PaymentTypeStrategyType;
import com.parking_lot.lld.enums.PriceCalculationStrategyType;
import com.parking_lot.lld.strategy.payment_strategy.CashPaymentStrategy;
import com.parking_lot.lld.strategy.payment_strategy.DebitCardPaymentStrategy;
import com.parking_lot.lld.strategy.payment_strategy.IPaymentStrategy;
import com.parking_lot.lld.strategy.price_calculation_strategy.FixedPriceCalculationStrategy;
import com.parking_lot.lld.strategy.price_calculation_strategy.HourlyPriceCalculationStrategy;
import com.parking_lot.lld.strategy.price_calculation_strategy.IPriceCalculationStrategy;

public class PaymentFactory {

    public static IPaymentStrategy getPaymentStrategy(PaymentTypeStrategyType pt) {
        IPaymentStrategy ps = null;
        switch (pt) {
            case CASH:
                ps = new CashPaymentStrategy();
                break;
            case DEBIT:
                ps = new DebitCardPaymentStrategy();
        }
        return ps;
    }
}
