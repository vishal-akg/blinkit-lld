package entities.shipping;

import entities.order.OrderProxy;
import valueobjects.TrackingId;

import java.util.UUID;

public class ExpressShipping extends Shipping{
    @Override
    public void ship(OrderProxy orderProxy) {
        shippingState.ship(this);
    }
}
