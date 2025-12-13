package low_level_design1.my_atm.services;

import low_level_design1.atm.dto.GetAtmAmountRequestDTO;
import low_level_design1.my_atm.apis.BackendApi;
import low_level_design1.my_atm.apis.NodeBackendApi;
import low_level_design1.my_atm.model.Atm;

public class CashDispenseService implements ICashDispenseService {
    private BackendApi backendApi;

    public CashDispenseService(BackendApi b) {
        backendApi = b;
    }

    @Override
    public boolean dispenseCash(Atm atm, int txId,int amount) {
        //how much amout in atm=
        int atmAmt = backendApi.getAtmAmount(new GetAtmAmountRequestDTO(atm.getAtmId()));
        if (atmAmt < amount) {
            throw new RuntimeException("");
        }
        return true;
//       return nodeBackendApi.dispenseCash();
    }
}
