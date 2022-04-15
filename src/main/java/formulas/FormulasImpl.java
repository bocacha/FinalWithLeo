package formulas;

import app.*;
import org.apache.log4j.Logger;
import warehouse.WarehouseImpl;

import java.util.HashMap;
import java.util.Map;

class FormulasImpl implements Formulas {

    private static Logger logger = Logger.getLogger(FormulasImpl.class);
    private Map<String, Map<String, Integer>> formulaList = new HashMap<>();


    @Override
    public void createFormula(String name) {
        String nameToUpper= name.toUpperCase();
        Map<String, Integer> formula = new HashMap<>();
        formulaList.put(nameToUpper, formula);
        logger.info(nameToUpper + " Formula was created!");

    }

    @Override
    public void addIngredientToFormula(String formulaName, String ingredient, int units) {
        String nameToUpper= formulaName.toUpperCase();
        String ingredientToUpper = ingredient.toUpperCase();

        formulaList.get(nameToUpper).put(ingredientToUpper,units);
        logger.info(units + " " +ingredientToUpper+ " was added to "+ nameToUpper+"!");
    }

    @Override
    public void deleteFormula(String formulaName) {
        formulaList.remove(formulaName);
    }

    @Override
    public Map<String, Map<String, Integer>> getFormulas() {
        return formulaList;
    }
}
