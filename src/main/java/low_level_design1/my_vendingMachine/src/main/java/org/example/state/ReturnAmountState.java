package org.example.state;

import lombok.Getter;
import lombok.Setter;
import org.example.model.VendingMachine;

@Getter
public class ReturnAmountState implements StateInterface {
    private final VendingMachine vm;
    private final int amount;

    public ReturnAmountState(VendingMachine vm, int amount) {
        this.vm = vm;
        this.amount = amount;
    }

    @Override
    public void insertCoin(int coin) {
        System.out.println("cannot insert the coin");
    }

    @Override
    public void selectItem(int itemNum) {
        System.out.println("cannot select item");
    }

    @Override
    public void dispenseItem(int item) {
        System.out.println("cannot dispense item");
    }

    @Override
    public void returnCoin() {
        System.out.println("return amount=" + amount);
        vm.setCurrentState(new IdleState(vm));
    }
}
