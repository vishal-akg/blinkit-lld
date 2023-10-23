package entities.order.state;

import entities.order.Order;
import entities.payment.Payment;
import valueobjects.TransactionId;

public class OrderCreatedState implements OrderState{
    private Order order;

    public OrderCreatedState(Order order) {
        this.order = order;
    }

    @Override
    public void pay() {
        order.pay();
    }

    @Override
    public void cancel() {

    }
}
