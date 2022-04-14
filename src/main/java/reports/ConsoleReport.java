package reports;

import app.Warehouse;
import warehouse.*;


import java.util.Deque;
import java.util.Map;


public abstract class ConsoleReport implements Reports{
    @Override
    public String printReport(Warehouse warehouse) {

        StringBuilder build = new StringBuilder(printLines());
        build.append(reportTitle());
        build.append(printLines());
        build.append(printSuppliesKeys(String.valueOf(warehouse.getWarehouse().keySet())));
        build.append(printLines());

        for (Map.Entry<String, Deque<Supply>> entry : warehouse.getWarehouse().entrySet()){
            build.append(printSupply(entry));
            build.append(printLines());
        }

        return build.toString();
    }

    protected abstract String reportTitle();
    protected abstract String printLines();
    protected abstract String printSuppliesKeys(String keys);
    protected abstract String printSupply(Map.Entry<String, Deque<Supply>> entry);

}
