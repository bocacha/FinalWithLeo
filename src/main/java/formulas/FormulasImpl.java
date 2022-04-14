package formulas;

import app.*;

import java.util.HashMap;
import java.util.Map;

class FormulasImpl implements Formulas {

    private Map<String, Map<String, Integer>> formulaList = new HashMap<>();


    @Override
    public void createFormula(String name) {
        String nameToUpper= name.toUpperCase();
        Map<String, Integer> formula = new HashMap<>();
        formulaList.put(nameToUpper, formula);

    }

    @Override
    public void addIngredientToFormula(String formulaName, String ingredient, int units) {
        String nameToUpper= formulaName.toUpperCase();
        String ingredientToUpper = ingredient.toUpperCase();

        formulaList.get(nameToUpper).put(ingredientToUpper,units);

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
