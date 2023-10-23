package entities.supplier;

import domain.controller.BlinkitController;

import java.util.ArrayList;
import java.util.List;

public class Supplier {
    private String id;
    private String name;

    private List<Lot> lots;

    private BlinkitController blinkitController;

    public Supplier(String id, String name, BlinkitController blinkitController) {
        this.id = id;
        this.name = name;
        this.lots = new ArrayList<>();
        this.blinkitController = blinkitController;
    }

    public void supplyLot(String code, String productCode, Lot lot) {
        blinkitController.addLotToInventory(code, productCode, lot);
        lots.add(lot);
    }
}
