package low_level_design1.my_atm.services;

import low_level_design1.atm.dto.CreateTransactionDTO;
import low_level_design1.my_atm.apis.BackendApi;
import low_level_design1.my_atm.model.Atm;
import low_level_design1.my_atm.apis.NodeBackendApi;

public class StartTransactionService implements IStartTransactionService {
    BackendApi backendApi;

    public StartTransactionService(BackendApi b) {
        backendApi = b;
    }

    @Override
    public int initTransaction(Atm atm) {
        CreateTransactionDTO createTransactionDTO=new CreateTransactionDTO(atm.getAtmId());
        return backendApi.createTransaction(createTransactionDTO);

    }
}
