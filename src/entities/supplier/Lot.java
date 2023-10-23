package entities.supplier;

import entities.warehouse.inventory.Unit;

import java.util.List;

public class Lot {
    private List<Unit> units;
    private Double price;

    public Lot(List<Unit> units, Double price) {
        this.units = units;
        this.price = price;
    }

    public List<Unit> getUnits() {
        return units;
    }
}
