package entities.order.state;

import valueobjects.TransactionId;

public interface OrderState {
    void pay();
    void cancel();
}
