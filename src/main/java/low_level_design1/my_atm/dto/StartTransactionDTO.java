package low_level_design1.my_atm.dto;

import lombok.Getter;

@Getter
public class StartTransactionDTO {
    private final String atmId;
    public StartTransactionDTO(String atmId){
        this.atmId=atmId;
    }
}
