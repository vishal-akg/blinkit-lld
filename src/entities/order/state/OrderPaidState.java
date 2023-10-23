package entities.order.state;

import entities.order.Order;
import entities.payment.Payment;
import valueobjects.TransactionId;

public class OrderPaidState implements OrderState{
    private Order order;
    public OrderPaidState(Order order) {
        this.order = order;
    }

    @Override
    public void pay() {
        System.out.println("Order has already been paid");
    }

    @Override
    public void cancel() {

    }
}
