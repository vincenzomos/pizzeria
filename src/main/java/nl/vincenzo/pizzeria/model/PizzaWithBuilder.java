package nl.vincenzo.pizzeria.model;

import java.util.Set;

/**
 * This class is responsible for... <undocumented-class>
 */
public class PizzaWithBuilder {

    private Sauce sauce;
    private Set<Topping> toppings;

    private PizzaWithBuilder(Sauce sauce, Set<Topping> toppings) {
        this.sauce = sauce;
        this.toppings = toppings;
    }

    public void eat() {
        System.out.println("Eating the IPizza ");
    }

    public static final class PizzaBuilder {
        private Sauce sauce;
        private Set<Topping> toppings;

        private PizzaBuilder() {
        }


        public static PizzaBuilder aPizza() {
            return new PizzaBuilder();
        }

        public static PizzaBuilder fromOrder(PizzaOrder pizzaOrder) {
            PizzaBuilder pizzaBuilder = new PizzaBuilder();
            pizzaBuilder.sauce = pizzaOrder.getSauce();
            pizzaBuilder.toppings = pizzaOrder.getToppings();
            return pizzaBuilder;
        }

        public PizzaBuilder withSauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public PizzaBuilder withToppings(Set<Topping> toppings) {
            this.toppings = toppings;
            return this;
        }

        public PizzaWithBuilder build() {
            return new PizzaWithBuilder(sauce, toppings);
        }
    }
}
