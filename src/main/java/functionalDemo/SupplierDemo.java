package functionalDemo;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo {

    public Supplier<String> defaultString() {
        return () -> "DEFAULT VALUE";
    }

    public static void main(String[] args) {
        SupplierDemo supplierDemo = new SupplierDemo();
        List<String> stringList = List.of("A","B","C");

        System.out.println(stringList.stream()
                .findAny()
                .orElseGet(supplierDemo.defaultString()));

        System.out.println(
                Collections.EMPTY_LIST.stream()
                        .findAny()
                        .orElseGet(supplierDemo.defaultString())
        );

    }
}
