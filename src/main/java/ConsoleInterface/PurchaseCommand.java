package ConsoleInterface;

import app.Formulas;
import app.Warehouse;

import java.util.Scanner;

public class PurchaseCommand {

    Warehouse warehouse;
    Formulas formula;

    public PurchaseCommand(Warehouse warehouse,Formulas formula){

        this.warehouse = warehouse;
        this.formula = formula;
    }

    private Scanner sc = new Scanner(System.in);

    public void purchaseMenu() {
        int option=0;
        while(option !=3){
            System.out.println("================================");
            System.out.println("|    1. Check Availability     |");
            System.out.println("|    2. Purchase               |");
            System.out.println("|    3. Exit                   |");
            System.out.println("=================================");
            System.out.println("Please select an option: ");
            System.out.println("=================================");
            option= sc.nextInt();
            PurchaseOptions po = new PurchaseOptions(warehouse,formula);
            po.select(option);
        }

    }

    public void exit() {
        System.out.println("this is a formula");
    }

    interface MoveAction {
        void select();
    }

    private WarehouseCommands.MoveAction[] moveActions = new WarehouseCommands.MoveAction[]{
            new WarehouseCommands.MoveAction() {
                public void select() {
                    purchaseMenu();
                }
            },
            new WarehouseCommands.MoveAction() {
                public void select() {
                    exit();
                }
            },
    };

    public void select(int index) {
        moveActions[index-1].select();
    }
}
