package entities.order.state;

import entities.order.Order;
import entities.payment.Payment;
import valueobjects.TransactionId;

public class OrderReturnedState implements OrderState{
    private Order order;

    public OrderReturnedState(Order order) {
        order.refund();
    }

    @Override
    public void pay() {
        System.out.println("Order has been returned back.");
    }

    @Override
    public void cancel() {
        System.out.println("Order has been returned back.");
    }
}
