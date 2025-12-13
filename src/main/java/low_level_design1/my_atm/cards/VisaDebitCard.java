package low_level_design1.my_atm.cards;

import low_level_design1.my_atm.enums.CardType;
import low_level_design1.my_atm.model.Card;

public class VisaDebitCard extends Card implements DebitCard,VisaCard{
    public VisaDebitCard(CardType cardType) {
        super(cardType);
    }

    @Override
    public void makePinPayment() {
        this.connectToVisaNetwork();
    }

    @Override
    public void connectToVisaNetwork(){
        System.out.println("Hi");
    }
}
