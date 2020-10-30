import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CreateMap {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("alpha", "beta", "gamma");

        //Mapa em que a chave é a string e o valor é o tamanho da string
        Map<String, Integer> map = strings
                .stream()
                .collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(map);
    }
}