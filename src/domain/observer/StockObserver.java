package domain.observer;

import entities.warehouse.catalogue.Stock;

public interface StockObserver {
    void update(Stock data);
}
