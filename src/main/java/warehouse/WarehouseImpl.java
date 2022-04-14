package warehouse;

import app.*;

import java.util.*;

public class WarehouseImpl implements Warehouse {

    private HashMap<String, Deque<Supply>> warehouse = new HashMap<>();

    @Override
    public void createSupply(String newSupply) {
        String newSupplyUpperCase = newSupply.toUpperCase();

        if (!warehouse.containsKey(newSupplyUpperCase)) {

            Deque storage = new LinkedList<>();
            warehouse.put(newSupplyUpperCase, storage);
            System.out.println("Your storage was successfully created");

        } else {
            System.out.println("The warehouse already has that storage created");
        }
    }

    @Override
    public void addSuppliesToWarehouse(String storage, String user, int units, Double price) {
        String storageToUpper = storage.toUpperCase();

        if (warehouse.containsKey(storageToUpper)) {
            Supply newSupply = new Supply(user, units, price);
            warehouse.get(storageToUpper).add(newSupply);
            System.out.println("Item successfully added");
        } else {
            System.out.println("Item doesn't exist in warehouse, you need to create the storage to upload it");
        }
    }

    @Override
    public HashMap<String, Deque<Supply>> getWarehouse() {
        return warehouse;
    }

    @Override
    public Integer unitsPerSupply(String name) {
        String nameToUpper = name.toUpperCase();

        if (warehouse.get(nameToUpper).isEmpty()) {
            return 0;
        }

        return warehouse.get(nameToUpper).stream().map(x -> x.getUnits()).reduce((acc, curUnit) -> (acc + curUnit)).get();

    }

    @Override
    public void deleteSupply(String name) {
        String nameToUpper = name.toUpperCase();
        warehouse.get(nameToUpper).pollFirst();
        System.out.println("Supply successfully deleted!");
    }



    @Override
    public HashMap<String, Deque<Supply>> updateWarehouse(String key, int units) {

        String nameToUpper = key.toUpperCase();
        int unitsExtracted = 0;
        Supply lastSupply;
        Supply returnedSupply = new Supply("none", 0, 0.0);

        HashMap<String, Deque<Supply>> product = new HashMap<>();
        Deque<Supply> emptyQueue = new LinkedList<>();
        product.put(nameToUpper, emptyQueue);

        do {

            lastSupply = warehouse.get(nameToUpper).poll();
            product.get(nameToUpper).addFirst(lastSupply);
            unitsExtracted = unitsExtracted + lastSupply.getUnits();
            System.out.println(product);

        } while (units >= unitsExtracted);

        if (units - unitsExtracted < 0) {

            int newUnits = unitsExtracted - units;
            int currentUnits = lastSupply.getUnits();
            String user = lastSupply.getUser();
            double price = lastSupply.getPrice();

            returnedSupply.setPrice(price);
            returnedSupply.setUnits(currentUnits - newUnits);
            returnedSupply.setUser(user);

            lastSupply.setUnits(newUnits);
            warehouse.get(nameToUpper).addFirst(lastSupply);

            Supply lastProduct = product.get(nameToUpper).poll();

            product.get(nameToUpper).addFirst(returnedSupply);
            System.out.println(product);
        }

        return product;

    }
}
