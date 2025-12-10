package low_level_design1.my_vendingMachine.states;

import low_level_design1.my_vendingMachine.enums.VMState;
import low_level_design1.my_vendingMachine.model.Product;
import low_level_design1.my_vendingMachine.model.VendingMachine;
import low_level_design1.my_vendingMachine.services.InventoryService;

public class DispenseProductState implements StateInterface {
    private final VendingMachine vm;
    private final int returnAmount;
    private InventoryService inventoryService;

    public DispenseProductState(VendingMachine vm, int returnAmt) {
        this.vm = vm;
        returnAmount = returnAmt;
        inventoryService = new InventoryService();
    }

    @Override
    public void returnCoin() {
        throw new IllegalStateException("Cannot return coin at this point");
    }

    @Override
    public void dispenseItem(int aiselNum) {
        // reduce the inventory by 1
        Product p1 = inventoryService.getItem(aiselNum);
        if(p1==null){
         System.out.println("Issue with dispensing machine, returning your money..");
         vm.changeState(new ReturnAmountState(vm,vm.getCurrentAmount()));
        }
        else {
            inventoryService.reduceInventory(p1);
        }
        // also return the remaining amount
        if (returnAmount == 0)
            vm.changeState(new NoCoinState(vm));
        else
            vm.changeState(new ReturnAmountState(vm, returnAmount));
    }

    @Override
    public void insertCoin(int amount) {
        throw new IllegalStateException("no coin inserted");
    }

    @Override
    public void selectItem(int buttonNum) {
        throw new IllegalStateException("no coin inserted");
    }

    @Override
    public void refill() {
        throw new IllegalStateException("hhh");
    }

    @Override
    public VMState getState() {
        return VMState.DISPENSING_PRODUCT;
    }
}
