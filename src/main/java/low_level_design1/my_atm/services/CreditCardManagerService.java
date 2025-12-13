package low_level_design1.my_atm.services;

import low_level_design1.atm.dto.CreateTransactionDTO;
import low_level_design1.my_atm.apis.BackendApi;
import low_level_design1.my_atm.dto.ValidateCardDetailsDTO;
import low_level_design1.my_atm.dto.ValidateWithdrawlAmountWithBankDTO;
import low_level_design1.my_atm.model.Card;

public class CreditCardManagerService implements CardManagerService {
    private BackendApi backendApi;

    // this service will communicate with backend api
    public CreditCardManagerService(BackendApi b) {
        backendApi = b;
    }

    @Override
    public boolean validateCardDetails(Card card, int pin, int txnId) {
        ValidateCardDetailsDTO v=new ValidateCardDetailsDTO(card,pin,txnId);
        return backendApi.validateCardDetailsWithBank(v);
    }

    @Override
    public boolean validateWithdrawlAmount(int atmId,int txId, int amount) {
        //call the bank server api and do business logic
        ValidateWithdrawlAmountWithBankDTO v=new ValidateWithdrawlAmountWithBankDTO(amount,txId);
        return backendApi.validateAmountWithBank(v);
    }

    @Override
    public int doTransaction(int atmId,Card card, int amount) {
        CreateTransactionDTO c=new CreateTransactionDTO(atmId,card,amount);
        return backendApi.createTransaction(c);
    }


}
