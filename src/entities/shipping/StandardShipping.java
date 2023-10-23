package entities.shipping;

import entities.order.OrderProxy;
import valueobjects.TrackingId;

import java.util.UUID;

public class StandardShipping extends Shipping{
    @Override
    public void ship(OrderProxy orderProxy) {
        shippingState.ship(this);
    }
}
