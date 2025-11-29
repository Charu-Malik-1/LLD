package low_level_design1.my_parking_lot.models.ticket_and_price;

import lombok.Getter;
import lombok.Setter;
import low_level_design1.my_parking_lot.heler.TimeHelpers;
import low_level_design1.my_parking_lot.models.parking_spots.ParkingSlot;
import low_level_design1.my_parking_lot.models.ticket_and_price.payments.PaymentStrategy;
import low_level_design1.my_parking_lot.models.ticket_and_price.prices.PricingStrategy;
import low_level_design1.my_parking_lot.models.vehicles.Vehicle;
import low_level_design1.my_parking_lot.services.PricingService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Getter
@Setter
public class Ticket {
    private final String ticketNum;
    private final long entryTime;
    private Optional<Long> exitTime;
    private final Vehicle vehicle;
    private final ParkingSlot parkingSlot;
    private List<PricingStrategy> priceStrategies; // this will be fix rate and dynamic price
    private Optional<PaymentStrategy> optioanlPaymentStrategy;

    public Ticket( long e, Vehicle v, ParkingSlot ps, List<PricingStrategy> prSt) {
        entryTime = e;
        this.vehicle = v;
        parkingSlot = ps;
        this.priceStrategies = prSt;
        ticketNum= UUID.randomUUID().toString();
    }

    public void setExitTime(Long exitTime) {
        this.exitTime = Optional.of(exitTime);
    }

    public void setPaymentStrategy(PaymentStrategy ps) {
        this.optioanlPaymentStrategy = Optional.of(ps);
    }

    public void calculatePriceAndPay() {
        long price = PricingService.calculateParkingCharge(this);
        System.out.println("price calculated=" + price);
        optioanlPaymentStrategy.get().pay(price);
    }

    public void display(){
        System.out.println("Ticket id="+this.ticketNum);
        System.out.println("Entry time="+ TimeHelpers.convertMillisecondsToHours(this.entryTime));
        System.out.println("Vehicle="+this.vehicle.getRegNum());
        System.out.println("Parking slot="+this.parkingSlot.getSlotNum());
    }
}
