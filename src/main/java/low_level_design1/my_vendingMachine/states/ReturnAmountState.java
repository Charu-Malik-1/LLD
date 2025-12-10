package low_level_design1.my_vendingMachine.states;

import low_level_design1.my_vendingMachine.enums.VMState;
import low_level_design1.my_vendingMachine.model.VendingMachine;

public class ReturnAmountState implements StateInterface {
    private final VendingMachine vm;
    private final int returnAmount;

    public ReturnAmountState(VendingMachine vm, int returnAmt) {
        this.vm = vm;
        returnAmount = returnAmt;
    }

    @Override
    public void returnCoin() {
        System.out.println("return amt"+returnAmount);
        vm.changeState(new NoCoinState(vm));
    }

    @Override
    public void insertCoin(int amount) {
        throw new IllegalStateException("ddd");
    }

    @Override
    public void selectItem(int buttonNum) {
        throw new IllegalStateException("ddd");
    }



    @Override
    public void dispenseItem(int aiselNum) {
        throw new IllegalStateException("ddd");
    }

    @Override
    public void refill() {
        throw new IllegalStateException("ddd");
    }

    @Override
    public VMState getState() {
        return VMState.RETURN_COIN_STATE;
    }
}
