package receipts;

import ConsoleInterface.PurchaseOptions;
import warehouse.Supply;

public class ReceiptFormat extends ReceiptImpl {


    @Override
    protected String reportTitle() {
        return "| Product Receipt\n";
    }

    @Override
    protected String printLines() {
        return "|-------------------------------------------------------------------------|\n";
    }

    @Override
    protected String printSuppliesKeys(String keys) {
        return "| Supply used: " + keys.toString() + "\n";
    }

    @Override
    protected String printSupply(Supply in) {
        return "| " +  in.getUnits() + " units to " + in.getPrice() + " = " + Math.floor(in.getPrice()* in.getUnits()*100)/100 + "\n";
    }


}
