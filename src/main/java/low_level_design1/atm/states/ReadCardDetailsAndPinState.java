package low_level_design1.atm.states;

import low_level_design1.atm.backendApis.NodeBackendApi;
import low_level_design1.atm.enums.CardType;
import low_level_design1.atm.factories.CardManagerFactory;
import low_level_design1.atm.models.Card;
import low_level_design1.atm.enums.ATMState;
import low_level_design1.atm.models.Atm;
import low_level_design1.atm.services.CardManagerService;

public class ReadCardDetailsAndPinState implements StateInterface {
    private final Atm atm;

    public ReadCardDetailsAndPinState(Atm atm) {
        this.atm = atm;
    }
    @Override
    public boolean readCardDetailsAndPin(Card card,String pin) {

        // later if card logic will change we need to change only in factory
        CardManagerService manager=CardManagerFactory.getCardManager(card.getCardType());
        boolean isCardValid=manager.validateCard(card,pin);
        if(isCardValid)
            this.atm.changeState(new ReadCashWithdrawState(atm));
        else {
            this.atm.changeState(new EjectCardState(atm));
        }
        return isCardValid;
    }
    @Override
    public boolean cancelTransaction(int traId){
        this.atm.changeState(new ReadyForTransactionState(atm));
        return true;
    }

      @Override
    public boolean readCashWithdrawlDetails(Card card,int trId,int amount){
        throw new IllegalStateException("ATM is currently busy with other transaction");
    }


    @Override
    public int startTransaction() {
        throw new IllegalStateException("ATM is currently busy with other transaction");
    }

    @Override
    public int dispenseCash(Card card,int amt,int trId) {
        throw new IllegalStateException("ATM is currently busy with other transaction");
    }

    @Override
    public boolean ejectCard() {
        throw new IllegalStateException("ATM is currently busy with other transaction");
    }

    @Override
    public ATMState getState() {
        return ATMState.READ_CARD_DETAILS_AND_PIN;
    }


}
