package nl.vincenzo.pizzeria.model;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StreamUtils;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class is responsible for... <undocumented-class>
 */
public class Director {

    List<IPizzaBaker> slaves;

    public Director(List<IPizzaBaker> slaves) {
        this.slaves = slaves;
    }

    public List<IntermediatePizza> orderAllKindsOfPizza() {
        List<IntermediatePizza> startOfPizzaOrders = slaves.stream()
                .map(s -> s.startBakingYourPizza())
                .collect(Collectors.toCollection(ArrayList::new));

        List<IntermediatePizza> intermediateResults = processPizzaStep(new ArrayList<IntermediatePizza>(
        ), startOfPizzaOrders, this::isFirstStepOK);
        System.out.println("Boss: Allright Fools Now its ready for step2");



        return intermediateResults;
    }

//    /**
//     *  recursive method to finish pizzas
//     * @param finishedPizzas
//     * @param unfinishedStepOnePizzas
//     * @return
//     */
//    private List<IntermediatePizza> getPizzasInFinishedStepOneState(List<IntermediatePizza> finishedPizzas, List<IntermediatePizza> unfinishedStepOnePizzas) {
//        //basecase
//        if (unfinishedStepOnePizzas.isEmpty()) {
//            return finishedPizzas;
//        }
//        Map<Boolean, List<IntermediatePizza>> firstStepResults = unfinishedStepOnePizzas.stream()
//                .map(pizza -> pizza.getBaker().addSauce(pizza.getRecipe()))
//                .collect(Collectors.partitioningBy(this::isFirstStepOK, Collectors.toCollection(ArrayList::new)));
//
//        finishedPizzas.addAll(firstStepResults.get(Boolean.TRUE));
//        List<IntermediatePizza> newUnfinishedStepOnePizzas = firstStepResults.get(Boolean.FALSE) == null ? new ArrayList<>() : firstStepResults.get(Boolean.FALSE);
//        return getPizzasInFinishedStepOneState(finishedPizzas, newUnfinishedStepOnePizzas);
//    }

    /**
     *  recursive method to finish pizzas
     * @param finishedPizzas
     * @param unfinishedStepOnePizzas
     * @return
     */
    private List<IntermediatePizza> processPizzaStep(List<IntermediatePizza> finishedPizzas, List<IntermediatePizza> unfinishedStepOnePizzas, Predicate<IntermediatePizza> prepareStepOK) {
        //basecase
        if (unfinishedStepOnePizzas.isEmpty()) {
            return finishedPizzas;
        }
        Map<Boolean, List<IntermediatePizza>> firstStepResults = unfinishedStepOnePizzas.stream()
                .map(pizza -> pizza.getBaker().addSauce(pizza.getRecipe()))
                .collect(Collectors.partitioningBy(prepareStepOK, Collectors.toCollection(ArrayList::new)));

        finishedPizzas.addAll(firstStepResults.get(Boolean.TRUE));
        List<IntermediatePizza> newUnfinishedStepOnePizzas = firstStepResults.get(Boolean.FALSE) == null ? new ArrayList<>() : firstStepResults.get(Boolean.FALSE);
        return processPizzaStep(finishedPizzas, newUnfinishedStepOnePizzas, prepareStepOK);
    }


    private boolean isFirstStepOK(IntermediatePizza pizza) {
        return isSauceOk(pizza) && doIThinkItsOK(pizza.getBaker());
    }

    private boolean doIThinkItsOK(IPizzaBaker baker) {
        Random rand = new Random();
        int n = rand.nextInt(100000) + 1;
        if (n == 1) {
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
}
