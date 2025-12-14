package low_level_design1.my_atm.apis;

import low_level_design1.my_atm.dto.UpdateAtmStateDto;
import low_level_design1.my_atm.dto.GetAtmAmountRequestDTO;
import low_level_design1.my_atm.dto.CreateTransactionDTO;
import low_level_design1.my_atm.dto.ValidateCardDetailsDTO;
import low_level_design1.my_atm.dto.ValidateWithdrawlAmountWithBankDTO;
import low_level_design1.my_atm.model.Card;
public interface BackendApi {
    int createTransaction(CreateTransactionDTO createTransactionDTO);
    boolean validateCardDetailsWithBank(ValidateCardDetailsDTO v);
    boolean validateAmountWithBank(ValidateWithdrawlAmountWithBankDTO v);
    boolean dispenseCash(int txId, int amount);
    boolean updateStatusInBank(UpdateAtmStateDto u);
    int getAtmAmount(GetAtmAmountRequestDTO a);
}
