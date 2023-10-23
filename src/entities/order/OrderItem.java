package entities.order;

import entities.warehouse.inventory.Unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderItem {
    private Unit unit;

    private Double price;

    public OrderItem(Unit unit, Double price) {
        this.unit = unit.cloneUnit();
        this.price = price;
    }
}
