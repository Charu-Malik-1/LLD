package low_level_design1.my_atm.states;

import low_level_design1.my_atm.apis.BackendApi;
import low_level_design1.my_atm.enums.AtmState;
import low_level_design1.my_atm.factories.CardManagerFactory;
import low_level_design1.my_atm.model.Atm;
import low_level_design1.my_atm.model.Card;
import low_level_design1.my_atm.services.CardManagerService;
import low_level_design1.my_atm.services.ICashDispenseService;

public class ReadCardDetailsAndPinState implements StateInterface {
    private final Atm atm;

    public ReadCardDetailsAndPinState(Atm atm) {
        this.atm = atm;
    }

    @Override
    public int startTransaction(Card card) {
        throw new IllegalStateException("invalid state at this point");
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, int pin, int txId) {
        // check the card type,
        // validate card details with backend
        //if valid change atm state to next state
        //todo add code for card
        CardManagerService cms=CardManagerFactory.getCardManager(card.getCardType());
        boolean isValid = cms.validateCardDetails(card, pin, txId);
        if (isValid)
            atm.changeState(new ReadCashWithdrawState(atm));
        else
            atm.changeState(new EjectCardState(atm));
        return isValid;
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
        return AtmState.READ_CARD_DETAILS_AND_PIN;
    }

    @Override
    public boolean cancelTransaction(int trId) {
        atm.changeState(new ReadyForTransactionState(atm));
        return true;
    }
}
