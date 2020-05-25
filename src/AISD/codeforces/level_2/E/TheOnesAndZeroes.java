//package AISD.codeforces.level_2.D;

import java.util.Scanner;

public class TheOnesAndZeroes {
    private static int n, m, num;
    private static int[] by, ax;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[n][n];
        ax = new int[n];
        by = new int[n];
        m = sc.nextInt();
        ans(0, arr);
        System.out.print(num);
    }

    private static boolean status(int x, int y, int[][] arr) {
        int p1 = y - x;
        int p2 = y + x;
        for (int i = 0; i < n; ++i) {
            if (arr[i][y] == 1) return false;
            if (arr[x][i] == 1) return false;
            if (i + p1 >= 0 && i + p1 < n) {
                if (arr[i][i + p1] == 1) return false;
            }
            if (-i + p2 >= 0 && -i + p2 < n) {
                if (arr[i][-i + p2] == 1) return false;
            }
        }
        return true;
    }

    private static void ans(int d, int[][] arr)
    {
        if (d == m) {
            num++;
            return;
        }
        int x = d != 0 ? ax[d - 1] : 0;
        int y = d != 0 ? by[d - 1] + 1 : 0;
        for (int i = x; i < n; ++i) {
            for (int j = (i != x) ? 0 : y; j < n; j++) {
                if (status(i, j, arr))
                {
                    arr[i][j] = 1;
                    ax[d] = i;
                    by[d] = j;
                    ans(d + 1, arr);
                    arr[i][j] = 0;
                }
            }
        }
    }
}