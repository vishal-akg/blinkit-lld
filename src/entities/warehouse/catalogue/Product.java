package entities.warehouse.catalogue;

public class Product {
    private String code;
    private String name;
    private Integer quantity;
    private Double price;

    private Product(String code, String name, Double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() {
        return code;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public static class Builder {
        private String code;
        private String name;
        private Double price;

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder price(Double price) {
            this.price = price;
            return this;
        }

        public Product build() {
            return new Product(code, name, price);
        }
    }
}
