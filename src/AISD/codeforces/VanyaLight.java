package AISD.codeforces;//package AISD;

import java.util.Arrays;
import java.util.Scanner;

public class VanyaLight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        int[] light = new int[n];
        for (int i = 0; i < n; i++) {
            light[i] = scanner.nextInt();
        }
        Arrays.sort(light);
        int prev = 0;
        int maxAreaLight = 0;
        for (int i = 0; i < n; i++) {
            if (light[i] - prev > maxAreaLight) {
                maxAreaLight = light[i] - prev;
            }
            prev = light[i];
        }
        double ans = (double) maxAreaLight / 2;
        if (light[0] > ans) {
            ans = light[0];
        }
        if (l - light[n - 1] > ans) {
            ans = l - light[n -1];
        }
        System.out.println(ans);
    }
}
