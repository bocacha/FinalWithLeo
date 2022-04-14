package ConsoleInterface;

import app.Formulas;
import app.Warehouse;

import java.util.Scanner;

public class FormulaCommand {

    Formulas formula;

    public FormulaCommand(Formulas formula){

        this.formula = formula;
    }

    private Scanner sc = new Scanner(System.in);



    public void formulaMenu() {
        int option=0;
        while(option !=4){
            System.out.println("=================================");
            System.out.println("|    1. Check Status            |");
            System.out.println("|    2. Create Formula          |");
            System.out.println("|    3. Delete Formula          |");
            System.out.println("|    4. Exit                    |");
            System.out.println("=================================");
            System.out.println("Please select an option: ");
            System.out.println("=================================");
            option= sc.nextInt();
            FormulasOptions fo = new FormulasOptions(formula);
            fo.select(option);
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
                    formulaMenu();
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
