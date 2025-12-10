package low_level_design1.my_atm.states;

import low_level_design1.my_atm.enums.AtmState;
import low_level_design1.my_atm.model.Atm;
import low_level_design1.my_atm.model.Card;
import low_level_design1.my_atm.services.ICardService;
import low_level_design1.my_atm.services.ICashDispenseService;
import low_level_design1.my_atm.services.IStartTransactionService;

public class StartTransactionState implements StateInterface {
    private Atm atm;
    private IStartTransactionService startTransactionService;// TODO make it interface
    private final ICardService cardService;
    private final ICashDispenseService cashDispenseService;

    public StartTransactionState(Atm atm, IStartTransactionService s, ICardService c, ICashDispenseService cd) {
        this.atm = atm;
        startTransactionService = s;
        cardService = c;
        this.cashDispenseService=cd;
    }

    @Override
    public int startTransaction() {
        int txnId = startTransactionService.initTransaction();
        if (txnId > 0)
            atm.changeState(new ReadCardDetailsAndPinState(atm, cardService,cashDispenseService));
        else {
            // TODO
        }
        return txnId;
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, int pin, int txId) {
        throw new IllegalStateException("invalid state at this point");
    }

    @Override
    public boolean readCashWithdrawDetails(int amount, int txId) {
        return false;
    }

    @Override
    public boolean readCashWithdrawDetails(int amount) {
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
        throw new IllegalStateException("invalid state at this point");
    }

    @Override
    public void cancelTransaction(int trId) {
        throw new IllegalStateException("invalid state at this point");
    }
}
