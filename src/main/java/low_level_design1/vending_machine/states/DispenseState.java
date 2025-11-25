package low_level_design1.vending_machine.states;

import low_level_design1.vending_machine.Inventory;
import low_level_design1.vending_machine.Product;
import low_level_design1.vending_machine.VendingMachine;


public class DispenseState implements State{
    private VendingMachine vendingMachine;
    public DispenseState(VendingMachine vm){
        this.vendingMachine=vm;
    }
    @Override
    public void insertCoin(double amount) {
        throw new IllegalStateException("no coin inserted");
    }

    @Override
    public void pressButton(int aisleNum) {
        throw new IllegalStateException("no coin inserted");
    }

    @Override
    public void dispense(int aisleNum) {
        Inventory inventory= vendingMachine.getInventory();
        Product product=inventory.getProductAt(aisleNum);
        inventory.deductProductCount(aisleNum);
        double change= vendingMachine.getAmount()- product.getPrice();
        vendingMachine.setAmount(0);
        vendingMachine.setCurVendingMachineState(vendingMachine.getNoCoinInsertedState());
    }
}
