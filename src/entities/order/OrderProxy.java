package entities.order;

import entities.location.Location;
import entities.order.Order;

public class OrderProxy {
    private Order order;

    public OrderProxy(Order order) {
        this.order = order;
    }

    public Double getWeight() {
        return 10.0;
    }

    public Location getShippingAddress() {
        return order.getLocation();
    }
}
