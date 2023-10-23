package entities.warehouse;

import entities.warehouse.catalogue.Catalogue;
import entities.warehouse.catalogue.Product;
import entities.supplier.Lot;
import entities.warehouse.inventory.Inventory;

import java.util.List;

public class Warehouse {
    private Inventory inventory;
    private Catalogue catalogue;

    public Warehouse() {
        inventory = new Inventory();
        catalogue = new Catalogue();
        inventory.addObserver(catalogue);
    }

    public List<Product> getProducts() {
        return catalogue.getProducts();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void addProducts(List<Product> products) {
        catalogue.addProducts(products);
    }

    public void addLotToInventory(String productCode, Lot lot) {
        inventory.addLotToInventory(productCode, lot);
    }
}
