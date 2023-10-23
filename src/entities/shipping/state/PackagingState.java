package entities.shipping.state;

import entities.shipping.Shipping;

import java.util.Timer;
import java.util.TimerTask;

public class PackagingState implements ShippingState{

    @Override
    public void ship(Shipping shipping) {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                shipping.setShippingState(new OnTheWayState(shipping));
                timer.cancel();
            }

        }, 2000);
    }
}
