package low_level_design1.atm.states;

import low_level_design1.atm.models.Card;
import low_level_design1.atm.enums.ATMState;

public interface StateInterface {
    int startTransaction();
    boolean readCardDetailsAndPin(Card card,String pin);
    boolean readCashWithdrawlDetails(Card card,int trId,int amount);
    int dispenseCash(Card card,int amt,int trId);
    boolean ejectCard();
    ATMState getState();
    boolean cancelTransaction(int trId);
}
