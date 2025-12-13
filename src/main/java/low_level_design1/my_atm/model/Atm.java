package low_level_design1.my_atm.model;

import lombok.Getter;
import lombok.Setter;
import low_level_design1.my_atm.services.ICashDispenseService;
import low_level_design1.my_atm.services.IStartTransactionService;
import low_level_design1.my_atm.states.ReadyForTransactionState;
import low_level_design1.my_atm.states.StateInterface;

@Getter
@Setter
public class Atm {
    private final int atmId;
    private StateInterface currentState;  // ← Added this

    // IMP this was we get the services , all services should attach to ATM, not pass from 1 state to other
    private final ICashDispenseService cashDispenseService;
    private IStartTransactionService startTransactionService;

    public Atm(int atmId, ICashDispenseService cashDispenseService, IStartTransactionService s1) {
        this.atmId = atmId;
        currentState = new ReadyForTransactionState(this);
        this.cashDispenseService = cashDispenseService;
        this.startTransactionService = s1;
    }

    public void changeState(StateInterface newState) {
        // It change the current state of Atm in Atm Machine, but we have to change this state in bank server also
        currentState = newState;
        // todo update the state in backedn also
//        this.backendApi.updateStatus(new UpdateAtmStateDto(atmId,newState.getState()));
    }

    public IStartTransactionService getStartTransactionService() {
        return startTransactionService;
    }

    public ICashDispenseService getCashDispenseService() {
        return cashDispenseService;
    }

    // ← Added these delegate methods:
    public int startTransaction(Card card) {
        return currentState.startTransaction(card);
    }

    public boolean readCardDetailsAndPin(Card card, int pin, int txId) {
        return currentState.readCardDetailsAndPin(card, pin, txId);
    }

    public boolean readCashWithdrawDetails(Card card, int amount, int txId) {
        return currentState.readCashWithdrawDetails(card, amount, txId);
    }

    public int dispenseCash(int txId, int amount) {
        return currentState.dispenseCash(txId, amount);
    }

    public boolean ejectCard() {
        return currentState.ejectCard();
    }

    public void cancelTransaction(int trId) {
        currentState.cancelTransaction(trId);
    }
}
