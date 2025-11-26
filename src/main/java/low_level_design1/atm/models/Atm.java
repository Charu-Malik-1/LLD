package low_level_design1.atm.models;

import lombok.Getter;
import lombok.Setter;
import low_level_design1.atm.backendApis.NodeBackendApi;
import low_level_design1.atm.dto.UpdateAtmStateDto;
import low_level_design1.atm.states.ReadyForTransactionState;
import low_level_design1.atm.states.StateInterface;

@Getter
@Setter
public class Atm {
    private final String atmId;
    private final NodeBackendApi nodeBackendApi;
    private StateInterface stateInterface;

    public Atm(String atmId) {
        this.atmId = atmId;
        nodeBackendApi = new NodeBackendApi();
        this.stateInterface = new ReadyForTransactionState(this, nodeBackendApi);
    }

    public void changeState(StateInterface stateInterface) {
        this.stateInterface = stateInterface;
        nodeBackendApi.updateState(new UpdateAtmStateDto(atmId, stateInterface.getState()));
    }
}
