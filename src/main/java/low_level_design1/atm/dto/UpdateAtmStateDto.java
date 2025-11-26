package low_level_design1.atm.dto;

import lombok.Getter;
import low_level_design1.atm.enums.ATMState;

@Getter
public class UpdateAtmStateDto {
    private final String atmId;
    private final ATMState state;
    public UpdateAtmStateDto(String atmId,ATMState atmState){
        this.atmId=atmId;
        this.state=atmState;
    }
}
