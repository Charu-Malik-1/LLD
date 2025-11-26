package low_level_design1.atm.backendApis;

import low_level_design1.atm.dto.GetAtmAmountRequestDTO;
import low_level_design1.atm.dto.UpdateAtmStateDto;
import low_level_design1.atm.models.Card;

public class NodeBackendApi implements BackendApi{

    @Override
    public int createTransaction(String atmId){
        if(atmId==null || atmId.isEmpty()){
            throw new IllegalStateException("ssss");
        }
        return (int)Math.random()*1000;
    }
    @Override
    public boolean validateCardDetails(Card card){
        if(card==null)
            throw new IllegalStateException("enter valid card");
        return true;
    }
    @Override
    public boolean validateWithdrawAmountWithBank(double amount,int trId){
        return true;
    }
    @Override
    public boolean deductCash(int traId,int am){
        return true;
    }
    @Override
    public void updateState(UpdateAtmStateDto updateAtmStateDto){
return ;
    }

    @Override
    public int getAtmAmount(GetAtmAmountRequestDTO getAtmAmountRequestDTO) {
        // otherwise it will do backend call
        return 100000;
    }
}
