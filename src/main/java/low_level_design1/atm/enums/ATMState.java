package low_level_design1.atm.enums;

public enum ATMState {
    IDLE,
    READY_FOR_TRANSACTION,
    DISPENSING_CASH,
    READ_CARD_DETAILS_AND_PIN,
    READ_CASH_WITHDRW_DETAILS,
    EJECT_CARD
}
