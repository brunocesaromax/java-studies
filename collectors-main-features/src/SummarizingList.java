import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class SummarizingList {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,2,3,4,5,6,6);

        //Também é possível para Long ou Double
        IntSummaryStatistics stats = integers
                .stream()
                .collect(Collectors.summarizingInt(x -> x ));
        System.out.println(stats);
    }
}