package lambda_stream;

import java.util.*;
import java.util.stream.Collectors;

public class Stream_hw {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 7, 8, 10);
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
        Integer max = list2.stream().max(Integer::compare).get();
        System.out.println(list.stream().filter(v -> max < v).collect(Collectors.toList()));
        System.out.println(max);

        // Посчитать количество строк в set, в которых количество гласных больше трёх.
        char[] chars = new char[]{'a', 'e', 'y', 'u', 'i', 'o'};
        HashSet<String> strings = new HashSet<>();
        strings.add("AAED");
        strings.add("SSddsa");

        System.out.println(strings.stream().filter(i-> i.toUpperCase().chars().filter(j ->(j =='Y' || j=='A'|| j=='O'||j=='U'||j=='I'||j=='E')).count()>2).count());


        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        items.forEach((k,v)->System.out.print(k));
        System.out.println();
        // Получить сумму длин строк коллекции,
        // которые длиннее 5-ти символов.( активно использовать методы map, count, filter…)
        String[] text = {"hello1", "hi", "hello1", "hello12"};
        int total = Arrays.stream(text).mapToInt(s -> s.length()).filter(s -> s > 5).sum();
        System.out.println(total);


    }
}
