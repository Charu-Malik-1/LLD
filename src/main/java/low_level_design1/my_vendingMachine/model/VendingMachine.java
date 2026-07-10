package low_level_design1.my_vendingMachine.model;

import lombok.Getter;
import lombok.Setter;
import low_level_design1.my_vendingMachine.enums.VMState;
import low_level_design1.my_vendingMachine.inventories.Inventory;
import low_level_design1.my_vendingMachine.services.AmountService;
import low_level_design1.my_vendingMachine.services.InventoryService;
import low_level_design1.my_vendingMachine.states.NoCoinState;
import low_level_design1.my_vendingMachine.states.StateInterface;

@Getter
@Setter
public class VendingMachine {
    private int currentAmount;
    private StateInterface currentState;
    private InventoryService inventoryService;
    private AmountService amountService;

    public VendingMachine(InventoryService inventory, AmountService amountService) {
        currentAmount = 0;
        currentState = new NoCoinState(this);
        this.inventoryService = inventory;
        this.amountService=amountService;
    }

    public void changeState(StateInterface curState) {
        currentState = curState;
    }
}
