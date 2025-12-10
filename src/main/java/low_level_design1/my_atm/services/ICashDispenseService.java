package low_level_design1.my_atm.services;

import low_level_design1.my_atm.apis.NodeBackendApi;

public interface ICashDispenseService {
    public boolean dispenseCash(int txId,int am);
}
