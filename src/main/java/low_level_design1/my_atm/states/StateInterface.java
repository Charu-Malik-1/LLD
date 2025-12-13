package low_level_design1.my_atm.states;

import low_level_design1.my_atm.enums.AtmState;
import low_level_design1.my_atm.model.Card;

public interface StateInterface {
    int startTransaction(Card card,int amount);
    boolean readCardDetailsAndPin(Card card, int pin,int txId);
    boolean readCashWithdrawDetails(Card card,int amount, int txId);
    int dispenseCash(int traId, int amount);
    boolean ejectCard();
    AtmState getState();
    boolean cancelTransaction(int trId);
}
