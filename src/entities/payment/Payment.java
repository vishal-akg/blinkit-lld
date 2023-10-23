package entities.payment;

import entities.payment.observer.PaymentObservable;
import entities.payment.observer.PaymentObserver;
import entities.payment.state.PaymentCreatedState;
import entities.payment.state.PaymentState;
import valueobjects.RefundId;
import valueobjects.TransactionId;

import java.util.ArrayList;
import java.util.List;

public abstract class Payment implements PaymentObservable {
    private Double amount;
    private PaymentState paymentState;
    protected TransactionId transactionId;
    protected List<RefundId> refundIds;
    private List<PaymentObserver> observers;

    public Payment(Double amount) {
        this.amount = amount;
        this.observers = new ArrayList<>();
        this.paymentState = new PaymentCreatedState(this);
    }

    public void pay() {
         paymentState.pay();
    }

    public void setPaymentState(PaymentState state) {
        this.paymentState = state;
        notifyObservers();
    }

    @Override
    public void addObserver(PaymentObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(PaymentObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (PaymentObserver observer: observers) {
            observer.update(paymentState);
        }
    }

    public TransactionId getTransactionId() {
        return transactionId;
    }

    public abstract void processPayment();
    public abstract void processRefund();
}
