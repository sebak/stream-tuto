package functionalDemo;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

    Consumer<Integer> myConsumer() {
        return integer -> System.out.println("Input value is: " + integer);
    }
    public static void main(String[] args) {
        Consumer<Integer> consumer = integer -> System.out.println("Input value is: " + integer);
        consumer.accept(20);
        ConsumerDemo consumerDemo = new ConsumerDemo();
        consumerDemo.myConsumer().accept(50);

        List<Integer> integerList = List.of(1, 2, 4, 79, 34, 45);

        integerList.forEach(consumer); // forEach take a consumer and it will call automatically method accept
    }
}
