package low_level_design1.my_atm.services;

import low_level_design1.my_atm.apis.NodeBackendApi;
import low_level_design1.my_atm.model.Atm;

public interface IStartTransactionService {
    public int initTransaction(Atm atm);
}
