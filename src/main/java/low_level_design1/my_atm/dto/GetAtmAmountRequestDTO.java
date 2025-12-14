package low_level_design1.my_atm.dto;

import lombok.Getter;

@Getter
public class GetAtmAmountRequestDTO {
    private int atmId;

    public GetAtmAmountRequestDTO(int atmId) {
        this.atmId = atmId;
    }
}
