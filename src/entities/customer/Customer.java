package entities.customer;

import entities.cart.Cart;
import entities.cart.CartItem;
import entities.location.Location;
import entities.order.Order;
import entities.warehouse.catalogue.Product;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String id;
    private String name;
    private Location location;

    private Cart cart;

    private List<Order> orders;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
        this.orders = new ArrayList<>();
        this.cart = new Cart();
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void addProductToCart(Product product, Integer quantity) {
        cart.addItemToCart(new CartItem(product, quantity));
    }

    public Cart getCart() {
        return cart;
    }
}
