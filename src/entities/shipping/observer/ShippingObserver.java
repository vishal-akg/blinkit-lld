package entities.shipping.observer;

import entities.shipping.state.ShippingState;

public interface ShippingObserver {
    void update(ShippingState shippingState);
}
