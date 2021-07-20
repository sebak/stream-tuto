package stream.exception.handling;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ExceptionHandlingExample {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("44", "243", "123");
        List<Integer> integerList = list.stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(integerList);

        /**
         Let say now we have a String that is not a number as List<String> list = Arrays.asList("44", "243", "xyz") parseInt will throw numberFormatException
         we can catch that exception in lamda and by doing
         */

        List<String> list1 = Arrays.asList("44", "243", "xyz");

        list1.forEach(ExceptionHandlingExample::printList);

        /**
         Let say we want to manage it in better way by using consumer
         */

        list1.forEach(handleExceptionIfAny(s -> System.out.println(Integer.parseInt(s))));
        //list1.forEach(handleExceptionIfAny(Integer::parseInt)); // if we don't want to print

        /**
         * List<Integer> list2 = Arrays.asList(1, 2, 3, 0);
         *  list2.forEach(handleExceptionIfAny(s -> System.out.println(Integer.parseInt(s))));
         *  will not work because the consumer is a string we have to make it more generic to be use with any type
         */

        System.out.println("************************** GENERIC EXCEPTION MANAGEMENT NumberFormatException *************************");
        list1.forEach(handleGenericExceptionIfAny(s -> System.out.println(Integer.parseInt(s)), NumberFormatException.class));

        System.out.println("************************** GENERIC EXCEPTION MANAGEMENT ArithmeticException *************************");
        List<Integer> list2 = Arrays.asList(1, 2, 3, 0);
        //we want to handle ArithmeticException because division by 0 is forbidden
        list2.forEach(handleGenericExceptionIfAny(s -> System.out.println(10 / s), ArithmeticException.class));

        // handle exception for checkedException

        //list2.forEach(checkedExceptionHandlerConsumer(s -> Thread.sleep(s)));

        list2.forEach(checkedExceptionHandlerConsumer(s -> {
            Thread.sleep(s);
            System.out.println("I have sleep " + s + " millisecond");
        }));
    }

    public static void printList(String s) {
        try {
            System.out.println(Integer.parseInt(s));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * we return a Consumer of String a Consumer is a functional interface who accept and input and return void (nothing)
     * foreach is taking Consumer in param so i return a Consumer in parameter we give a Consumer that we are going to
     * define in caller method
     */
    public static Consumer<String> handleExceptionIfAny(Consumer<String> payload) {
        return obj -> {
            try {
                payload.accept(obj); // we execute our Consumer define as input
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        };
    }

    /**
     * we declare generic function with two parameter, the first is any type the second is any exception that must extends Exception
     * type because we can have any Exception thrown. Class of exception type we expect to handle because we don't not the type before,
     * according to the type of list that will be call we will handle different exception
     */
    public static <T, ObjectException extends Exception> Consumer<T> handleGenericExceptionIfAny(Consumer<T> payload, Class<ObjectException> objectExceptionClass) {
        return obj -> {
            try {
                payload.accept(obj); // we execute our Consumer define as input
            } catch (Exception e) {
                try {
                    ObjectException objException = objectExceptionClass.cast(e);
                    System.out.println("Exception: " + objException.getMessage());
                } catch (ClassCastException castException) {
                    throw e;
                }
            }
        };
    }

    // in param we give our functional interface
    public static <T> Consumer<T> checkedExceptionHandlerConsumer(CheckedExceptionHandlerConsumer<T, Exception> handlerConsumer) {
        return obj -> {
            try {
                handlerConsumer.accept(obj); // we execute our Consumer define as input
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
