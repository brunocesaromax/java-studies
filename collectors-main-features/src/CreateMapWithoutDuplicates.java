import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CreateMapWithoutDuplicates {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("alpha", "beta", "gamma", "beta");

        //Para criar o mapa através da lista que possui valores duplicados (beta)
        // deve-se primeiro tratar as chaves duplicadas, (i1, i2) -> i1
        Map<String, Integer> map = strings
                .stream()
                .collect(Collectors.toMap(Function.identity(), String::length, (i1, i2) -> i1));
        System.out.println(map);
    }
}