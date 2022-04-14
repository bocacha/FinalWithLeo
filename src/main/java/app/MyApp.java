package app;

import ConsoleInterface.FormulaCommand;
import ConsoleInterface.PurchaseCommand;
import ConsoleInterface.WarehouseCommands;
import formulas.*;
import warehouse.*;
import java.util.*;


public class MyApp {


    static WarehouseFactory factory = new WarehouseFactoryImpl();
    static FormulasFactory formulas = new FormulasFactoryImpl();
    static Formulas formula = formulas.create();
    static Warehouse warehouse = factory.create();
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        initializeValues();
        WarehouseCommands menuW = new WarehouseCommands(warehouse);
        FormulaCommand menuF = new FormulaCommand(formula);
        PurchaseCommand menuP = new PurchaseCommand(warehouse,formula);

        int option = 0;
        //warehouse.createSupply("Corn");
        System.out.println();
        while (option !=5){
            System.out.println("================================");
            System.out.println("|      FEED FACTORY MENU        |");
            System.out.println("================================");
            System.out.println("| Options:                      |");
            System.out.println("|    1. Warehouse               |");
            System.out.println("|    2. Formulas                |");
            System.out.println("|    3. Purchases               |");
            System.out.println("|    4. Reports                 |");
            System.out.println("|    5. Exit System             |");
            System.out.println("=================================");
            System.out.println("Please enter your option: ");
            System.out.println("=================================");

            option = sc.nextInt();
            if(option==1){
                menuW.select(1);
            }else if(option==2){
                menuF.select(1);
            }else if(option==3){
                menuP.select(1);
            }


        }
    }
        //printMenu(new MenuFormat());


//        printReport(new ConsoleReportFirstFormat(), warehouse);
//
////        checkExistence("f1");
//       warehouse.updateWarehouse("corn", 5);
////       warehouse.deleteSupply("corn");
//        printReport(new ConsoleReportFirstFormat(), warehouse);
//
//
//        warehouse.updateWarehouse("corn",21);
//        printReport(new ConsoleReportFirstFormat(), warehouse);

//        HashMap<String, Deque<Supply>> firstReceipt = extractingProducts("F1", 5);
//
//        printReport(new ConsoleReportFirstFormat(), warehouse);
//        printReceipt(new ReceiptFormat(), firstReceipt);
//       }
//    private static int printMenu(CommandInterface myInterface) {
//        System.out.println(myInterface.InteractiveInterface());
//        int option=0;
//        option= Integer.parseInt(sc.nextLine());
//        return option;
//    }

//        private static void printReport (Reports report, Warehouse warehouse){
//            System.out.println(report.printReport(warehouse));
//        }
//        private static void printReceipt (Receipts receipt, HashMap < String, Deque < Supply >> product ){
//            System.out.println(receipt.print(product));
//        }
//
        static void initializeValues() {


            warehouse.createSupply("Corn");
            warehouse.addSuppliesToWarehouse("corn", "Leonardo", 20, 98.43);
            warehouse.addSuppliesToWarehouse("corn", "Richard", 40, 99.32);
            warehouse.addSuppliesToWarehouse("corn", "Godofredo", 12, 51.02);

            warehouse.createSupply("Sorghum");
            warehouse.addSuppliesToWarehouse("Sorghum", "Leonardo", 20, 98.43);
            warehouse.addSuppliesToWarehouse("Sorghum", "Richard", 40, 99.32);
            warehouse.addSuppliesToWarehouse("Sorghum", "Godofredo", 12, 51.02);

            warehouse.createSupply("Soybean flour");
            warehouse.addSuppliesToWarehouse("Soybean flour", "Leonardo", 20, 98.43);
            warehouse.addSuppliesToWarehouse("Soybean flour", "Richard", 40, 99.32);
            warehouse.addSuppliesToWarehouse("Soybean flour", "Godofredo", 12, 51.02);

            warehouse.createSupply("Mineral supplements");
            warehouse.addSuppliesToWarehouse("Mineral supplements", "Leonardo", 20, 98.43);
            warehouse.addSuppliesToWarehouse("Mineral supplements", "Richard", 40, 99.32);
            warehouse.addSuppliesToWarehouse("Mineral supplements", "Godofredo", 12, 51.02);

            warehouse.createSupply("Vitamins");
            warehouse.addSuppliesToWarehouse("Vitamins", "Leonardo", 20, 98.43);
            warehouse.addSuppliesToWarehouse("Vitamins", "Richard", 40, 99.32);
            warehouse.addSuppliesToWarehouse("Vitamins", "Godofredo", 12, 51.02);

            formula.createFormula("f1");
            formula.addIngredientToFormula("f1", "Corn", 5);
            formula.addIngredientToFormula("f1", "Soybean flour", 3);
            formula.addIngredientToFormula("f1", "Vitamins", 3);
            formula.addIngredientToFormula("f1", "Sorghum", 3);


            formula.createFormula("f2");
            formula.addIngredientToFormula("f2", "corn", 6);
            formula.addIngredientToFormula("f2", "Soybean flour", 4);
            formula.addIngredientToFormula("f2", "Vitamins", 1);
            formula.addIngredientToFormula("f2", "Sorghum", 3);
            formula.addIngredientToFormula("f2", "Mineral supplements", 2);

            formula.createFormula("f3");
            formula.addIngredientToFormula("f3", "corn", 7);
            formula.addIngredientToFormula("f3", "Soybean flour", 5);
            formula.addIngredientToFormula("f3", "Sorghum", 2);
            formula.addIngredientToFormula("f3", "Mineral supplements", 4);

        }
//
//        static boolean checkExistence (String formulaName,int quantity){
//
//            String nameToUpper = formulaName.toUpperCase();
//            Map<String, Integer> formulaList = formula.getFormulas().get(nameToUpper);
//            List<String> passedChecks = new ArrayList<>();
//            List<String> failedChecks = new ArrayList<>();
//
//            for (String ingredient : formulaList.keySet()) {
//                if (warehouse.getWarehouse().containsKey(ingredient)) {
//
//                    if (formulaList.get(ingredient) * quantity <= warehouse.unitsPerSupply(ingredient)) {
//
//                        passedChecks.add(ingredient + " exist in warehouse and we have enough units to prepare the formula");
//
//                    } else {
//
//                        int missingUnits = warehouse.unitsPerSupply(ingredient) - formulaList.get(ingredient);
//                        failedChecks.add(ingredient + " exist, but we need " + missingUnits + " more units to prepare it");
//
//                    }
//
//                } else {
//                    failedChecks.add(ingredient + " doesn't exist in warehouse");
//                }
//            }
//
//
//            if (failedChecks.isEmpty()) {
//                return true;
//            }
//            System.out.println(failedChecks);
//            return false;
//        }
//
//        static HashMap<String, Deque<Supply>> extractingProducts (String formulaName,int quantity){
//
//            String nameToUpper = formulaName.toUpperCase();
//            HashMap<String, Deque<Supply>> product = new HashMap<>();
//
//            if (checkExistence(nameToUpper, quantity)) {
//
//                for (Map.Entry<String, Integer> in : formula.getFormulas().get(nameToUpper).entrySet()) {
//
//                    product.putAll(warehouse.updateWarehouse(in.getKey(), in.getValue() * quantity));
//
//                }
//            }
//            return product;
//        }


    }




