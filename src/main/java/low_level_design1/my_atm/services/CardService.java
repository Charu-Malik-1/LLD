package low_level_design1.my_atm.services;

import low_level_design1.my_atm.apis.BackendApi;
import low_level_design1.my_atm.apis.NodeBackendApi;
import low_level_design1.my_atm.model.Card;

public class CardService implements ICardService{
    private BackendApi backendApi;

    public CardService(BackendApi b) {
        backendApi = b;
    }

    @Override
    public boolean validateCardDetails(Card card, int pin, int txnId) {
        return backendApi.validateCardDetails(card, pin, txnId);
    }

    @Override
    public boolean validateAmount(int amount, int txId) {
        return backendApi.validateAmount(amount, txId);
    }
}
