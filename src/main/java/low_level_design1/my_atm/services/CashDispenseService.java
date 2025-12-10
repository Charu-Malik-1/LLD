package low_level_design1.my_atm.services;

import low_level_design1.my_atm.apis.BackendApi;
import low_level_design1.my_atm.apis.NodeBackendApi;

public class CashDispenseService implements ICashDispenseService{
    private BackendApi backendApi;
    public CashDispenseService(BackendApi b){
        backendApi=b;
    }
    @Override
    public boolean dispenseCash(int txId,int am){
        return true;
//       return nodeBackendApi.dispenseCash();
    }
}
