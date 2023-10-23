package entities.warehouse;

import java.util.List;

public class StoreCode {
    private String code;
    private List<Integer> pincodes;

    public StoreCode(String code, List<Integer> pincodes) {
        this.code = code;
        this.pincodes = pincodes;
    }

    public String getCode() {
        return code;
    }

    public Boolean isPincodeCovered(Integer pincode) {
        return pincodes.contains(pincode);
    }
}
