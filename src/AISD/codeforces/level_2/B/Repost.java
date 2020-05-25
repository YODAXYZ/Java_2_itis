package AISD.codeforces.level_2.B;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Repost {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<String, Integer> hwo = new HashMap<>();
        hwo.put("polycarp", 1);
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().toLowerCase();
            String[] arr = line.split(" reposted ");
            String from_n = arr[0];
            String hwo_n = arr[1];
            if (!hwo.containsKey(hwo_n)) {
                hwo.put(hwo_n, 1);
            }
            if (!hwo.containsKey(from_n)) {
                hwo.put(from_n, 1);
            }
            hwo.replace(from_n, hwo.get(hwo_n) + 1);
        }

        System.out.println(hwo.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getValue());
    }
}
