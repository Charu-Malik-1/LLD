package low_level_design1.my_vendingMachine.states;

import low_level_design1.my_vendingMachine.enums.VMState;
import low_level_design1.my_vendingMachine.model.VendingMachine;


public class NoCoinState implements StateInterface {
    private final VendingMachine vm;
    public NoCoinState(VendingMachine vm) {
        this.vm = vm;
    }

    @Override
    public void insertCoin(int amount) {
        // validate amount
        boolean isAmountValid = vm.getAmountService().validateAmount(amount);
        if (isAmountValid) {
            vm.setCurrentAmount(amount);
            vm.changeState(new HasCoinState(vm));
        } else {
            System.out.println("Please insert the valid coin");
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
