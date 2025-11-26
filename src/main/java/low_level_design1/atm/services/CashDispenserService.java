package low_level_design1.atm.services;

import lombok.AllArgsConstructor;
import low_level_design1.atm.backendApis.BackendApi;
import low_level_design1.atm.backendApis.NodeBackendApi;
import low_level_design1.atm.dto.GetAtmAmountRequestDTO;
import low_level_design1.atm.models.Atm;


public class CashDispenserService {
    // check how much cash in atm , and bank server should also know how much amount in atm
    // how much amount in my bank account to check in bank acount -> api call will go to bank server,
    // DTO will also required
    private final BackendApi backendApi;

    public CashDispenserService(){
        backendApi=new NodeBackendApi();
    }

   public void dispenseCash(Atm atm, int amount){

        //how much amt in atm
       int atmAmt= backendApi.getAtmAmount(new GetAtmAmountRequestDTO(atm.getAtmId()));
       if(atmAmt<amount){
           //atm has less money
           throw new RuntimeException("");
       }
       System.out.println("Dispensing cash"+amount);
    }
}
