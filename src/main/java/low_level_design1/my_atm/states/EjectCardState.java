package low_level_design1.my_atm.states;

import low_level_design1.my_atm.enums.AtmState;
import low_level_design1.my_atm.model.Atm;
import low_level_design1.my_atm.model.Card;

public class EjectCardState implements StateInterface {
    private final Atm atm;

    public EjectCardState(Atm atm) {
        this.atm = atm;
    }


    @Override
    public int startTransaction(Card card,int amt) {
        return 0;
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, int pin, int txId) {
        return false;
    }

    @Override
    public boolean readCashWithdrawDetails(Card card, int amount, int txId) {
        return false;
    }

    @Override
    public int dispenseCash(int traId, int amount) {
        return 0;
    }

    @Override
    public boolean ejectCard() {
        atm.changeState(new ReadyForTransactionState(atm));
        return true;
    }

    @Override
    public AtmState getState() {
        return AtmState.EJECT_CARD;
    }

    @Override
    public boolean cancelTransaction(int trId) {
        atm.changeState(new ReadyForTransactionState(atm));
        return true;
    }
}
