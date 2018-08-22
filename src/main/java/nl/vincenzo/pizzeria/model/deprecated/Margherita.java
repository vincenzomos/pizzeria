package nl.vincenzo.pizzeria.model.deprecated;

import lombok.Getter;
import nl.vincenzo.pizzeria.model.IPizza;

import java.util.Set;

/**
 * This class is responsible for... <undocumented-class>
 */
@Getter
public class Margherita  {

    public void eat() {
        System.out.println("Eating pizza: " + this.getClass().getSimpleName());
    }

    public void getToppings() {

    }

    public void getSauce() {

    }


}
