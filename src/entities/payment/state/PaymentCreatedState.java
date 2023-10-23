package entities.payment.state;

import entities.payment.Payment;
import valueobjects.RefundId;
import valueobjects.TransactionId;

import java.util.Timer;
import java.util.TimerTask;

public class PaymentCreatedState implements PaymentState{
    private Payment payment;

    public PaymentCreatedState(Payment payment) {
        this.payment = payment;
    }

    @Override
    public void pay() {
        payment.processPayment();
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                payment.setPaymentState(new PaymentPaidState(payment));
            }
        }, 2000);
    }

    @Override
    public void refund() {
        System.out.println("Payment cannot be refunded");
    }
}
