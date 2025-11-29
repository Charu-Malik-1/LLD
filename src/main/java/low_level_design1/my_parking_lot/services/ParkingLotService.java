package low_level_design1.my_parking_lot.services;

import low_level_design1.my_parking_lot.enums.ParkingSlotStatus;
import low_level_design1.my_parking_lot.models.parking_spots.FindSlotStrategy;
import low_level_design1.my_parking_lot.models.parking_spots.ParkingLot;
import low_level_design1.my_parking_lot.models.parking_spots.ParkingSlot;
import low_level_design1.my_parking_lot.models.ticket_and_price.Ticket;
import low_level_design1.my_parking_lot.models.vehicles.Vehicle;

import java.util.HashMap;
import java.util.Optional;

public class ParkingLotService {
    private ParkingLot parkingLot;
    private FindSlotStrategy findSlotStrategy;
    private HashMap<String,ParkingSlot> vehicleSlotMap=new HashMap<>();
    // we are doing linear-search to find the parking slot.
    // now suppose we want to remove the vehicle for that we need to get the slot, this map
    // will have vehicle to slot mapping. That we can fetch from vehicle num and free the slot

    private HashMap<String, Ticket> vehicleTicketMap=new HashMap<>();
    // have mapping of vehicle reg num to ticket
    public ParkingLotService(ParkingLot parkingLot, FindSlotStrategy findSlotStrategy) {
        this.parkingLot = parkingLot;
        this.findSlotStrategy = findSlotStrategy;
    }

    public void parkCar(Vehicle vehicle) {
        // we need to find the parking slot
        // if slot availble assign the slot to vehicle
        // give ticket to the vehicle
        Optional<ParkingSlot> slot = findSlotStrategy.findSlot(parkingLot, vehicle);
        if(!slot.isPresent()){
            System.out.println("Parking is full");
            return;
        }
        slot.get().setParkedVehicle(Optional.of(vehicle));
        slot.get().setParkingSlotStatus(ParkingSlotStatus.OCCUPIED);
        // this we can change by state pattern
        vehicleSlotMap.put(vehicle.getRegNum(),slot.get());
        System.out.println("Vehicle parked at slot ");
        slot.get().display();

        // lets create ticket
        Ticket ticket=new Ticket(System.currentTimeMillis(),vehicle,slot.get(),parkingLot.getPricingStrategies());
        vehicleTicketMap.put(vehicle.getRegNum(),ticket);
        System.out.println("ticket created");
        ticket.display();
    }

    public void leaveParking(Vehicle vehicle){
        // empty the parking lot
        //pay before leave
        ParkingSlot slot=vehicleSlotMap.get(vehicle.getRegNum());
        if(slot==null){
            System.out.println("vehicle is not found in parking lot");
            return;
        }
        slot.removeVehicle(vehicle);
        vehicleSlotMap.remove(vehicle.getRegNum());
        System.out.println("vehicle left parking lot");

        //pay before leave
        Ticket ticket=vehicleTicketMap.get(vehicle.getRegNum());
        ticket.setExitTime(System.currentTimeMillis());
        ticket.calculatePriceAndPay();
        System.out.println("vehicle left the parking");
    }
}
