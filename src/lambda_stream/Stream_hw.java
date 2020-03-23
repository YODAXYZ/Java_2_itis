package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class List_list2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 7, 8, 10);
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
        Integer max = list2.stream().max(Integer::compare).get();
        System.out.println(list.stream().filter(v -> max < v).collect(Collectors.toList()));
        System.out.println(max);

        // Посчитать количество строк в set, в которых количество гласных больше трёх.
        
    }
}
