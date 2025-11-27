package low_level_design1.my_vendingMachine.model;

import lombok.Getter;
import lombok.Setter;
import low_level_design1.my_vendingMachine.enums.VMState;
import low_level_design1.my_vendingMachine.inventories.Inventory;
import low_level_design1.my_vendingMachine.states.NoCoinState;
import low_level_design1.my_vendingMachine.states.StateInterface;

@Getter
@Setter
public class VendingMachine {
    private int currentAmount;
    private StateInterface currentState;
    private Inventory inventory;

    public VendingMachine() {
        currentAmount = 0;
        currentState = new NoCoinState(this);
    }

    public void changeState(StateInterface curState) {
        currentState = curState;
    }
}
