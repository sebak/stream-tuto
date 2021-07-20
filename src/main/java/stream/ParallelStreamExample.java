package stream;

import java.util.stream.IntStream;

public class ParallelStreamExample {
    /*
    In sequential stream task are executed by  many thread in one core of the computer that mean that the result are predicted because there is order of execution.
    In parallel stream all the core of computer execute the task i want to parallelize, i can't predict witch task are going to finish first, the threads
    on each core can finish before another one
    * */

    public static void main(String[] args) {
        // When range is less than 2000 on my computer sequential stream have better performance than parallel Stream but after 2000 data that parallel stream give better performance
        int start = 1;
        int end = 10000;

        long startTime1 = System.currentTimeMillis();
        IntStream.range(start, end).forEach(System.out::println);
        long endTime1 = System.currentTimeMillis();

        System.out.println("===========================Parallel Stream====================================");

        long startTime2 = System.currentTimeMillis();
        IntStream.range(start, end).parallel().forEach(System.out::println);
        long endTime2 = System.currentTimeMillis();

        System.out.println("===========================Performance====================================");

        System.out.println(String.format("Execution time for sequential stream execution %s milli second", endTime1 - startTime1));

        System.out.println(String.format("Execution time for parallel stream execution %s milli second", endTime2 - startTime2));

        System.out.println(" ********************* Witch thread work in sequential stream in one core **********************");
        // there is only one thread that work
        IntStream.range(1, 10).forEach(value -> System.out.println("ThreadName:" + Thread.currentThread().getName() + " " + value));

        System.out.println(" ********************* Witch thread work in parallel stream in many core **********************");
       // there is many thread that work
        IntStream.range(1, 10).parallel()
                .forEach(value -> System.out.println("ThreadName:" + Thread.currentThread().getName() + " " + value));
    }
}
