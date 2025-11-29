package low_level_design1.my_parking_lot.factories;

import low_level_design1.my_parking_lot.config.ServerConfig;
import low_level_design1.my_parking_lot.enums.PricingStrategyType;
import low_level_design1.my_parking_lot.models.ticket_and_price.Ticket;
import low_level_design1.my_parking_lot.heler.TimeHelpers;
import low_level_design1.my_parking_lot.models.ticket_and_price.prices.ConstantPriceStrategy;
import low_level_design1.my_parking_lot.models.ticket_and_price.prices.HourlyPriceStrategy;
import low_level_design1.my_parking_lot.models.ticket_and_price.prices.PricingStrategy;

public class PricingStrategyFactory {

    public static PricingStrategy createHourlyPricingStrategy(Ticket ticket) {
        return new HourlyPriceStrategy(ServerConfig.PRICE_PER_HOUR,
                TimeHelpers.convertMillisecondsToHours(
                        ticket.getExitTime().get() - ticket.getEntryTime()));
    }

    public static PricingStrategy createConstantPricingStrategy(Ticket ticket) {
        return new ConstantPriceStrategy(20);
    }
}
