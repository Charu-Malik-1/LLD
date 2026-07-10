package org.example.state;

import lombok.Getter;
import org.example.model.VendingMachine;
import org.example.service.AmountService;
import org.example.service.InventoryService;

@Getter
public class NoCoinState implements StateInterface {
    private final VendingMachine vm;

    public NoCoinState(VendingMachine vm) {
        this.vm = vm;
    }

    @Override
    public void insertCoin(int amount) {
        AmountService amountService = vm.getAmountService();
        InventoryService inventoryService = vm.getInventoryService();
        int price = inventoryService.findProductWithItemNum(vm.getCurrentItem()).getPrice();
        if (amountService.hasEnoughAmount(price)) {
            vm.setCurrentState(new DispenseProductState(vm));
            vm.getCurrentState().dispenseItem(vm.getCurrentItem());
        }
        else {
            System.out.println("First insert valid amount");
            vm.setCurrentState(new IdleState(vm));
        }
    }

    @Override
    public void selectItem(int itemNum) {
        System.out.println("Fisrt insert the coin");
    }

    @Override
    public void dispenseItem(int item) {
        System.out.println("Fisrt insert the coin");
    }

    @Override
    public void returnCoin() {
        System.out.println("Fisrt insert the coin");
    }
}
