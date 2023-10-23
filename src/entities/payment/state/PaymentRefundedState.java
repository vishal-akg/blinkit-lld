package entities.payment.state;

import entities.payment.Payment;
import valueobjects.RefundId;
import valueobjects.TransactionId;

public class PaymentRefundedState implements PaymentState {
    private Payment payment;
    public PaymentRefundedState(Payment payment) {
        this.payment = payment;
    }

    @Override
    public void pay() {
        System.out.println("Payment has already been refunded");
    }

    @Override
    public void refund() {
        System.out.println("Payment has already been refunded");
    }
}
