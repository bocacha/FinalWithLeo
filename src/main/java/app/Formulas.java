package app;

import java.util.Map;

public interface Formulas {
    void createFormula(String name);
    void addIngredientToFormula(String formulaName, String ingredient, int units);
    void deleteFormula(String formulaName);
    Map<String, Map<String, Integer>> getFormulas();
}
