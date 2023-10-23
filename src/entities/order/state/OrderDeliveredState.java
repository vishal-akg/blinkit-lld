package entities.order.state;

import entities.order.Order;
import entities.payment.Payment;
import valueobjects.TransactionId;

public class OrderDeliveredState implements OrderState{
    private Order order;

    public OrderDeliveredState(Order order) {
        this.order = order;
    }

    @Override
    public void pay() {
        System.out.println("Order has been already delivered.");
    }

    @Override
    public void cancel() {

    }
}
