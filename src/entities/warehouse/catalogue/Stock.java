package entities.warehouse.catalogue;

public class Stock {
    private String productCode;
    private Integer quantity;

    public Stock(String productCode, Integer quantity) {
        this.productCode = productCode;
        this.quantity = quantity;
    }

    public String getProductCode() {
        return productCode;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
