package reports;

import warehouse.*;


import java.util.*;

public class ConsoleReportFirstFormat extends ConsoleReport{
    @Override
    protected String reportTitle() {
        return "| Current Warehouse Storage\n";
    }

    @Override
    protected String printLines() {
        return "|-------------------------------------------------------------------------|\n";
    }

    @Override
    protected String printSuppliesKeys(String key) {
        return "| Supply List :" + key.toString() + "\n";
    }

    @Override
    protected String printSupply(Map.Entry<String, Deque<Supply>> entry) {
        if(entry.getValue().toString().equals("[]")) {
            return "| " + entry.getKey() + " = " + "No Supply added yet\n";
        }
        else {
            return "| " + entry.toString() + "\n";
        }

    }


}
