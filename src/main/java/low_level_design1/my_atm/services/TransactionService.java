package low_level_design1.my_atm.services;

import low_level_design1.my_atm.dto.CreateTransactionDTO;
import low_level_design1.my_atm.dto.UpdateAtmStateDto;
import low_level_design1.my_atm.dto.GetAtmAmountRequestDTO;
import low_level_design1.my_atm.apis.BackendApi;
import low_level_design1.my_atm.model.Atm;
import low_level_design1.my_atm.model.Card;

public class TransactionService implements IStartTransactionService {
    BackendApi backendApi;

    public TransactionService(BackendApi b) {
        backendApi = b;
    }

    @Override
    public int initTransaction(Atm atm,Card card,int amt) {
        CreateTransactionDTO createTransactionDTO = new CreateTransactionDTO(atm.getAtmId(),card,amt);
        return backendApi.createTransaction(createTransactionDTO);
    }
}
