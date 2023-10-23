package entities.location;

public class LocationFactory {
    public Location createLocation(String city, Integer pincode) {
        return new Location(city, pincode);
    }
}
