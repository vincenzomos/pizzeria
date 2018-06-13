package nl.vincenzo.pizzeria.model;

import lombok.Getter;

import java.util.Set;

/**
 * This class is responsible for... <undocumented-class>
 */
@Getter
public class Margherita implements IPizza {

    private static Sauce SAUCE = Sauce.TOMATO;
    private static Set<Topping> TOPPINGS = Set.of(Topping.MOZZA);


    @Override
    public void eat() {
        System.out.println("Eating pizza: " + this.getClass().getSimpleName());
    }


}
