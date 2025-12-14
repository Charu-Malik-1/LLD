package low_level_design1.my_atm.factories;

import low_level_design1.my_atm.apis.BackendApi;
import low_level_design1.my_atm.enums.CardType;
import low_level_design1.my_atm.services.CardManagerService;
import low_level_design1.my_atm.services.CreditCardManagerService;
import low_level_design1.my_atm.services.DebitCardManagerService;

public class CardManagerFactory {
    private final BackendApi backendApi;

    public CardManagerFactory(BackendApi b) {
        backendApi = b;
    }

    public CardManagerService getCardManager(CardType cardType) {
        CardManagerService cardManagerService = null;
        if (cardType.equals(CardType.DEBIT)) {
            cardManagerService = new DebitCardManagerService(backendApi);
        } else if (cardType.equals(CardType.CREDIT)) {
            cardManagerService = new CreditCardManagerService(backendApi);
        } else {
            throw new IllegalStateException("Invalid card type");
        }
        return cardManagerService;
    }
}
