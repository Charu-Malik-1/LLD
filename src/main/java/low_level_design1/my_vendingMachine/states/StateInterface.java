package low_level_design1.my_vendingMachine.states;

import low_level_design1.my_vendingMachine.enums.VMState;

public interface StateInterface {

    void insertCoin(int amount);
    void selectItem(int buttonNum);
    void returnCoin();
    void dispenseItem(int aiselNum);
    void refill();
    VMState getState();
}
