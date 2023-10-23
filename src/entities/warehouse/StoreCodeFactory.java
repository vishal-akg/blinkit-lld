package entities.warehouse;

import entities.location.Location;

import java.util.List;

public class StoreCodeFactory {
    public StoreCode create(String code, List<Integer> pincodes) {
        return new StoreCode(code, pincodes);
    }
}
