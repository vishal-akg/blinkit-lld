package entities.payment.state;

import entities.payment.Payment;
import valueobjects.RefundId;
import valueobjects.TransactionId;

public class PaymentPaidState implements PaymentState {
    private Payment payment;
    public PaymentPaidState(Payment payment) {
        this.payment = payment;
    }

    @Override
    public void pay() {
        System.out.println("Payment already done.");
    }

    @Override
    public void refund() {
        payment.processRefund();
    }
}
