package warehouse;

import app.*;


public class WarehouseFactoryImpl implements WarehouseFactory {
    @Override
    public Warehouse create() {
        return new WarehouseImpl();
    }
}
