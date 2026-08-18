package com.lld.atm.atm.lld.practice.state;

import com.lld.atm.atm.lld.practice.enums.TransactionType;
import com.lld.atm.atm.lld.practice.models.Atm;

public class SelectOperationState extends IAtmState {
    @Override
    public void selectOperation(Atm atm, TransactionType type) {
        switch (type) {
            case BALANCE_ENQUIRY -> atm.setCurrentAtmState(new BalanceEnquiryState());
            case CASH_WITHDRAW -> atm.setCurrentAtmState(new CashWithdrawlState());

            case FUND_TRANSFER -> atm.setCurrentAtmState(new TransferMoneyState());

            case CHANGE_PIN -> atm.setCurrentAtmState(new ChangePinState());

            case CANCEL -> atm.getCurrentAtmState().returnCard(atm);

        }
    }
}
