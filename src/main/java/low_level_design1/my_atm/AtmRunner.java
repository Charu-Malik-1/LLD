package low_level_design1.my_atm;
import low_level_design1.my_atm.apis.BackendApi;
import low_level_design1.my_atm.apis.NodeBackendApi;
import low_level_design1.my_atm.cards.RupayDebitCard;
import low_level_design1.my_atm.enums.CardType;
import low_level_design1.my_atm.model.Atm;
import low_level_design1.my_atm.model.Card;
import low_level_design1.my_atm.services.*;
import low_level_design1.my_atm.states.*;

public class AtmRunner {
    public static void main(String[] args) {
        System.out.println("=== ATM System with Simple Dependency Injection ===\n");

        // Step 1: Create all dependencies manually (at application start)
        BackendApi backendApi = new NodeBackendApi();
        IStartTransactionService startTxnService = new StartTransactionService(backendApi);
        ICardService cardService = new CardService(backendApi);
        ICashDispenseService cashDispenseService = new CashDispenseService(backendApi);

        // Step 2: Create ATM
        Atm atm = new Atm(1001);
        System.out.println("ATM ID: " + atm.getAtmId());
        System.out.println("Initial ATM State: " + atm.getAtmState());
        System.out.println();


        // Set the initial state with all required dependencies
        StartTransactionState initialState = new StartTransactionState(atm, startTxnService, cardService,cashDispenseService);
        atm.changeState(initialState);

        System.out.println("ATM ID: " + atm.getAtmId());
        System.out.println("Initial ATM State: " + atm.getAtmState());
        System.out.println();

// Scenario 1: Successful Transaction
        System.out.println("--- Scenario 1: Successful Transaction ---");
        runSuccessfulTransaction(atm, new RupayDebitCard(CardType.DEBIT));
        System.out.println();

        // Reset ATM
        resetAtm(atm, startTxnService, cardService,cashDispenseService);

        // Scenario 2: Invalid PIN
        System.out.println("--- Scenario 2: Invalid PIN Transaction ---");
        runInvalidPinTransaction(atm, new RupayDebitCard(CardType.DEBIT));
        System.out.println();

        System.out.println("=== Demo Complete ===");

    }

    private static void runSuccessfulTransaction(Atm atm, Card card) {
        // Step 1: Start Transaction
        // ATM delegates to current state (StartTransactionState)
        // State transitions internally to ReadCardDetailsAndPinState
        System.out.println("Step 1: Starting transaction...");
        int txnId = atm.startTransaction();
        System.out.println("Current State: " + atm.getAtmState() + "\n");

        // Step 2: Read Card Details
        // ATM delegates to current state (ReadCardDetailsAndPinState)
        // State transitions internally to ReadCashWithdrawState
        System.out.println("Step 2: Reading card details...");
        atm.readCardDetailsAndPin(card, 1234, txnId);
        System.out.println("Current State: " + atm.getAtmState() + "\n");

        // Step 3: Read Cash Withdraw
        // ATM delegates to current state (ReadCashWithdrawState)
        // State transitions internally to DispenseCashState
        System.out.println("Step 3: Processing withdrawal...");
        atm.readCashWithdrawDetails(5000, txnId);
        System.out.println("Current State: " + atm.getAtmState() + "\n");

        // Step 4: Dispense Cash
        // ATM delegates to current state (DispenseCashState)
        // State transitions internally to EjectCardState
        System.out.println("Step 4: Dispensing cash...");
        atm.dispenseCash(txnId, 5000);
        System.out.println("Current State: " + atm.getAtmState() + "\n");

        // Step 5: Eject Card
        // ATM delegates to current state (EjectCardState)
        System.out.println("Step 5: Ejecting card...");
        atm.ejectCard();
        System.out.println("Current State: " + atm.getAtmState());
        System.out.println("Transaction Complete!");
    }

    private static void resetAtm(Atm atm, IStartTransactionService startTxnService,
                                 ICardService cardService,ICashDispenseService cashDispenseService) {
        StartTransactionState resetState = new StartTransactionState(atm, startTxnService, cardService,cashDispenseService);
        atm.changeState(resetState);
        System.out.println("--- ATM Reset to START_TRANSACTION State ---\n");
    }

    private static void runInvalidPinTransaction(Atm atm, Card card) {
        // Step 1: Start Transaction
        System.out.println("Step 1: Starting transaction...");
        int txnId = atm.startTransaction();
        System.out.println("Current State: " + atm.getAtmState() + "\n");

        // Step 2: Try with invalid PIN
        // State will transition to EjectCard internally due to invalid PIN
        System.out.println("Step 2: Reading card with invalid PIN...");
        atm.readCardDetailsAndPin(card, 9999, txnId);
        System.out.println("Current State: " + atm.getAtmState() + "\n");

        // Step 3: Eject Card
        System.out.println("Step 3: Ejecting card due to invalid PIN...");
        atm.ejectCard();
        System.out.println("Current State: " + atm.getAtmState());
        System.out.println("Transaction Terminated!");
    }
}
