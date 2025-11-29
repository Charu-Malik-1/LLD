package low_level_design1.my_parking_lot.models.ticket_and_price.payments;

public interface PaymentStrategy {
   void pay(float amount);
}
