package entities.shipping.observer;

public interface ShippingObservable {
    void addObserver(ShippingObserver observer);
    void removeObserver(ShippingObserver observer);
    void notifyObservers();
}
