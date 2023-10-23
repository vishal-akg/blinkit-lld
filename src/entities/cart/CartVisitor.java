package entities.cart;

public interface CartVisitor {
    void visit(CartItem cartItem);
}
