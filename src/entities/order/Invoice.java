package entities.order;

import entities.location.Location;

import java.util.Date;
import java.util.List;

public class Invoice {
    private String number;
    private Date date;
    private Location address;
    private List<OrderItem> orderItems;

    public Invoice(Location address, List<OrderItem> orderItems) {
        this.number = "";
        this.date = new Date();
        this.orderItems = orderItems;
        this.address = address;
    }
}
