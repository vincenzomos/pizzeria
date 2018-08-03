package nl.vincenzo.pizzeria;

import nl.vincenzo.pizzeria.model.Director;
import nl.vincenzo.pizzeria.model.IPizzaBaker;
import nl.vincenzo.pizzeria.model.MargeritaRecipe;
import nl.vincenzo.pizzeria.model.OnionAndTunaRecipe;
import nl.vincenzo.pizzeria.model.PizzaBaker;
import nl.vincenzo.pizzeria.model.Sauce;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class PizzeriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzeriaApplication.class, args);

		Director director = new Director(getPizzaBakers());
		director.orderAllKindsOfPizza();
	}

	public static List<IPizzaBaker> getPizzaBakers() {

		PizzaBaker margeritaBaker = PizzaBaker.PizzaBakerBuilder.aPizzaBaker()
				.withPizzaSkills(Set.of(new MargeritaRecipe()))
				.build();

		PizzaBaker onionTunaBaker = PizzaBaker.PizzaBakerBuilder.aPizzaBaker()
				.withPizzaSkills(Set.of(new OnionAndTunaRecipe()))
				.build();

		return List.of(margeritaBaker, onionTunaBaker);
	}


}
