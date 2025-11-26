package low_level_design1.atm.services;

import low_level_design1.atm.backendApis.NodeBackendApi;
import low_level_design1.atm.models.Card;
import org.w3c.dom.Node;

public class CreditCardManagerService implements CardManagerService{
    private final NodeBackendApi nodeBackendApi;
    public CreditCardManagerService(){
        nodeBackendApi=new NodeBackendApi();
    }
    @Override
    public boolean validateCard(Card card, String pin) {
        // make dto, call backend aoi, do business logic
        return true;
    }

    @Override
    public boolean validateWithdrawl(int transId, double amount) {
        // make dto, call backend api, do business logic
        return true;
    }

    @Override
    public boolean doTransaction(Card card, double amount, int transactionId) {
        // make dto, call backend api, do business logic
        return true;
    }
}
