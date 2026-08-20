package com.lld.vending_machine.state;

import com.lld.vending_machine.model.Rack;
import com.lld.vending_machine.model.VendingMachine;

public class HasCoinState implements IVendingState {
    public HasCoinState() {
        System.out.println("--------------HAS-COIN-STATE-----------------");
    }

    @Override
    public void insertCoin(VendingMachine vm, int coin) {
        if (coin > 0) {
            int amt = vm.getCurrentAmt();
            amt = amt + coin;
            vm.setCurrentAmt(amt);
            System.out.println("user inserted more coin, now total amt is =" + amt);
        } else {
            System.out.println("less or invalid coin , returning coin..");
            vm.setCurrentState(new ReturnCoinState());
        }
    }

    @Override
    public int selectProduct(VendingMachine vm, int rackNum) {
        Rack rack = vm.getInventory().getRacks().get(rackNum);
        if (rack == null || rack.isProductAvailable() == false) {
            System.out.println("invalid rack or product not available");
            vm.setCurrentState(new ReturnCoinState());
            return 0;
        }
        System.out.println("user selected the product: " + rack.getProduct().getProductName());


        int productPrice = rack.getProduct().getPrice();

        if (vm.getCurrentAmt() == productPrice)//user entered the exact amt
        {// simple dispnse and go to idle
            vm.setCurrentState(new DispenseProductState(rack));
            return -1;
        } else if (vm.getCurrentAmt() > productPrice) {
            // dispnse
            // the return coin
            vm.setCurrentState(new DispenseProductState(rack));
            return 1;
        } else { // current<product price --> give user 3 chance to enter coin
            System.out.println("less by amt: " + (productPrice-vm.getCurrentAmt()));
            give3ChanceToUserToInsertCoin(vm);

            if (vm.getCurrentAmt() == productPrice)//user entered the exact amt
            {// simple dispnse and go to idle
                vm.setCurrentState(new DispenseProductState(rack));
                return -1;
            } else if (vm.getCurrentAmt() > productPrice) {
                // dispnse
                // the return coin
                vm.setCurrentState(new DispenseProductState(rack));
                return 1;
            } else {
                return 0;
            }
        }
    }

    void give3ChanceToUserToInsertCoin(VendingMachine vm) {
        System.out.println("less amt ");
        // make 3 appempts from user to take i/p
        int i = 0;
        int input[] = {3, 5, 43};
        while (i < input.length) {
            vm.getCurrentState().insertCoin(vm, input[i]);
            i++;
        }
    }

    @Override
    public void dispenseProduct(VendingMachine vm) {
    }

    @Override
    public void returnCoin(VendingMachine vm) {
    }
}
