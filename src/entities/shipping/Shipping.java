package entities.shipping;

import entities.location.Location;
import entities.order.OrderProxy;
import entities.shipping.observer.ShippingObservable;
import entities.shipping.observer.ShippingObserver;
import entities.shipping.state.PackagingState;
import entities.shipping.state.ShippingState;
import valueobjects.TrackingId;

import java.util.ArrayList;
import java.util.List;

public abstract class Shipping implements ShippingObservable {
    private Location location;
    protected ShippingState shippingState;
    private List<ShippingObserver> observers;

    public Shipping() {
        observers = new ArrayList<>();
        shippingState = new PackagingState();
    }

    public abstract void ship(OrderProxy orderProxy);

    public Location getLocation() {
        return location;
    }

    public void setShippingState(ShippingState shippingState) {
        this.shippingState = shippingState;
        notifyObservers();
    }

    public void addObserver(ShippingObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ShippingObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (ShippingObserver observer: observers) {
            observer.update(shippingState);
        }
    }
}
