package low_level_design1.vending_machine.states;

import low_level_design1.vending_machine.Inventory;
import low_level_design1.vending_machine.Product;
import low_level_design1.vending_machine.VendingMachine;

public class CoinInsertedState implements State{
    VendingMachine vendingMachine;
    public CoinInsertedState(VendingMachine vendingMachine){
        this.vendingMachine=vendingMachine;
    }

    @Override
    public void insertCoin(double amount) {
        vendingMachine.setAmount(amount);
    }

    @Override
    public void pressButton(int aisleNum) {
        Inventory inventory=vendingMachine.getInventory(aisleNum);
        Product product=inventory.getProductAt(aisleNum);
        if(!vendingMachine.hasSufficientAmount(product.getId())){
            throw new IllegalStateException("Insufficient amt");
        }
        if(!inventory.checkIfProductAvailable(product.getId())){
            throw new IllegalStateException("product num");
        }
        vendingMachine.setCurVendingMachineState(vendingMachine.getState());
    }

    @Override
    public void dispense(int aisleNum) {
        throw new IllegalStateException(" product not choosen");
    }
}
