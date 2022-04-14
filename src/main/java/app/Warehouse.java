package app;

import warehouse.*;

import java.util.Deque;
import java.util.HashMap;

public interface Warehouse {
    void createSupply(String newSupply);
    void addSuppliesToWarehouse(String storage, String user, int units, Double price);
    HashMap<String, Deque<Supply>> getWarehouse();
    Integer unitsPerSupply(String key);
    void deleteSupply(String key);
    HashMap<String, Deque<Supply>> updateWarehouse(String key, int units);
}