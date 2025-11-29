package low_level_design1.my_parking_lot.models.ticket_and_price.payments;

public class CashPayment implements PaymentStrategy{
    @Override
    public void pay(float amount) {
        System.out.println("cash payment "+amount);
    }
}
