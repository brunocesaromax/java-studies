import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByList {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("alpha", "beta", "gamma");
        Map<Integer, List<String>> result1 = strings
                .stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(result1);

        //Mapeando para um tipo específico de lista
        Map<Integer, List<String>> result2 = strings
                .stream()
                .collect(Collectors.groupingBy(String::length, Collectors.toCollection(LinkedList::new)));
        System.out.println(result2);
    }
}