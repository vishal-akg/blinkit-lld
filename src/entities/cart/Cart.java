package entities.cart;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems;

    public Cart() {
        cartItems = new ArrayList<>();
    }

    public void addItemToCart(CartItem cartItem) {
        cartItems.add(cartItem);
    }

    public Double getCartValue() {
        CartValueCalculator cartValueCalculator = new CartValueCalculator();

        for (CartItem cartItem: cartItems) {
            cartValueCalculator.visit(cartItem);
        }

        return cartValueCalculator.getCartValue();
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void clear() {
        cartItems.clear();
    }
}
