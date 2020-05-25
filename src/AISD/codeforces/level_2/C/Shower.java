package AISD.codeforces.level_2.C;

import java.util.Scanner;

public class Shower {
    public static int countHappy(int[][] queue) {
        int sum = 0;
        for (int i = 1; i < 6 ; i++) {
            for (int j = 1; j < 6; j++) {
                if (j!=i)
                    for (int k = 1; k < 6 ; k++) {
                        if (k != j && k != i)
                            for (int l = 1; l < 6 ; l++) {
                                if (l != k && l != j && l != i)
                                    for (int m = 1; m < 6; m++) {
                                        if (m != l && m != k && m != j && m != i) {
                                            int t = queue[i][j] + queue[j][i] + queue[k][l] + queue[l][k] + queue[j][k] + queue[k][j] + queue[l][m] + queue[m][l] + queue[k][l] +
                                                    queue[l][k] + queue[l][m] + queue[m][l];
                                            if (t > sum) {
                                                sum = t;
                                            }
                                        }
                                    }
                            }
                    }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] queue = new int[6][6];
        for (int i = 1; i < 6 ; i++) {
            for (int j = 1; j < 6; j++) {
                queue[i][j]=scanner.nextInt();
            }
        }

        int ans = countHappy(queue);
        System.out.println(ans);
    }
}
