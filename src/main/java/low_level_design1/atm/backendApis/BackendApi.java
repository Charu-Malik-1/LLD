package low_level_design1.atm.backendApis;

import low_level_design1.atm.dto.GetAtmAmountRequestDTO;
import low_level_design1.atm.dto.UpdateAtmStateDto;
import low_level_design1.atm.models.Card;

public interface BackendApi {
    int createTransaction(String atmId);

    boolean validateCardDetails(Card card);

    boolean validateWithdrawAmountWithBank(double amount, int trId);

    boolean deductCash(int traId, int am);

    void updateState(UpdateAtmStateDto updateAtmStateDto);

    int getAtmAmount(GetAtmAmountRequestDTO getAtmAmountRequestDTO);
}
