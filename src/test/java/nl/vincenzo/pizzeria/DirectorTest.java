package nl.vincenzo.pizzeria;

import nl.vincenzo.pizzeria.model.Director;
import nl.vincenzo.pizzeria.model.IPizza;
import nl.vincenzo.pizzeria.model.IPizzaBaker;
import nl.vincenzo.pizzeria.model.MargeritaRecipe;
import nl.vincenzo.pizzeria.model.OnionAndTunaRecipe;
import nl.vincenzo.pizzeria.model.PizzaBaker;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class is responsible for... <undocumented-class>
 */
public class DirectorTest {

    @Test
    public void runPizzaBakingSimulation() {
        Director director = new Director(getPizzaBakers());
        Set<IPizza> allPizzas = director.allKindsOfPizza();

        //eat all
        allPizzas.stream()
                .forEach(pizza -> pizza.eat());

    }

    public static List<IPizzaBaker> getPizzaBakers() {

        PizzaBaker margeritaBaker = PizzaBaker.PizzaBakerBuilder.aPizzaBaker()
                .withPizzaSkills(new HashSet<>(Arrays.asList(new MargeritaRecipe())))
                .withName("Mario")
                .build();

        PizzaBaker onionTunaBaker = PizzaBaker.PizzaBakerBuilder.aPizzaBaker()
                .withPizzaSkills(new HashSet<>(Arrays.asList(new OnionAndTunaRecipe())))
                .withName("Pepe")
                .build();

        return Arrays.asList(margeritaBaker, onionTunaBaker);
    }
}
