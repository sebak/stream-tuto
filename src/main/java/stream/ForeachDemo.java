package stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class ForeachDemo {

    public Predicate<String> ignoreCaseStartWith(final String prefix) {
        return string -> string.toUpperCase().startsWith(prefix.toUpperCase());
    }

    public static void main(String[] args) {
        ForeachDemo foreachDemo = new ForeachDemo();
        List<String> stringList = List.of("MARIE","BORRIS","CAMILLE", "MARK");
        stringList.stream().forEach(s -> System.out.println(s));

        Map<Integer, String> integerStringMap = Map.of(1, "MARIE", 2, "BORRIS", 3, "CAMILLE" , 4, "MARK");

        integerStringMap.forEach(((integer, s) -> System.out.println("key: " + integer + " Value: " + s)));

        stringList.stream().filter(foreachDemo.ignoreCaseStartWith("m")).forEach(s -> System.out.println(s));
        integerStringMap.entrySet().stream().filter(key -> key.getKey() % 2 == 0).forEach(integerStringEntry -> System.out.println(integerStringEntry));

    }
}
