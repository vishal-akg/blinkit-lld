package entities.payment;

import valueobjects.RefundId;
import valueobjects.TransactionId;

import java.util.UUID;

public class CardPayment extends Payment {
    public CardPayment(Double amount) {
        super(amount);
    }
    @Override
    public void processPayment() {
        transactionId = new TransactionId(UUID.randomUUID().toString());
    }

    @Override
    public void processRefund() {
        refundIds.add(new RefundId(UUID.randomUUID().toString()));
    }

}
