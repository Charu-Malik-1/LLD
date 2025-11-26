package low_level_design1.atm.services;

import low_level_design1.atm.backendApis.NodeBackendApi;
import low_level_design1.atm.models.Card;

public class DebitCardManagerService implements CardManagerService {
    private final NodeBackendApi nodeBackendApi;
    public DebitCardManagerService(){
        nodeBackendApi=new NodeBackendApi();
    }
    @Override
    public boolean validateCard(Card card, String pin) {
        // will call the bank server api and do business logic
        return false;
    }

    @Override
    public boolean validateWithdrawl(int tranId, double amount) {
        // will call the bank server api and do business logic
        return false;
    }

    @Override
    public boolean doTransaction(Card card, double amount, int transactionId) {
        // will call the bank server api and do business logic
        return false;
    }
}
