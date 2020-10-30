import java.util.Arrays;
import java.util.List;

public class SummingList {

    public static void main(String[] args) {
        //Integers
        List<String> strings = Arrays.asList("alpha", "beta", "gamma");
        int result1 = strings
                .stream().mapToInt(String::length).sum();
        System.out.println(result1);

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 6);
        result1 = integers.stream().mapToInt(x -> x).sum();
        System.out.println(result1);

        //Doubles
        List<Double> doubleValues = Arrays.asList(1.1, 2.0, 3.0, 4.0, 5.0, 5.0);
        Double result2 = doubleValues.stream().mapToDouble(x -> x).sum();
        System.out.println(result2);

        //Long
        List<Long> longValues = Arrays.asList(100L, 200L, 300L);
        Long result3 = longValues.stream().mapToLong(x -> x).sum();
        System.out.println(result3);
    }
}