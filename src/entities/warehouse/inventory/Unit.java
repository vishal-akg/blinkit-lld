package entities.warehouse.inventory;

public class Unit implements UnitCloneable{
    private String serialNumber;

    public Unit(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public Unit cloneUnit() {
        return new Unit(serialNumber);
    }
}
