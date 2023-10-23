package entities.payment.observer;

import entities.payment.state.PaymentState;

public interface PaymentObserver {
    void update(PaymentState state);
}
