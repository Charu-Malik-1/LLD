package low_level_design1.atm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetAtmAmountRequestDTO {
    private final String atmId;
}
