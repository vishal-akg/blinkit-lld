import domain.controller.BlinkitController;
import entities.customer.Customer;
import entities.location.Location;
import entities.order.Order;
import entities.payment.factory.CardPaymentFactory;
import entities.shipping.factory.ExpressShippingFactory;
import entities.supplier.Lot;
import entities.supplier.Supplier;
import entities.warehouse.catalogue.Product;
import entities.warehouse.inventory.Unit;

import java.util.Arrays;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        BlinkitController blinkitController = BlinkitController.getInstance();
        blinkitController.addWarehouse("DEL0011",
                Arrays.asList(110001, 110002, 110003, 110004, 110005, 110006, 110007, 110008)
        );

        Supplier supplier = blinkitController.registerSupplier("Dharmender Fruits & Vegetable Wholesaler");
        List<Product> products = Arrays.asList(
                new Product.Builder().code("FUJI_APPLE").name("Fuji Apple").price(200.0).build(),
                new Product.Builder().code("NAGPUR_ORANGE").name("Nagpur Orange").price(78.0).build()
        );
        blinkitController.addProductsToWarehouse("DEL0011", products);

        Customer customer = blinkitController.registerCustomer("Vishal Chaurasia", new Location("Delhi", 110001));
        List<Product> catalogue = blinkitController.showCatalogue(customer);

        supplier.supplyLot("DEL0011", "FUJI_APPLE", new Lot(Arrays.asList(
                new Unit("00001"),
                new Unit("00002"),
                new Unit("00003"),
                new Unit("00004"),
                new Unit("00005")
        ), 600.0));

        Product product = catalogue.get(0);
        customer.addProductToCart(product, 2);
        Order order = blinkitController.placeOrder(customer, new CardPaymentFactory(), new ExpressShippingFactory());
        if (order != null) {
            order.pay();
        }
    }
}