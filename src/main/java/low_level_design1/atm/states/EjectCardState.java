package low_level_design1.atm.states;

import low_level_design1.atm.backendApis.NodeBackendApi;
import low_level_design1.atm.models.Card;
import low_level_design1.atm.enums.ATMState;
import low_level_design1.atm.models.Atm;

public class EjectCardState implements StateInterface {
    private final Atm atm;
    public EjectCardState(Atm atm) {
        this.atm = atm;
    }
    @Override
    public boolean ejectCard() {
        System.out.println("card ejected");
        atm.changeState(new ReadyForTransactionState(atm));
        return true;
    }

    @Override
    public int startTransaction() {
        throw new IllegalStateException("ATM is currently busy with other transaction");
    }

    @Override
    public boolean readCardDetailsAndPin(Card card,String pin) {
        throw new IllegalStateException("ATM is currently busy with other transaction");
    }

    @Override
    public boolean readCashWithdrawlDetails(Card card,int trId,int amount){
        throw new IllegalStateException("ATM is currently busy with other transaction");
    }

    @Override
    public int dispenseCash(Card card,int amt,int trId) {
        throw new IllegalStateException("ATM is currently busy with other transaction");
    }

    @Override
    public ATMState getState() {
        return ATMState.EJECT_CARD;
    }

    @Override
    public boolean cancelTransaction(int trId) {
        throw new IllegalStateException("ATM is currently busy with other transaction");
    }
}
