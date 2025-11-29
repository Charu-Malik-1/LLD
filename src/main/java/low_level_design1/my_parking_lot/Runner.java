package low_level_design1.my_parking_lot;

import low_level_design1.my_parking_lot.factories.FindSlotStrategyFactory;
import low_level_design1.my_parking_lot.models.parking_spots.*;
import low_level_design1.my_parking_lot.models.ticket_and_price.payments.*;
import low_level_design1.my_parking_lot.models.ticket_and_price.prices.ConstantPriceStrategy;
import low_level_design1.my_parking_lot.models.ticket_and_price.prices.HourlyPriceStrategy;
import low_level_design1.my_parking_lot.models.ticket_and_price.prices.PricingStrategy;
import low_level_design1.my_parking_lot.models.vehicles.*;
import low_level_design1.my_parking_lot.services.ParkingLotService;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    private static ParkingFloor createFloor1() {
        List<ParkingSlot> slots = new ArrayList<>();
        ParkingFloor floor = new ParkingFloor(1, slots);

        // Add 2 regular car slots
        slots.add(new CarParkingSlot(101, floor));
        slots.add(new CarParkingSlot(102, floor));

        // Add 2 regular bike slots
        slots.add(new BikeParkingSlot(103, floor));
        slots.add(new BikeParkingSlot(104, floor));

        // Add 1 electric car slot
        slots.add(new ElectricCarSlot(105, floor));

        // Add 1 electric bike slot
        slots.add(new ElectricBikeSlot(106, floor));

        return floor;
    }

    private static ParkingFloor createFloor2() {
        List<ParkingSlot> slots = new ArrayList<>();
        ParkingFloor floor = new ParkingFloor(2, slots);

        // Add 2 regular car slots
        slots.add(new CarParkingSlot(201, floor));
        slots.add(new CarParkingSlot(202, floor));

        // Add 2 regular bike slots
        slots.add(new BikeParkingSlot(203, floor));
        slots.add(new BikeParkingSlot(204, floor));

        return floor;
    }

    public static void main(String[] args) {
        //create price strategy
        List<PricingStrategy> pricingStrategies = new ArrayList<>();
        pricingStrategies.add(new HourlyPriceStrategy(40, 1L));
        pricingStrategies.add(new ConstantPriceStrategy(20));

        // create parking lot with 2 floors
        ParkingLot parkingLot = new ParkingLot(2, pricingStrategies);
        System.out.println("Parking lot created with 2 floors");

        // Step 3: Create Floor 1 with various parking slots
        ParkingFloor floor1 = createFloor1();
        parkingLot.addParkingFloor(floor1);
        System.out.println("✓ Floor 1 added with 6 slots (2 Car, 2 Bike, 1 Electric Car, 1 Electric Bike)\n");

        // Step 4: Create Floor 2 with various parking slots
        ParkingFloor floor2 = createFloor2();
        parkingLot.addParkingFloor(floor2);
        System.out.println("✓ Floor 2 added with 4 slots (2 Car, 2 Bike)\n");

        // create find slot strategy
        FindSlotStrategy findSlotStrategy = FindSlotStrategyFactory.createLinearSearchFindSlotStrategy();

        // Step 6: Create Parking Lot Service
        ParkingLotService parkingService = new ParkingLotService(parkingLot, findSlotStrategy);
        System.out.println("✓ Parking Service initialized\n");

        System.out.println("========== TESTING PARKING OPERATIONS ==========\n");

        // Test Case 1: Park regular vehicles
        System.out.println("--- Test 1: Parking Regular Vehicles ---");
        Vehicle car1 = new Car("KA-01-1234", "Red");
        Vehicle bike1 = new Bike("KA-02-5678", "Black");

        parkingService.parkCar(car1);
        System.out.println();

        parkingService.parkCar(bike1);
        System.out.println();

        // Test Case 2: Park electric vehicles
        System.out.println("--- Test 2: Parking Electric Vehicles ---");
        Vehicle electricCar1 = new ElectricCar("KA-03-9999", "Blue");
        Vehicle electricBike1 = new ElectricBike("KA-04-8888", "Green");

        parkingService.parkCar(electricCar1);
        System.out.println();

        parkingService.parkCar(electricBike1);
        System.out.println();

        // Test Case 3: Park more vehicles
        System.out.println("--- Test 3: Parking More Vehicles ---");
        Vehicle car2 = new Car("KA-05-7777", "White");
        Vehicle bike2 = new Bike("KA-06-6666", "Yellow");

        parkingService.parkCar(car2);
        System.out.println();

        parkingService.parkCar(bike2);
        System.out.println();

        // Simulate some time passing
        try {
            System.out.println("--- Waiting 2 seconds (simulating parking duration) ---\n");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Test Case 4: Vehicle exit with payment
        System.out.println("--- Test 4: Vehicle Exit and Payment ---");

        // Car1 exits and pays with card
        System.out.println("Car1 leaving with Card Payment:");
        parkingService.leaveParking(car1, new CardPayment());
        System.out.println();

        // Bike1 exits and pays with cash
        System.out.println("Bike1 leaving with Cash Payment:");
        parkingService.leaveParking(bike1, new CashPayment());
        System.out.println();

        // Electric car exits and pays with Fastag
        System.out.println("Electric Car leaving with Fastag Payment:");
        parkingService.leaveParking(electricCar1, new FastagPayment());
        System.out.println();

        // Test Case 5: Try to park after some slots are freed
        System.out.println("--- Test 5: Parking After Slots Are Freed ---");
        Vehicle car3 = new Car("KA-07-5555", "Silver");
        parkingService.parkCar(car3);
        System.out.println();

        // Test Case 6: Fill parking lot completely
        System.out.println("--- Test 6: Testing Full Parking Lot ---");
        Vehicle bike3 = new Bike("KA-08-4444", "Red");
        Vehicle bike4 = new Bike("KA-09-3333", "Blue");
        Vehicle car4 = new Car("KA-10-2222", "Black");
        Vehicle car5 = new Car("KA-11-1111", "Green");

        parkingService.parkCar(bike3);
        System.out.println();

        parkingService.parkCar(bike4);
        System.out.println();

        parkingService.parkCar(car4);
        System.out.println();

        parkingService.parkCar(car5);
        System.out.println();

        // Try to park when full
        System.out.println("--- Test 7: Attempting to Park When Full ---");
        Vehicle car6 = new Car("KA-12-9999", "Purple");
        parkingService.parkCar(car6);
        System.out.println();

        // Test Case 8: Exit remaining vehicles
        System.out.println("--- Test 8: Clearing Parking Lot ---");

        parkingService.leaveParking(electricBike1, new CashPayment());
        System.out.println();

        parkingService.leaveParking(car2, new CardPayment());
        System.out.println();

        parkingService.leaveParking(bike2, new FastagPayment());
        System.out.println();

        // Test Case 9: Test invalid vehicle exit
        System.out.println("--- Test 9: Testing Invalid Vehicle Exit ---");
        Vehicle nonParkedCar = new Car("KA-99-9999", "Orange");
        parkingService.leaveParking(nonParkedCar, new CashPayment());
        System.out.println();

        System.out.println("========== ALL TESTS COMPLETED ==========");
    }
}
