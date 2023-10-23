package entities.cart;

public class CartValueCalculator implements CartVisitor{
    private Double cartValue = 0.0;
    @Override
    public void visit(CartItem cartItem) {
        cartValue += cartItem.getPrice();
    }

    public Double getCartValue() {
        return cartValue;
    }
}
