import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FindMinimum {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 6);
        System.out.println(integers.stream().min(Comparator.naturalOrder()).get());

        List<String> strings = Arrays.asList("alpha","beta","gamma");
        System.out.println(strings.stream().min(Comparator.naturalOrder()).get());

        //Reverse Order
        System.out.println(integers.stream().min(Comparator.reverseOrder()).get());
        System.out.println(strings.stream().min(Comparator.reverseOrder()).get());
    }
}