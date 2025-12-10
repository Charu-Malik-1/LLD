package low_level_design1.my_atm.apis;
import low_level_design1.my_atm.model.Card;
public interface BackendApi {
    int startTransaction();
    boolean validateCardDetails(Card card, int pin, int txnId);
    boolean validateAmount(int amount, int txId);
    boolean dispenseCash(int txId, int amount);
}
