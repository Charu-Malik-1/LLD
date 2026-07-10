package org.example.state;

import lombok.Getter;
import org.example.model.VendingMachine;

@Getter
public class DispenseProductState implements StateInterface {
    private final VendingMachine vm;

    public DispenseProductState(VendingMachine vm) {
        this.vm = vm;
    }

    @Override
    public void insertCoin(int coin) {
        System.out.println("Cannot insert coin while dispensing");
    }

    @Override
    public void selectItem(int itemNum) {
        System.out.println("Cannot select item while dispensing");
    }

    @Override
    public void dispenseItem(int item) {

        // This will reduce product from inventory and give the amount that should return
        int amount = vm.dispenseItem(item);
        if (amount > 0) {
            vm.setCurrentState(new ReturnAmountState(vm, amount));
            vm.getCurrentState().returnCoin();
        } else {
            System.out.println("No amount to return.");
            vm.setCurrentState(new IdleState(vm));
        }
        vm.setCurrentAmount(0);

    }

    @Override
    public void returnCoin() {
        System.out.println("Cannot return coin while dispensing");
    }
}
