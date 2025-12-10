package low_level_design1.my_atm.states;

import low_level_design1.my_atm.enums.AtmState;
import low_level_design1.my_atm.model.Card;

public interface StateInterface {
    int startTransaction();
    boolean readCardDetailsAndPin(Card card, int pin,int txId);
    boolean readCashWithdrawDetails(int amount,int txId);

    boolean readCashWithdrawDetails(int amount);

    int dispenseCash(int traId, int amount);
    boolean ejectCard();
    AtmState getState();
    void cancelTransaction(int trId);
}
