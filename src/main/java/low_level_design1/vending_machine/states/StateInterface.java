package low_level_design1.vending_machine.states;

public interface State {

    void insertCoin(double amount);
    void pressButton(int aisleNum);
    void dispense(int aisleNum);

}
