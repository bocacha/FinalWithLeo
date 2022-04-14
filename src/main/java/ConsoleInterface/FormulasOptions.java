package ConsoleInterface;

import app.Warehouse;

import java.util.Scanner;

public class FormulasOptions {

    Warehouse warehouse;

    public FormulasOptions(Warehouse warehouse){
        this.warehouse = warehouse;
    }

    private Scanner sc = new Scanner(System.in);

    public void warehouseMenu() {
        int option=0;
        while(option !=5){
            System.out.println("================================");
            System.out.println("|    1. Check Status           |");
            System.out.println("|    2. Create Supply Storage  |");
            System.out.println("|    3. Add to Supply          |");
            System.out.println("|    4. Delete Supply Storage  |");
            System.out.println("|    5. Exit                   |");
            System.out.println("=================================");
            System.out.println("Please select an option: ");
            System.out.println("=================================");
            option= sc.nextInt();
            WarehouseOptions wo = new WarehouseOptions(warehouse);
            wo.select(option);
        }

    }

    public void warehouseOptions() {
        System.out.println("Menu Principal");
    }

    public void formulaOptions() {
        System.out.println("foto del warehouse");
    }

    public void exit() {
        System.out.println("this is a formula");
    }

    interface MoveAction {
        void select();
    }

    private MenuCommands.MoveAction[] moveActions = new MenuCommands.MoveAction[]{
            new MenuCommands.MoveAction() {
                public void select() {
                    warehouseMenu();
                }
            },
            new MenuCommands.MoveAction() {
                public void select() {
                    warehouseOptions();
                }
            },
            new MenuCommands.MoveAction() {
                public void select() {
                    formulaOptions();
                }
            },
            new MenuCommands.MoveAction() {
                public void select() {
                    exit();
                }
            },
    };

    public void select(int index) {
        moveActions[index-1].select();
    }
}
