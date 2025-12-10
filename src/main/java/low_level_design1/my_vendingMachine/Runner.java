package low_level_design1.my_vendingMachine;

import low_level_design1.my_vendingMachine.inventories.Inventory;
import low_level_design1.my_vendingMachine.model.Product;
import low_level_design1.my_vendingMachine.model.VendingMachine;

public class Runner {

    public static void main(String[] args) {
        // creating 5 products
        Product cocacola = new Product(1, "cocacola", 20);
        Product bread = new Product(2, "bread", 50);
        Product cake = new Product(3, "cake", 30);
        Product chips = new Product(4, "chips", 40);
        Product chocolate = new Product(5, "chocolate", 60);

        // creating Inventory
        Inventory inventory = new Inventory(5);
        createInventory(inventory, cocacola, 4);
        createInventory(inventory, bread, 6);
        createInventory(inventory, cake, 5);
        createInventory(inventory, chips, 6);
        createInventory(inventory, chocolate, 3);

        VendingMachine vm = new VendingMachine(inventory);

        // Demonstrate vending machine operations
        System.out.println("=== Vending Machine Demo ===\n");

        // Scenario 1: Successful purchase with exact amount
        System.out.println("Scenario 1: Buy Cocacola (20 rupees) with exact amount");
        System.out.println("Current State: " + vm.getCurrentState().getState());
        vm.getCurrentState().insertCoin(20);
        System.out.println("Current State after inserting coin: " + vm.getCurrentState().getState());
        System.out.println("Current Amount: " + vm.getCurrentAmount());
        vm.getCurrentState().selectItem(1); // Aisel 1 has cocacola
        System.out.println("Current State after selecting item: " + vm.getCurrentState().getState());
        vm.getCurrentState().dispenseItem(1);
        System.out.println("Current State after dispensing: " + vm.getCurrentState().getState());
        System.out.println();

        // Scenario 2: Purchase with extra amount (change should be returned)
        System.out.println("Scenario 2: Buy Cake (30 rupees) with 50 rupees");
        System.out.println("Current State: " + vm.getCurrentState().getState());
        vm.getCurrentState().insertCoin(50);
        System.out.println("Current Amount: " + vm.getCurrentAmount());
        vm.getCurrentState().selectItem(3); // Aisel 3 has cake
        vm.getCurrentState().dispenseItem(3);
        System.out.println("Current State after dispensing: " + vm.getCurrentState().getState());
        vm.getCurrentState().returnCoin(); // Return the change
        System.out.println("Current State after returning change: " + vm.getCurrentState().getState());
        System.out.println();

        // Scenario 3: Insert multiple coins before selecting
        System.out.println("Scenario 3: Buy Chocolate (60 rupees) by inserting multiple coins");
        System.out.println("Current State: " + vm.getCurrentState().getState());
        vm.getCurrentState().insertCoin(20);
        System.out.println("Amount after first coin: " + vm.getCurrentAmount());
        vm.getCurrentState().insertCoin(20);
        System.out.println("Amount after second coin: " + vm.getCurrentAmount());
        vm.getCurrentState().insertCoin(20);
        System.out.println("Amount after third coin: " + vm.getCurrentAmount());
        vm.getCurrentState().selectItem(5); // Aisel 5 has chocolate
        vm.getCurrentState().dispenseItem(5);
        System.out.println("Current State after dispensing: " + vm.getCurrentState().getState());
        System.out.println();

        // Scenario 4: Purchase with extra coins and change
        System.out.println("Scenario 4: Buy Chips (40 rupees) with 100 rupees");
        vm.getCurrentState().insertCoin(100);
        System.out.println("Current Amount: " + vm.getCurrentAmount());
        vm.getCurrentState().selectItem(4); // Aisel 4 has chips
        vm.getCurrentState().dispenseItem(4);
        System.out.println("Current State: " + vm.getCurrentState().getState());
        vm.getCurrentState().returnCoin(); // Return 60 rupees change
        System.out.println("Final State: " + vm.getCurrentState().getState());
        System.out.println();

        System.out.println("=== Demo Complete ===");

    }

    static void createInventory(Inventory inventory, Product product, int qty) {
        for (int i = 1; i <= qty; i++) {
            inventory.addProduct(product);
        }
    }
}
