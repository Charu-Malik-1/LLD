package low_level_design1.my_atm.apis;
import low_level_design1.atm.dto.CreateTransactionDTO;
import low_level_design1.atm.dto.GetAtmAmountRequestDTO;
import low_level_design1.atm.dto.UpdateAtmStateDto;
import low_level_design1.my_atm.model.Card;
public interface BackendApi {
    int createTransaction(CreateTransactionDTO createTransactionDTO);
    boolean validateCardDetailsWithBank(Card card, int pin, int txnId);
    boolean validateAmountWithBack(int amount, int txId);
    boolean dispenseCash(int txId, int amount);
    boolean updateStatusInBank(UpdateAtmStateDto u);
    int getAtmAmount(GetAtmAmountRequestDTO a);
}
