package entities.order;

import entities.cart.Cart;
import entities.cart.CartItem;
import entities.warehouse.catalogue.Product;
import entities.customer.Customer;
import entities.payment.Payment;
import entities.payment.factory.PaymentFactory;
import entities.shipping.Shipping;
import entities.shipping.factory.ShippingFactory;
import entities.warehouse.inventory.Inventory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderController {

    public Order createOrder(Customer customer,
                             PaymentFactory paymentFactory,
                             ShippingFactory shippingFactory,
                             Inventory inventory
    ) {
        Cart cart = customer.getCart();
        Map<String, List<OrderItem>> orderItems = new HashMap<>();
        for (CartItem cartItem: cart.getCartItems()) {
            Product product = cartItem.getProduct();
            orderItems.put(
                    product.getCode(),
                    inventory.reserveUnits(
                            product.getCode(),
                            cartItem.getQuantity()
                    ).stream()
                            .map(unit -> new OrderItem(
                                    unit.cloneUnit(),
                                    product.getPrice()
                            )).collect(Collectors.toList()
                            )
            );
        }

        Payment payment = paymentFactory.createPayment(cart.getCartValue());
        Shipping shipping = shippingFactory.createShipping();

        Order order = new Order.Builder()
                .customer(customer)
                .payment(payment)
                .shipping(shipping)
                .orderItems(orderItems)
                .build();

        cart.clear();
        payment.addObserver(order);
        shipping.addObserver(order);
        return order;
    }

    public void pay(Order order) {
         order.pay();
    }
}
