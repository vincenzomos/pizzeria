package nl.vincenzo.pizzeria.model;

import java.util.Set;

/**
 * This class is responsible for... <undocumented-class>
 */
public class PizzaBaker implements IPizzaBaker {

    private Set<IRecipe> pizzaSkills;
    private String name;

    @Override
    public IntermediatePizza bakePiza(IntermediatePizza intermediatePizzaStepTwo) {
        if (pizzaSkills.contains(intermediatePizzaStepTwo.getRecipe())) {
            System.out.println("Ok Chef I'll bake the pizza");
            return IntermediatePizza.anIntermediatePizza().withToppings(intermediatePizzaStepTwo.getRecipe().getToppings())
                    .buildPizzaStepOne();
        }
        throw new IllegalStateException(" Sorry i can not create  a : " + intermediatePizzaStepTwo.getRecipe().getClass().getSimpleName() + "  ask me to create one of " + pizzaSkills);
    }

    @Override
    public IntermediatePizza addToppings(IntermediatePizza intermediatePizzaStepOne) {
        if (pizzaSkills.contains(intermediatePizzaStepOne.getRecipe())) {
            System.out.println(name + ": Ok Chef I'll add the Toppings");
            return IntermediatePizza.anIntermediatePizza().withToppings(intermediatePizzaStepOne.getRecipe().getToppings())
                    .buildPizzaStepOne();
        }
        throw new IllegalStateException(" Sorry i can not create  a : " + intermediatePizzaStepOne.getRecipe().getClass().getSimpleName() + "  ask me to create one of " + pizzaSkills);
    }

    @Override
    public IntermediatePizza addSauce(IRecipe recipe) {
        if (pizzaSkills.contains(recipe)) {
            System.out.println(name + ": Ok Boss I am adding the Sauce");
            return IntermediatePizza.anIntermediatePizza()
                    .withPizzaBaker(this)
                    .withRecipe(recipe)
                    .buildPizzaStepOne();
        }
        throw new IllegalStateException(" Sorry i can not create  a : " + recipe.getClass().getSimpleName() + "  ask me to create one of " + pizzaSkills);
    }

    @Override
    public IntermediatePizza startBakingYourPizza() {
        IRecipe recipe = pizzaSkills.stream().findFirst().get();
        System.out.println(name + ": OK Boss I know a " + recipe.getClass().getSimpleName());
        return IntermediatePizza.anIntermediatePizza()
                .withPizzaBaker(this)
                .withRecipe(recipe)
                .buildPizzaBase();
    }

    @Override
    public Set<IRecipe> getPizzaSkills() {
        return pizzaSkills;
    }

    @Override
    public String getName() {
        return name;
    }

    public static final class PizzaBakerBuilder {
        private Set<IRecipe> pizzaSkills;
        private String name;

        private PizzaBakerBuilder() {
        }

        public static PizzaBakerBuilder aPizzaBaker() {
            return new PizzaBakerBuilder();
        }

        public PizzaBakerBuilder withPizzaSkills(Set<IRecipe> pizzaSkills) {
            this.pizzaSkills = pizzaSkills;
            return this;
        }

        public PizzaBakerBuilder withName(String name) {
            this.name = name;
            return this;
        }


        public PizzaBaker build() {
            PizzaBaker pizzaBaker = new PizzaBaker();
            pizzaBaker.pizzaSkills = this.pizzaSkills;
            pizzaBaker.name = this.name;
            return pizzaBaker;
        }
    }
}
