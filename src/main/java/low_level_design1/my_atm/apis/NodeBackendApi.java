package low_level_design1.my_atm.apis;

import low_level_design1.atm.dto.CreateTransactionDTO;
import low_level_design1.atm.dto.GetAtmAmountRequestDTO;
import low_level_design1.atm.dto.UpdateAtmStateDto;
import low_level_design1.my_atm.dto.ValidateCardDetailsDTO;
import low_level_design1.my_atm.dto.ValidateWithdrawlAmountWithBankDTO;
import low_level_design1.my_atm.model.Card;

public class NodeBackendApi implements BackendApi{
    // This class will call the bank Apis for each functionality and use the DTOs , as bank api might use the
    // different structure of any class like Atm or Card than our code
    @Override
    public int createTransaction(CreateTransactionDTO createTransactionDTO)
    {// this will call the bank api
        if(createTransactionDTO.getAtmId()==-1)
            throw new IllegalStateException("Atm id cannot be null");
        return (int)Math.random();
    }

    @Override
    public boolean validateCardDetailsWithBank(ValidateCardDetailsDTO v){
        //call bank api and validate card details with bank
        return true;
    }

    @Override
    public boolean validateAmountWithBank(ValidateWithdrawlAmountWithBankDTO v){
        //call bank api and validate amount with bank, if user account has this much amount
       return true;
    }

    @Override
    public boolean dispenseCash(int txId,int am){
        //call bank api and validate with bank if Atm machine itself as this much cash if yes then dispense
        return true;
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
