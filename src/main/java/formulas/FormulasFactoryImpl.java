package formulas;

import app.Formulas;
import app.FormulasFactory;


public class FormulasFactoryImpl implements FormulasFactory {
    @Override
    public Formulas create() {
        return new FormulasImpl();
    }
}
