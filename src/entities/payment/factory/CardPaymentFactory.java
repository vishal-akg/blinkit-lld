package entities.payment.factory;

import entities.payment.CardPayment;
import entities.payment.Payment;

public class CardPaymentFactory implements PaymentFactory{
    @Override
    public Payment createPayment(Double amount) {
        return new CardPayment(amount);
    }
}
