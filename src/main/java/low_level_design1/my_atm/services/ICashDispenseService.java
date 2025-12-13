package low_level_design1.my_atm.services;

import low_level_design1.my_atm.apis.NodeBackendApi;
import low_level_design1.my_atm.model.Atm;

public interface ICashDispenseService {

    public boolean dispenseCash(Atm atm,int txId, int am);
}
