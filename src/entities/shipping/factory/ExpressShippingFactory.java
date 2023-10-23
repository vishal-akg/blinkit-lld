package entities.shipping.factory;

import entities.shipping.ExpressShipping;
import entities.shipping.Shipping;

public class ExpressShippingFactory implements ShippingFactory{
    @Override
    public Shipping createShipping() {
        return new ExpressShipping();
    }
}
