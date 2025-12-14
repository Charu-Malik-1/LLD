package low_level_design1.my_atm.services;

import low_level_design1.my_atm.dto.CreateTransactionDTO;
import low_level_design1.my_atm.dto.UpdateAtmStateDto;
import low_level_design1.my_atm.dto.GetAtmAmountRequestDTO;
import low_level_design1.my_atm.apis.BackendApi;
import low_level_design1.my_atm.model.Atm;

public class CashDispenseService implements ICashDispenseService {
    private BackendApi backendApi;

    public CashDispenseService(BackendApi b) {
        backendApi = b;
    }

    @Override
    public boolean dispenseCash(Atm atm, int txId, int amount) {
        //how much amout in atm=
        GetAtmAmountRequestDTO g = new GetAtmAmountRequestDTO(atm.getAtmId());
        int atmAmt = backendApi.getAtmAmount(g);
        if (atmAmt < amount) {
            throw new RuntimeException("");
        }
        return true;
    }
}
