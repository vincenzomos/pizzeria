package nl.vincenzo.pizzeria.model;

import java.util.Set;

/**
 * This class is responsible for ... <undocumented-class>
 */
public interface IPizzaBaker {

    String getName();
    IntermediatePizza bakePiza(IntermediatePizza intermediatePizza);

    IntermediatePizza addToppings(IntermediatePizza IntermediatePizza);

    IntermediatePizza addSauce(IntermediatePizza IntermediatePizza);

    IntermediatePizza startBakingYourPizza();

    Set<IRecipe> getPizzaSkills();

}
