package low_level_design1.my_atm.services;

import low_level_design1.my_atm.apis.BackendApi;
import low_level_design1.my_atm.model.Card;

public class DebitCardManagerService implements CardManagerService {
    private BackendApi backendApi;
// TODO use DTO
    // this service will communicate with backend api
    public DebitCardManagerService(BackendApi b) {
        backendApi = b;
    }

    @Override
    public boolean validateCardDetails(Card card, int pin, int txnId) {
        // backend might accept other DTO TODO
        return backendApi.validateCardDetailsWithBank(card, pin, txnId);
    }

    @Override
    public boolean validateWithdrawl(int txId, int amount) {
        //call the bank server api and do business logic
        return backendApi.validateAmountWithBack(amount, txId);
    }

    @Override
    public boolean doTransaction(Card card, int amount, int txId) {
        return backendApi.createTransaction();
    }
}
