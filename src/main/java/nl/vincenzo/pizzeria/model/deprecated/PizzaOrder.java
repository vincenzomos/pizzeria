package nl.vincenzo.pizzeria.model.deprecated;

import lombok.Getter;
import nl.vincenzo.pizzeria.model.Sauce;
import nl.vincenzo.pizzeria.model.Topping;

import java.util.Set;

/**
 * This class is responsible for... <undocumented-class>
 */
@Getter
public class PizzaOrder {

    private Sauce sauce;
    private Set<Topping> toppings;


    public static final class PizzaOrderBuilder {
        private Sauce sauce;
        private Set<Topping> toppings;

        private PizzaOrderBuilder() {
        }

        public static PizzaOrderBuilder aPizzaOrder() {
            return new PizzaOrderBuilder();
        }

        public PizzaOrderBuilder withSauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public PizzaOrderBuilder withToppings(Set<Topping> toppings) {
            this.toppings = toppings;
            return this;
        }

        public PizzaOrder build() {
            PizzaOrder pizzaOrder = new PizzaOrder();
            pizzaOrder.sauce = this.sauce;
            pizzaOrder.toppings = this.toppings;
            return pizzaOrder;
        }
    }
}
