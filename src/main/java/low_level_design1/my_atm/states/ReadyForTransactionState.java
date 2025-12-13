package low_level_design1.my_atm.states;

import low_level_design1.my_atm.enums.AtmState;
import low_level_design1.my_atm.model.Atm;
import low_level_design1.my_atm.model.Card;

public class ReadyForTransactionState implements StateInterface {
    private Atm atm;


    public ReadyForTransactionState(Atm atm) {
        this.atm = atm;
    }

    @Override
    public int startTransaction(Card card) {
        // change the atm state in backedn
        int txId=atm.getStartTransactionService().initTransaction(atm);
        //change the atm state in current physical atm
        this.atm.changeState(new ReadCardDetailsAndPinState(atm,card));
        return txId;
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, int pin, int txId) {
        throw new IllegalStateException("invalid state at this point");
    }

    @Override
    public boolean readCashWithdrawDetails(Card card,int amount, int txId) {
        throw new IllegalStateException("invalid state at this point");
    }

    @Override
    public int dispenseCash(int traId, int amount) {
        throw new IllegalStateException("invalid state at this point");
    }

    @Override
    public boolean ejectCard() {
        throw new IllegalStateException("invalid state at this point");
    }

    @Override
    public AtmState getState() {
        return AtmState.START_TRANSACTION;
    }

    @Override
    public boolean cancelTransaction(int trId) {
        throw new IllegalStateException("invalid state at this point");
    }
}
