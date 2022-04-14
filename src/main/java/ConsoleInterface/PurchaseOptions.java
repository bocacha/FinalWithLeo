package ConsoleInterface;

import app.Formulas;
import app.Warehouse;
import receipts.ReceiptFormat;
import receipts.Receipts;
import warehouse.Supply;

import java.util.*;

public class PurchaseOptions  {

    Warehouse warehouse;
    Formulas formula;

    static Scanner sc = new Scanner(System.in);

    public PurchaseOptions( Warehouse warehouse, Formulas formula){

        this.warehouse = warehouse;
        this.formula = formula;
    }
    boolean checkExistence (String formulaName,int quantity){

            String nameToUpper = formulaName.toUpperCase();
            Map<String, Integer> formulaList = formula.getFormulas().get(nameToUpper);
            List<String> passedChecks = new ArrayList<>();
            List<String> failedChecks = new ArrayList<>();

            for (String ingredient : formulaList.keySet()) {
                if (warehouse.getWarehouse().containsKey(ingredient)) {

                    if (formulaList.get(ingredient) * quantity <= warehouse.unitsPerSupply(ingredient)) {

                        passedChecks.add(ingredient + " exist in warehouse and we have enough units to prepare the formula");

                    } else {

                        int missingUnits = warehouse.unitsPerSupply(ingredient) - formulaList.get(ingredient);
                        failedChecks.add(ingredient + " exist, but we need " + missingUnits + " more units to prepare it");

                    }

                } else {
                    failedChecks.add(ingredient + " doesn't exist in warehouse");
                }
            }


            if (failedChecks.isEmpty()) {
                return true;
            }else{
                System.out.println(failedChecks);

            }
        return false;
    }
    public void checkAvailability() {
        System.out.println("Please enter the Formula name:");
        String formulaName=sc.nextLine();
        System.out.println("Please enter the Formula quantities:");
        int amount= sc.nextInt();


        if(checkExistence(formulaName,amount)){
            System.out.println("There are enough Supplies to create " + amount + " units of " +formulaName);
        }

    }

    HashMap<String, Deque<Supply>> extractingProducts (String formulaName,int quantity){

        String nameToUpper = formulaName.toUpperCase();
        HashMap<String, Deque<Supply>> product = new HashMap<>();

        if (checkExistence(nameToUpper, quantity)) {

            for (Map.Entry<String, Integer> in : formula.getFormulas().get(nameToUpper).entrySet()) {

                product.putAll(warehouse.updateWarehouse(in.getKey(), in.getValue() * quantity));

            }
        }
        return product;
    }

    public void purchase() {
        System.out.println("Please enter the Formula name:");
        String formulaName=sc.nextLine();
        System.out.println("Please enter the Formula quantities:");
        int amount= sc.nextInt();

        HashMap<String, Deque<Supply>> productResult = extractingProducts(formulaName,amount);
        printReceipt(new ReceiptFormat(),productResult);

    }

    private static void printReceipt (Receipts receipt, HashMap < String, Deque < Supply >> product ){
            System.out.println(receipt.print(product));
    }

    public void back() {
        System.out.println("Back to previous menu");
    }



    interface MoveAction {
        void select();
    }

    private WarehouseCommands.MoveAction[] moveActions = new WarehouseCommands.MoveAction[]{
            new WarehouseCommands.MoveAction() {
                public void select() {
                    checkAvailability();
                }
            },
            new WarehouseCommands.MoveAction() {
                public void select() {
                    purchase();
                }
            },
            new WarehouseCommands.MoveAction() {
                public void select() {
                    back();
                }
            },
    };

    public void select(int index) {
        moveActions[index-1].select();
    }
}
