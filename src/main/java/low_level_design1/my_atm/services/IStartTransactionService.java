package low_level_design1.my_atm.services;

import low_level_design1.my_atm.apis.NodeBackendApi;
import low_level_design1.my_atm.model.Atm;
import low_level_design1.my_atm.model.Card;

public interface IStartTransactionService {
    int initTransaction(Atm atm, Card card, int amt);
}
