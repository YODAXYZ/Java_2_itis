package AISD.codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class Search {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a1 = new int[n];
        for (int i = 0; i < n; i++) {
            a1[i] = scanner.nextInt();
        }
        Arrays.sort(a1);
        int m = scanner.nextInt();
        int[] q1 = new int[m];

        for (int i = 0; i < m; i++) {
            q1[i] = scanner.nextInt();
        }

        for (int i = 0; i < m; i++) {
            System.out.println(binar(a1, q1[i]));
        }
        
    }
    public static int binar(int[] a1, int value) {
        int start = 0;
        int end = a1.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (a1[mid] < value) {
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return start;
    }
}
