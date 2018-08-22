package nl.vincenzo.pizzeria.model;

/**
 * This class is responsible for... <undocumented-class>
 */
public enum PizzaPrepareStepType {
    ADD_SAUCE {
        @Override
        public IntermediatePizza actionOnPizza(IntermediatePizza pizza) {
            return  pizza.getPizzaBaker().addSauce(pizza);
        }
    }, ADD_TOPPING {
        @Override
        public IntermediatePizza actionOnPizza(IntermediatePizza pizza) {

            return pizza.getPizzaBaker().addToppings(pizza);
        }
    };

    public abstract IntermediatePizza actionOnPizza(IntermediatePizza pizza);


}
