package receipts;

import warehouse.Supply;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

abstract class ReceiptImpl implements Receipts{
    @Override
    public String print(HashMap<String, Deque<Supply>> receipt) {

        StringBuilder build = new StringBuilder(printLines());
        build.append(reportTitle());
        build.append(printLines());

        build.append(printSuppliesKeys(String.valueOf(receipt.keySet())));

        build.append(printLines());

        for (Map.Entry<String, Deque<Supply>> entry : receipt.entrySet()){
            for( Supply in : entry.getValue()){
                build.append(printSupply(in));
                build.append(printLines());
            }
        }

        return build.toString();
    }
    protected abstract String reportTitle();
    protected abstract String printLines();
    protected abstract String printSuppliesKeys(String keys);
    protected abstract String printSupply(Supply in);


}
