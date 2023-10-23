package entities.warehouse.catalogue;

import domain.observer.StockObserver;

import java.util.ArrayList;
import java.util.List;

public class Catalogue implements StockObserver {
    private List<Product> products;

    public Catalogue() {
        this.products = new ArrayList<>();
    }

    public void addProducts(List<Product> products) {
        this.products.addAll(products);
    }

    @Override
    public void update(Stock stock) {
        System.out.println("new stock " + stock.getProductCode() + ", " + stock.getQuantity());
        for (Product product: products) {

            if (product.getCode().equals(stock.getProductCode())) {
                product.setQuantity(stock.getQuantity());
            }
        }
    }

    public List<Product> getProducts() {
        return products;
    }
}
