package AISD.codeforces;

import java.util.Scanner;

public class Polshar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[] first = new String[n];
        String[] second = new String[m];
        for (int i = 0; i < n; i++) {
            first[i] = scanner.next();
        }
        for (int i = 0; i < m; i++) {
            second[i] = scanner.next();
        }
        int similar = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (first[i].equals(second[j])) {
                    similar++;
                }
            }
        }
        if (similar % 2 != 0)  {
            n++;
        }
        if (n > m) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
