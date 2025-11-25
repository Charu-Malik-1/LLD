package low_level_design1.vending_machine.states;

import low_level_design1.vending_machine.VendingMachine;
import low_level_design1.vending_machine.enums.VendingMachineState;

public class NoCoinInsertedState implements State{
    VendingMachine vm;
    public NoCoinInsertedState(VendingMachine vm){
        this.vm=vm;
    }
    @Override
    public void insertCoin(double amount) {
        vm.setAmount(amount);
        vm.setCurVendingMachineState(vm.getCoinInsertedState());
    }

    @Override
    public void pressButton(int aisleNum) {
        throw new IllegalStateException("no coin inserted");
    }

    @Override
    public void dispense(int aisleNum) {
        throw new IllegalStateException("no coin inserted");
    }
}
