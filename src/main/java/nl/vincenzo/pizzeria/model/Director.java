package nl.vincenzo.pizzeria.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class is responsible for... <undocumented-class>
 */
public class Director {

    List<IPizzaBaker> pizzaBakerSlaves;

    public Director(List<IPizzaBaker> slaves) {
        this.pizzaBakerSlaves = slaves;
    }

    public Set<IPizza> allKindsOfPizza() {
        List<IntermediatePizza> startOfPizzaOrders = pizzaBakerSlaves.stream()
                .map(s -> s.startBakingYourPizza())
                .collect(Collectors.toCollection(ArrayList::new));

        PizzaPrepareStep stepOfAddingSauce = new PizzaPrepareStep(this::isFirstStepFinished, PizzaPrepareStepType.ADD_SAUCE);

        List<IntermediatePizza> basePizzasWithSauce = processPizzaStep(new ArrayList<IntermediatePizza>(
        ), startOfPizzaOrders, stepOfAddingSauce);
        System.out.println("Boss: Allright You Fools Now its ready for step2");

        PizzaPrepareStep stepOfAddingToppings = new PizzaPrepareStep(this::isSecondStepFinished, PizzaPrepareStepType.ADD_TOPPING);

        List<IntermediatePizza> intermediateResultsAfterStep2 = processPizzaStep(new ArrayList<IntermediatePizza>(
        ), basePizzasWithSauce, stepOfAddingToppings);

        System.out.println("Boss: Finally idiots you're done , let's let the customer decide what he wants.");

        return intermediateResultsAfterStep2.stream()
                .map(pizza -> Pizza.aPizza().fromIntermediatePizza(pizza).build())
                .collect(Collectors.toSet());

    }

    /**
    /**
     *  recursive method to finish pizzas
     * @param finishedPizzas
     * @param unfinishedStepOnePizzas
     * @return
     */
    private List<IntermediatePizza> processPizzaStep(List<IntermediatePizza> finishedPizzas, List<IntermediatePizza> unfinishedStepOnePizzas, PizzaPrepareStep pizzaPrepareStep) {
        //basecase
        if (unfinishedStepOnePizzas.isEmpty()) {
            return finishedPizzas;
        }
        Map<Boolean, List<IntermediatePizza>> firstStepResults = unfinishedStepOnePizzas.stream()
                .map(pizza -> pizzaPrepareStep.processPrepareStep(pizza))
                .collect(Collectors.partitioningBy(pizzaPrepareStep::isPrepareStepOk, Collectors.toCollection(ArrayList::new)));

        finishedPizzas.addAll(firstStepResults.get(Boolean.TRUE));
        List<IntermediatePizza> newUnfinishedStepOnePizzas = firstStepResults.get(Boolean.FALSE) == null ? new ArrayList<>() : firstStepResults.get(Boolean.FALSE);
        return processPizzaStep(finishedPizzas, newUnfinishedStepOnePizzas, pizzaPrepareStep);
    }


    private boolean isFirstStepFinished(IntermediatePizza pizza) {
        return isSauceOk(pizza) && doIThinkItsOK(pizza.getPizzaBaker());
    }

    private boolean isSecondStepFinished(IntermediatePizza pizza) {
        return isToppingOk(pizza) && doIThinkItsOK(pizza.getPizzaBaker());
    }

    private boolean doIThinkItsOK(IPizzaBaker baker) {
        Random rand = new Random();
        int n = rand.nextInt(10);
        if (n > 5) {
            System.out.println("Boss: Pizza is OK " + baker.getName());
            return true;
        } else {
            System.out.println("Boss: Vaffanculo " + baker.getName() + ", Do it again");
            return false;
        }
    }

    private boolean isSauceOk(IntermediatePizza pizza) {
        return pizza.getSauce().equals(pizza.getRecipe().getSauce());
    }
    private boolean isToppingOk(IntermediatePizza pizza) {
        return pizza.getSauce().equals(pizza.getRecipe().getSauce());
    }
}
