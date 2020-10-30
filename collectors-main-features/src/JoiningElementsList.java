import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoiningElementsList {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("alpha","beta","gamma");
        String result1 = strings
                .stream()
                .distinct()
                .collect(Collectors.joining(","));
        System.out.println(result1);

        // Com prefixo e sufixo
        String result2 = strings
                .stream()
                .distinct()
                .collect(Collectors.joining(",","[","]"));
        System.out.println(result2);
    }
}