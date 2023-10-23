package entities.warehouse.inventory;

import domain.observer.StockObservable;
import domain.observer.StockObserver;
import entities.warehouse.catalogue.Stock;
import entities.supplier.Lot;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory implements StockObservable {
    private Map<String, Deque<Unit>> units;
    private List<StockObserver> observers;

    public Inventory() {
        observers = new ArrayList<>();
        units = new HashMap<>();
    }

    public void addLotToInventory(String productCode, Lot lot) {

        if (units.containsKey(productCode)) {
            units.get(productCode).addAll(lot.getUnits());
        } else {
            units.put(productCode, new ArrayDeque<>(lot.getUnits()));
        }
        notifyObservers(new Stock(productCode, units.get(productCode).size()));
    }

    @Override
    public void addObserver(StockObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Stock data) {
        for (StockObserver observer: observers) {
            observer.update(data);
        }
    }

    public synchronized List<Unit> reserveUnits(String productCode, Integer numberOfUnits) {

        Queue<Unit> unitsOfProduct = units.get(productCode);
        if (unitsOfProduct == null || unitsOfProduct.size() < numberOfUnits) {
            throw new IllegalStateException("Not enough units of products, #" + productCode);
        }

        List<Unit> reservedUnits = new ArrayList<>(numberOfUnits);
        for (int i = 0; i < numberOfUnits; i++) {
            reservedUnits.add(unitsOfProduct.poll());
        }

        notifyObservers(new Stock(productCode, unitsOfProduct.size()));
        return reservedUnits;
    }
}
