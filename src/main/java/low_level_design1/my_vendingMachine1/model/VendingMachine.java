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
    private Inventory inventory;
    private static VendingMachine instance;
    private final InventoryService inventoryService;
    private final AmountService amountService;

    public static VendingMachine getVendingMachineInstance(Inventory inventory, InventoryService inventoryService, AmountService amountService) {
        instance = new VendingMachine(inventory, inventoryService, amountService);
        return instance;
    }

    private VendingMachine(Inventory inventory, InventoryService inventoryService, AmountService amountService) {
        currentAmount = 0;
        currentState = new NoCoinState(this);
        this.inventory = inventory;
        this.inventoryService = inventoryService;
        this.amountService = amountService;
    }

    public void changeState(StateInterface curState) {
        currentState = curState;
    }

    public void insertCoin(int amount) {
        currentState.insertCoin(amount);
    }

    public void selectItem(int button) {
        currentState.selectItem(button);
    }

    public void dispenseItem(int aiselNum) {
        currentState.dispenseItem(aiselNum);
    }

    public void returnCoin() {
        currentState.returnCoin();
    }
}
