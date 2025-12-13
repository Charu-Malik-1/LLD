package low_level_design1.my_atm.dto;

import lombok.Getter;

@Getter
public class ValidateWithdrawlAmountWithBankDTO {
    private final int amount;
    private final int transactionId;

    public ValidateWithdrawlAmountWithBankDTO(int amt,int txId){
        this.amount=amt;
        this.transactionId=txId;
    }

}