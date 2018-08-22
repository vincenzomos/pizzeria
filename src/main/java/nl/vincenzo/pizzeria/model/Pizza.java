package nl.vincenzo.pizzeria.model;

import java.util.Set;

/**
 * This class is responsible for... <undocumented-class>
 */
public class Pizza implements IPizza {

    private IRecipe recipe;
    private Sauce sauce;
    private Set<Topping> toppings;

    public Pizza(PizzaBuilder pizzaBuilder) {
        this.recipe = pizzaBuilder.recipe;
        this.sauce = pizzaBuilder.sauce;
        this.toppings = pizzaBuilder.toppings;
    }

    @Override
    public Sauce getSauce() {
        return sauce;
    }

    @Override
    public Set<Topping> getToppings() {
        return toppings;
    }

    public void eat() {
        System.out.println("Eating the pizza of Type  " + recipe);
    }

    public static PizzaBuilder aPizza() {
        return new PizzaBuilder();
    }

    public static final class PizzaBuilder {
        private IRecipe recipe;
        private Sauce sauce;
        private Set<Topping> toppings;

        private PizzaBuilder() {
        }

//        public static PizzaBuilder fromOrder(PizzaOrder pizzaOrder) {
//            PizzaBuilder pizzaBuilder = new PizzaBuilder();
//            pizzaBuilder.sauce = pizzaOrder.getSauce();
//            pizzaBuilder.toppings = pizzaOrder.getToppings();
//            return pizzaBuilder;
//        }

        public PizzaBuilder fromIntermediatePizza(IntermediatePizza pizza) {
            this.recipe = pizza.getRecipe();
            this.sauce = pizza.getSauce();
            this.toppings = pizza.getToppings();
            return this;
        }


        public PizzaBuilder withSauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public PizzaBuilder withToppings(Set<Topping> toppings) {
            this.toppings = toppings;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}
