package nl.vincenzo.pizzeria.model;

import java.util.Set;

/**
 * This class is responsible for... <undocumented-class>
 */
public class IntermediatePizza {

    private IPizzaBaker baker;
    private Sauce sauce;
    private Set<Topping> toppings;
    private IRecipe recipe;


    public static IntermediatePizzaBuilder anIntermediatePizza() {
        return new IntermediatePizzaBuilder();
    }


    public static IntermediatePizza buildPizzaStepOne(IntermediatePizzaBuilder builder) {
        IntermediatePizza intermediatePizza = new IntermediatePizza();
        if(builder.recipe == null) {
            throw new IllegalArgumentException("I need the recipe becasue I cant remember s#&t");
        }
        intermediatePizza.recipe = builder.recipe;
        intermediatePizza.baker = builder.baker;
        intermediatePizza.sauce = builder.recipe.getSauce();
        return intermediatePizza;
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

    public IPizzaBaker getBaker() {
        return baker;
    }

    public static final class IntermediatePizzaBuilder {
        private IRecipe recipe;
        private Sauce sauce;
        private Set<Topping> toppings;
        private PizzaBaker baker;

        private IntermediatePizzaBuilder() {
        }

        public IntermediatePizzaBuilder withRecipe(IRecipe recipe) {
            this.recipe = recipe;
            return this;
        }

        public IntermediatePizzaBuilder withPizzaBaker(PizzaBaker baker) {
            this.baker = baker;
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


        public IntermediatePizza buildPizzaStepOne() {
            return IntermediatePizza.buildPizzaStepOne(this);
        }

        public IntermediatePizza buildPizzaBase() {
            IntermediatePizza intermediatePizza = new IntermediatePizza();
            intermediatePizza.recipe = this.recipe;
            intermediatePizza.baker = this.baker;
            return intermediatePizza;
        }


        public IntermediatePizza buildPizzaStepTwo() {
            IntermediatePizza intermediatePizza = new IntermediatePizza();
            intermediatePizza.sauce = this.sauce;
            intermediatePizza.toppings = this.toppings;
            return intermediatePizza;
        }
    }
}
