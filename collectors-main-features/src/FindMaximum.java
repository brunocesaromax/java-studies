import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindMaximum {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("alpha","beta","gamma");
        System.out.println(strings.stream().max(Comparator.naturalOrder()).get());
    }
}