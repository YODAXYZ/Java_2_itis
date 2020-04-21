package AISD.codeforces;//package AISD;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Chat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] an = new String[n];
        HashSet<String> names = new HashSet<>();
        for (int i = 0; i < n; i++) {
            an[i] = scanner.next();
        }
        for (int i = n - 1; i >= 0; i--) {
            if (names.contains(an[i])) {
                continue;
            }
            names.add(an[i]);
            System.out.println(an[i]);
        }
    }
}
