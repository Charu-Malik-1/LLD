package low_level_design1.my_atm.apis;

import low_level_design1.atm.dto.CreateTransactionDTO;
import low_level_design1.atm.dto.GetAtmAmountRequestDTO;
import low_level_design1.atm.dto.UpdateAtmStateDto;
import low_level_design1.my_atm.dto.ValidateCardDetailsDTO;
import low_level_design1.my_atm.dto.ValidateWithdrawlAmountWithBankDTO;

public class PythonBackendApi implements BackendApi{
    @Override
    public int createTransaction(CreateTransactionDTO createTransactionDTO)
    {
        if(createTransactionDTO.getAtmId()==-1)
            throw new IllegalStateException("Atm id cannot be null");
        return (int)Math.random();
    }

    @Override
    public boolean validateCardDetailsWithBank(ValidateCardDetailsDTO v) {
        return false;
    }

    @Override
    public boolean validateAmountWithBank(ValidateWithdrawlAmountWithBankDTO v) {
        return false;
    }

    @Override
    public boolean dispenseCash(int txId, int amount) {
        return false;
    }
    @Override
    public boolean updateStatusInBank(UpdateAtmStateDto u) {
        //it will talk to bank server if backend is successfully update the bank server
        return true;
    }

    @Override
    public int getAtmAmount(GetAtmAmountRequestDTO a) {
        return 0;
    }
}
