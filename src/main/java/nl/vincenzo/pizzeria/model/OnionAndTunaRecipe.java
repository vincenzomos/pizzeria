package nl.vincenzo.pizzeria.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This class is responsible for ... <undocumented-class>
 */
public class OnionAndTunaRecipe implements IRecipe {

    public Sauce getSauce() {
        return Sauce.TOMATO;
    }

    public Set<Topping> getToppings() {
        return  new HashSet<>(Arrays.asList(Topping.MOZZA, Topping.TUNA, Topping.ONION));

    }
}
