package entities.supplier;

import domain.controller.BlinkitController;

public class SupplierFactory {
    public Supplier createSupplier(String id, String name, BlinkitController blinkitController) {
        return new Supplier(id, name, blinkitController);
    }
}
