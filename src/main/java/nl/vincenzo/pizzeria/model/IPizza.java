package nl.vincenzo.pizzeria.model;


import java.util.Set;

/**
 * This class is responsible for... <undocumented-class>
 */
public interface IPizza {

    void eat();
    Set<Topping> getToppings();
    Sauce getSauce();

}
