package nl.vincenzo.pizzeria.model;

import java.util.Set;

/**
 * This class is responsible for ... <undocumented-class>
 */
public class OnionAndTunaRecipe implements IRecipe {

    @Override
    public Sauce getSauce() {
        return Sauce.TOMATO;
    }

    @Override
    public Set<Topping> getToppings() {
        return  Set.of(Topping.MOZZA, Topping.TUNA, Topping.ONION);
    }
}
