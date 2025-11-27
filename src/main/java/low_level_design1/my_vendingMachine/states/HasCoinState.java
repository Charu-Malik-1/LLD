package low_level_design1.my_vendingMachine.states;

import low_level_design1.my_vendingMachine.enums.VMState;
import low_level_design1.my_vendingMachine.model.Product;
import low_level_design1.my_vendingMachine.model.VendingMachine;
import low_level_design1.my_vendingMachine.services.AmountService;
import low_level_design1.my_vendingMachine.services.InventoryService;

public class HasCoinState implements StateInterface {
    private final VendingMachine vm;
    private final AmountService amountService; // TODO change it to interface
    private InventoryService inventoryService;// todo change to interface

    public HasCoinState(VendingMachine vm) {
        this.vm = vm;
        amountService = new AmountService();
        inventoryService = new InventoryService();
    }

    @Override
    public void insertCoin(int amount) {
        // validate amount
        boolean isAmountValid = amountService.validateAmount(amount);
        if (isAmountValid) {
            vm.setCurrentAmount(amount + vm.getCurrentAmount());
        } else {
            // todo
        }
    }

    @Override
    public void selectItem(int buttonNum) {
        Product p = inventoryService.getItem(buttonNum);
        // item is available and amount is also sufficient
        if (p!=null && p.getPrice() <= vm.getCurrentAmount()) {
          vm.changeState(new DispenseProductState(vm,vm.getCurrentAmount()-p.getPrice()));
        }
        else
            throw new IllegalStateException("dd");
    }

    @Override
    public void returnCoin() {
        throw new IllegalStateException("illegal");
    }

    @Override
    public void dispenseItem(int aiselNum) {
        throw new IllegalStateException("illegal");
    }

    @Override
    public void refill() {
        throw new IllegalStateException("illegal");
    }

    @Override
    public VMState getState() {
        return VMState.COIN_INSERTED_STATE;
    }
}
