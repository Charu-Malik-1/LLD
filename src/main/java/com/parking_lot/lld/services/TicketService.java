package com.parking_lot.lld.services;

import com.parking_lot.lld.enums.PriceCalculationStrategyType;
import com.parking_lot.lld.factory.PriceCalculationFactory;
import com.parking_lot.lld.model.ParkingSlot;
import com.parking_lot.lld.model.Ticket;
import com.parking_lot.lld.model.Vehicle;
import java.time.LocalDateTime;

public class TicketService {

    public Ticket issueTicket(int id, PriceCalculationStrategyType pc, Vehicle vehicle, ParkingSlot ps) {
        Ticket ticket = new Ticket(id, pc, vehicle,ps);
        return ticket;
    }

    public void releaseTicket(Ticket ticket) {
        PriceCalculationStrategyType pt = ticket.getPriceCalculationStrategyType();
        ticket.setOutTime(LocalDateTime.now());
        int price = PriceCalculationFactory.getPriceCalculationStrategy(pt).calculatePrice(ticket.getVehicle().getVehicleType(), ticket.getInTime(), ticket.getOutTime());
        ticket.setAmt(price);
    }
}
