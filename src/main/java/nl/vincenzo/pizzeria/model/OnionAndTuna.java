package nl.vincenzo.pizzeria.model;

import lombok.Getter;

import java.util.Set;

/**
 * This class is responsible for... <undocumented-class>
 */
@Getter
public class OnionAndTuna implements IPizza {

    private static Sauce SAUCE = Sauce.TOMATO;
    private static Set<Topping> TOPPINGS = Set.of(Topping.MOZZA, Topping.TUNA, Topping.ONION);

    @Override
    public void eat() {
        System.out.println("Eating pizza: " + this.getClass().getSimpleName());
    }


}
