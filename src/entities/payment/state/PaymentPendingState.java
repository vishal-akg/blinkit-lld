package entities.payment.state;

import entities.payment.Payment;
import valueobjects.RefundId;
import valueobjects.TransactionId;

public class PaymentPendingState implements PaymentState {
    private Payment payment;
    public PaymentPendingState(Payment payment) {
        this.payment = payment;
    }

    @Override
    public void pay() {
        System.out.println("Payment has already been initiated, please wait for it get confirmed");
    }

    @Override
    public void refund() {
        System.out.println("Payment is initiated, cannot refund for now.");
    }
}
