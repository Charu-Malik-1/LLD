package low_level_design1.my_atm.states;

import low_level_design1.my_atm.enums.AtmState;
import low_level_design1.my_atm.model.Atm;
import low_level_design1.my_atm.model.Card;
import low_level_design1.my_atm.services.ICardService;
import low_level_design1.my_atm.services.ICashDispenseService;

public class ReadCardDetailsAndPinState implements StateInterface {
    private final Atm atm;
    private final ICardService cardService;
    private final ICashDispenseService cashDispenseService;

    public ReadCardDetailsAndPinState(Atm atm, ICardService c, ICashDispenseService cd) {
        this.atm = atm;
        cardService = c;
        cashDispenseService = cd;
    }

    @Override
    public int startTransaction() {
        return 0;
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, int pin, int txId) {
        // check the card type,
        // validate card details with backend
        //if valid change atm state to next state
        //todo add code for card
        boolean isValid = cardService.validateCardDetails(card, pin, txId);
        if (isValid)
            atm.changeState(new ReadCashWithdrawState(atm, cardService, cashDispenseService));
        else
            atm.changeState(new EjectCardState(atm));
        return isValid;
    }

    @Override
    public boolean readCashWithdrawDetails(int amount, int txId) {
        return false;
    }

    @Override
    public boolean readCashWithdrawDetails(int amount) {
        return false;
    }

    @Override
    public int dispenseCash(int traId, int amount) {
        return 0;
    }

    @Override
    public boolean ejectCard() {
        return false;
    }

    @Override
    public AtmState getState() {
        return null;
    }

    @Override
    public void cancelTransaction(int trId) {

    }
}
