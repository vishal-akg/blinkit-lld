package entities.payment.factory;

import entities.payment.Payment;

public interface PaymentFactory {
    Payment createPayment(Double amount);
}
