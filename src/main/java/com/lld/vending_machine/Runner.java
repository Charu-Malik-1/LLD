package com.lld.vending_machine;

import com.lld.vending_machine.model.Inventory;
import com.lld.vending_machine.model.Product;
import com.lld.vending_machine.model.Rack;
import com.lld.vending_machine.model.VendingMachine;

public class Runner {
    public void runner() {
        Product p1 = new Product(1, "chips", 50);
        Product p2 = new Product(2, "veg", 60);
        Product p3 = new Product(3, "non", 80);

        Rack rack1 = new Rack(1);
        Rack rack2 = new Rack(2);
        Rack rack3 = new Rack(3);

        rack1.loadProduct(p1, 5);
        rack2.loadProduct(p2, 4);
        rack3.loadProduct(p3, 7);

        Inventory inventory = new Inventory();
        inventory.addRack(rack1);
        inventory.addRack(rack2);
        inventory.addRack(rack3);

        VendingMachine vm = VendingMachine.getInstance(inventory);

        //--------happy case-------------
        System.out.println("\n\n\nHAPPY CASE");
        vm.getCurrentState().insertCoin(vm, 100);
        vm.getCurrentState().insertCoin(vm, 200);
        helper(vm, 1);
        //----------------------INVALID---- insert less amt
        System.out.println("\n\n\nINVALID- INSERT LESS AMT");
        vm.getCurrentState().insertCoin(vm, 2);
        helper(vm, 1);
      //-------------------insert invalid rack---------------------
        System.out.println("\n\n\nINVALID - INVALID RACK");
        vm.getCurrentState().insertCoin(vm, 100);
        vm.getCurrentState().insertCoin(vm, 200);
        helper(vm, 100);
    }

    private void helper(VendingMachine vm, int rackNum) {
        int status = vm.getCurrentState().selectProduct(vm, rackNum);
        if (status == 1) {
            vm.getCurrentState().dispenseProduct(vm);
            vm.getCurrentState().returnCoin(vm);
        } else if (status == 0) {
            vm.getCurrentState().returnCoin(vm);
        } else if (status == -1) {
            // go to idle
            vm.getCurrentState().dispenseProduct(vm);
            System.out.println("No coin to return.. operation complete");
        }
    }
}

