package low_level_design1.my_parking_lot.services;

import low_level_design1.my_parking_lot.enums.PricingStrategyType;
import low_level_design1.my_parking_lot.factories.PricingStrategyFactory;
import low_level_design1.my_parking_lot.models.ticket_and_price.prices.PricingStrategy;
import low_level_design1.my_parking_lot.models.ticket_and_price.Ticket;


public class PricingService {
    public static long calculateParkingCharge(Ticket ticket) {
        for (PricingStrategy strategy : ticket.getPriceStrategies()) {
            if (strategy.getType().equals(PricingStrategyType.HOURLY)) {
                strategy = PricingStrategyFactory.createHourlyPricingStrategy(ticket);

            }
        }
        return ticket.getPriceStrategies().stream()
                .mapToLong(strategy -> strategy
                        .calculatePrice(ticket.getEntryTime(), ticket.getExitTime().get()))
                .sum();
    }
}
