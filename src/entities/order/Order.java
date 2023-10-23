package entities.order;

import entities.customer.Customer;
import entities.location.Location;
import entities.order.state.OrderCreatedState;
import entities.order.state.OrderState;
import entities.payment.Payment;
import entities.payment.observer.PaymentObserver;
import entities.payment.state.PaymentPaidState;
import entities.payment.state.PaymentState;
import entities.shipping.Shipping;
import entities.shipping.observer.ShippingObserver;
import entities.shipping.state.OnTheWayState;
import entities.shipping.state.OrderDeliveredState;
import entities.shipping.state.ShippingState;
import valueobjects.TransactionId;

import java.util.List;
import java.util.Map;

public class Order implements PaymentObserver, ShippingObserver {
    private Customer customer;
    private Map<String, List<OrderItem>> orderItems;
    private Shipping shipping;
    private Payment payment;
    private OrderState orderState;

    private Order(Customer customer, Map<String, List<OrderItem>> orderItems, Payment payment, Shipping shipping) {
        this.customer = customer;
        this.orderItems = orderItems;
        this.payment = payment;
        this.shipping = shipping;
        this.orderState = new OrderCreatedState(this);
    }

    public void pay() {
        System.out.println("paying for the order #");
         payment.pay();
    }

    public void refund() {
        payment.processRefund();
    }

    public Location getLocation() {
        return shipping.getLocation();
    }

    public TransactionId getTransactionId() {
        return payment.getTransactionId();
    }

    @Override
    public void update(PaymentState state) {
        if (state instanceof PaymentPaidState) {
            shipping.ship(new OrderProxy(this));
        }
    }

    @Override
    public void update(ShippingState state) {
        if (state instanceof OnTheWayState) {
            System.out.println("Order is on the way, will reach you by 10 seconds");
        } else if (state instanceof OrderDeliveredState) {
            System.out.println("Order has been successfully delivered");
        }
    }

    public static class Builder {
        private Customer customer;
        private Map<String, List<OrderItem>> orderItems;
        private Payment payment;
        private Shipping shipping;

        public Builder customer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder orderItems(Map<String, List<OrderItem>> orderItems) {
            this.orderItems = orderItems;
            return this;
        }

        public Builder payment(Payment payment) {
            this.payment = payment;
            return this;
        }

        public Builder shipping(Shipping shipping) {
            this.shipping = shipping;
            return this;
        }

        public Order build() {
            return new Order(customer, orderItems, payment, shipping);
        }
    }
}
