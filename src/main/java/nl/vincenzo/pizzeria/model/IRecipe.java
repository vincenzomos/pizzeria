package nl.vincenzo.pizzeria.model;

import java.util.Set;

/**
 * This class is responsible for... <undocumented-class>
 */
public interface IRecipe {

//    PizzaType getPizzaType();
    Sauce getSauce();
    Set<Topping> getToppings();

}
