package com.parking_lot.lld.strategy.price_calculation_strategy;

import com.parking_lot.lld.enums.VehicleType;

import java.time.LocalDateTime;

public interface IPriceCalculationStrategy {

    int calculatePrice(VehicleType vehicleType, LocalDateTime inTime,LocalDateTime outTime);
}
