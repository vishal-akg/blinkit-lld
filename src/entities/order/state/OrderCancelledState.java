package entities.order.state;

import entities.order.Order;
import entities.payment.Payment;
import valueobjects.TransactionId;

public class OrderCancelledState implements OrderState{
    private Order order;

    public OrderCancelledState(Order order) {
        this.order = order;
    }

    @Override
    public void pay() {
        System.out.println("Order has already been cancelled.");
    }

    @Override
    public void cancel() {
        System.out.println("Order has already been cancelled.");
    }
}
