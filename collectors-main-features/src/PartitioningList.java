import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningList {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a","alpha","beta","gamma");
        Map<Boolean, List<String>> result = strings.stream()
                .collect(Collectors.partitioningBy(s -> s.length() > 2));
        System.out.println(result);
    }
}