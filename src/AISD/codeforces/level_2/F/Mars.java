package AISD.codeforces.level_2.F;

import java.util.Scanner;

public class Mars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int area[][] = new int[n][n];
        int step[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                area[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    step[i][j] = area[i][j];
                }
                else if (i == 0) {
                    step[i][j] = step[i][j - 1] + area[i][j];
                }
                else if (j == 0) {
                    step[i][j] = step[i - 1][j] + area[i][j];
                } else {
                    step[i][j] = Math.max(step[i - 1][j], step[i][j - 1]) + area[i][j];
                }
            }
        }
        System.out.println(step[n - 1][n - 1]);
    }
}
