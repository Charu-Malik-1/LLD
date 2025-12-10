package low_level_design1.my_atm.enums;

public enum AtmState {
    IDLE,
    START_TRANSACTION,
    READ_CARD_DETAILS_AND_PIN,
    READ_CASH_WITHDRAW_DETAILS,
    DISPENSE_CASH,
    EJECT_CARD
}
