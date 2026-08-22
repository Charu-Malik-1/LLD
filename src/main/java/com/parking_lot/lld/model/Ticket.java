package com.parking_lot.lld.model;

import com.parking_lot.lld.enums.PriceCalculationStrategyType;
import com.parking_lot.lld.strategy.price_calculation_strategy.IPriceCalculationStrategy;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
public class Ticket {
    private final int id;
    private final PriceCalculationStrategyType priceCalculationStrategyType;
    private int amt;
    private final Vehicle vehicle;
    private final LocalDateTime inTime;
    private LocalDateTime outTime;
    private ParkingSlot parkingSlot;

    public Ticket(int id, PriceCalculationStrategyType pc, Vehicle vehicle,ParkingSlot ps) {
        this.id = id;
        this.priceCalculationStrategyType = pc;
        this.vehicle = vehicle;
        amt = 0;
        inTime = LocalDateTime.now();
        parkingSlot=ps;
    }
}
