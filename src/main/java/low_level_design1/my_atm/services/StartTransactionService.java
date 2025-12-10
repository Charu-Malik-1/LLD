package low_level_design1.my_atm.services;

import low_level_design1.my_atm.apis.BackendApi;
import low_level_design1.my_atm.apis.NodeBackendApi;

public class StartTransactionService implements IStartTransactionService{
    BackendApi backendApi;
    public StartTransactionService(BackendApi b){
        backendApi=b;
    }
    @Override
    public int initTransaction(){
        return backendApi.startTransaction();
    }
}
