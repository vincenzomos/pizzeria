package nl.vincenzo.pizzeria.model;

import java.util.Set;
import java.util.StringJoiner;

/**
 * This class is responsible for... <undocumented-class>
 */
public class IntermediatePizza {

    private IPizzaBaker pizzaBaker;
    private Sauce sauce;
    private Set<Topping> toppings;
    private IRecipe recipe;


    public static IntermediatePizzaBuilder anIntermediatePizza() {
        return new IntermediatePizzaBuilder();
    }

    public Sauce getSauce() {
        return sauce;
    }

    public Set<Topping> getToppings() {
        return toppings;
    }

    public IRecipe getRecipe() {
        return recipe;
    }

    public IPizzaBaker getPizzaBaker() {
        return pizzaBaker;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", IntermediatePizza.class.getSimpleName() + "[", "]")
                .add("pizzaBaker=" + pizzaBaker)
                .add("sauce=" + sauce)
                .add("toppings=" + toppings)
                .add("recipe=" + recipe)
                .toString();
    }

    public static final class IntermediatePizzaBuilder {
        private IRecipe recipe;
        private Sauce sauce;
        private Set<Topping> toppings;
        private IPizzaBaker pizzaBaker;

        private IntermediatePizzaBuilder() {
        }

        public IntermediatePizzaBuilder fromInstance(IntermediatePizza intermediatePizza) {
            IntermediatePizzaBuilder builder = new IntermediatePizzaBuilder();
            builder.recipe = intermediatePizza.getRecipe();
            builder.sauce = intermediatePizza.getRecipe().getSauce();
            builder.toppings = intermediatePizza.getRecipe().getToppings();
            builder.pizzaBaker = intermediatePizza.getPizzaBaker();
            return builder;
        }

        public IntermediatePizzaBuilder withRecipe(IRecipe recipe) {
            this.recipe = recipe;
            return this;
        }

        public IntermediatePizzaBuilder withPizzaBaker(PizzaBaker baker) {
            this.pizzaBaker = baker;
            return this;
        }

        public IntermediatePizzaBuilder withSauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public IntermediatePizzaBuilder withToppings(Set<Topping> toppings) {
            this.toppings = toppings;
            return this;
        }


//        public IntermediatePizza buildPizzaStepOne() {
//            IntermediatePizza intermediatePizza = new IntermediatePizza();
//            intermediatePizza.recipe = this.recipe;
//            intermediatePizza.pizzaBaker = this.pizzaBaker;
//            intermediatePizza.sauce = this.sauce;
//            return intermediatePizza;
//        }

        public IntermediatePizza buildPizzaBase() {
            IntermediatePizza intermediatePizza = new IntermediatePizza();
            intermediatePizza.recipe = this.recipe;
            intermediatePizza.pizzaBaker = this.pizzaBaker;
            return intermediatePizza;
        }

        public IntermediatePizza buildPizzaStepTwo() {
            IntermediatePizza intermediatePizza = new IntermediatePizza();
            intermediatePizza.recipe = this.recipe;
            intermediatePizza.pizzaBaker = this.pizzaBaker;
            intermediatePizza.sauce = this.sauce;
            intermediatePizza.toppings = this.toppings;
            return intermediatePizza;
        }
    }
}
