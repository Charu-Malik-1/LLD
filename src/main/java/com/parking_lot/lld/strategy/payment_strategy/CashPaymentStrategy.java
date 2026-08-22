package com.parking_lot.lld.strategy.payment_strategy;

import com.parking_lot.lld.enums.VehicleType;
import com.parking_lot.lld.strategy.price_calculation_strategy.IPriceCalculationStrategy;

import java.time.LocalDateTime;

public class CashPaymentStrategy implements IPaymentStrategy {

    @Override
    public boolean makePayment(int amt){
        return true;
    }
    }
