package low_level_design1.my_atm.apis;

import low_level_design1.atm.dto.CreateTransactionDTO;
import low_level_design1.atm.dto.UpdateAtmStateDto;
import low_level_design1.my_atm.model.Card;

public class PythonBackendApi implements BackendApi{
    @Override
    public int createTransaction(CreateTransactionDTO createTransactionDTO)
    {
        if(createTransactionDTO.getAtmId()==null || createTransactionDTO.getAtmId().isEmpty())
            throw new IllegalStateException("Atm id cannot be null");
        return (int)Math.random();
    }

    @Override
    public boolean validateCardDetailsWithBank(Card card, int pin, int txnId) {
        return false;
    }

    @Override
    public boolean validateAmountWithBack(int amount, int txId) {
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
}
