package low_level_design1.my_vendingMachine.states;

import low_level_design1.my_vendingMachine.enums.VMState;
import low_level_design1.my_vendingMachine.model.VendingMachine;
import low_level_design1.my_vendingMachine.services.AmountService;

public class NoCoinState implements StateInterface {
    private final VendingMachine vm;
    private final AmountService amountService; // TODO change it to interface

    public NoCoinState(VendingMachine vm) {
        this.vm = vm;
        amountService = new AmountService();
    }

    @Override
    public void insertCoin(int amount) {
        // validate amount
        boolean isAmountValid = amountService.validateAmount(amount);
        if (isAmountValid) {
            vm.setCurrentAmount(amount);
            vm.changeState(new HasCoinState(vm));
        } else {
            // todo
        }
    }

    @Override
    public void selectItem(int buttonNum) {
        throw new IllegalStateException("hhh");
    }

    @Override
    public void returnCoin() {
        throw new IllegalStateException("hhh");
    }

    @Override
    public void dispenseItem(int aiselNum) {
        throw new IllegalStateException("hhh");
    }

    @Override
    public void refill() {
        throw new IllegalStateException("hhh");
    }

    @Override
    public VMState getState() {
        return VMState.NO_COIN_INSERTED_STATE;
    }
}
