package nl.vincenzo.pizzeria;

import nl.vincenzo.pizzeria.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class PizzeriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzeriaApplication.class, args);

		Director director = new Director(getPizzaBakers());
		Set<IPizza> pizzaSet = director.allKindsOfPizza();

		pizzaSet.stream()
				.forEach(pizza -> pizza.eat());
	}

	public static List<IPizzaBaker> getPizzaBakers() {

		PizzaBaker margeritaBaker = PizzaBaker.PizzaBakerBuilder.aPizzaBaker()
				.withPizzaSkills(new HashSet<>(Arrays.asList(new MargeritaRecipe())))
				.build();

		PizzaBaker onionTunaBaker = PizzaBaker.PizzaBakerBuilder.aPizzaBaker()
				.withPizzaSkills(new HashSet<>(Arrays.asList(new OnionAndTunaRecipe())))
				.build();

		return Arrays.asList(margeritaBaker, onionTunaBaker);
	}


}
