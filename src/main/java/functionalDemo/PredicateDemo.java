package functionalDemo;

import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

    public Predicate<Integer> isPair() {
        return integer -> {
            if (integer % 2 == 0) return true;
            return false;
        };
    }

    public static void main(String[] args) {
        PredicateDemo predicateDemo = new PredicateDemo();
        int value1  = 4;
        int value2  = 7;
        System.out.println(value1 + " is pair ? " + predicateDemo.isPair().test(value1));
        System.out.println(value2 + " is pair ? " + predicateDemo.isPair().test(value2));


        List<Integer> integerList = List.of(1, 2, 4, 79, 34, 45);
        integerList.stream()
        .filter(predicateDemo.isPair())
                .forEach(integer -> System.out.println(integer + " Is Pair"));

    }
}
