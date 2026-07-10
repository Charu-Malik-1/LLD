package org.example;

import org.example.model.Inventory;
import org.example.model.Product;
import org.example.model.VendingMachine;
import org.example.service.AmountService;
import org.example.service.InventoryService;

public class VendingMachineRunner {

    public static void runner() {
        Product cocakola = new Product(1, "cocakola", 100);
        Product potato = new Product(2, "potato", 20);
        Product tomato = new Product(3, "tomato", 40);
        Product brinjal = new Product(4, "brinjal", 50);

        Inventory inventory = new Inventory(5);
        createInventory(inventory,cocakola);
        createInventory(inventory,potato);
        createInventory(inventory,tomato);
        createInventory(inventory,brinjal);

        InventoryService inventoryService = new InventoryService(inventory);
        inventoryService.addProductToInventory(brinjal);
        inventoryService.addProductToInventory(brinjal);
        inventoryService.addProductToInventory(brinjal);
        inventoryService.addProductToInventory(potato);
        inventoryService.addProductToInventory(potato);
        inventoryService.addProductToInventory(potato);
        AmountService amountService=new AmountService();

        VendingMachine vm = VendingMachine.getInstace(inventoryService,amountService);
        /** These 2 operations are only visible to end user
         * User can insert the coin and select the item
        * **/

        vm.selectItem(4);
        vm.insertCoin(60);
    }

    private static void createInventory(Inventory inventory,Product product) {
         inventory.addProductToInventory(product);
    }

    //admin operations
    public void addInventory(){}
    public void showInventory(){}
}
