package low_level_design1.my_atm.services;

import low_level_design1.my_atm.apis.NodeBackendApi;
import low_level_design1.my_atm.model.Card;

public interface ICardService {

    public boolean validateCardDetails(Card card, int pin, int txnId) ;

    public boolean validateAmount(int amount, int txId) ;
}
