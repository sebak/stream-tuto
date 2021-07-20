package stream;

import java.util.List;
import java.util.function.Function;

public class MapVsReduceDemo {

   // Map -> transformation of data,
   // Reduce -> aggregating of data
    /**
     * Example: Stream of [2,4,6,9,1,3,7] Sum numbers present in Stream
     *
     *  Map -> transform Stream <Object> to Stream of int
     *  Reduce -> combine Stream of int and produce Sum of it
     *
     */

    public static void main(String[] args) {
        List<Integer> integers = List.of(2,4,6,9,1,3,7);
        
        // in normal approach to sum we will do
        
        int sum = 0;
        for (int val: integers) {
            sum = sum + val;
        }
        System.out.println("Sum of Stream with traditional approach is: " + sum);

        // java 8 approach with matToInt get a Integer value or in and rt

        int sum1 = integers.stream().mapToInt(i -> i).sum();

        System.out.println("Sum of Stream with java 8 and mapToInt approach is: " + sum1);

        // java 8 approach use reduce function (see his prototype)  0 is our init value our binaryOperator function is represent by (a, b) -> a +b

        int sum2 = integers.stream().reduce(0, (a, b) -> a +b);

        System.out.println("Sum of Stream with java 8 and reduce approach is: " + sum2);

        // java 8 approach use reduce function (see his prototype)  with method reference and optional

        int sum3 = integers.stream().reduce(0, (a, b) -> a +b);

        System.out.println("Sum of Stream with java 8 and reduce approach is: " + sum3);
    }
}
