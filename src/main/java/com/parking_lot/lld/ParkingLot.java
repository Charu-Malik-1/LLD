package com.parking_lot.lld;

import com.parking_lot.lld.enums.PaymentTypeStrategyType;
import com.parking_lot.lld.enums.PriceCalculationStrategyType;
import com.parking_lot.lld.factory.PaymentFactory;
import com.parking_lot.lld.factory.PriceCalculationFactory;
import com.parking_lot.lld.model.*;
import com.parking_lot.lld.services.TicketService;
import com.parking_lot.lld.strategy.payment_strategy.IPaymentStrategy;
import com.parking_lot.lld.strategy.price_calculation_strategy.IPriceCalculationStrategy;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private static ParkingLot instance;
    private Map<Integer, Floor> floorMap;
    TicketService ticketService;
    Map<Integer, User> userMap;

    public ParkingLot getInstance(TicketService ticketService) {
        if (instance == null) {
            synchronized (ParkingLot.class) {
                if (instance == null)
                    instance = new ParkingLot(ticketService);
            }
        }
        return instance;
    }

    private ParkingLot(TicketService ticketService) {
        floorMap = new HashMap<>();
        this.ticketService = ticketService;
        userMap = new HashMap<>();
    }

    public void entry(Vehicle vehicle, int ticketId, PriceCalculationStrategyType pc) {
        //getAvailableSlot
        ParkingSlot ps = null;
        for (Map.Entry<Integer, Floor> e : floorMap.entrySet()) {
            Floor floor = e.getValue();
            ps = floor.getAvailableSlot(vehicle);
            if (ps != null) {
                break;
            }
        }
        if (ps == null) {
            System.out.println("parking full.. ");
            return;
        }

        // allocate slot
        ps.bookSlot(vehicle);

        // issue ticket
        Ticket ticket = ticketService.issueTicket(ticketId, pc, vehicle, ps);
        User user = new User();
        user.setTicket(ticket);
        userMap.put(ticketId, user);
    }

    public void exit(Vehicle vehicle, User user, PaymentTypeStrategyType pstype) {
        // release slot

        Ticket ticket = user.getTicket();
        ParkingSlot ps = ticket.getParkingSlot();
        ps.releaseSlot();

        //calculate price
        PriceCalculationStrategyType pcsType = ticket.getPriceCalculationStrategyType();
        IPriceCalculationStrategy pcs = PriceCalculationFactory.getPriceCalculationStrategy(pcsType);
        int price = pcs.calculatePrice(vehicle.getVehicleType(), ticket.getInTime(), ticket.getOutTime());

        // makePayment
        IPaymentStrategy pst= PaymentFactory.getPaymentStrategy(pstype);
        if(pst.makePayment(price)){

        }


    }

}
