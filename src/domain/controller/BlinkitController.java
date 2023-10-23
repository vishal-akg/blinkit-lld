package domain.controller;

import entities.customer.Customer;
import entities.order.Order;
import entities.order.OrderController;
import entities.payment.factory.PaymentFactory;
import entities.shipping.factory.ShippingFactory;
import entities.warehouse.catalogue.CatalogueFactory;
import entities.warehouse.catalogue.Product;
import entities.location.Location;
import entities.location.LocationFactory;
import entities.supplier.Lot;
import entities.supplier.Supplier;
import entities.supplier.SupplierFactory;
import entities.warehouse.StoreCode;
import entities.warehouse.StoreCodeFactory;
import entities.warehouse.Warehouse;
import entities.warehouse.WarehouseFactory;

import java.util.*;

public class BlinkitController {
    private static BlinkitController instance;
    private OrderController orderController;
    private Map<StoreCode, Warehouse> warehouses;
    private Map<Integer, StoreCode> mapOfPincodeToStores;
    private List<Customer> customers;
    private List<Supplier> suppliers;
    private WarehouseFactory warehouseFactory;
    private SupplierFactory supplierFactory;
    private StoreCodeFactory storeCodeFactory;
    private LocationFactory locationFactory;
    private CatalogueFactory catalogueFactory;
    private List<Location> locations;
    private List<StoreCode> storeCodes;

    private BlinkitController() {
        this.warehouses = new HashMap<>();
        this.mapOfPincodeToStores = new HashMap<>();
        this.customers = new ArrayList<>();
        this.suppliers = new ArrayList<>();
        this.storeCodes = new ArrayList<>();
        this.orderController = new OrderController();
        this.warehouseFactory = new WarehouseFactory();
        this.supplierFactory = new SupplierFactory();
        this.catalogueFactory = new CatalogueFactory();
        this.storeCodeFactory = new StoreCodeFactory();
        this.locationFactory = new LocationFactory();
    }

    public static BlinkitController getInstance() {
        synchronized (BlinkitController.class) {
            if (instance == null) {
                instance = new BlinkitController();
            }
        }
        return instance;
    }

    public Customer registerCustomer(String name, Location location) {
        Customer customer = new Customer(UUID.randomUUID().toString(), name);
        customer.setLocation(location);
        customers.add(customer);
        return customer;
    }

    private StoreCode addStoreCodes(String code, List<Integer> pincodes) {
        StoreCode storeCode = storeCodeFactory.create(code, pincodes);
        storeCodes.add(storeCode);
        for (Integer pincode: pincodes) {
            mapOfPincodeToStores.putIfAbsent(pincode, storeCode);
        }
        return storeCode;
    }

    public void addWarehouse(String code, List<Integer> pincodes) {
        StoreCode storeCode = addStoreCodes(code, pincodes);
        warehouses.put(storeCode, warehouseFactory.createWarehouse());
    }

    public Supplier registerSupplier(String name) {
        Supplier supplier = supplierFactory.createSupplier(UUID.randomUUID().toString(), name, this);
        suppliers.add(supplier);
        return supplier;
    }

    private Optional<StoreCode> getStoreCode(String code) {
        return storeCodes.stream().filter(store -> store.getCode() == code).findFirst();
    }

    public void addProductsToWarehouse(String code, List<Product> products) {
        Optional<StoreCode> storeCode = getStoreCode(code);

        if (storeCode.isPresent()) {
            warehouses.get(storeCode.get()).addProducts(products);
        }
    }

    public void addLotToInventory(String code, String productCode, Lot lot) {
        Optional<StoreCode> storeCode = getStoreCode(code);
        if (storeCode.isPresent()) {
            warehouses.get(storeCode.get()).addLotToInventory(productCode, lot);
        }
    }

    public List<Product> showCatalogue(Customer customer) {
        StoreCode storeCode = mapOfPincodeToStores.get(customer.getLocation().getPincode());
        return warehouses.get(storeCode).getProducts();
    }

    public Order placeOrder(Customer customer, PaymentFactory paymentFactory, ShippingFactory shippingFactory) {
        StoreCode storeCode = mapOfPincodeToStores.get(customer.getLocation().getPincode());
        if (storeCode != null) {
            Warehouse warehouse = warehouses.get(storeCode);
            return orderController.createOrder(customer, paymentFactory, shippingFactory, warehouse.getInventory());
        }
        return null;
    }
}
