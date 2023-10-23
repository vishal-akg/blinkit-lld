package entities.shipping.state;

import entities.shipping.Shipping;

import java.util.Timer;
import java.util.TimerTask;

public class OnTheWayState implements ShippingState{
    public OnTheWayState(Shipping shipping) {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                shipping.setShippingState(new OrderDeliveredState());
                timer.cancel();
            }
        }, 5000);
    }
    @Override
    public void ship(Shipping shipping) {

    }
}
