package nl.vincenzo.pizzeria.model;

import java.util.Set;

/**
 * This class is responsible for... <undocumented-class>
 */
public class PizzaBaker implements IPizzaBaker {

    private Set<IPizza> pizzaSkills;


    @Override
    public IPizza bakePiza() {
        return null;
    }

    @Override
    public IPizza addToppings() {
        return null;
    }

    @Override
    public IPizza addSauce() {
        return null;
    }

    public IPizza takePizzaOrder(IPizza pizza) {
        if (pizzaSkills.contains(pizza)) {

        }
        throw new IllegalStateException(" Sorry i can not create  a : " + pizza.getClass().getSimpleName() + "  ask me to create one of " + pizzaSkills);
    }
}
