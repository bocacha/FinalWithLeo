package ConsoleInterface;

import ConsoleInterface.MenuCommands;
import app.Warehouse;

import java.util.Scanner;

public class WarehouseOptions  {

    Warehouse warehouse;
    static Scanner sc = new Scanner(System.in);

    public WarehouseOptions( Warehouse warehouse){
        this.warehouse = warehouse;
    }

    public void checkStatus() {
        //System.out.println(warehouse.getWarehouse().entrySet());
        for(String entry : warehouse.getWarehouse().keySet()){
            System.out.println(entry);
            System.out.println(warehouse.getWarehouse().get(entry));
        }
    }

    public void createSupplyStorage() {
        System.out.println("Please enter the new Storage supply:");
        String storageName= sc.nextLine();
        warehouse.createSupply(storageName);

    }

    public void addToStorage() {

        System.out.println("Enter new Supply name:");
        String description=sc.nextLine();
        System.out.println("Please enter your Name:");
        String name = sc.nextLine();
        System.out.println("How many units will be entered to Warehouse?");
        int units = sc.nextInt();
        System.out.println("Please enter the supplies price:");
        double price = sc.nextDouble();
        warehouse.addSuppliesToWarehouse(description,name,units,price);
    }



    public void something(){
        System.out.println("To delete the last element in your Storage:");
        System.out.println("Please enter your Storage name");
        String supply=sc.nextLine();
        warehouse.deleteSupply(supply);

    }

    public void back() {
        System.out.println("this is a formula");
    }

    interface MoveAction {
        void select();
    }

    private MenuCommands.MoveAction[] moveActions = new MenuCommands.MoveAction[]{
            new MenuCommands.MoveAction() {
                public void select() {
                    checkStatus();
                }
            },
            new MenuCommands.MoveAction() {
                public void select() {
                    createSupplyStorage();
                }
            },
            new MenuCommands.MoveAction() {
                public void select() {
                    addToStorage();
                }
            },
            new MenuCommands.MoveAction() {
                public void select() {
                    something();
                }
            },
            new MenuCommands.MoveAction() {
                public void select() {
                    back();
                }
            },
    };

    public void select(int index) {
        moveActions[index-1].select();
    }
}
