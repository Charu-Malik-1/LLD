package low_level_design1.my_atm.dto;

import lombok.Getter;
import low_level_design1.my_atm.enums.AtmState;

@Getter
public class UpdateAtmStateDto {
    private final int atmId;
    private final AtmState atmState;

    public UpdateAtmStateDto(int a, AtmState a1) {
        atmId = a;
        atmState = a1;
    }
}
