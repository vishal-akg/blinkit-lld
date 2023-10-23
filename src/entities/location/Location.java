package entities.location;

public class Location {
    private String city;
    private Integer pincode;

    public Location(String city, Integer pincode) {
        this.city = city;
        this.pincode = pincode;
    }
    public String getCode() {
        return city;
    }
    public Integer getPincode() {
        return pincode;
    }
}
