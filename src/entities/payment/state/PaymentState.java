package entities.payment.state;

import valueobjects.RefundId;
import valueobjects.TransactionId;

public interface PaymentState {
    void pay();

    void refund();
}
