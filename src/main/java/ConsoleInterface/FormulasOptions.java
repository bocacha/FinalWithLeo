package ConsoleInterface;

import app.Formulas;
import app.Warehouse;

import java.util.Map;
import java.util.Scanner;

public class FormulasOptions {

    Formulas formula;

    public FormulasOptions(Formulas formula){

        this.formula= formula;
    }

    private Scanner sc = new Scanner(System.in);

    public void checkStatus() {

        for(String entry: formula.getFormulas().keySet()){
            System.out.println("Formula name : " + entry);
            System.out.println(formula.getFormulas().get(entry));
        }

    }

    public void createFormula() {
        System.out.println("Please enter the new Formula name:");
        String formulaName = sc.nextLine();
        formula.createFormula(formulaName);

        int option=0;
        while(option != 2){
            System.out.println("Do you want to add an Ingredient to the Formula? 1)YES 2)NO");
            option = sc.nextInt();
            if(option==1){
                System.out.println("Please input the Ingredient name:");
                sc.nextLine();
                String ingredient=sc.nextLine();
                System.out.println("Enter the number of Units:");
                int units=sc.nextInt();
                formula.addIngredientToFormula(formulaName,ingredient,units);
            }
        }

    }

    public void deleteFormula() {
        System.out.println("Enter the Name of the Formula to Delete:");
        String name=sc.nextLine();
        formula.deleteFormula(name);
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
                    checkStatus();
                }
            },
            new WarehouseCommands.MoveAction() {
                public void select() {
                    createFormula();
                }
            },
            new WarehouseCommands.MoveAction() {
                public void select() {
                    deleteFormula();
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
