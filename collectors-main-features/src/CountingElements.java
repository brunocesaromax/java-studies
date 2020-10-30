import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountingElements {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 6);
        Long collect = integers
                .stream()
                .filter(x -> x < 4)
                .collect(Collectors.counting());
        System.out.println(collect);
    }
}