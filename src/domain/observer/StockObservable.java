package domain.observer;

import entities.warehouse.catalogue.Stock;

public interface StockObservable {
    void addObserver(StockObserver observer);
    void removeObserver(StockObserver observer);
    void notifyObservers(Stock data);
}
