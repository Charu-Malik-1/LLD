package low_level_design1.vending_machine;

import lld.atm1.state.DispenseCashState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import low_level_design1.vending_machine.enums.VendingMachineState;
import low_level_design1.vending_machine.states.CoinInsertedState;
import low_level_design1.vending_machine.states.DispenseState;
import low_level_design1.vending_machine.states.NoCoinInsertedState;
import low_level_design1.vending_machine.states.State;

import low_level_design1.vending_machine.states.State;

@AllArgsConstructor
@Getter
@Setter
public class VendingMachine {
    private double amount;
    private State curVendingMachineState;
    private NoCoinInsertedState noCoinInsertedState;
    private CoinInsertedState coinInsertedState;
    private DispenseState dispenseState;
    private Inventory inventory;
    public VendingMachine(){
        amount=0;
        noCoinInsertedState=new NoCoinInsertedState(this);
        coinInsertedState=new CoinInsertedState(this);
        dispenseState=new DispenseState(this);
        curVendingMachineState=noCoinInsertedState;
        inventory=new Inventory(2);
    }

    public boolean hasSufficientAmount(double expectedAmt){
        return expectedAmt<=this.amount;
    }

    public void insertCoin(double amount){
        this.curVendingMachineState.insertCoin(amount);
        System.out.println(amount+" coin is inserted");
    }

    public void pressButton(int aisleNum){
        this.curVendingMachineState.pressButton(aisleNum);
        this.curVendingMachineState.dispense(aisleNum);
    }

    public void addProduct(Product p){
        try{
            getInventory().addProduct(p);
        }catch(Exception e){}
    }

}
