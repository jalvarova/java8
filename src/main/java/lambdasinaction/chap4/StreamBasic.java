package lambdasinaction.chap4;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class StreamBasic {

    public static void main(String...args){
        // Java 7
        getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);

        System.out.println("---");

        // Java 8
        getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);

        //getLowCaloricDishesByCaloriasInJava8(Dish.menu).forEach(System.out::println);

    }

    public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes){
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for(Dish d: dishes){
            if(d.getCalories() < 400){
                lowCaloricDishes.add(d);
            }
        }
        List<String> lowCaloricDishesName = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            public int compare(Dish d1, Dish d2){
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        for(Dish d: lowCaloricDishes){
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }

    public static List<Integer> getLowCaloricDishesNamesInJava8(List<Dish> dishes){
        return dishes.parallelStream()
                .filter(d -> d.getCalories() < 550)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getCalories).distinct()
                .collect(toList());
    }

    public static Map<Integer, List<Dish>> getLowCaloricDishesByCaloriasInJava8(List<Dish> dishes){
        return dishes.parallelStream()
                .filter(d -> d.getCalories() < 550)
                .sorted(comparing(Dish::getCalories))
                .collect(groupingBy(Dish::getCalories));

    }
}
