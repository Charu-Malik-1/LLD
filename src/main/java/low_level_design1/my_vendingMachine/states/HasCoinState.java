package low_level_design1.my_vendingMachine.states;

import low_level_design1.my_vendingMachine.enums.VMState;
import low_level_design1.my_vendingMachine.model.Product;
import low_level_design1.my_vendingMachine.model.VendingMachine;
import low_level_design1.my_vendingMachine.services.AmountService;
import low_level_design1.my_vendingMachine.services.InventoryService;

public class HasCoinState implements StateInterface {
    private final VendingMachine vm;

    public HasCoinState(VendingMachine vm) {
        this.vm = vm;
    }

    @Override
    public void insertCoin(int amount) {
        // validate amount
        boolean isAmountValid = vm.getAmountService().validateAmount(amount);
        if (isAmountValid) {
            vm.setCurrentAmount(amount + vm.getCurrentAmount());
        } else {
            System.out.println("Inserted coin is not valid coin");
        }
    }

    @Override
    public void selectItem(int buttonNum) {
        Product p = vm.getInventoryService().getItem(buttonNum);
        // item is available and amount is also sufficient
        if (p != null && p.getPrice() <= vm.getCurrentAmount()) {
            vm.changeState(new DispenseProductState(vm, vm.getCurrentAmount() - p.getPrice()));
        } else {
            if (p == null)
                throw new IllegalStateException("Item not available");
            else if (p.getPrice() > vm.getCurrentAmount())
                throw new IllegalStateException("Selected item is of more price");
        }

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
