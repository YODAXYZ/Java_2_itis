package AISD.codeforces.level_2.G;//package AISD.codeforces;

import java.util.Scanner;

public class Fences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), small = sc.nextInt(), big = sc.nextInt(), mod = 1000000009;
        long ans = 0;

        if (n < 3) {
            System.out.println(small >= n ? "1" : "0");
            return;
        }

        int[] cur = new int[n + 1], p = new int[n + 1], p1 = new int[n + 1], p2 = new int[n + 1];

        p1[1] = small > 0 ? 1 : 0;
        p2[2] = small > 1 ? 1 : 0;
        cur[0] = big > 0 ? 1 : 0;
        cur[3] = small > 2 ? 1 : 0;

        for (int i = 4; i <= n; i++) {
            p = p1;
            p1 = p2;
            p2 = cur;
            cur = new int[n + 1];

            int maxSmall = Math.min(i, small);
            for (int j = maxSmall; j > 0; j--) {
                cur[j] = p2[j - 1];
            }

            maxSmall = Math.min(i - 3, small);
            for (int j = Math.max(i % 3, i - big * 3); j <= maxSmall; j += 3) {
                cur[j] = (int) (((long) cur[j] + p[j]) % mod);
            }
        }

        for (int i : cur) {
            ans = (ans + i) % mod;
        }
        System.out.println(ans);
    }
}
