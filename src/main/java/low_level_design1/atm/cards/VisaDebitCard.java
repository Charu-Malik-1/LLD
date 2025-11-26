package low_level_design1.atm.cards;

import low_level_design1.atm.enums.CardType;
import low_level_design1.atm.models.Card;

// it will become visa debit card when it implement the functionality of debit card via visa n/w
// visadebtcard is-a card
public class VisaDebitCard extends Card implements Debit,Visa {

    public VisaDebitCard(String cardNum, CardType cardType, int pin, String name, String bankName) {
        super(cardNum, cardType, pin, name, bankName);
    }

    @Override
    public void makePinPayment() {
        this.connectToVisaNetwork();
        System.out.println("hi");
    }

    @Override
    public void connectToVisaNetwork() {
        System.out.println("hi");
    }
}
