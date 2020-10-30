import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AveragingList {

    public static void main(String[] args) {
        //Long
        List<Long> longValues = Arrays.asList(100L, 200L, 300L);
        Double result1 = longValues
                .stream()
                .collect(Collectors.averagingLong(x -> x * 2));
        System.out.println(result1);

        //Integer
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 6);
        Double result2 = integers
                .stream()
                .collect(Collectors.averagingInt(x -> x * 2));
        System.out.println(result2);

        //Double
        List<Double> doubles = Arrays.asList(1.1, 2.0, 3.0, 4.0, 5.0, 5.0);
        Double result3 = doubles
                .stream()
                .collect(Collectors.averagingDouble(x -> x));
        System.out.println(result3);
    }
}