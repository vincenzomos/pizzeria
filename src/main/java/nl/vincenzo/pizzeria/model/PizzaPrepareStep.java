package nl.vincenzo.pizzeria.model;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * This class is responsible for... <undocumented-class>
 */
public class PizzaPrepareStep {

    private PizzaPrepareStepType pizzaPrepareStepType;
    private Predicate<IntermediatePizza> validator;

    public PizzaPrepareStep(Predicate<IntermediatePizza> validator, PizzaPrepareStepType pizzaPrepareStepType) {
        this.validator = validator;
        this.pizzaPrepareStepType = pizzaPrepareStepType;
    }

    boolean isPrepareStepOk(IntermediatePizza pizza) {
            return validator.test(pizza);
    }

    public IntermediatePizza processPrepareStep(IntermediatePizza pizza) {
        return pizzaPrepareStepType.actionOnPizza(pizza);
    }

}
